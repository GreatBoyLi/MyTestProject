package peng.wen.zookeeper.acl;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ZKNodeAcl {
    /**
     * zookeeper地址
     */
    private static final String zkServerPath = "slave1:2181,slave2:2181,master:2181";
    /**
     * 超时时间
     */
    private static final Integer timeout = 50000;
    /**
     * ZK对象
     */
    private ZooKeeper zooKeeper;

    /**
     * 无参的构造函数
     */
    public ZKNodeAcl(){}

    public ZKNodeAcl(String zkServerPath){
        try {
            zooKeeper = new ZooKeeper(zkServerPath, timeout, null);
        } catch (IOException e) {
            e.printStackTrace();
            if (zooKeeper != null){
                try {
                    zooKeeper.close();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建节点
     * @param path 路径
     * @param data 数据
     * @param acls 权限
     */
    public void createZKNode(String path, byte[] data, List<ACL> acls){
        String result = "";
        /**
         * 同步或者异步创建节点，都不支持子节点的递归创建，异步有一个callback函数
         * 参数：
         * path：创建的路径
         * data：存储的数据的byte[]
         * acls：控制权限策略
         *              Ids.OPEN_ACL_UNSAFE --> world:anyone:cdrwa
         *              CREATOR_ALL_ACL --> auth:user:password:cdrwa
         * createMode：节点类型，是一个枚举
         *              PERSISTENT：持久节点
         *              PERSISTENT_SEQUENTIAL：持久顺序节点
         *              EPHEMERAL：临时节点
         *              EPHEMERAL_SEQUENTIAL：临时顺序节点
         */
        try {
            // 同步方法
            result = zooKeeper.create(path, data, acls, CreateMode.PERSISTENT);
            System.out.println("创建节点：\t" + result + "\t成功....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, KeeperException, InterruptedException {
        ZKNodeAcl zkServer = new ZKNodeAcl(zkServerPath);
        /**
         * 创建node start
         */
        // acl 任何人都可以访问
//        zkServer.createZKNode("/aclimooc","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE);

        // 自定义用户认真访问
        List<ACL> acls = new ArrayList<ACL>();
        Id liwpb1 = new Id("digest",AclUtils.getDigestUserPwd("liwpb1:123456"));
        Id liwpb2 = new Id("digest",AclUtils.getDigestUserPwd("liwpb2:123456"));
        acls.add(new ACL(ZooDefs.Perms.ALL,liwpb1));
        acls.add(new ACL(ZooDefs.Perms.READ,liwpb2));
        acls.add(new ACL(ZooDefs.Perms.DELETE | ZooDefs.Perms.CREATE, liwpb2));
        zkServer.createZKNode("/aclimooc/testdigest", "testdigest".getBytes(), acls);

        // 注册过的用户必须通过addAuthInfo才能操作节点，参考命令行 addauth
        zkServer.zooKeeper.addAuthInfo("digest","liwpb1:123456".getBytes());
        zkServer.createZKNode("/aclimooc/testdigest/childtest","childtest".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL);

        // ip方式的acl
        List<ACL> aclsIP = new ArrayList<ACL>();
        Id ipId1 = new Id("ip","172.21.100.232");
        aclsIP.add(new ACL(ZooDefs.Perms.ALL,ipId1));
        zkServer.createZKNode("/aclimooc/iptest","iptest".getBytes(),aclsIP);

        // 验证IP是否有权限
//        zkServer.zooKeeper.setData("/aclimooc/iptest", "123456".getBytes(),0);
    }
}

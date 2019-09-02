package peng.wen.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * 操作ZK节点，创建和删除操作
 */
public class ZKNodeOperator implements Watcher{

    private static final Logger log = LoggerFactory.getLogger(ZKNodeOperator.class);
    /**
     * zookeeper地址
     */
    public static final String zkServerPath = "slave1:2181,slave2:2181,master:2181";

    /**
     * 超时时间
     */
    private static final Integer timeout = 50000;

    /**
     * ZK对象
     */
    private ZooKeeper zooKeeper;

    /**
     * 无参构造函数
     */
    public ZKNodeOperator(){}

    /**
     * 传入地址的构造函数
     */
    public ZKNodeOperator(String zkServerPath){
        try {
            zooKeeper = new ZooKeeper(zkServerPath, timeout, new ZKNodeOperator());
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
//            result = zooKeeper.create(path, data, acls, CreateMode.EPHEMERAL);

            String ctx = "{'create':'success'}";
            zooKeeper.create(path, data, acls, CreateMode.EPHEMERAL, new CreateCallBack(), ctx);
            System.out.println("创建节点：\t" + result + "\t成功...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZKNodeOperator zkNodeOperator = new ZKNodeOperator(zkServerPath);
        log.warn("连接状态：{}",zkNodeOperator.getZooKeeper().getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.warn("连接状态：{}",zkNodeOperator.getZooKeeper().getState());

        zkNodeOperator.createZKNode("/liwpb", "liwpb".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE);

        /**
         * 修改节点信息，同步方式，还有异步方式
         * path：节点路径
         * data：数据
         * version：数据状态
         */
        Stat status = zkNodeOperator.getZooKeeper().setData("/liwpb", "modify".getBytes(), 0);
        System.out.println(status.getVersion());

        /**
         * 删除节点信息，有同步和异步之分
         */
//        zkNodeOperator.getZooKeeper().delete("/test", 0);

        String ctx = "{'delete':'succes'}";
        zkNodeOperator.getZooKeeper().delete("/test", 0, new DeleteCallBack(), ctx);
        Thread.sleep(2000);
    }

    /**
     * get方法
     * @return ZooKeeper
     */
    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    /**
     * zookeeper的watcher
     * @param watchedEvent watcher事件
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        log.warn("接收到watch通知：{}", watchedEvent);
    }
}

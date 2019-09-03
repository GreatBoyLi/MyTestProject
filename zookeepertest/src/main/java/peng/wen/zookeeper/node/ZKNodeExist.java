package peng.wen.zookeeper.node;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZKNodeExist implements Watcher{

    /**
     * zookeeper
     */
    private ZooKeeper zooKeeper;
    /**
     * zookeeper地址
     */
    public static final String zkServerPath="master:2181,slave1:2181,slave2:2181";
    /**
     * 超时时间
     */
    public static final Integer timeout = 5000;
    /**
     * 计数器
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 无参的构造函数
     */
    public ZKNodeExist(){}

    /**
     * 构造函数
     * @param zkServerPath zk服务器地址
     */
    public ZKNodeExist(String zkServerPath){
        try {
            zooKeeper = new ZooKeeper(zkServerPath,timeout, new ZKNodeExist());
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
     * 主函数
     * @param args
     */
    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZKNodeExist zkServer = new ZKNodeExist(zkServerPath);

        /**
         * path：节点路径
         * watch：watch监听器
         */
        Stat stat = zkServer.zooKeeper.exists("/liwpb1",true);
        if (stat != null){
            System.out.println("节点存在，节点版本为：" + stat.getVersion());
        }else{
            System.out.println("节点不存在");
        }
        countDownLatch.await();
    }

    /**
     * 监听事件
     * @param watchedEvent 监听事件
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if(watchedEvent.getType() == Event.EventType.NodeDataChanged){
                Stat stat = new Stat();
                ZKNodeExist zkServer = new ZKNodeExist(zkServerPath);
                System.out.println("节点数据修改");
                byte[] resByte = zkServer.zooKeeper.getData("/liwpb", false, stat);
                System.out.println("当前节点的值：" + new String(resByte));
                System.out.println("当前节点的版本：" + stat.getVersion());
                System.out.println("当前节点的版本：" + stat.getVersion());
                countDownLatch.countDown();
            }else if (watchedEvent.getType() == Event.EventType.NodeDeleted){
                System.out.println("节点删除");
                countDownLatch.countDown();
            }else if(watchedEvent.getType() == Event.EventType.NodeCreated){
                System.out.println("节点创建");
                countDownLatch.countDown();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

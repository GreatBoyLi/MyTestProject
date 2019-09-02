package peng.wen.zookeeper.node;

import lombok.Getter;
import lombok.Setter;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * zookeeper 获取节点数据的demo演示
 */
@Getter
@Setter
public class ZKGetNodeData implements Watcher{
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
     * 计数器？？
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    /**
     *
     */
    private static Stat stat = new Stat();

    /**
     * 无参的构造函数
     */
    public ZKGetNodeData(){}
    /**
     * 构造函数
     */
    public ZKGetNodeData(String zkServerPath){
        try {
            zooKeeper = new ZooKeeper(zkServerPath,timeout, new ZKGetNodeData());
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
     * 主线程Main方法
     * @param args
     */
    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZKGetNodeData zkServer = new ZKGetNodeData(zkServerPath);

        /**
         * path：节点路径
         * watch：true或者false，注册一个watch时间
         * stat：状态
         */
        byte[] resByte = zkServer.getZooKeeper().getData("/liwpb", true, stat);
        String result = new String(resByte);
        System.out.println("当前值：" + result);
        countDownLatch.await();
    }

    /**
     * 监听事件
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if(watchedEvent.getType() == Event.EventType.NodeDataChanged){
                ZKGetNodeData zkServer = new ZKGetNodeData(zkServerPath);

                byte[] resByte = zkServer.getZooKeeper().getData("/liwpb", false, stat);
                String result = new String(resByte);
                System.out.println("更改后的值：" + result);
                System.out.println("版本号变化dversion：" + stat.getVersion());
                countDownLatch.countDown();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

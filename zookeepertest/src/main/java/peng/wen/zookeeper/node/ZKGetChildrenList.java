package peng.wen.zookeeper.node;

import lombok.Getter;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 获取节点的子节点demo演示
 */
@Getter
public class ZKGetChildrenList implements Watcher{
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
     * 无参构造函数
     */
    private ZKGetChildrenList(){}

    /**
     * 计数器
     */
    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 构造函数
     * @param zkServerPath zk服务器地址
     */
    public ZKGetChildrenList(String zkServerPath){
        try {
            zooKeeper = new ZooKeeper(zkServerPath, timeout, new ZKGetChildrenList());
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
        ZKGetChildrenList zkServer = new ZKGetChildrenList(zkServerPath);

        /**
         * path：父节点路径
         * watch：true或者false，注册一个watch事件
         */

        // 同步获取
//        List<String> strChildList = zkServer.getZooKeeper().getChildren("/liwpb", true);
//        for (String s : strChildList){
//            System.out.println(s);
//        }

        // 异步获取
        String ctx = "{'callback':'ChildrenCallback'}";
//        zkServer.getZooKeeper().getChildren("/liwpb",true, new ChildrenCallBack(), ctx);
        zkServer.getZooKeeper().getChildren("/liwpb",true, new Children2Callback(), ctx);

        countDownLatch.await();
    }


    /**
     * watch事件
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        try{
            if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                System.out.println("NodeChildrenchanged");
                ZKGetChildrenList zkServer = new ZKGetChildrenList(zkServerPath);
                List<String> strChildList = zkServer.getZooKeeper().getChildren(watchedEvent.getPath(),false);
                for (String s : strChildList){
                    System.out.println(s);
                }
                countDownLatch.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}

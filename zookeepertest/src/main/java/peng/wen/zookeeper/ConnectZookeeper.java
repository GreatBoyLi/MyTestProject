package peng.wen.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 连接zk服务器的演示demo
 */
public class ConnectZookeeper implements Watcher {

    private static final Logger log = LoggerFactory.getLogger(ConnectZookeeper.class);
    /**
     * zookeeper地址
     */
    private static final String zkServerPath = "slave1:2181,slave2:2181,master:2181";

    /**
     * 超时时间
     */
    private static final Integer timeout = 50000;

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 客户端和zk服务端连接是一个异步过程
         * 当连接成功后，客户端会受到一个watch通知
         *
         * 参数：
         * connectString：连接服务器的ip:port字符串
         *      比如“192.168.1.1:2181,192.168.1.2:2181,192.168.1.3:2181”
         *      可以是一个ip，也可以是多个ip，一个ip代表单机，多个ip代表集群
         *      也可以在ip后加路径
         * sessionTimeout：超时时间，心跳收不到就超时了
         * watcher：通知事件，如果有对应的事件触发，则会收到一个通知；如果不需要，那就设置null
         * canBeReadOnly：可读，当这个物理机节点断开后，还是可以读到数据的，只是不能写，
         *                此时数据被读取到的可能是旧数据，此处建议设置为false，不推荐使用
         * sessionId：会话id
         * sessionPassed：会话密码   当会话丢失后，可以依据sesionId 和 sessionPassed重新获取会话
         */
        ZooKeeper zk = new ZooKeeper(zkServerPath, timeout, new ConnectZookeeper());

        log.debug("客户端开始连接zookeeper服务器...");
        log.debug("连接状态：{}", zk.getState());
        Thread.sleep(5000);

        log.debug("连接状态：{}", zk.getState());
    }

    /**
     * zookeeper的Watcher
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        log.debug("接收到watch通知：{}", watchedEvent);
    }
}

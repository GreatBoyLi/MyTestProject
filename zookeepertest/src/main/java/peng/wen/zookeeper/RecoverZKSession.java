package peng.wen.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * zookeeper 恢复之前的会话连接demo演示
 */
public class RecoverZKSession implements Watcher {

    private static final Logger log = LoggerFactory.getLogger(RecoverZKSession.class);
    /**
     * zookeeper地址
     */
    private static final String zkServerPath = "slave1:2181,slave2:2181,master:2181";

    /**
     * 超时时间
     */
    private static final Integer timeout = 50000;

    /**
     * 主方法
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(zkServerPath, timeout, new RecoverZKSession());

        long sessionId = zk.getSessionId();
        byte[] sessionPasswd = zk.getSessionPasswd();

        log.warn("客户端开始连接zookeeper服务器...");
        log.warn("连接状态：{}", zk.getState());
        Thread.sleep(2000);
        log.warn("连接状态：{}", zk.getState());


        Thread.sleep(200);
        log.warn("开始会话重连");

        ZooKeeper zkSession = new ZooKeeper(zkServerPath, timeout, new RecoverZKSession(),sessionId,sessionPasswd);
        log.warn("重新连接状态：{}", zkSession.getState());
        Thread.sleep(2000);
        log.warn("重新连接状态：{}", zkSession.getState());
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

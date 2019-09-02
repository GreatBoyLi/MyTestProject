package peng.wen.zookeeper;

import org.apache.zookeeper.AsyncCallback;

/**
 * 创建节点时异步创建，回调函数
 */
public class CreateCallBack implements AsyncCallback.StringCallback{
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("创建节点：" + path);
        System.out.println((String)ctx);
    }
}

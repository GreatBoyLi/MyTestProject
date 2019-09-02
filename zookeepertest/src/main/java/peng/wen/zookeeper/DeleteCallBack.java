package peng.wen.zookeeper;

import org.apache.zookeeper.AsyncCallback;

/**
 * 删除节点时异步删除，回调函数
 */
public class DeleteCallBack implements AsyncCallback.VoidCallback{
    @Override
    public void processResult(int i, String path, Object o) {
        System.out.println("删除节点" + path);
        System.out.println((String) o);
    }
}

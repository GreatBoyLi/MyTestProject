package peng.wen.zookeeper;

import org.apache.zookeeper.AsyncCallback;

public class DeleteCallBack implements AsyncCallback.VoidCallback{
    @Override
    public void processResult(int i, String path, Object o) {
        System.out.println("删除节点" + path);
        System.out.println((String) o);
    }
}

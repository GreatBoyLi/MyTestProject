package peng.wen.zookeeper.node;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class Children2Callback implements AsyncCallback.Children2Callback{
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        for (String s : children){
            System.out.println(s);
        }
        System.out.println("int 类型的 rc：" + rc);
        System.out.println("ChildrenCallback:" + path);
        System.out.println((String)ctx);
        System.out.println(stat);
    }
}

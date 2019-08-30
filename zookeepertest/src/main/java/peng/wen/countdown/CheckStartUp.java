package peng.wen.countdown;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * 监控中心
 * @author liwpb
 */
@Getter
@Setter
public class CheckStartUp {
    /**
     * 调度站集合
     */
    private List<BaseDangerCenter> stationList;
    /**
     * 计数器
     */
    private  CountDownLatch countDownLatch;

    private Liwpb liwpb;

    /**
     * 构造函数
     */
    public CheckStartUp(){}

    /**
     * 检查所有调度站
     * @return boolean
     */
    public  boolean checkAllStations() throws InterruptedException {

        liwpb = new Liwpb();
        liwpb.setAge(7);
        // 初始化3个调度站
        countDownLatch = new CountDownLatch(3);

        // 把所有站点添加进list
        stationList = new ArrayList<BaseDangerCenter>();
        stationList.add(new StationBeijing(countDownLatch,liwpb));
        stationList.add(new StationJiangXi(countDownLatch,liwpb));
        stationList.add(new StationNeimeng(countDownLatch,liwpb));

        // 使用线程池
        Executor executor = newFixedThreadPool(stationList.size());

        for (BaseDangerCenter center: stationList){
            executor.execute(center);
        }

        // 等待线程执行完毕
        countDownLatch.await();

        System.out.println(countDownLatch.getCount() + "   "  + liwpb.getAge());

        for (BaseDangerCenter center : stationList){
            if (!center.isOk()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        boolean result = new CheckStartUp().checkAllStations();
        System.out.println("监控中心针对所有危化品调度站点的检查结果为：" + result);
    }
}

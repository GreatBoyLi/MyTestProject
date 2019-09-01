package peng.wen.countdown;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;

/**
 * 抽象类，用于演示，危险品化工车监控中心，统一检查
 * @author liwpb
 */
@Getter
@Setter
public abstract  class BaseDangerCenter implements Runnable{

    /**
     * 计数器
     */
    private CountDownLatch countDownLatch;

    /**
     * 调度站
     */
    private String station;

    /**
     * 调度站针对当前自己站点进行检查，是否检查ok的标志
     */
    private boolean ok;

    private Liwpb liwpb;

    /**
     * 构造函数
     * @param countDownLatch 计数器
     * @param station 调度站
     */
    public BaseDangerCenter(CountDownLatch countDownLatch, String station, Liwpb liwpb){
        this.countDownLatch = countDownLatch;
        this.station = station;
        this.liwpb = liwpb;
        this.ok = false;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try{
            check();
            ok = true;
        }catch (Exception e){
            e.printStackTrace();
            ok = false;
        }finally {
            if (countDownLatch != null){
                liwpb.jian();
                System.out.println("liwpb数字为：" + liwpb.getAge());
                System.out.println("CountDown数字为：" + countDownLatch.getCount());
                countDownLatch.countDown();
            }
        }
    }

    /**
     * 检查危化品车
     * 蒸罐
     * ……
     */
    public abstract void check();
}

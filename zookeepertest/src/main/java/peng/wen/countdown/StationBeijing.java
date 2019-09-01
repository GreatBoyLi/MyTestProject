package peng.wen.countdown;

import java.util.concurrent.CountDownLatch;

public class StationBeijing extends BaseDangerCenter{
    /**
     * 构造函数
     *
     * @param countDownLatch 计数器
     */
    public StationBeijing(CountDownLatch countDownLatch, Liwpb liwpb) {
        super(countDownLatch, "北京调度站", liwpb);
    }

    /**
     * 检查危化品车
     * 蒸罐
     * ……
     */
    @Override
    public void check() {
        System.out.println("正在检查[" + this.getStation() + "]...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("检查[" + this.getStation() + "]完毕，可以发车。");
    }
}

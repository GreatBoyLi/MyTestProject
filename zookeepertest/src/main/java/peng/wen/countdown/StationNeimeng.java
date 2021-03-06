package peng.wen.countdown;

import java.util.concurrent.CountDownLatch;

public class StationNeimeng extends BaseDangerCenter{
    /**
     * 构造函数
     *
     * @param countDownLatch 计数器
     */
    public StationNeimeng(CountDownLatch countDownLatch, Liwpb liwpb) {
        super(countDownLatch, "内蒙调度站", liwpb);
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
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("检查[" + this.getStation() + "]完毕，可以发车。");
    }
}

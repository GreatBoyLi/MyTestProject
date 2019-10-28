package com.peng.wen.leetcode;

public class leetcode303Another {

    // 先进行预处理
    private int[] sum;  //sum[i]存储前i个元素和,nums[0....i-1]。sum[0] = 0;
    private int[] data;

    public leetcode303Another(int[] nums){

        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            data[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++){
            sum[i] = sum[i -1] + nums[i - 1];
        }
    }

    public void update(int i, int val){
//        int a = val - data[i];
//        data[i] = val;
//        for (int j = i + 1; j < sum.length; j++){
//            sum[j] = sum[j] + a;
//        }
        data[i] = val;
        for (int j = i + 1; j < sum.length; j ++){
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }

    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];
    }
}

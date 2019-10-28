package com.peng.wen.leetcode;

import com.peng.wen.Tree.SegmentTree;

public class leetcode303 {

    private SegmentTree<Integer> segmentTree;

    public leetcode303(int[] nums){
        if (nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++){
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j){
        if (segmentTree == null){
            throw new IllegalArgumentException("Segment tree is null.");
        }
        return segmentTree.query(i, j);
    }
}

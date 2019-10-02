package com.peng.wen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int num : nums1){
            set.add(num);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums2){
            if (set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
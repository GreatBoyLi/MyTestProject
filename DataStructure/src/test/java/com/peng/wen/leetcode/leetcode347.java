package com.peng.wen.leetcode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class leetcode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        return null;
    }
}

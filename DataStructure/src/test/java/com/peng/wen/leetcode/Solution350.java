package com.peng.wen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int num : nums1){
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums2){
            if (map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num)  == 0){
                    map.remove(num);
                }
            }
        }
        int[] result = new  int[list.size()];
        for (int i = 0; i < list.size(); i ++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {1,1};

        int[] c = new Solution350().intersect(a,b);
        for (int i : c){
            System.out.println(i);
        }
    }
}

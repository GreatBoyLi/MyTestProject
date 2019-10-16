package com.peng.wen.leetcode;

import java.util.*;

public class leetcode347another {

    private class Freq{
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }

//    private class FreqComparator implements Comparator<Freq>{
//
//        @Override
//        public int compare(Freq o1, Freq o2) {
//            return o1.freq - o2.freq;
//        }
//    }



    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

//        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.freq - o2.freq;
            }
        });//匿名类
        for (int key : map.keySet()){
            if (pq.size() < k){
                pq.add(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<Integer>();
        while(!pq.isEmpty()){
            res.add(pq.remove().e);
        }
        return res;
    }
}

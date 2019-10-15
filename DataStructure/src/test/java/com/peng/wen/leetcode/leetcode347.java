package com.peng.wen.leetcode;

import java.util.*;

public class leetcode347 {

    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            return this.freq - o.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
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

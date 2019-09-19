package com.peng.wen.Map;


import com.peng.wen.map.LinkedListMap;
import com.peng.wen.map.Map;

public class LinkedListMapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedListMap<String, Integer>();
        map.add("1",1);
        map.add("2",2);
        map.remove("2");
        map.add("3",3);
//        map.set("2",1);
        map.set("1",2);
        map.add("1",1);
    }
}

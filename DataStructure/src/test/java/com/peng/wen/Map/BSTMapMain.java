package com.peng.wen.Map;

import com.peng.wen.map.BSTMap;

public class BSTMapMain {

    public static void main(String[] args) {
        BSTMap<String, String> map = new BSTMap<String, String>();
        map.add("5","5");
        map.add("2","2");
        map.add("1","1");
        map.add("3","3");
        map.add("6","6");
        map.add("7","7");
        map.add("8","8");
        map.remove("6");
        System.out.println(map.get("6"));
        map.set("5","50");
        System.out.println(map.get("5"));
    }
}

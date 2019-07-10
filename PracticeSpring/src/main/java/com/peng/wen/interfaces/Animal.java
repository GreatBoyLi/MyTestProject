package com.peng.wen.interfaces;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Animal {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private JSONObject attribute = new JSONObject();

    public JSONObject getAttribute() {
        return attribute;
    }

    public void setAttribute(JSONObject attribute) {
        this.attribute = attribute;
    }
    public void say(){
        System.out.println("I am animal father.");
    }

    public String getValue(String key){
        JSONObject jsonObject = this.attribute.getJSONObject(key);
        if (jsonObject != null && !jsonObject.isEmpty()) {
            return jsonObject.getString("HAHA");
        } else {
            return null;
        }
    }
}

package com.peng.wen.interfaces;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Animal {
    JSONObject attribute;

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
        if (!jsonObject.isEmpty()) {
            return jsonObject.getString("HAHA");
        } else {
            return null;
        }
    }
}

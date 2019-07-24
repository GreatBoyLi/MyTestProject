package com.peng.wen.dubbo.quickstart;

import com.peng.wen.dubbo.ServiceAPI;

public class QuickStartServiceImpl implements ServiceAPI {

    @Override
    public String sendMessage(String message) {
        return "quickstart-proveder-message= " + message;
    }
}

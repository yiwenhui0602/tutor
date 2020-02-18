package com.qiaoyy.util;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiaoyy.log.AppLog;

public class MBResponse {

    public String code;
    public String msg;
    public Object result;

    private MBResponse(String code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }


    public static MBResponse getMBResponse(String code) {
        return new MBResponse(code, null, null);
    }

    public static MBResponse getMBResponse(String code, Object result) {
        return new MBResponse(code, null, result);
    }

    public static void sendResponse(HttpServletRequest request, HttpServletResponse response, MBResponse responseModel) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/json; charset=UTF-8");
        response.getOutputStream().write(JSONObject.toJSONString(responseModel).getBytes("UTF-8"));
        AppLog.LOG_INTERFACE.info("[resp][{}] - {}", MBRequest.getUUID(request), JSON.toJSONString(responseModel));
    }
}

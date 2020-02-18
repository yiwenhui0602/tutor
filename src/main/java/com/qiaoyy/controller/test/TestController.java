package com.qiaoyy.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    public TestController() {
        super();

    }

    @RequestMapping(value = "/test/test")
    protected void test(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            JSONObject jsonObject = MBRequest.getContent(request);
//            AccountModel accountModel =userManager.findByUserid(jsonObject.getLong("userid"));
//            MBResponse responseModel = null;
//            if (accountModel != null) {
//                responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, accountModel);
//            } else {
//                responseModel = MBResponse.getMBResponse(MBResponseCode.ERROR);
//            }
//            MBResponse.sendResponse(request, response, responseModel);
//        } catch (Exception e) {
//            try {
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            AppLog.LOG_COMMON.error(this.getClass().getSimpleName() + " Exception :", e);
//        }
    }

}

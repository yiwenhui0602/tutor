package com.tutor.logic.user;

import com.tutor.logic.WebApi;
import com.tutor.logic.entity.AccountInformationEntity;
import com.tutor.util.MBResponse;
import com.tutor.util.MBResponseCode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AccountController {

    @Autowired
    private AccountManager accountManager;

    /**
     * 处理登录请求
     */
    @RequestMapping(value = WebApi.USER_LOGIN, method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account_number = request.getParameter("account_number");
        String account_type = request.getParameter("account_type");
        String account_password = request.getParameter("account_password");

        MBResponse responseModel = null;
        // 参数校验
        if (StringUtils.isEmpty(account_number)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "账号不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(account_password)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "密码不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        // 构建entity实体
        AccountInformationEntity entity = new AccountInformationEntity();
        entity.setAccountNunmer(account_number);
        entity.setAccountPassword(account_password);
        entity.setAccountType(Integer.valueOf(account_type));
        // 调用登录逻辑
        entity = accountManager.login(entity);

        if (entity != null) {
            // 返回数据
            JSONObject responseObject = new JSONObject();
            responseObject.put("account_number", entity.getAccountNunmer());
            responseObject.put("account_type", entity.getAccountType());
            responseObject.put("account_id", entity.getAccountId());

            if (entity.getAccountType() == 0) {
                JSONObject adminInfo = new JSONObject();
                adminInfo.put("admin_name", "admin");
                responseObject.put("admin_info", adminInfo);
            } else if (entity.getAccountType() == 1) {
                JSONObject teacherInfo = new JSONObject();
                teacherInfo.put("teacher_id", "111111111");
                teacherInfo.put("teacher_name", "教师张");
                teacherInfo.put("teacher_gender", "男");
                teacherInfo.put("teacher_phone", "13888888888");
                teacherInfo.put("subject_id", "142030601");
                teacherInfo.put("teacher_account", entity.getAccountId());
                responseObject.put("teacher_info", teacherInfo);
            } else if (entity.getAccountType() == 2) {
                JSONObject studentInfo = new JSONObject();
                studentInfo.put("student_name", "学生李");
                studentInfo.put("student_gender", "女");
                studentInfo.put("student_id", "142030601");
                studentInfo.put("class_id", "160310100");
                studentInfo.put("student_account", entity.getAccountId());
                responseObject.put("student_info", studentInfo);
            } else if (entity.getAccountType() == 3) {
                JSONObject parentInfo = new JSONObject();
                parentInfo.put("parent_id", "22222222");
                parentInfo.put("parent_name", "家长王");
                parentInfo.put("parent_gender", "男");
                parentInfo.put("parent_phone", "18900000000");
                parentInfo.put("student_id", "142030601");
                parentInfo.put("relationship", "父亲");
                parentInfo.put("parent_account", entity.getAccountId());
                responseObject.put("parent_info", parentInfo);
            }

            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, responseObject);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.ERROR);
        }

        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

}

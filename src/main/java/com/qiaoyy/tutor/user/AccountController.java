package com.qiaoyy.tutor.user;

import com.qiaoyy.tutor.WebApi;
import com.qiaoyy.tutor.entity.AccountInformationEntity;
import com.qiaoyy.util.MBResponse;
import com.qiaoyy.util.MBResponseCode;
import org.json.JSONObject;
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
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, responseObject);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.ERROR);
        }

        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

}

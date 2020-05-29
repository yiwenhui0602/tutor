package com.tutor.logic.announcements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.ClassInformationEntity;
import com.tutor.util.MBResponse;
import com.tutor.util.MBResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 新闻
 *
 * @author yiwenhui
 * @date 2020/2/18 16:40
 */
@Controller
public class SchoolClassController {

    @Autowired
    private com.tutor.logic.announcements.SchoolClassManager schoolClassManager;

    @RequestMapping(value = WebApi.QUERY_CLASS_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ClassInformationEntity> list = schoolClassManager.queryAll();

        JSONArray jsonArray = new JSONArray();
        for (ClassInformationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("class_id", entity.getClassId());
            object.put("class_name", entity.getClassName());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_CLASS, method = RequestMethod.POST)
    @ResponseBody
    public void addClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassInformationEntity entity = new ClassInformationEntity();

        String className = request.getParameter("class_name");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(className)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "班级名字不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setClassName(className);
        entity = schoolClassManager.addClass(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

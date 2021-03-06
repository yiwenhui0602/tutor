package com.tutor.logic.subject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.SubjectInformationEntity;
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
public class SubjectController {

    @Autowired
    private SubjectManager subjectManager;

    @RequestMapping(value = WebApi.QUERY_SUBJECT_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<SubjectInformationEntity> list = subjectManager.queryAll();

        JSONArray jsonArray = new JSONArray();
        for (SubjectInformationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("subject_id", entity.getSubjectId());
            object.put("subject_name", entity.getSubjectName());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_SUBJECT_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void addSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SubjectInformationEntity entity = new SubjectInformationEntity();

        String subjectName = request.getParameter("subject_name");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(subjectName)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "科目名字不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setSubjectName(subjectName);
        entity = subjectManager.addSubject(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.QUERY_SUBJECT_INFO, method = RequestMethod.POST)
    @ResponseBody
    public void queryCourseInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SubjectInformationEntity entity = subjectManager.queryBySubjectId(Integer.parseInt(request.getParameter("subject_id")));

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, entity);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }
}

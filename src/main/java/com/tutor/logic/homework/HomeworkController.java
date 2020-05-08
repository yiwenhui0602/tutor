package com.tutor.logic.homework;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.HomeworkEntity;
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
 * @author 何金成
 * @date 2020/2/18 16:40
 */
@Controller
public class HomeworkController {

    @Autowired
    private HomeworkManager homeworkManager;

    @RequestMapping(value = WebApi.QUERY_HOMEWORK_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<HomeworkEntity> list;

        String class_id = request.getParameter("class_id");
        if (class_id != null) {
            list = homeworkManager.queryByClassId(Integer.parseInt(class_id));
        } else {
            list = homeworkManager.queryAll();
        }

        JSONArray jsonArray = new JSONArray();
        for (HomeworkEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("hw_id", entity.getHwId());
            object.put("class_id", entity.getClassId());
            object.put("subject_id", entity.getSubjectId());
            object.put("hw_detail", entity.getHwDetail());
            object.put("hw_title", entity.getHwTitle());
            object.put("hw_time", entity.getHwTime());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_HOMEWORK, method = RequestMethod.POST)
    @ResponseBody
    public void addHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HomeworkEntity entity = new HomeworkEntity();

        String file = request.getParameter("hw_file");
        String detail = request.getParameter("hw_detail");
        String title = request.getParameter("hw_title");
        String date = request.getParameter("hw_date");
        String class_id = request.getParameter("class_id");
        String subject_id = request.getParameter("subject_id");

        MBResponse responseModel = null;

        // 参数校验
//        if (StringUtils.isEmpty(file)) {
//            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "作业文件不能为空");
//            MBResponse.sendResponse(request, response, responseModel);
//            return;
//        }
        if (StringUtils.isEmpty(detail)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "作业详情不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(title)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "作业标题不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setHwDetail(detail);
        entity.setHwTitle(title);
        entity.setHwTime(date);
        entity.setClassId(Integer.parseInt(class_id));
        entity.setSubjectId(Integer.parseInt(subject_id));
        entity = homeworkManager.addHomework(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

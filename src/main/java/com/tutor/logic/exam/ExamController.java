package com.tutor.logic.exam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.course.CourseManager;
import com.tutor.logic.entity.CoursetableEntity;
import com.tutor.logic.entity.ExamInfomationEntity;
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
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamManager examManager;

    @RequestMapping(value = WebApi.QUERY_EXAM_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ExamInfomationEntity> list = examManager.queryAll();

        JSONArray jsonArray = new JSONArray();
        for (ExamInfomationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("exam_id", entity.getExamId());
            object.put("exam_name", entity.getExamName());
            object.put("exam_time", entity.getExamTime());
            object.put("subject_id", entity.getSubjectId());
            object.put("subject_name", entity.getSubjectName());
            object.put("class_id", entity.getClassId());
            object.put("class_name", entity.getClassName());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_EXAM, method = RequestMethod.POST)
    @ResponseBody
    public void addExam(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExamInfomationEntity entity = new ExamInfomationEntity();

        String exam_id = request.getParameter("exam_id");
        String exam_name = request.getParameter("exam_name");
//        String exam_time = request.getParameter("exam_time");
        int subject_id = Integer.parseInt(request.getParameter("subject_id"));
        String subject_name = request.getParameter("subject_name");
        int class_id = Integer.parseInt(request.getParameter("class_id"));
        String class_name = request.getParameter("class_name");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(exam_name)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "考试名称不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(subject_name)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "科目不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(class_name)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "班级不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        if (StringUtils.isEmpty(exam_id) == false) {
            entity.setExamId(Integer.parseInt(exam_id));
        }
        entity.setExamName(exam_name);
        entity.setSubjectId(subject_id);
        entity.setSubjectName(subject_name);
        entity.setClassId(class_id);
        entity.setClassName(class_name);
        entity = examManager.addCourse(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

package com.tutor.logic.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.SubjectInformationEntity;
import com.tutor.logic.entity.TeacherInformaEntity;
import com.tutor.logic.subject.SubjectManager;
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
public class TeacherController {

    @Autowired
    private TeacherManager teacherManager;
    @Autowired
    private SubjectManager subjectManager;

    @RequestMapping(value = WebApi.QUERY_TEACHER_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TeacherInformaEntity> list = teacherManager.queryAll();


        JSONArray jsonArray = new JSONArray();
        for (TeacherInformaEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("teacher_id", entity.getTeacherId());
            object.put("teacher_name", entity.getTeacherName());
            object.put("teacher_gender", entity.getTeacherGender());
            object.put("teacher_account", entity.getTeacherAccount());
            object.put("teacher_phone", entity.getTeacherPhone());
            object.put("subject_id", entity.getSubjectId());
            SubjectInformationEntity subject = subjectManager.queryBySubjectId(entity.getSubjectId());
            object.put("subject_name", subject.getSubjectName());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_TEACHER, method = RequestMethod.POST)
    @ResponseBody
    public void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TeacherInformaEntity entity = new TeacherInformaEntity();

        int teacherId = Integer.parseInt(request.getParameter("teacher_id"));
        String teacherAccount = request.getParameter("teacher_account");
        String teacherGender = request.getParameter("teacher_gender");
        String teacherName = request.getParameter("teacher_name");
        String teacherPhone = request.getParameter("teacher_phone");
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(teacherGender)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "教师性别不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(teacherName)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "教师名字不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(teacherPhone)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "教师电话不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setTeacherId(teacherId);
        entity.setTeacherAccount(teacherAccount);
        entity.setTeacherGender(teacherGender);
        entity.setTeacherName(teacherName);
        entity.setTeacherPhone(teacherPhone);
        entity.setSubjectId(subjectId);
        entity = teacherManager.addTeacher(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

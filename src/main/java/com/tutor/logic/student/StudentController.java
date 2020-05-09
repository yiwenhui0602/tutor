package com.tutor.logic.student;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.ClassInformationEntity;
import com.tutor.logic.entity.ScoreInfomationEntity;
import com.tutor.logic.entity.StudentInformationEntity;
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

@Controller
public class StudentController {
    @Autowired
    private StudentManager studentManager;

    @RequestMapping(value = WebApi.QUERY_STUDENT_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<StudentInformationEntity> list;
        String class_id = request.getParameter("class_id");
        if (class_id != null) {
            list = studentManager.queryByClassId(Integer.parseInt(class_id));
        } else {
           list = studentManager.queryAll();
        }

        JSONArray jsonArray = new JSONArray();
        for (StudentInformationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("class_id", entity.getClassId());
            object.put("student_id", entity.getStudentId());
            object.put("student_name", entity.getStudentName());
            object.put("student_gender", entity.getStudentGender());
            object.put("student_account", entity.getStudentAccount());

            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.QUERY_ADD_STUDENT, method = RequestMethod.POST)
    @ResponseBody
    public void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentInformationEntity entity = new StudentInformationEntity();

        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        String student_gender = request.getParameter("student_gender");
        String class_id = request.getParameter("class_id");
        String student_account = request.getParameter("student_account");
        String parent_name = request.getParameter("parent_name");
        String parent_relation = request.getParameter("parent_relation");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(student_name)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "学生姓名不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(parent_name)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "家长姓名不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }


        if (StringUtils.isEmpty(student_id) == false) {
            entity.setStudentId(Integer.parseInt(student_id));
        }
        entity.setStudentName(student_name);
        entity.setStudentGender(student_gender);
        entity.setClassId(Integer.parseInt(class_id));
        entity.setStudentAccount(student_account);
        entity.setParentName(parent_name);
        entity.setParentRelation(parent_relation);
        entity = studentManager.addStudent(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

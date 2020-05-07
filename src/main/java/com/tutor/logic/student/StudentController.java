package com.tutor.logic.student;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.ClassInformationEntity;
import com.tutor.logic.entity.StudentInformationEntity;
import com.tutor.util.MBResponse;
import com.tutor.util.MBResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
}

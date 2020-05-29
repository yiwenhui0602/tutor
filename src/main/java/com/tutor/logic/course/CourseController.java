package com.tutor.logic.course;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.CoursetableEntity;
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

/**
 * 新闻
 *
 * @author yiwenhui
 * @date 2020/2/18 16:40
 */
@Controller
public class CourseController {

    @Autowired
    private CourseManager courseManager;

    @RequestMapping(value = WebApi.QUERY_COURSE_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CoursetableEntity> list = courseManager.queryAll();

        JSONArray sevenJsons = new JSONArray();
        for (int i = 0; i < 7; i++) {
            JSONArray jsonArray = new JSONArray();
            for (CoursetableEntity entity : list) {
                JSONObject object = new JSONObject();
                object.put("course_id", entity.getCourseId());
                object.put("course_time", entity.getCourseTime());
                object.put("course_address", entity.getCourseAddress());
                object.put("course_date", entity.getCourseDate());
                object.put("course_name", "临时课程名");
                jsonArray.add(object);
            }
            sevenJsons.add(jsonArray);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, sevenJsons);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_COURSE, method = RequestMethod.POST)
    @ResponseBody
    public void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CoursetableEntity entity = new CoursetableEntity();

        String time = request.getParameter("course_time");
        String address = request.getParameter("course_address");
        Date date = new Date(Calendar.getInstance().getTimeInMillis());

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(time)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "课程时间不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(address)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "课程地址不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setCourseTime(time);
        entity.setCourseAddress(address);
        entity.setCourseDate(date);
        entity = courseManager.addCourse(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

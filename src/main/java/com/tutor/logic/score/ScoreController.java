package com.tutor.logic.score;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.ExamInfomationEntity;
import com.tutor.logic.entity.ScoreInfomationEntity;
import com.tutor.logic.exam.ExamManager;
import com.tutor.logic.homework.HomeworkManager;
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
public class ScoreController {
    @Autowired
    private ScoreManager scoreManager;
    @Autowired
    private ExamManager examManager;


    @RequestMapping(value = WebApi.QUERY_SCORE_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ScoreInfomationEntity> list;
        String exam_id = request.getParameter("exam_id");
        if (exam_id != null) {
            list = scoreManager.queryByExamId(Integer.parseInt(exam_id));
        } else {
            list = scoreManager.queryAll();
        }

        JSONArray jsonArray = new JSONArray();
        for (ScoreInfomationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("score_id", entity.getScoreId());
            object.put("exam_id", entity.getExamId());
            object.put("student_id", entity.getStudentId());
            object.put("student_name", entity.getStudentName());
            object.put("score_num", entity.getScoreNum());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.QUERY_STUDENT_SCORE_LIST, method = RequestMethod.POST)
    @ResponseBody
    public void queryStudentScoreList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ScoreInfomationEntity> list;
        String student_id = request.getParameter("student_id");
        if (student_id != null) {
            list = scoreManager.queryByStudentId(Integer.parseInt(student_id));
        } else {
            list = scoreManager.queryAll();
        }

        JSONArray jsonArray = new JSONArray();
        for (ScoreInfomationEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("score_id", entity.getScoreId());
            object.put("exam_id", entity.getExamId());
            object.put("student_id", entity.getStudentId());
            object.put("student_name", entity.getStudentName());
            object.put("score_num", entity.getScoreNum());

            List<ExamInfomationEntity> exams = examManager.queryExamById(entity.getExamId());
            if (exams.size() > 0) {
                ExamInfomationEntity exam = exams.get(0);
                object.put("exam_name", exam.getExamName());
                object.put("subject_name", exam.getSubjectName());
            }

            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.ADD_SCORE, method = RequestMethod.POST)
    @ResponseBody
    public void addScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ScoreInfomationEntity entity = new ScoreInfomationEntity();

        String score_id = request.getParameter("score_id");
        String exam_id = request.getParameter("exam_id");
        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        String score_num = request.getParameter("score_num");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(score_num)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "分数不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        if (StringUtils.isEmpty(score_id) == false) {
            entity.setScoreId(Integer.parseInt(score_id));
        } else  {
//            entity.setExamId(0);
        }
        entity.setExamId(Integer.parseInt(exam_id));
        entity.setStudentId(Integer.parseInt(student_id));
        entity.setStudentName(student_name);
        entity.setScoreNum(score_num);
        entity = scoreManager.addScore(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}


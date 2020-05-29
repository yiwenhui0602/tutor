package com.tutor.logic.announcements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.AnnouncementManagementEntity;
import com.tutor.util.DateUtils;
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
public class AnnouncementsController {

    @Autowired
    private AnnouncementsManager announcementsManager;

    @RequestMapping(value = WebApi.QUERY_ANNOUNCEMENTS, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AnnouncementManagementEntity> list = announcementsManager.queryAll();

        JSONArray jsonArray = new JSONArray();
        for (AnnouncementManagementEntity entity : list) {
            JSONObject object = new JSONObject();
            object.put("notice_id", entity.getNoticeId());
            object.put("notice_title", entity.getNoticeTitle());
            object.put("notice_time", entity.getNoticeTime());
            object.put("notice_author", entity.getNoticeAuthor());
            object.put("notice_detail", entity.getNoticeDetail());
            jsonArray.add(object);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);

        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.POST_ANNOUNCEMENTS, method = RequestMethod.POST)
    @ResponseBody
    public void postAnnouncements(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AnnouncementManagementEntity entity = new AnnouncementManagementEntity();

        String title = request.getParameter("notice_title");
        String author = request.getParameter("notice_author");
        String detail = request.getParameter("notice_detail");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(title)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "标题不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(author)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "作者不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(detail)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "详情不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setNoticeTitle(title);
        entity.setNoticeAuthor(author);
        entity.setNoticeTime(DateUtils.getCurrentDate());
        entity.setNoticeDetail(detail);
        entity = announcementsManager.addAnnouncements(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

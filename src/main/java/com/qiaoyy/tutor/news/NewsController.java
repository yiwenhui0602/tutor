package com.qiaoyy.tutor.news;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiaoyy.tutor.WebApi;
import com.qiaoyy.tutor.entity.NewsManagementEntity;
import com.qiaoyy.util.MBResponse;
import com.qiaoyy.util.MBResponseCode;
import com.qiaoyy.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新闻
 *
 * @author 何金成
 * @date 2020/2/18 16:40
 */
@Controller
public class NewsController {

    @Autowired
    private NewsManager newsManager;

    @RequestMapping(value = WebApi.QUERY_NEWS, method = RequestMethod.POST)
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<NewsManagementEntity> list = newsManager.queryAll();

        // 构建返回结构
        JSONArray jsonArray = new JSONArray();
        for (NewsManagementEntity entity : list) {
            JSONObject newsObject = new JSONObject();
            newsObject.put("news_id", entity.getNewsId());
            newsObject.put("news_title", entity.getNewsTitle());
            newsObject.put("news_subtitle", entity.getNewsSubtitle());
            newsObject.put("news_date", entity.getNewsDate());
            newsObject.put("news_url", entity.getNewsUrl());
            jsonArray.add(newsObject);
        }

        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 返回数据
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.POST_NEWS, method = RequestMethod.POST)
    @ResponseBody
    public void postNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NewsManagementEntity entity = new NewsManagementEntity();

        String title = request.getParameter("news_title");
        String subtitle = request.getParameter("news_subtitle");
        String url = request.getParameter("news_url");

        MBResponse responseModel = null;

        // 参数校验
        if (StringUtils.isEmpty(title)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "标题不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(subtitle)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "子标题不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }
        if (StringUtils.isEmpty(url)) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.PARAMS_ERR, "链接不能为空");
            MBResponse.sendResponse(request, response, responseModel);
            return;
        }

        entity.setNewsTitle(title);
        entity.setNewsSubtitle(subtitle);
        entity.setNewsDate(DateUtils.getCurrentDate());
        entity.setNewsUrl(url);
        entity = newsManager.addNews(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

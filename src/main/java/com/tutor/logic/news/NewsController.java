package com.tutor.logic.news;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tutor.logic.WebApi;
import com.tutor.logic.entity.NewsManagementEntity;
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
 * @author 何金成
 * @date 2020/2/18 16:40
 */
@Controller
public class NewsController {

    // 声明一个newsManager对象
    @Autowired
    private NewsManager newsManager;

    // 该注解用于将url path与queryNews方法绑定，客户端调用该接口会自动调用该方法
    @RequestMapping(value = WebApi.QUERY_NEWS, method = RequestMethod.POST)//WebAPI是专门存放接口path静态常量的类
    @ResponseBody
    public void queryNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 直接调用newsManager的queryAll方法，获取NewsManagementEntity的对象数组
        List<NewsManagementEntity> list = newsManager.queryAll();

        // 构建一个空的数组，用于装json字典
        JSONArray jsonArray = new JSONArray();
        // for循环list中的每一个NewsManagementEntity对象
        for (NewsManagementEntity entity : list) {
            // 声明一个空的json、字典、Object
            JSONObject newsObject = new JSONObject();
            // 往字典里面塞键值对，左键右值，值为entity中的属性（其实是通过get方法，因为属性是私有的）
            newsObject.put("news_id", entity.getNewsId());
            newsObject.put("news_title", entity.getNewsTitle());
            newsObject.put("news_subtitle", entity.getNewsSubtitle());
            newsObject.put("news_date", entity.getNewsDate());
            newsObject.put("news_url", entity.getNewsUrl());
            // 把构造好的json字典添加到数组中
            jsonArray.add(newsObject);
        }

        // 将上面构造好的json数组搭配一个SUCCESS的code，构建响应对象
        MBResponse responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS, jsonArray);
        // 将响应对象发送出去
        MBResponse.sendResponse(request, response, responseModel);
    }

    @RequestMapping(value = WebApi.POST_NEWS, method = RequestMethod.POST)
    @ResponseBody
    public void postNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 首先创建一个用于添加到数据的NewsManagementEntity对象
        NewsManagementEntity entity = new NewsManagementEntity();
        // 从请求参数中分别取对应的参数
        String title = request.getParameter("news_title");
        String subtitle = request.getParameter("news_subtitle");
        String url = request.getParameter("news_url");

        // 先设置一个空的响应对象
        MBResponse responseModel = null;

        // 参数校验
        // 如果title为空的话，就构造一个error的响应对象，并发送出去
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

        // 给新创建的entity对象中的各个属性赋值
        entity.setNewsTitle(title);
        entity.setNewsSubtitle(subtitle);
        entity.setNewsDate(DateUtils.getCurrentDate());
        entity.setNewsUrl(url);
        // 调用newsManager的addNews方法，把对象直接传进去，还是用entity接收，如不为null，则表示添加成功，反之添加的数据库失败
        entity = newsManager.addNews(entity);

        if (entity != null) {
            responseModel = MBResponse.getMBResponse(MBResponseCode.SUCCESS);
        } else {
            responseModel = MBResponse.getMBResponse(MBResponseCode.DB_ERR);
        }
        MBResponse.sendResponse(request, response, responseModel);
    }
}

package com.tutor.logic;

/**
 * @author yiwenhui
 * @date 2020/2/18 15:32
 */
public class WebApi {
    // 登录
    public static final String USER_LOGIN = "/login";
    // 查询新闻
    public static final String QUERY_NEWS = "/newslist";
    // 查询公告
    public static final String QUERY_ANNOUNCEMENTS = "/announcements";
    // 发送新闻
    public static final String POST_NEWS = "/post/news";
    // 发送公告
    public static final String POST_ANNOUNCEMENTS = "/post/announcements";
    // 查询班级列表
    public static final String QUERY_CLASS_LIST = "/classList";
    // 添加班级列表
    public static final String ADD_CLASS = "/add/class";
    // 查询科目列表
    public static final String QUERY_SUBJECT_LIST = "/subjectList";
    // 查询单个科目信息
    public static final String QUERY_SUBJECT_INFO = "/subjectInfo";
    // 添加科目
    public static final String ADD_SUBJECT_LIST = "/add/subject";
    // 查询教师列表
    public static final String QUERY_TEACHER_LIST = "/teacherList";
    // 添加教师
    public static final String ADD_TEACHER = "/add/teacher";
    // 查询课程列表
    public static final String QUERY_COURSE_LIST = "/courseList";
    // 添加课程
    public static final String ADD_COURSE = "/add/course";
    // 查询作业列表
    public static final String QUERY_HOMEWORK_LIST = "/homeworkList";
    // 添加作业
    public static final String ADD_HOMEWORK = "/add/homework";
    // 查询学生列表
    public static final String QUERY_STUDENT_LIST = "/studentList";
    // 添加学生
    public static final String QUERY_ADD_STUDENT = "/add/student";
    // 查询考试列表
    public static final String QUERY_EXAM_LIST = "/examList";
    // 添加考试
    public static final String ADD_EXAM = "/add/exam";
    // 查询分数  exam_id  or  student_id
    public static final String QUERY_SCORE_LIST = "/scoreList";
    // 查询学生分数 student_id
    public static final String QUERY_STUDENT_SCORE_LIST = "/studentScoreList";
    // 添加分数
    public static final String ADD_SCORE = "/add/score";
}

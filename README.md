# tutor

项目是一个简单的【家校互动平台】，角色包括：管理员、教师、学生、家长。



首先看一下数据库表。
![image-20200119153136808](./README_imgs/WeChat4723abb641d4dac4557789d97b8f85ed.png)

接口文档：全用Post请求，返回统一格式为：code、msg、result（以下Response为result字段）

1、登录：
account_type  
0:管理员
1:教师
2:学生
3:家长

| Path     | /login                                                       |
| -------- | ------------------------------------------------------------ |
| Params   | {"account_number":xxx, "account_type":xxx, account_password:xxx} |
| Response | {"account_number":xxx, "account_type":xxx, account_id:xxx} |

2、新闻列表：

| Path     | /newslist                                                    |
| -------- | ------------------------------------------------------------ |
| Params   | -                                                            |
| Response | [{"news_id", "new_title", "news_subtitle", "news_date", "news_url"}]  【news表所有字段】 |

3、公告列表：

| Path     | /announcements             |
| -------- | -------------------------- |
| Params   | -                          |
| Response | 【announcement表所有字段】 |

4、添加新闻

| Path     | /post/news                  |
| -------- | -------------------------- |
| Params   | 【news表所有字段（除id）】 |
| Response | -                          |

5、添加公告

| Path     | /post/announcements                 |
| -------- | ---------------------------------- |
| Params   | 【announcement表所有字段（除id）】 |
| Response | -                                  |

6、获取班级列表

| Path     | /classList            |
| -------- | --------------------- |
| Params   | -                     |
| Response | 数组[class表所有字段] |

7、获取科目列表

| Path     | /subjectList            |
| -------- | ----------------------- |
| Params   | -                       |
| Response | 数组[subject表所有字段] |

8、获取教师列表

| Path     | /teacherList            |
| -------- | ----------------------- |
| Params   | -                       |
| Response | 数组[teacher表所有字段] |

9、获取课程表列表

| Path     | /courseList            |
| -------- | ---------------------- |
| Params   | class_id               |
| Response | 数组[course表所有字段] |

10、获取作业列表

| Path     | /homeworkList            |
| -------- | ------------------------ |
| Params   | class_id                 |
| Response | 数组[homework表所有字段] |

11、添加教师信息

| Path     | /addTeacher           |
| -------- | --------------------- |
| Params   | 【teacher表所有字段】 |
| Response |                       |



登录入口：

![image-20200119153136808](./README_imgs/image-20200119153136808.png)

## 【管理员】

登录界面其实四个角色都一样。只不过管理员就一个账号，假设账号密码都为admin。

![image-20200119154247750](./README_imgs/image-20200119154247750.png)

因为是一个App 4个角色用，登录肯定复用同一个。所以在登录时要存储登录的角色。并且为了简化，没有token，也没有过期，校验成功即可，最多保存id和角色，知道当前用户是谁就行。

![image-20200119154610753](./README_imgs/image-20200119154610753.png)

![image-20200119154942853](./README_imgs/image-20200119154942853.png)

每个角色登录成功后都有三个tab，分别为“信息管理”、“教务管理”、“我的”。虎哥你可以搞个配置文件，到时候我们修改起来方便，切图随便搞一个占位就可以。

第一个“信息管理”是每个角色都有的，但只有管理员右上角有添加入口。添加页码如下：

![image-20200119155128157](./README_imgs/image-20200119155128157.png)

管理员的第二个标签如下：

![image-20200119155217486](./README_imgs/image-20200119155217486.png)

其中教师管理：

![image-20200119155248308](./README_imgs/image-20200119155248308.png)

班级管理：

![image-20200119155333163](./README_imgs/image-20200119155333163.png)

科目管理：

![image-20200119155401285](./README_imgs/image-20200119155401285.png)

这些都包含了角色的创建。

管理员最后一个tab“我的”，其实4个角色都差不多，就简单展示一些信息即可：

![image-20200119155456077](./README_imgs/image-20200119155456077.png)



## 【教师】

除了管理员，教师、学生、家长登录时候都还有一个注册的功能，例如当管理员添加了教师账号A，表示A可以注册登录，因为A在教师表有记录，会先用A的信息去用户表查有没有账号密码，如果没有表示没注册，跳到注册页面。注册成功后，用户表有记录了，才可以登录。学生、家长亦是如此。

![image-20200119155844962](./README_imgs/image-20200119155844962.png)

第一个tab和管理员一样，只是没有添加入口。来看第二个入口：

![image-20200119155933050](./README_imgs/image-20200119155933050.png)

成绩管理包括：

![image-20200119155953177](./README_imgs/image-20200119155953177.png)

作业管理包括：

![image-20200119160012888](./README_imgs/image-20200119160012888.png)



## 【学生】

还是看第二个tab：

![image-20200119160056782](./README_imgs/image-20200119160056782.png)

分别为：

![image-20200119160143964](./README_imgs/image-20200119160143964.png)

课表的页面，前面有过，复用即可。

## 【家长】

**暂缺，后补**
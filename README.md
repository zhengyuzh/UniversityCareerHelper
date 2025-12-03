# 系统使用说明
- 该系统是在若以框架的基础上进行的开发，前端使用的是Thymeleaf + BootStrap进行开发
- 视频效果演示地址：<a href ="https://b23.tv/UmKIxMY" >B站视频传送门</a>
- 本篇文章的结尾有部署教程说明和登录账号(不同角色用户)
## 环境配置说明
- JDK 1.8
- Mysql 5.7+
- Maven 3.3.9
- IDEA 2020

## 项目基本介绍
数据库：数据库由于一些个人原因 未公布在Github 上。我的个人微信公众号：乡下小哥编程。微信公众号私信 回复 高校学生求职就业互助系统数据库， 就可以自动获取数据库脚本的相关链接，一定要 回复 高校学生求职就业互助系统数据库。错一个字 都无法自动获取到的。

## 功能划分大致说明
- A.招聘信息发布模块的主体是教师用户和企业用户，学生用户只能浏览招聘信息。
- B.求职信息发布模块的主体是学生用户，教师和企业用户可以浏览学生发布的求职信息。
- C.就业互助社区模块教师，企业，学生都可以使用，教师发布就业指导内容帖，企业发布企业需要什么样的人才之类的需求帖，学生发怎样才能找到称心如意的工作之类的求助帖（比如果成功找到工作的学长学姐分享经验之类的,或者单纯提问怎么才能找到工作的）
- D.统计分析模块，可以统计各类求职、就业信息的数据（根据本网站求职就业发布内容来统计），并进行可视化的展示。
- E.企业对象，以及企业信息管理模块，功能是可以发布招聘信息，浏览求职信息。
- F.用户可以发布知识文章、其它用户可以浏览相关详情。
- G.管理员可以对用户发布的评论、文章信息、社区交流帖子进行审核。审核通过的才会对外展示。
- H.管理员可以管理用户信息、给角色分配权限等。

<img width="2022" height="1744" alt="系统功能划分" src="https://github.com/user-attachments/assets/46c682b7-b134-451d-bd7d-ef420ed292ba" />

## 实现效果演示
- 视频效果演示地址：<a href ="https://b23.tv/UmKIxMY" >B站视频传送门</a>
- 实现效果部分截图
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/9658a3a1-46e6-4300-8dbe-1659c71486cb" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/02bbbe4b-5bc2-4bb1-827a-74df9f600dc8" />

<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/7c5034eb-7d99-47f4-bd61-1350f53c61f9" />
<img width="1920" height="778" alt="image" src="https://github.com/user-attachments/assets/63f971bd-29b8-4e8e-bf67-99277ee6ae42" />

<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/8f778868-44c7-4bcd-864b-35c6c7a5f3d0" />
<img width="1920" height="807" alt="image" src="https://github.com/user-attachments/assets/ac2d58a9-69e4-4698-859c-9794b77870d5" />

<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/68ad305d-9032-4695-80ab-46987a665d4b" />
<img width="1920" height="782" alt="image" src="https://github.com/user-attachments/assets/e1f6aa46-d507-40ec-a505-bc8ee305d3c2" />

<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/f224e1c8-2441-4f0b-91f8-61355dcaa7bf" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/9b1f06ec-bbbb-46d2-a3cd-b9dd97e64f8a" />
<img width="1920" height="588" alt="image" src="https://github.com/user-attachments/assets/643500e5-6900-4356-8189-4c1d5b238ed4" />


<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/c3baf3bd-5e3d-48de-891a-7918442dba70" />
<img width="1920" height="797" alt="image" src="https://github.com/user-attachments/assets/86607a92-8bed-4e9b-a7e7-bd35227b18cd" />

<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/371b940c-ff61-496a-abff-327529bc5400" />
<img width="1920" height="798" alt="image" src="https://github.com/user-attachments/assets/cc6b6a30-7ef5-4996-b7fc-b3a681d87afe" />

- 普通学生用户
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/c3b1760a-8b2d-4cf6-8179-4d211d894093" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/d4feb9ed-fd76-4f82-9066-675a8cb101b2" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/bf45a7b5-83ce-426f-b0c8-6b135a2e2e53" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/f79e1f44-445c-43b8-9a08-b664aa536bf0" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/fbbefc0c-96ed-4dd4-bcbd-7eadf4a9c304" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/fea94069-70c1-4362-8673-80b88f0e55da" />

- 教师用户
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/6d75c331-4186-4998-b3fd-dd273fabce54" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/14d8701c-da9a-44f8-9bc3-c6a28f797350" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/14cd4586-654d-4641-b050-2caa3cc6c2fe" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/d1874ccc-1f77-415c-83ff-bb84e88ea003" />

- 企业用户
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/1ec771be-4333-44c1-817c-d6078fe1f84c" />

- 管理员
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/9c458494-c57d-4021-8958-30190fdeefc8" />
<img width="1920" height="911" alt="image" src="https://github.com/user-attachments/assets/f5b0e5b5-7fa5-4022-93a2-c104e831a35b" />



## 系统部署使用说明


- 配置项目使用jdk
<img width="431" height="376" alt="image" src="https://github.com/user-attachments/assets/c89738b1-46d4-46a5-b80a-9bb011684878" />
<img width="958" height="510" alt="image" src="https://github.com/user-attachments/assets/dadce3aa-c47b-44d2-8bad-8838db4015e9" />

- maven配置
<img width="414" height="389" alt="image" src="https://github.com/user-attachments/assets/f49b1647-d292-4412-ad6b-42e0571b4e81" />
<img width="958" height="486" alt="image" src="https://github.com/user-attachments/assets/1b8178e5-e2d4-401c-b54b-ece4f7f2cff6" />


- 修改数据库连接的账号和密码
<img width="1920" height="1030" alt="image" src="https://github.com/user-attachments/assets/686a22f1-2c18-40b1-a107-a70e7e44cb4e" />

- 首先确保Pom文件中的所有依赖下载成功，如果下载失败，可能会导致项目运行失败
<img width="958" height="514" alt="image" src="https://github.com/user-attachments/assets/e43ad891-7737-49e7-9cbf-f4d12ead9126" />
- 【如何清理缓存】：如果pom文件还有爆红，并且启动项目不成功，尝试清理缓存 重启启动IDEA加载项目。
<img width="958" height="482" alt="image" src="https://github.com/user-attachments/assets/4d2ceb68-3155-43b3-be12-9068f667f839" />

 - 找到项目的启动类，点击启动即可，启动类一般是在Main目录下，名称是Application。查看控制台打印的日志信息，启动成功，会显示启动花费多长时间。
 <img width="1920" height="1030" alt="image" src="https://github.com/user-attachments/assets/e4d0d368-ef7c-4cf6-a1bb-8407049cf3ae" />

- 普通用户

账号：zhangsan
密码：123456

账号：yonghu1
密码：123456

- 企业用户

账号：qiye1
密码：123456

账号：qiye2
密码：123456

- 教师用户

账号：jiaoshi1
密码：123456

- 管理员

账号：admin
密码：admin123

个人微信联系添加方式：18348375641













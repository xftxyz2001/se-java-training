# 需求设计说明书

## 1 概述
本系统是一个高校学生管理系统，主要包括成绩管理、课程管理、学生管理和系统管理四个模块。该系统使用Spring Boot框架作为后端开发技术，使用Vue.js作为前端开发技术。

## 2 功能需求

### 2.1 成绩管理模块
1. 录入成绩：教师可以输入学生的考试成绩；
2. 查询成绩：学生和教师可以查询某门课程或某位学生的考试成绩，并显示相应的统计信息；
3. 更新成绩：教师可以修改学生的成绩。

### 2.2 课程管理模块
1. 添加课程：管理员可以添加新的课程信息；
2. 删除课程：管理员可以删除指定的课程信息；
3. 修改课程：管理员可以修改课程的信息；
4. 查询课程：学生和教师可以查询所有的课程信息。

### 2.3 学生管理模块
1. 添加学生：管理员可以添加新的学生信息；
2. 删除学生：管理员可以删除指定的学生信息；
3. 修改学生：管理员可以修改学生的信息；
4. 查询学生：学生和教师可以查询所有的学生信息。

### 2.4 系统管理模块
1. 用户权限管理：管理员可以创建新用户和删除已有用户；
2. 角色权限管理：管理员可以创建新角色和删除已有角色；
3. 日志记录管理：系统记录所有的操作日志，并提供查询功能。

## 非功能需求

### 3.1 性能需求
1. 响应时间要求：系统对于高并发请求，响应时间不超过2秒。
2. 数据处理能力：系统能够支持每秒1000条以上的数据处理能力。

### 3.2 可用性需求
1. 系统可用性：系统24小时稳定运行，系统故障不超过1小时。
2. 数据可靠性：数据备份、灾备功能保证数据安全可靠。

### 3.3 安全性需求
1. 用户权限管理：系统需要保证用户只能访问其具有权限的数据；
2. 数据加密传输：系统需要使用SSL等加密协议对用户的数据进行加密传输，保证数据传输的安全性；
3. 防止SQL注入攻击：系统需要对输入数据进行合法性检查，防止SQL注入攻击。

## 4 界面设计
本系统采用响应式设计，兼容PC端和移动端。界面整体采用简洁明了的风格，易于操作和理解。界面颜色以蓝色为主，给人舒适的感觉。各个模块的界面设计风格一致，方便用户使用。

## 5 数据库设计
数据库使用MySQL，共设计五张表：user、role、permission、student、course、score。

## 6 技术架构
后端采用Spring Boot框架，前端采用Vue.js框架，使用RESTful API进行通信。系统采用分层架构，将数据访问、业务处理和控制器分别放置在不同的层中。系统使用MyBatis作为ORM框架和Spring Security作为权限框架。

## 7 部署方案
系统将部署在Linux服务器上，使用Docker容器技术。后端使用Nginx或Apache作为Web服务器，前端使用Node.js搭建开发环境，并使用Webpack打包。系统使用Jenkins进行自动化部署。

## 8 测试方案
本系统包括单元测试、集成测试和系统测试。单元测试通过JUnit和Mockito等工具进行，集成测试通过Postman或类似的工具进行接口测试，系统测试则由专门的测试人员负责。测试结果将会作为最终交付的一部分，确保系统的质量和稳定性。

## 9 维护方案
为了保证系统的持续运行和稳定性，需要进行日常的维护和更新。维护包括对系统的监控、故障处理、数据备份、安全检查等。更新包括对系统的升级、功能扩展、性能优化等。维护和更新可以委托给专业的运维团队或者由开发团队负责。

## 10 项目管理
本项目使用敏捷开发模式进行管理，采用Scrum框架进行项目管理。项目分为多个Sprint，每个Sprint都有一个明确的目标和交付物。每个Sprint包括计划会议、每日站立会议、评审会议和回顾会议。在项目管理过程中，需要不断与客户沟通，及时反馈用户需求和问题，以确保项目的顺利完成。

## 11 版权声明
本系统所有代码和文档均受版权法保护，未经作者许可不能进行任何形式的复制、转载或修改。任何侵犯版权者将承担法律责任。


# 数据库设计

## 用户表（users）

```sql
CREATE TABLE users (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
username varchar(50) NOT NULL COMMENT '用户名',
password varchar(100) NOT NULL COMMENT '密码',
name varchar(50) DEFAULT NULL COMMENT '姓名',
email varchar(50) DEFAULT NULL COMMENT '邮箱',
phone varchar(20) DEFAULT NULL COMMENT '手机号',
create_time datetime DEFAULT NULL COMMENT '创建时间',
update_time datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (id),
UNIQUE KEY username_UNIQUE (username),
UNIQUE KEY email_UNIQUE (email),
UNIQUE KEY phone_UNIQUE (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
```

## 角色表（roles）

```sql
CREATE TABLE roles (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
name varchar(50) NOT NULL COMMENT '角色名称',
description varchar(100) DEFAULT NULL COMMENT '描述',
PRIMARY KEY (id),
UNIQUE KEY name_UNIQUE (name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
```

## 权限表（permissions）

```sql
CREATE TABLE permissions (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
name varchar(50) NOT NULL COMMENT '权限名称',
url varchar(100) DEFAULT NULL COMMENT '权限对应的URL',
PRIMARY KEY (id),
UNIQUE KEY name_UNIQUE (name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
```

## 学生表（students）

```sql
CREATE TABLE students (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
name varchar(50) DEFAULT NULL COMMENT '姓名',
gender tinyint(1) DEFAULT NULL COMMENT '性别，0表示女，1表示男',
age int(3) DEFAULT NULL COMMENT '年龄',
student_no varchar(20) NOT NULL COMMENT '学号',
class_id int(11) DEFAULT NULL COMMENT '班级ID',
create_time datetime DEFAULT NULL COMMENT '创建时间',
update_time datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (id),
UNIQUE KEY student_no_UNIQUE (student_no),
KEY fk_class_id_idx (class_id),
CONSTRAINT fk_class_id FOREIGN KEY (class_id) REFERENCES classes (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='学生表';
```

## 班级表（classes）

```sql
CREATE TABLE classes (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
name varchar(50) DEFAULT NULL COMMENT '班级名称',
department varchar(50) DEFAULT NULL COMMENT '所属院系',
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='班级表';
```

## 课程表（courses）

```sql
CREATE TABLE courses (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
name varchar(50) DEFAULT NULL COMMENT '课程名称',
teacher varchar(50) DEFAULT NULL COMMENT '授课老师',
credit double DEFAULT NULL COMMENT '学分',
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='课程表';
```

## 成绩表（scores）

```sql
CREATE TABLE scores (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
course_id int(11) DEFAULT NULL COMMENT '课程ID',
student_id int(11) DEFAULT NULL COMMENT '学生ID',
score_val double DEFAULT NULL COMMENT '成绩',
exam_time datetime DEFAULT NULL COMMENT '考试时间',
PRIMARY KEY (id),
KEY fk_course_id_idx (course_id),
KEY fk_student_id_idx (student_id),
CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES courses (id),
CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES students (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='成绩表';
```

## 日志表（logs）

```sql
CREATE TABLE logs (
id int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
user_id int(11) DEFAULT NULL COMMENT '用户ID',
operation varchar(50) DEFAULT NULL COMMENT '操作类型',
operation_time datetime DEFAULT NULL COMMENT '操作时间',
operation_ip varchar(50) DEFAULT NULL COMMENT '操作IP地址',
detail varchar(1000) DEFAULT NULL COMMENT '操作详情',
PRIMARY KEY (id),
KEY fk_user_id_idx (user_id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='日志表';
```

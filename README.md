# 学生管理系统后端 (Student Management System)

## 📌 项目简介
这是一个基于 Spring Boot + MyBatis 的学生管理系统后端 API 项目。
支持学生的增删改查、批量插入，以及全局异常处理与事务回滚。
是我在 2026 年 10 月自学 Java 后的第一个企业级 Web 项目。

## 🛠️ 技术栈
- **后端框架**：Java 17, Spring Boot 3
- **持久层**：MyBatis, MySQL
- **工具**：Lombok, Maven, IDEA HTTP Client
- **核心机制**：依赖注入（IoC）、AOP 事务管理、全局异常处理

## ✨ 功能模块
- [x] 查询全部学生
- [x] 根据 ID 查询单个学生
- [x] 添加学生（含年龄校验、ID 重复校验）
- [x] 修改学生信息
- [x] 删除学生
- [x] 批量添加学生（含事务回滚验证）

## 📂 项目结构
src/main/java/com/example/demo/
├── controller/    # 接收前端请求，处理 Web 接口
├── service/       # 业务逻辑层，处理参数校验与事务
├── mapper/        # 数据访问层，对接 MyBatis 和 MySQL
├── entity/        # 实体类，对应数据库表结构
├── handler/       # 全局异常处理器
└── util/          # 自定义业务异常工具类

## 🔌 接口列表
| 请求方式 | 接口路径 | 功能描述 |
| :--- | :--- | :--- |
| GET | /students | 查询所有学生 |
| GET | /students/{id} | 根据ID查询学生 |
| POST | /students | 添加学生 |
| PUT | /students | 修改学生信息 |
| DELETE | /students/{id} | 删除学生 |
| POST | /students/batch | 批量添加学生 |

## 🚀 如何运行
1. 在 MySQL 中创建数据库 `student_db` 和学生表 `student`。
2. 修改 `src/main/resources/application.properties` 中的数据库账号密码。
3. 运行 `DemoApplication.java` 启动项目。
4. 打开 IDEA 自带的 `test.http` 文件，点击绿色三角即可测试接口。

## 🧠 难点与解决
- **手写 JDBC 转 MyBatis**：从手动管理 Connection/PreparedStatement/ResultSet，转为使用 `@Mapper` 和注解，体会到 ORM 框架对开发效率的提升。
- **事务控制**：从手写 `setAutoCommit(false)` / `rollback()` 转为使用 `@Transactional`，理解声明式事务的底层原理。
- **全局异常处理**：使用 `@RestControllerAdvice` 统一拦截异常，将难以阅读的 HTTP 500 错误转换为前端友好的 JSON 格式。
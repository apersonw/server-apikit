# 后端API集成框架
# 项目说明文档
## 项目分层结构：
#### 控制器：
- spring boot starter
- 注解说明：
1. 生成测试接口方法：@Api
2. rest控制器：@RestController
3. 请求路径注解：@RequestMapping(value = "v1")
#### 业务逻辑：
- spring
#### DAO
- jdbc Template
#### 缓存
- redis端口：6382
#### 数据库
- mysql端口：3307
- flyway
#### Web 应用服务器
- tomcat端口：8078

#### 三个启动类介绍
- 项目启动类：cn.happy.server.app.AppApiMain
1. AppApiMain加载所有依赖lib文件
- API文档生成类：cn.happy.server.app.AppApiBuilderMain
1. 根据API接口注释自动化提取信息生成接口文档
2. 接口文档访问地址：http://localhost:8081/apidoc/index.html
3. 自动化生成 Spring Test 类型的测试类 ApiManager
- DAO层生成类：cn.happy.server.app.AppApiDaoBuilder
1. 根据db.migration下SQL语句生成的表自动化生成对应的DAO层

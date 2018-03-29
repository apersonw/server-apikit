package cn.happy.server.app;

import org.forkjoin.apikit.Analyse;
import org.forkjoin.apikit.Context;
import org.forkjoin.apikit.Manager;
import org.forkjoin.apikit.ObjectFactory;
import org.forkjoin.apikit.generator.ApiDocGenerator;
import org.forkjoin.apikit.generator.JavaClientGenerator;
import org.forkjoin.apikit.generator.apidoc.ApiDocProject;
import org.forkjoin.apikit.impl.JdtAnalyse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class AppApiBuilderMain {
    private static final Logger log = LoggerFactory.getLogger(AppApiBuilderMain.class);

    public static void main(String[] args) throws Exception {
        final String version = "v1";
        File root = new File("server-app");
        //如果路径错误，可以在这里添加
        if (!root.exists()) {
            root = new File("server/server-app");
        }

        File dir = new File(root, "src/main/java/");
        File apiDoc = new File(root, "src/main/resources/static/apidoc");
        File javaClientDir = new File(root, "src/test/java/");

        // TODO 修改下面的乱七八糟的路径
        log.info("代码路径:{}", dir.getAbsolutePath());


        Manager manager = new Manager();
        manager.setPath(dir.getAbsolutePath());
        manager.setRootPackage("cn.happy.server.app");
        manager.setObjectFactory(objectFactory);

        //开始处理
        manager.analyse();

        {
            JavaClientGenerator generator = new JavaClientGenerator();
            generator.setOutPath(javaClientDir.getAbsolutePath());
            generator.setVersion(version);
            generator.setRootPackage("cn.happy.server.app.client");
            manager.generate(generator);
        }

        {
            ApiDocGenerator generator = new ApiDocGenerator();
            generator.setOutPath(apiDoc.getAbsolutePath());
            generator.setVersion(version);
            generator.setAmd(true);
            ApiDocProject apiDocProject = new ApiDocProject();
            apiDocProject.setName("API接口文档");
            apiDocProject.setDescription("API接口文档");
            apiDocProject.setTitle("API接口文档");
            apiDocProject.setUrl("http://www.project.com/v1/");
            apiDocProject.setSampleUrl("http://test.project.com/v1/");

            apiDocProject.setHeader(new ApiDocProject.Header("公共说明", "\n" +
                    "<h1 id=\"API接口文档\">API接口文档</h1>\n" +
                    "\n" +
                    "<p>相关接口采用http restfull实现，可提供java 和 nodejs sdk。</p>\n" +
                    "\n" +
                    "<hr>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<h2 id=\"一-公共部分\">一. 公共部分</h2>\n" +
                    "\n" +
                    "<ol start=\"1\"><li rel=\"1\">服务器地址</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>测试服务器地址 <a href=\"http://test.a.happy.cn/v1/\" target=\"_blank\">http://test.project.com/v1/</a> <br>\n" +
                    "正式服务器地址 <a href=\"https://a.happy.cn/v1/\" target=\"_blank\">http://www.project.com/v1/</a></p>\n" +
                    "\n" +
                    "<ol start=\"2\"><li rel=\"2\">请求</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>POST 正文都是 <strong>application/x-www-from-urlencoded</strong></p>\n" +
                    "\n" +
                    "<blockquote>\n" +
                    "  <p>标准的 表单形式</p>\n" +
                    "</blockquote>\n" +
                    "\n" +
                    "<ol start=\"3\"><li rel=\"3\">登录(accessToken)</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>除了获取登录协议本身，其他协议都需要 accessToken</p>\n" +
                    "\n" +
                    "<p>通过http header authorization 传递 accessToken 给服务器</p>\n" +
                    "\n" +
                    "<blockquote>\n" +
                    "  <p>获取accessToken 参加后面的说明</p>\n" +
                    "</blockquote>\n" +
                    "\n" +
                    "<ol start=\"4\"><li rel=\"4\">返回值</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>返回值都是 JSON，后面协议说明的数据说明都是指 data 字段</p>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<h3 id=\"字段说明\">字段说明</h3>\n" +
                    "\n" +
                    "<table>\n" +
                    "<thead>\n" +
                    "<tr>\n" +
                    "  <th align=\"left\">字段名字</th>\n" +
                    "  <th align=\"center\">类型</th>\n" +
                    "  <th align=\"center\">名称</th>\n" +
                    "  <th align=\"left\">说明</th>\n" +
                    "</tr>\n" +
                    "</thead>\n" +
                    "<tbody><tr>\n" +
                    "  <td align=\"left\">status</td>\n" +
                    "  <td align=\"center\">Number</td>\n" +
                    "  <td align=\"center\">状态</td>\n" +
                    "  <td align=\"left\">0:表示正确, 其他参见下面说明</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "  <td align=\"left\">msg</td>\n" +
                    "  <td align=\"center\">String</td>\n" +
                    "  <td align=\"center\">错误说明</td>\n" +
                    "  <td align=\"left\">错误的描述文本</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "  <td align=\"left\">data</td>\n" +
                    "  <td align=\"center\">Object(任何类型)</td>\n" +
                    "  <td align=\"center\">数据</td>\n" +
                    "  <td align=\"left\">详细的数据内容</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "  <td align=\"left\">msgMap</td>\n" +
                    "  <td align=\"center\">Object(字符串键值对)</td>\n" +
                    "  <td align=\"center\">错误说明表</td>\n" +
                    "  <td align=\"left\">字符串键值对，键表示错误的字段，值表示错误的描述</td>\n" +
                    "</tr>\n" +
                    "</tbody></table>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<h3 id=\"状态说明\">状态说明</h3>\n" +
                    "\n" +
                    "<p>status 表示状态说明</p>\n" +
                    "\n" +
                    "<ol><li rel=\"1\">0:正确。</li>\n" +
                    "<li rel=\"2\">1:表示参数错误, 一般情况下错误都是这个类型。</li>\n" +
                    "<li rel=\"3\">-1:表示权限错误，</li>\n" +
                    "<li rel=\"4\">-2:客户端错误，</li>\n" +
                    "<li rel=\"5\">-3:客户端取消，</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>正确返回如下</p>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<pre class=\"prettyprint hljs-dark\"><code class=\"language-json hljs\">{<br>  <span class=\"hljs-attr\">\"status\"</span>:<span class=\"hljs-number\">0</span>,<br>  <span class=\"hljs-attr\">\"msg\"</span>:<span class=\"hljs-literal\">null</span>,<br>  <span class=\"hljs-attr\">\"data\"</span>:{<span class=\"hljs-attr\">\"accessToken\"</span>:<span class=\"hljs-string\">\"EzQ6DV5rQkK92vfrB+kRsQJQM8jTeSZu\"</span>,<span class=\"hljs-attr\">\"expiresSecond\"</span>:<span class=\"hljs-number\">0</span>},<br>  <span class=\"hljs-attr\">\"msgMap\"</span>:<span class=\"hljs-literal\">null</span><br>}<br></code></pre>\n" +
                    "\n" +
                    "<p>错误返回如下</p>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<pre class=\"prettyprint hljs-dark\"><code class=\"language-json hljs\">{<br>  <span class=\"hljs-attr\">\"status\"</span>:<span class=\"hljs-number\">1</span>,<br>  <span class=\"hljs-attr\">\"msg\"</span>:<span class=\"hljs-literal\">null</span>,<br>  <span class=\"hljs-attr\">\"data\"</span>:<span class=\"hljs-literal\">null</span>,<br>  <span class=\"hljs-attr\">\"msgMap\"</span>:{<span class=\"hljs-attr\">\"secretKey\"</span>:<span class=\"hljs-string\">\"secretKey错误\"</span>}<br>}<br></code></pre>\n" +
                    "\n" +
                    "<hr>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<h2 id=\"二授权\">二.授权</h2>\n" +
                    "\n" +
                    "<ul><li>除了登录协议以外的协议都需要通过授权协议获取 AccessToken</li>\n" +
                    "</ul>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<h3 id=\"1-登录\">1 登录</h3>\n" +
                    "\n" +
                    "<ol><li rel=\"1\">uri: 服务器url + token（例如: <a href=\"http://test.project.cn/v1/token\" target=\"_blank\">http://test.a.happy.cn/v1/login</a>）</li>\n" +
                    "<li rel=\"2\">method: post</li>\n" +
                    "<li rel=\"3\">参数(LoginForm)</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<table>\n" +
                    "<thead>\n" +
                    "<tr>\n" +
                    "  <th align=\"left\">字段名字</th>\n" +
                    "  <th align=\"center\">类型</th>\n" +
                    "  <th align=\"center\">名称</th>\n" +
                    "  <th align=\"left\">说明</th>\n" +
                    "</tr>\n" +
                    "</thead>\n" +
                    "<tbody><tr>\n" +
                    "  <td align=\"left\">name</td>\n" +
                    "  <td align=\"center\">String</td>\n" +
                    "  <td align=\"center\">用户名</td>\n" +
                    "  <td align=\"left\">分配的秘钥id</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "  <td align=\"left\">password</td>\n" +
                    "  <td align=\"center\">String</td>\n" +
                    "  <td align=\"center\">密码</td>\n" +
                    "  <td align=\"left\">分配的秘钥值</td>\n" +
                    "</tr>\n" +
                    "</tbody></table>\n" +
                    "\n" +
                    "\n" +
                    "<ol start=\"4\"><li rel=\"4\">返回值（String）</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<p>accessToken</p>\n" +
                    "\n" +
                    "<ol start=\"5\"><li rel=\"5\">错误信息</li>\n" +
                    "</ol>\n" +
                    "\n" +
                    "<blockquote>\n" +
                    "  <p>返回值会详细描述错误的原因</p>\n" +
                    "</blockquote>\n" +
                    "\n" +
                    "<hr>"));

            generator.setApiDocProject(apiDocProject);
            manager.generate(generator);
        }
    }

    private static ObjectFactory objectFactory = new ObjectFactory() {
        @Override
        public Analyse createAnalyse() {
            return new JdtAnalyse();
        }

        @Override
        public Context createContext() {
            return new Context();
        }
    };
}

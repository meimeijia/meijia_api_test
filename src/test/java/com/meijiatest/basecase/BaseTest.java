package com.meijiatest.basecase;

import com.meijiatest.utils.PropertiesReaderUtil;
import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.path.json.config.JsonPathConfig;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

/**
 * @Description 接口测试的一些初始化工作，是所有 testcase 的父类
 * @Author meijia
 * @Date 2023/12/04 16:30
 * @Version 1.0
 */
@Slf4j
public class BaseTest {

    /**
     * 执行一个测试套之前执行，进行配置文件的读取操作
     * @param propertiesPath config.properties配置文件相对于项目的路径
     * @throws IOException IOException
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"propertiesPath"})
    public void beforeSuite(@Optional("src/test/resources/config/config.properties") String propertiesPath) throws IOException {
        /**
         * Optional注解表示当参数中找不到propertiesPath时，读取此注解赋予的值
         */
        // 1. 配置文件读取
        PropertiesReaderUtil.readProperties(propertiesPath);

        // 2. 判断有没有存放日志文件的Log目录，没有则创建
        File file = new File("Log");
        if (!file.exists() || !file.isDirectory()) {
            log.info("在当前项目下创建存放日志文件的Log文件夹");
            file.mkdir();
        } else {
            log.info("当前项目下已经存在存放日志文件的Log文件夹，无需再次创建");
        }

        // 3. 配置BigDecimal类型，用来获取响应的浮点类型
        RestAssured.config =
                RestAssured.config().jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL));
    }

    @BeforeTest
    public void beforeTest() {

    }

    /**
     * AfterTest
     */
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        // todo : 其他资源释放
    }

    /**
     * AfterSuite
     */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        // todo : 资源释放
    }
}


package com.meijiatest.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Description 读取 config.properties 文件的工具类
 * @Author gaoqize
 * @Date 2021/12/14 16:04
 * @Version 1.0
 */
@Slf4j
public class PropertiesReaderUtil {
    /**
     * 配置文件类
     */
    private static final Properties PROPERTIES = new Properties();

    /**
     * 私有化构造器，不允许外部构造
     */
    private PropertiesReaderUtil() {
    }

    /**
     * 读取 properties配置文件
     * @param propertiesPath 配置文件路径
     * @return PROPERTIES
     * @throws IOException IOException
     */
    public static Properties readProperties(String propertiesPath) throws IOException {
        log.info("开始读取config.properties配置文件");
        InputStream inputStream = new FileInputStream(propertiesPath);
        // 读取配置文件通过 utf-8 编码方式读取
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PROPERTIES.load(bufferedReader);
        return PROPERTIES;
    }

    /**
     * 依据键名获取配置文件中的键值
     * @param key 键名
     * @return 键值
     */
    public static String getKey(String key) {
        return PROPERTIES.getProperty(key);
    }
}

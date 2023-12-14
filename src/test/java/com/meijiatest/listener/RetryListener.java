package com.meijiatest.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class RetryListener implements IRetryAnalyzer {

        //定义重试次数的初始值
        private int initRetryNum = 1;
        //定义最大重试次数
        private int maxRetryNum = 4;

        @Override
        public boolean retry(ITestResult iTestResult) {
            if (initRetryNum < maxRetryNum) {
                //组装测试失败的错误消息
                String errorMessage = iTestResult.getName() + "方法执行失败，正在进行第 " +
                        initRetryNum + " 次重试";
                log.info(errorMessage);
                initRetryNum++;
                return true;
            }
            return false;
        }
}

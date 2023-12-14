package com.meijiatest.utils;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class AssertResultUtils {

    /**
     * 断言当前项目错误状态码和错误消息
     * @param response
     * @param codeField
     * @param expectedCode
     * @param messageField
     * @param expectedMessage
     */
    public static void assertApiResponsestatus(Response response, String codeField, String  expectedCode, String messageField,String expectedMessage){
        response.then().statusCode(200).body(codeField, equalTo(expectedCode)).body(messageField, equalTo(expectedMessage)).log().all();
    }

}

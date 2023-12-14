package com.meijiatest.utils;

import com.alibaba.fastjson.JSON;
import com.meijiatest.constants.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public class requestUtil {

    /**
     * GET 请求，查询参数，带请求头
     * @param host 请求域名
     * @param requestUrl 请求 url
     * @param requestParams 请求参数
     * @param headers 请求头
     * @return
     */
    public static Response sendGetResquestByQueryParamWithHeader(String host, String requestUrl, Map<String,String> requestParams, Map<String, String> headers) {

        String requestPath = host + requestUrl ;
        return given()
                .filters(new AllureRestAssured())
                .queryParams(requestParams)
                .headers(Constants.TOKEN, headers.get(Constants.TOKEN))
                .log().all()
                .when()
                .get(requestPath)
                .then()
                .extract().response();
    }

    /**
     * GET 请求，无参数，带请求头
     * @param host 请求域名
     * @param requestUrl 请求 url
     * @param headers 请求头
     * @return
     */
    public static Response sendGetResquestNoParamWithHeader(String host, String requestUrl,  Map<String, String> headers) {

        String requestPath = host + requestUrl ;
        return given()
                .headers(Constants.TOKEN, headers.get(Constants.TOKEN))
                .log().all()
                .when()
                .get(requestPath)
                .then()
                .extract().response();
    }




    /**
     * GET 请求，不带请求头
     * @param host
     * @param requestUrl
     * @param requestParams
     * @return
     */
    public static Response sendGetRequestNoHeader(String host, String requestUrl, String requestParams) {
        String requestPath = host + requestUrl + requestParams;
        log.info("requestpath : {} ", requestPath);
        return given()
                .when()
                .get(requestPath);
    }

    /**
     * POST 请求，不带请求头
     * @param host 请求域名
     * @param requestUrl 请求 url
     * @param requestBody 请求体
     * @return
     */
    public static Response sendPostRequestNoHeader(String host, String requestUrl, String requestBody) {
        String requestPath = host + requestUrl;
        log.info("requestpath : {} ", requestPath);
        return given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post(requestPath)
                .then()
                .log()
                .body().extract().response();
    }

    /**
     * POST 请求，带请求头，需要打印log
     * @param host 请求域名
     * @param requestUrl 请求 url
     * @param requestBody 请求体
     * @param headers 请求头
     * @return
     */
    private static Response sendPostRequestWithHeader(String host, String requestUrl, String requestBody, Map<String, String> headers) {
        String requestPath = host + requestUrl;
        log.info("requestpath : {} ", requestPath);
        log.info("requestBody : {} ", JSON.parseObject(requestBody));
        return given()
                .body(requestBody)
                .headers(Constants.TOKEN, headers.get(Constants.TOKEN))
                .contentType(ContentType.JSON)
                .when()
                .post(requestPath)
                .then()
                .log()
                .body().extract().response();
    }
}

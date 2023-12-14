package com.meijiatest.testcase;
import com.meijiatest.basecase.BaseTest;
import com.meijiatest.constants.Constants;
import com.meijiatest.dataprovider.WeatherDataProvider;
import com.meijiatest.pageobject.WeatherPage;
import com.meijiatest.utils.AssertResultUtils;
import com.meijiatest.utils.PropertiesReaderUtil;
import com.meijiatest.utils.requestUtil;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ParamterTest extends BaseTest {
    @Test(dataProvider = "getWeatherByAreaCn",dataProviderClass = WeatherDataProvider.class)
    public void testDataProviderParallel(String areaCN){
        long id = Thread.currentThread().getId();
        System.out.println(areaCN+ ": thread id:"+id);
    }

    @Test(dataProvider = "getWeatherByAreaCn",dataProviderClass = WeatherDataProvider.class)
    public void testQueryParam(String areaCN){
        String host = PropertiesReaderUtil.getKey("WeatherHostName");
        String requestUrl = WeatherPage.getWeatherByAreaCn;
        Map<String,String> params = new HashMap<>();
        params.put("areaCn",areaCN);
        params.put("need3hour","1");
        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.TOKEN,"AppCode/"+PropertiesReaderUtil.getKey("AppCode"));
        Response response = requestUtil.sendGetResquestByQueryParamWithHeader(host,requestUrl, params, headers);
        AssertResultUtils.assertApiResponsestatus(response,"code","0","desc","成功");
    }
}

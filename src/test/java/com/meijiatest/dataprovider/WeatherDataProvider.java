package com.meijiatest.dataprovider;

import org.testng.annotations.DataProvider;

public class WeatherDataProvider {


    @DataProvider(name = "getWeatherByAreaCn",parallel = true)
    public static Object[][] getWeathByAreaCn() {
        return  new Object[][]{
                {"北京"},{"上海"},{"杭州"}
        };
    }
}

package com.meijiatest.testcase;

import org.testng.annotations.Test;

public class SecondTest {


    @Test(groups = "second")
    public void b() {
        System.out.println("second: b");
    }

    @Test(groups = "second")
    public void a() {
        System.out.println("second: a");
    }
}

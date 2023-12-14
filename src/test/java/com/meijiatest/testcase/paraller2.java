package com.meijiatest.testcase;

import org.testng.annotations.Test;

public class paraller2 {

    @Test(groups = {"second"})
    public void test1()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller2-test1 thread id:"+id);
    }

    @Test(groups = {"second"})
    public void test2()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller2-test2 thread id:"+id);
    }
}

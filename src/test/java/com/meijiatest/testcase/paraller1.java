package com.meijiatest.testcase;


import org.testng.annotations.Test;

public class paraller1 {


    @Test(dependsOnGroups = {"second"},dependsOnMethods = {"test2"})
    public void test1()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller1-test1 thread id:"+id);
    }

    @Test(dependsOnGroups = {"second"})
    public void test2()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller1-test2 thread id:"+id);
    }
}

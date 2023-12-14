package com.meijiatest.testcase;

import org.testng.annotations.Test;

public class paraller3 {

    @Test
    public void test1()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller3-test1 thread id:"+id);
    }

    @Test
    public void test2()
    {
        long id = Thread.currentThread().getId();
        System.out.println("paraller3-test2 thread id:"+id);
    }
}

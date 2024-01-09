package com.meijiatest.testcase;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class FirstTest {

//    @Test(groups = "first",dependsOnGroups ={"second"}, dependsOnMethods = {"test2"})
//    public void test1() {
//        System.out.println("first: test1");
//    }
//    @Test(groups = "first",dependsOnGroups ={"second"},dependsOnMethods = {"test3"})
//    public void test2() {
//        System.out.println("first: test2");
//    }
//    @Test(groups = "first",dependsOnGroups ={"second"})
//    public void test3() {
//        System.out.println("first: test3");
//    }
//
//
//    @Test
//    public  void  testString() {
//        String a = "11";
//        String b = "9";
//        int result = Integer.parseInt(a) - Integer.parseInt(b);
//        System.out.println(result);
//    }
//
//    @Test
//    public  void  testString2() {
//        String[] nums = {"3","6","7","10"};
//        Arrays.sort(nums, ((o1, o2) -> {
//            if (o1.length() > o2.length())
//                return 1;
//            else if (o1.length() < o2.length())
//                return -1;
//            else
//                return o1.compareTo(o2);
//        }));
//        System.out.println(Arrays.toString(nums));
//    }




    @Test
    public int majorityElement( ) {
        int[] nums = {3,2,3};
        int len = nums.length/2;
        System.out.println(len);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(String.valueOf(nums[i]),map.get(nums[i])+1);
            } else {
                map.put(String.valueOf(nums[i]),1);
            }
        };
        int count = 0;
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            if (map.get(key) > len) {
               count++;
            }
        }
        return count;
    }



//    @Test
//    public void testCase1() {
//        System.out.println("@Test这是测试用例1");
//    }

//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("beforeMethod： 在测试方法之前运行的");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("AfterMethod：在测试方法之后运行");
//    }
//
//    @Test
//    public void testCase2() {
//        System.out.println("@Test这是测试用例2");
//    }
//
//    @BeforeClass
//    public void beforClass() {
//        System.out.println("BeforeClass: 类运行之前的方法,仅执行一次");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("afterClass: 类运行之后的方法，仅执行一次");
//    }
//
//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("BeforeSuite: 当前suite运行之前运行");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("AfterSuite: 当前suite运行之后运行");
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("BeforeTest: 在每个Test之前运行");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("AfterTest: 在每个Test之后运行");
//    }

}

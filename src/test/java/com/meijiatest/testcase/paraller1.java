package com.meijiatest.testcase;


import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class paraller1 {


    @Test
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer ,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++) {
            if(map.containsKey(target-numbers[i])) {
                result[0] = map.get(target-numbers[i]);
                result[1] = i+1;
                break;
            }
            map.put(numbers[i],i+1);

        }
    }
    @Test
    public void reverseWords() {
        String s = "the sky is blue";
        String[] strs = s.trim().split(" ");
        System.out.println("before"+Arrays.toString(strs));
        StringBuilder sb = new StringBuilder() ;
        // 从后往前遍历,遇到空格下一轮，某则拼接
        for(int i=strs.length-1;i>=0;i--) {
//            if(strs[i].equals("")) continue;
            sb.append(strs[i]+" ");
            System.out.println("after"+sb.toString());
        }
        System.out.println( sb.toString().trim());
    }
    @Test
    public void lengthOfLastWord() {
        String s ="   fly me   to   the moon  ";
        char[] c= s.toCharArray();

        int i =c.length-1;
        if(c[i] == ' ') {
            System.out.println(0);
//            return 0;
        }
        for(;i>0;i--) {
            if(c[i] == ' ') {
                break;
            }
        }
        System.out.println(c.length-i-1);
    }

    @Test
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j=length-1;
        for(int k=0;k<length-2  ;k++ ) {
            if(nums[k]>0) break;
            // 防止每次枚举的数值是重复的
            if(k>0 && nums[k] == nums[k-1] ){
                continue;
            }
            i=k+1;
            int sum = nums[k]+nums[i]+nums[j];
            if(sum<0) {
                while (i<j ) {
                    if(nums[i] == nums[i+1]) {
                        i++;
                    } else {
                        break;
                    }
                };
            }
            if(sum>0) {
                while (i<j ) {
                    if(nums[j] == nums[j-1]) {
                        j--;
                    } else {
                        break;
                    }
                };
            }
            if(sum == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                i++;
                j--;
            }
        }
        return result;
    }

    @Test
    public void rotate() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int len = nums.length;
        for (int i=0;i<k;i++) {
            int last = nums[len-1];
            for (int j=len-1;j>0;j--) {
                nums[j]= nums[j-1];
            }
            nums[0] = last;
           for(int z=0;z<nums.length;z++) {
               System.out.print(nums[z]);
           }
            System.out.println("=============");
        }
    }
    @Test
    public void majorityElement() {
        int[] nums = {3,2,3};
        int len = nums.length/2;
        System.out.println(len);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        };
        int count = 0;
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            if (map.get(key) > len) {
                count++;
            }
        }
        System.out.println(count);
    }
//
//    @Test(dependsOnGroups = {"second"},dependsOnMethods = {"test2"})
//    public void test1()
//    {
//        long id = Thread.currentThread().getId();
//        System.out.println("paraller1-test1 thread id:"+id);
//    }
//
//    @Test(dependsOnGroups = {"second"})
//    public void test2()
//    {
//        long id = Thread.currentThread().getId();
//        System.out.println("paraller1-test2 thread id:"+id);
//    }
}

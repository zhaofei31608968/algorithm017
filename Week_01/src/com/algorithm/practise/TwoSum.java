package com.algorithm.practise;

import java.util.HashMap;

/**
 * 方法一：暴力法 时间复杂度：O(n^2) 空间复杂度：O(1)O(1)
 * 方法二：两遍哈希表 时间复杂度：O(n) 空间复杂度：O(n)
 * 方法三: 一遍哈希表 时间复杂度：O(n) 空间复杂度：O(n)
 * 扩展成3个数相加的问题
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3,2};
        int target = 4;
        int[] result = twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    /**
     * @param nums 不同数值的一组数组
     * @param target 目标数值
     * @return 数组两个数的下标
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numPositionMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if(numPositionMap.get(otherNum) != null){
                return new int[]{numPositionMap.get(otherNum),i};
            }
            numPositionMap.put(nums[i],i);
        }

        throw new IllegalArgumentException("not found!");
    }
}

package com.snowriver.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * <p>
 * 需要先快速查找出数组中value相等得下标
 * <p>
 * 判断绝对值是否最大为k
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        boolean check = check(nums, 0);
        System.out.println(check);
    }


    private static boolean check(int[] nums, int k) {

        if (k == 0) {
            return false;
        }

        final boolean[] flag = {false};

        Set set = new HashSet<>(nums.length);

        Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            //判断是否前面有重复数据
            if (set.contains(nums[i])) {
                //有重复数据，获取到下标
                HashSet set1 = map.get(nums[i]);
                set1.add(i);
                map.put(nums[i], set1);
            }

            //添加到Set中
            HashSet set1 = map.get(nums[i]);
            if (set1 == null) {
                set1 = new HashSet<>();
                set1.add(i);
            }
            map.put(nums[i], set1);
            set.add(nums[i]);
        }

        // 重复得下标分类分组


        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            HashSet<Integer> value = entry.getValue();
            List<Integer> collect = value.stream().sorted().collect(Collectors.toList());

            if (collect.size() == 1) {
                continue;
            }

            collect.forEach(item -> {
                int expireValue = item + k;

                if (item.equals(collect.get(collect.size() -1))) {
                    return;
                }

                if (value.contains(expireValue)) {
                    flag[0] = true;
                }
                if (expireValue > collect.get(collect.size() -1)) {
                    flag[0] = true;
                }
            });
        }

        System.out.println(map);

        return flag[0];
    }

}
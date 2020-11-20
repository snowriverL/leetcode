package com.snowriver.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * @author guofuhao
 * Created on 2020/11/20 下午2:47
 * Email is guofuhao@mrfresh.com
 * Copyright is 北京滴哩科技有限公司
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * </p>
 *
 */
public class NumberAdd {

    private static int[] nums = new int[]{3, 3};

    private static int target = 6;

    public static void main(String[] args) {
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + "=========" + ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Integer beforeValue = 0;
        return getEndIndex(numList, beforeValue, target);
    }

    public static int[] getEndIndex(List<Integer> numList, Integer beforeValue, Integer target) {
        int index = 0;
        int[] result = new int[2];
        for(;;) {
            for (int i = 0; i < numList.size(); i++) {
                if (i < index) {
                    continue;
                }
                if (i == index) {
                    beforeValue = numList.get(i);
                    result[0] = i;
                    continue;
                }

                if (target == (beforeValue + numList.get(i))) {
                    result[1] = i;
                    return result;
                }

                if (i == (numList.size() - 1)) {
                    index++;
                }
            }
        }
    }
}

package cn.emmayu.homework.week.second;

import java.util.HashMap;
import java.util.Map;

public class Array {

    public int findShortestSubArray(int[] nums) {
        int len = nums.length, max = 0, min = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] p = map.get(nums[i]);
            if (p == null) {
                p = new int[]{i, 1};
                map.put(nums[i], p);
            } else {
                p[1]++;
            }
            if (p[1] > max) {
                max = p[1];
                min = i - p[0] + 1;
            } else if (p[1] == max) {
                min = Math.min(min, i - p[0] + 1);
            }
        }
        return min;
    }


}

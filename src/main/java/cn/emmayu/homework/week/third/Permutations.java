package cn.emmayu.homework.week.third;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> choosen = new ArrayList<>();
        int n = 0;
        rec(ans, choosen, n, nums);
        return ans;
    }

    void rec(List<List<Integer>> ans, List<Integer> choosen, int n, int[] nums) {
        if (n == nums.length) {
            ans.add(choosen);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            choosen.add(nums[n]);
            rec(ans, choosen, n, nums);
            choosen.remove(choosen.size() - 1);
            used[i] = false;
        }
    }

    private boolean[] used;

}

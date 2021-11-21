package cn.emmayu.homework.week.first;

/**
 * 66.加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class AddOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}

package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P415 {
    public int findNumber(String num,String target) {
        // 目标非素数，直接返回-1
        if (!isPrimeNum(Integer.parseInt(target))) {
            return -1;
        }
        minStep = Integer.MAX_VALUE;
        dfs(num.toCharArray(), target.toCharArray(), new HashSet<>(), 0);
        return minStep;
    }
    private static int minStep;

    private void dfs(char[] num, char[] target, Set<String> fb, int step) {
        // 是否已命中
        if (Arrays.equals(num,target)) {
            minStep = Math.min(step, minStep);
            return;
        }

        // 依次尝试
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target[i]) {
                // 已经一致，不需再变化
                continue;
            }
            // 尝试从0-9
            for (int j = 0; j <= 9; j++) {
                char next = (char) (j + 48);
                if (num[i] == next) {
                    continue;
                }
                char pre = num[i];
                num[i] = next;
                String newOne = new String(num);
                if (!fb.contains(newOne) && isPrimeNum(Integer.parseInt(newOne))) {
                    fb.add(newOne);
                    dfs(num, target, fb, step + 1);
                }
                num[i] = pre;
            }
        }
    }

    public boolean isPrimeNum(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

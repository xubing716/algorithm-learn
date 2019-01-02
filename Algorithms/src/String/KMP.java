package String;

import java.util.Arrays;

/**
 * 主要是学习KMP算法
 * 
 * @author x00427549 1） 暴力求解 2） 对于暴力求解的优化，KMP
 *
 */
public class KMP {


    // 暴力求解：时间复杂度为：O(N*N) 空间复杂度为：O(1)
    // 分析：每次不匹配的时候，j都回溯到0了，i+1，是不是可以利用已知[0~n-1]的结论来帮忙处理n，Manacher算法就是利用了这种对称性，对暴力求解
    // 最长回文子串算法进行了优化
    public static int getStringPatternLengthByViolence(String data, String pattern) {

        int i = 0;
        int j = 0;

        while (i <= data.length() - pattern.length() && j < pattern.length()) {
            if (data.charAt(i + j) == pattern.charAt(j)) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        if (j >= pattern.length()) {
            return i;
        }
        return -1;
    }

    public static int getStringPatternLengthByKMP(String data, String pattern) {

        int[] next = getNextImprove(pattern);
        int i = 0;
        int k = 0;
        int patternIndex = -1;
        while (i < data.length()) {
            if (k == -1 || data.charAt(i) == pattern.charAt(k)) {
                i++;
                k++;
            } else {
                k = next[k];
            }

            if (k >= pattern.length()) {
                // 表示已经找到匹配
                patternIndex = i - pattern.length();
                break;
            }
        }
        // 计算开始匹配问题
        return patternIndex;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;

        int i = 0;
        int k = -1;

        while (i < pattern.length() - 1) {

            if (k == -1 || pattern.charAt(k) == pattern.charAt(i)) {
                k++;
                i++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }

        System.out.println(Arrays.toString(next));
        return next;
    }

    // 在原来的next数组上面进行思考：如果当需要回溯的时候，例如：j时，回溯到next[j]，当pattern[k] == pattern[j]，回溯到k还是不相等
    // 所以：可以将next[j] = next[next[k]];这样就可以较少不必要的匹配了
    private static int[] getNextImprove(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;

        int i = 0;
        int k = -1;

        while (i < pattern.length() - 1) {

            if (k == -1 || pattern.charAt(k) == pattern.charAt(i)) {
                k++;
                i++;

                if (pattern.charAt(i) == pattern.charAt(k)) {
                    next[i] = next[k];
                } else {
                    next[i] = k;
                }
            } else {
                k = next[k];
            }
        }

        System.out.println(Arrays.toString(next));
        return next;
    }

    public static void main(String[] args) {
        String data = "abaabdcabadfkadabaabcabafoaabjdlasjdklfadkf";
        String pattern = "abaabcaba";
        System.out.println("violence:" + getStringPatternLengthByViolence(data, pattern));
        System.out.println("KMP:" + getStringPatternLengthByKMP(data, pattern));
        // getNext(pattern);
    }
}

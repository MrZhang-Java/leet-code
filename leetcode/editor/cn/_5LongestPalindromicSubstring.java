/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * <p>
 * Related Topics 双指针 字符串 动态规划 👍 7395 👎 0
 */

package leetcode.editor.cn;

/**
 * @author: 张小张
 * @date: 2024-10-22 19:58:28
 */
public class _5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new _5LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int strLen = s.length();
            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = 1;

            boolean[][] dp = new boolean[strLen][strLen];

            for (int r = 1; r < strLen; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            maxStart = l;
                            maxEnd = r;

                        }
                    }

                }

            }
            return s.substring(maxStart, maxEnd + 1);

        }


        public String longestPalindrome1(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int length = s.length();
            int left = 0;
            int right = 0;
            int maxLen = 0;
            int startIndex = 0;
            int len = 1;
            for (int i = 0; i < length; i++) {
                left = i - 1;
                right = i + 1;
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    len++;
                    left--;
                }
                while (right < length && s.charAt(right) == s.charAt(i)) {
                    len++;
                    right++;
                }

                while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                    len = len + 2;
                    left--;
                    right++;
                }
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = left + 1;
                }
                len = 1;
            }
            return s.substring(startIndex, startIndex + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
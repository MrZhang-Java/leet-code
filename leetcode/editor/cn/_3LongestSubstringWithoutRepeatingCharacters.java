/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 10387 👎 0
 */

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author: 张小张
 * @date: 2024-10-21 20:59:48
 *
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new _3LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用滑动窗口，放入set中，当set中存在要放入的字符时，记录当前长度是否大于上一次记录长度
         * 然后将左指针右移到set中不存在重复字符
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<Character>();
            int n = s.length();
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    set.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    set.add(s.charAt(rk + 1));
                    ++rk;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
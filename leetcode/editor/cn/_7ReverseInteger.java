/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 数学 👍 4023 👎 0
 */

package leetcode.editor.cn;

/**
 * @author: 张小张
 * @date: 2024-10-22 20:53:51
 */
public class _7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new _7ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
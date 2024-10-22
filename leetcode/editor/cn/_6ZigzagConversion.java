/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * <p>
 * Related Topics 字符串 👍 2393 👎 0
 */

package leetcode.editor.cn;

/**
 * @author: 张小张
 * @date: 2024-10-22 20:26:00
 */
public class _6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new _6ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            int n = s.length(), r = numRows;
            if (r == 1 || r >= n) {
                return s;
            }
            int t = r * 2 - 2;
            int c = (n + t - 1) / t * (r - 1);
            char[][] mat = new char[r][c];
            for (int i = 0, x = 0, y = 0; i < n; ++i) {
                mat[x][y] = s.charAt(i);
                if (i % t < r - 1) {
                    ++x; // 向下移动
                } else {
                    --x;
                    ++y; // 向右上移动
                }
            }
            StringBuffer ans = new StringBuffer();
            for (char[] row : mat) {
                for (char ch : row) {
                    if (ch != 0) {
                        ans.append(ch);
                    }
                }
            }
            return ans.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
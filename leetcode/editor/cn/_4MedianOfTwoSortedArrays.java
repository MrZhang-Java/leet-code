/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10⁶ <= nums1[i], nums2[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 二分查找 分治 👍 7269 👎 0
 */

package leetcode.editor.cn;

/**
 * @author: 张小张
 * @date: 2024-10-21 21:13:46
 */
public class _4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new _4MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 使用二分法，求第k小的数
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
            if (len1 == 0) return nums2[start2 + k - 1];

            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }


        /**
         * 合并数组 时间复杂度：log(m+n)
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            int[] nums;
            int m = nums1.length;
            int n = nums2.length;
            nums = new int[m + n];
            if (m == 0) {
                if (n % 2 == 0) {
                    return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
                } else {
                    return nums2[n / 2];
                }
            }
            if (n == 0) {
                if (m % 2 == 0) {
                    return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
                } else {
                    return nums1[m / 2];
                }
            }

            int count = 0;
            int i = 0, j = 0;
            while (count != (m + n)) {
                if (i == m) {
                    while (j != n) {
                        nums[count++] = nums2[j++];
                    }
                    break;
                }
                if (j == n) {
                    while (i != m) {
                        nums[count++] = nums1[i++];
                    }
                    break;
                }

                if (nums1[i] < nums2[j]) {
                    nums[count++] = nums1[i++];
                } else {
                    nums[count++] = nums2[j++];
                }
            }

            if (count % 2 == 0) {
                return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
            } else {
                return nums[count / 2];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
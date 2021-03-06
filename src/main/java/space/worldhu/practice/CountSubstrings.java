package space.worldhu.practice;

/**
 * @author hushicheng
 * @date 2020/8/19
 */
public class CountSubstrings {

    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *  aaaa
     * a a a a aa aa aa aaa aaa aaaa
     * 提示：
     *
     * 输入的字符串长度不会超过 1000 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int countSubstrings(String s) {
        int start = -1;
        int end = -1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            boolean pre = s.charAt(i - 1) == s.charAt(i);
            if (start == -1 && pre) {
                start = i - 1;
            }
            if (start != -1 && (!pre || i == s.length() - 1)) {
                end = i - 1;
                if (i == s.length() - 1) {
                    end = i;
                }
            }
            if (start != -1 && end != -1) {
                int length = end - start + 1;
                count = count + (1 + length) * length / 2 - length;
                start = -1;
                end = -1;
            }
        }
        count += s.length();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}

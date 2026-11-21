public class Solution {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int testNum = 1221;
        System.out.println("Is " + testNum + " a palindrome? " + solver.isPalindrome(testNum));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedHalf = 0;
        while (x > revertedHalf) {
            revertedHalf = revertedHalf * 10 + (x % 10);
            x /= 10;
        }

        return x == revertedHalf || x == revertedHalf / 10;
    }
}
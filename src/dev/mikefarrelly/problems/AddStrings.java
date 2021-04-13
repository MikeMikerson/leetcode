package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("122342342342342342342343", "123"));
        System.out.println(addStrings("9", "1"));
        System.out.println(addStrings("9", "99"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sumOfNums = new StringBuilder();
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        int carryOver = 0;

        while (num1Length >= 0 || num2Length >= 0) {
            int x = num1Length >= 0 ? num1.charAt(num1Length) - '0' : 0;
            int y = num2Length >= 0 ? num2.charAt(num2Length) - '0' : 0;
            int sum = (x + y + carryOver) % 10;

            carryOver = (x + y + carryOver) >= 10 ? 1 : 0;
            num1Length--;
            num2Length--;
            sumOfNums.append(sum);
        }

        if (carryOver == 1) {
            sumOfNums.append(1);
        }

        // Since we're iterating the numbers from the end of the string (because that's how addition works),
        // we're also appending to the string builder in the wrong order so we need to reverse it here.
        return sumOfNums.reverse().toString();
    }
}

package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1", "11"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carryOver = 0;

        while (aLength >= 0 || bLength >= 0) {
            int x = aLength >= 0 ? a.charAt(aLength) - '0' : 0;
            int y = bLength >= 0 ? b.charAt(bLength) - '0' : 0;
            int sum = (x + y + carryOver) % 2;
            carryOver = (x + y + carryOver) > 1 ? 1 : 0;

            aLength--;
            bLength--;
            builder.append(sum);
        }

        if (carryOver > 0) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}

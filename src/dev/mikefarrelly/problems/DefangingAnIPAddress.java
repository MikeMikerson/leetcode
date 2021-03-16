package dev.mikefarrelly.problems;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * Constraints:
 * - The given address is a valid IPv4 address.
 *
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        // The following line isi simply a one liner that uses a regular expression
        // return address.replace(".", "[.]");
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}

package dev.mikefarrelly.learn.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'.
 *
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        // true
        System.out.println(isValid("()"));
        // true
        System.out.println(isValid("()[]{}"));
        // false
        System.out.println(isValid("(]"));
        // false
        System.out.println(isValid("([)]"));
        // true
        System.out.println(isValid("{[]}"));

        // false
        System.out.println(isValid("(("));

        // false
        System.out.println(isValid("){"));

        // false
        System.out.println(isValid(")(){}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        List<Character> openingBrackets = createOpeningBracketList();
        List<Character> closingBrackets = createClosingBracketList();
        HashMap<Character, Character> map = createMatchingMap();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && closingBrackets.contains(c)) {
                return false;
            }

            if (openingBrackets.contains(c)) {
                stack.push(c);
            }

            if (closingBrackets.contains(c) && !stack.isEmpty()) {
                Character top = stack.peek();
                if (top != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static List<Character> createOpeningBracketList() {
        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add('[');
        list.add('{');
        return list;
    }

    private static List<Character> createClosingBracketList() {
        List<Character> list = new ArrayList<>();
        list.add(')');
        list.add(']');
        list.add('}');
        return list;
    }

    private static HashMap<Character, Character> createMatchingMap() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return map;
    }
}

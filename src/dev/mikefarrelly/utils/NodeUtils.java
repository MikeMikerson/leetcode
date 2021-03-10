package dev.mikefarrelly.utils;

import dev.mikefarrelly.node.ListNode;

public final class NodeUtils {
    private NodeUtils() {}

    public static void printNodes(ListNode root) {
        ListNode cur = root;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder.toString());
        System.out.println("============");

    }
}

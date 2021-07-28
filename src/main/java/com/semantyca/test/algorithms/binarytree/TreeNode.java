package com.semantyca.test.algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    private int value;
    TreeNode less;
    TreeNode more;


    public TreeNode(int value, TreeNode less, TreeNode more) {
        this.value = value;
        this.less = less;
        this.more = more;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int sum(TreeNode node, TraversingType recursive) {
        int total = 0;

        if (recursive == TraversingType.DEEP) {
            Stack<TreeNode> stack = new Stack();
            stack.push(node);
            while (!stack.isEmpty()) {
                TreeNode nestedNode = stack.pop();
                total = total + nestedNode.value;
                if (nestedNode.less != null) stack.push(nestedNode.less);
                if (nestedNode.more != null) stack.push(nestedNode.more);
            }
        } else if (recursive == TraversingType.ROW) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode nestedNode = queue.remove();
                total = total + nestedNode.value;
                if (nestedNode.less != null) queue.add(nestedNode.less);
                if (nestedNode.more != null) queue.add(nestedNode.more);
            }
        } else {
            total = node.value;
            if (node.less != null) total += node.sum(node.less, TraversingType.RECURSIVE);
            if (node.more != null) total += node.sum(node.more, TraversingType.RECURSIVE);
        }
        return total;
    }

    @Override
    public String toString() {
        return " " + value + " ";
    }
}

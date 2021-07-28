package com.semantyca.test.algorithms.binarytree;

public class AlgRunner {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7 ,
                new TreeNode(5, new TreeNode(2), new TreeNode(6)),
                        new TreeNode(8, null, new TreeNode(12, new TreeNode(10), new TreeNode(16))));

        System.out.println(root.sum(root, TraversingType.DEEP));
        System.out.println(root.sum(root, TraversingType.ROW));
        System.out.println(root.sum(root, TraversingType.RECURSIVE));
    }

}

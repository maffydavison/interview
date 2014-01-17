package com.maffy.example.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/29/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree {

    /**
     *
     *              50    -- root
     *
     *         30        60  -- children
     *
     *           34     52   62 -- leaf node
     *
     * left child --  51  54  -- right child  of node 52
     *
     */

    TreeNode root;

    public void addNode(int key, String name) {
        TreeNode newTreeNode = new TreeNode(key, name);

        if (root == null) {
            root = newTreeNode;
        } else {
            TreeNode focusTreeNode = root;
            TreeNode parent;
            while(true) {
                parent = focusTreeNode;
                if (key < focusTreeNode.key) {
                    focusTreeNode = focusTreeNode.leftChild;
                    if (focusTreeNode == null) {
                        parent.leftChild = newTreeNode;
                        return;
                    }
                } else {
                    focusTreeNode = focusTreeNode.rightChild;
                    if (focusTreeNode == null) {
                        parent.rightChild = newTreeNode;
                        return;
                    }
                }
            }
        }

    }

    public boolean isMirroredSymmetric(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            if (a.equals(b)) {
                return isMirroredSymmetric(a.leftChild, b.rightChild) & isMirroredSymmetric(a.rightChild, b.leftChild);
            } else {
                return false;
            }
        } else if (a == null && b == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inOrderTraverseTree(TreeNode focusTreeNode) {
        if (focusTreeNode != null)  {
            inOrderTraverseTree(focusTreeNode.leftChild);
            System.out.println(focusTreeNode);
            inOrderTraverseTree(focusTreeNode.rightChild);
        }
    }

    List<TreeNode> inOrderList = new LinkedList<TreeNode>();
    public List<TreeNode> inOrderTraverseTreeToList(TreeNode focusTreeNode) {
        if (focusTreeNode != null)  {
            inOrderTraverseTreeToList(focusTreeNode.leftChild);
            inOrderList.add(focusTreeNode);
            inOrderTraverseTreeToList(focusTreeNode.rightChild);
        }
        return inOrderList;
    }

    public void preOrderTraverseTree(TreeNode focusTreeNode) {
        if (focusTreeNode != null)  {
            System.out.println(focusTreeNode);
            preOrderTraverseTree(focusTreeNode.leftChild);
            preOrderTraverseTree(focusTreeNode.rightChild);
        }
    }
    List<TreeNode> preOrderList = new LinkedList<TreeNode>();
    public List<TreeNode> preOrderTraverseTreeToList(TreeNode focusTreeNode) {
        if (focusTreeNode != null)  {
            preOrderList.add(focusTreeNode);
            preOrderTraverseTree(focusTreeNode.leftChild);
            preOrderTraverseTree(focusTreeNode.rightChild);
        }
        return preOrderList;
    }

    public static void main(String [] args) {

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Tom");
        theTree.addNode(25, "Dick");
        theTree.addNode(15, "Harry");
        theTree.addNode(30, "Leslie");
        theTree.addNode(75, "Judy");
        theTree.addNode(85, "Mike");
        theTree.addNode(90, "Steve");

        theTree.preOrderTraverseTree(theTree.root);

        System.out.println();

        theTree.inOrderTraverseTree(theTree.root);

        System.out.println();

        List<TreeNode> order = theTree.inOrderTraverseTreeToList(theTree.root);
        for (TreeNode item : order) {
            System.out.println(item);
        }

        System.out.println();

        if(theTree.isMirroredSymmetric(theTree.root, theTree.root)) {
            System.out.println(" Yep. It's mirrored symmetric");
        } else {
            System.out.println(" Nope.  Not mirrored symmetric");
        }

    }
}

class TreeNode {

    int key;
    String name;

    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }


}

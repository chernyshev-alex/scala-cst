package faang

import org.scalatest.funsuite.AnyFunSuite

class BinTreeTest extends AnyFunSuite {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    //
    test ("testMaxTreeDepth") {
        val  root = TreeNode(3, Some(TreeNode(9)), Some(TreeNode(20, 
                Some(TreeNode(15)), Some(TreeNode(7)))))
        assert(3 == binTree.findMaxTreeDepth(Some(root)))
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    // Given the root of a binary tree, return the level order traversal of its nodes' values.
    // (i.e., from left to right, level by level).

    test ("testLevelOrder") {
        val root = TreeNode(3, Some(TreeNode(9)), Some(TreeNode(20, 
                Some(TreeNode(15)), Some(TreeNode(7)))))
        assert(List(List(3), List(9, 20), List(15,7)) === binTree.levelOrder(Some(root)))
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/
    // Given the root of a binary tree, imagine yourself standing on the right side of it,
    // return the values of the nodes you can see ordered from top to bottom.
    // in : [1,2,3,null,5,null,4] out : [1,3,4

    test ("testRightSideViewBfs") {
       val root = TreeNode(1, Some(TreeNode(2, None, Some(TreeNode(5)))),
                Some(TreeNode(3, None, Some(TreeNode(4)))))

        assert(List(1,3,4) === binTree.rightSideViewBfs(Some(root)));
    }

    test ("testRightSideViewDfs") {
       val root = TreeNode(1, Some(TreeNode(2, None, Some(TreeNode(5)))),
                Some(TreeNode(3, None, Some(TreeNode(4)))))

        assert(List(1,3,4) === binTree.rightSideViewDfs(Some(root)));
    }

    // https://leetcode.com/problems/validate-binary-search-tree/
    // Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    // A valid BST is defined as follows:
    
    // The left subtree of a node contains only nodes with keys less than the node's key.
    // The right subtree of a node contains only nodes with keys greater than the node's key.
    // Both the left and right subtrees must also be binary search trees.
    
    test ("testIsValidBST")  {
        var root = TreeNode(2, Some(TreeNode(1)), Some(TreeNode(3)))

        assert(true == binTree.isValidBST(Some(root)))

        root = TreeNode(5,
                Some(TreeNode(1)),
                Some(TreeNode(4, Some(TreeNode(3)), Some(TreeNode(6)))))

        assert(false == binTree.isValidBST(Some(root)))
    }
}
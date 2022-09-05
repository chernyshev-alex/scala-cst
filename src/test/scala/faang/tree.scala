package faang

import org.scalatest.funsuite.AnyFunSuite

class TreeTest extends AnyFunSuite {

  // https://leetcode.com/problems/binary-tree-level-order-traversal/
  // Given the root of a binary tree, return the level order traversal of its nodes' values.
  // (i.e., from left to right, level by level).
  test("Level Order") {
    val t = new TreeNode(3, new TreeNode(9, null, null), 
      new TreeNode(20, new TreeNode(15, null), new TreeNode(7, null)))
    assert(tree.levelOrder(t) === List(List(3), List(9, 20), List(15, 7)))
  }

// https://leetcode.com/problems/binary-tree-right-side-view/
// Given the root of a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.
  test("Right Side Bfs") {
    val t = new TreeNode(1, 
      new TreeNode(2, null, new TreeNode(5)), 
      new TreeNode(3, null, new TreeNode(4)))
    assert(tree.rightSideViewBfs(t) === List(1,3,4))
  }

  test("Right Side Dfs") {
    val t = new TreeNode(1, 
      new TreeNode(2, null, new TreeNode(5)), 
      new TreeNode(3, null, new TreeNode(4)))
    assert(tree.rightSideViewDfs(t) === List(1,3,4))
  }

}
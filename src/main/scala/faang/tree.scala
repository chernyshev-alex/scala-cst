package faang

import scala.collection._
import scala.annotation.tailrec

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object tree {

    def levelOrder(root: TreeNode): List[List[Int]] = {
      var result = List.empty[List[Int]]
      if (root == null) {
        return result
      }
      val q = mutable.Queue(root)
      while (!q.isEmpty) {
        var (level, next_level) = (List.empty[Int], List.empty[TreeNode])
        while (!q.isEmpty) {
          val t = q.dequeue()
          level = level :+ t.value
          List(t.left, t.right).filter(_ != null).foreach { 
            case n => 
                next_level = next_level :+ n
          }
        }
        result = result :+ level
        next_level.foreach(e => q.enqueue(e))
      }
      result
    } 

  def rightSideViewBfs(root: TreeNode): List[Int] = {
    var result = List.empty[Int]
    if (root == null) {
      return result
    }
    var t : TreeNode = null // right node
    val q = mutable.Queue(root)
    while (!q.isEmpty) {
      for ( i <- 0 until q.size ) {
        t = q.dequeue()
        List(t.left, t.right).filter(_ != null).foreach(n => q.enqueue(n))
      }
      result = result :+ t.value  // add last right values   
    } 
    result
  }

  def rightSideViewDfs(root: TreeNode): List[Int] = {
    var result = List.empty[Int]

    def rightSideViewDfsLvl(n : TreeNode, level : Int) {
      if (n != null) {
        if (level >= result.size) {
          result = result :+ n.value
        }
        List(n.right, n.left).filter(_ != null).foreach(rightSideViewDfsLvl(_, level+1))
      }
    }
    rightSideViewDfsLvl(root, 0)
    result
  }

}
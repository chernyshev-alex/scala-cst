package faang

import scala.collection.mutable

case class TreeNode(val value : Int, left : Option[TreeNode] = None, right : Option[TreeNode] = None )

object binTree {

    @inline def  __findMaxTreeDepth(n : Option[TreeNode], deep : Int) : Int = {
        if (n == None) return  deep;
        return  Math.max(__findMaxTreeDepth(n.get.left, deep +1) ,
                    __findMaxTreeDepth(n.get.right, deep + 1));
    }
 
    def findMaxTreeDepth(root : Option[TreeNode]) : Int = __findMaxTreeDepth(root, 0)

    // Binary Tree Level Order Traversal
    def levelOrder(root : Option[TreeNode]) : List[List[Int]] =  {
        if (root.isEmpty) return List.empty[List[Int]]

        var result = List.empty[List[Int]]
        var q = List(root)
        do {
            var currentLevel = List.empty[Option[TreeNode]]
            var nextLevel  = List.empty[Option[TreeNode]] 

            while (!q.isEmpty) {
                q.head match {
                    case Some(t) => currentLevel :+= q.head
                        List(t.left, t.right).foreach(te => if (te.isDefined) nextLevel :+= te)
                    case None => 
                }
                q = q.tail
            }
            result = result :+ currentLevel.map(_.get.value).toList
            q = nextLevel

        } while (!q.isEmpty)

        result;
    }

    // BFS right side

    def rightSideViewBfs(root : Option[TreeNode]) : List[Int] = {
         if (root.isEmpty) return List.empty[Int]

        var result = List.empty[Int]
        var q = List(root)
        while (!q.isEmpty) {
            var n : TreeNode = null
           for (i <- 0 until q.length) {
                n = q.head.get
                List(n.left, n.right).filter(_.isDefined).foreach( q :+= _ )
                q = q.tail
           }
            result :+= n.value
        }
        result;
    }

    def  __rightSideViewDfs(n : Option[TreeNode], level : Int, result : mutable.ArrayBuffer[Int] ) : List[Int] = {
    
        if (n.isEmpty) return  result.toList

        if (level >= result.length) {
            result.addOne(n.get.value)
        }
        __rightSideViewDfs(n.get.right, level+1, result);
        __rightSideViewDfs(n.get.left, level+1, result);

        result.toList
    }

    def rightSideViewDfs(root : Option[TreeNode]) : List[Int] = {
        return  __rightSideViewDfs(root, 0, mutable.ArrayBuffer.empty[Int]);
    }

    // ---
    def __isValidBST(n : Option[TreeNode], min :  Int,  max : Int) : Boolean =  {
        if (n .isEmpty)  return true;

        if (n.get.value <= min || n.get.value >= max) {
            return false;
        }
        return  __isValidBST(n.get.left, min, n.get.value)  && __isValidBST(n.get.right, n.get.value, max);
    }

    def isValidBST(root : Option[TreeNode]) = 
        __isValidBST(root, Int.MinValue, Int.MaxValue);
    
}
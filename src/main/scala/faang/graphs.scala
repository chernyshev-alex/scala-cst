package faang

import scala.collection.mutable._

object graphs {

  def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {
    var empls = ArrayBuffer.fill(manager.length)(ArrayBuffer.empty[Int])
    manager.zipWithIndex.foreach {
      case (managerId, i) =>  empls(i).addOne(managerId)
    } 

    def numOfMinutesDfs(nodeId : Int) : Int = {
      if (empls(nodeId).isEmpty) return  0
      var maxTime = 0
      for (emplId <- empls(nodeId) if emplId != -1 ) {
        maxTime = Math.max(maxTime, numOfMinutesDfs(emplId))
      }
      maxTime + informTime(nodeId)
    }
    numOfMinutesDfs(headID)
  }

  def scheduleCourseCanFinish(numCourses: Int, prerequisites: Array[Array[Int]]) : Boolean =  {
    var inDegree = Array.fill[Int](numCourses) (0)
    for (p <- prerequisites) {
      inDegree(p(0)) +=1;
    }
    val stack = Stack.empty[Int]
    for ( (n, index) <- inDegree.zipWithIndex if (inDegree(index)) == 0 ) {
      stack.push(index)
    }
    var count = 0
    while (!stack.isEmpty) {
      val idx = stack.pop()
      count +=1
      for (p <- prerequisites if idx == p(1)) {
        inDegree(p(0)) -=1
        if (inDegree(p(0)) == 0) {
          stack.push(p(0))
        }
      }
    }
    count == numCourses
  } 

  def networkDelayTimeDejkstra(times: Array[Array[Int]], n: Int, k: Int) : Int = {
    var dist = Array.fill[Int](n) (Int.MaxValue)

    val minHeap = PriorityQueue.empty[Int]
    var adj_list = Array.fill(n)(Array.empty[Tuple2[Int, Int]])

    var from_node = k - 1
    dist(from_node) = 0
    minHeap.enqueue(from_node)

    for (t <- times) {
      val (from, to, w) = (t(0), t(1), t(2))
      adj_list(from-1) = adj_list(from-1) :+ Tuple2(to-1, w)
    }
 
    while (!minHeap.isEmpty) {
      val node = minHeap.dequeue()
      for ((to, w) <- adj_list(node)) {
        if (dist(node) + w < dist(to)) {
          dist(to) = dist(node) + w
          minHeap.enqueue(to)
        }
      }
    }
    var mx = dist.max
    if (mx == Int.MaxValue) -1 else mx  
  }

  import scala.util.control.Breaks._ 
  
  def networkDelayTimeBellmanFord(times: Array[Array[Int]], n: Int, k: Int) : Int=  {
    var dist = Array.fill[Int](n) (Int.MaxValue)

    dist(k -1) = 0  
    breakable { 
      for (i <- 0 until n) {
        var count = 0
        for (t <- times) {
          val (from, to, w) = (t(0), t(1), t(2))
          if (dist(from-1) + w < dist(to -1)) {
            dist(to -1) = dist(from -1) + w
            count +=1
          }
        }
        if (count ==0) {
          break
        }
    }}
    var mx = dist.max
    if (mx == Int.MaxValue) -1 else mx  
  }

  def validPath(n : Int, edges : Array[Array[Int]], source : Int, destination : Int) : Boolean = {
    if (n ==1)
      return true

    val map = HashMap.empty[Int, List[Int]]
    val set = HashSet.empty[Int]
    val q = Queue.empty[Int]

    edges.foreach {
      case item => { 
        map.getOrElseUpdate(item(0), List.empty[Int])
        map.getOrElseUpdate(item(1), List.empty[Int])

        map.put(item(0), map.get(item(0)).get :+ item(1))
        map.put(item(1), map.get(item(1)).get :+ item(0))
      }
    }

    q.enqueue(source)
    while (!q.isEmpty) {
      val current = q.dequeue()
      if (!set.contains(current)) {
        set.add(current)
        val neighbors = map.get(current).get 
        for (n <- neighbors) {
          if (n == destination) {
            return true
          }
          q.enqueue(n)
        }
      }
    }
    false
  }
}

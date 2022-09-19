package faang

import org.scalatest.funsuite.AnyFunSuite

class GraphsTest extends AnyFunSuite {

    // https://leetcode.com/problems/time-needed-to-inform-all-employees/
    //
    test("Time Needed to Inform All Employees") {
        assert(1 == graphs.numOfMinutes(6, 2,  Array(2, 2, -1, 2, 2, 2), Array(0, 0, 1, 0, 0, 0)))
    }

    // Topological sort =========

    // Course Schedule
    // https://leetcode.com/problems/course-schedule/
    //
    // There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    // You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
    // that you must take course bi first if you want to take course ai.
    //
    // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    // Return true if you can finish all courses. Otherwise, return false.
    //

    test("total of numCourses courses you have to take") {
        assertResult(true)(graphs.scheduleCourseCanFinish(2, Array(Array(1, 0))))
        assertResult(false)(graphs.scheduleCourseCanFinish(2, Array(Array(1, 0), Array(0, 2))))
        assertResult(true)(graphs.scheduleCourseCanFinish( 6,
                Array(Array(0, 1), Array(0, 2),Array(0, 3),Array(0, 4),Array(4, 5))))
    }

    // Network Delay Time
    // https://leetcode.com/problems/network-delay-time/
    // You are given a network of n nodes, labeled from 1 to n.
    // You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
    // vi is the target node, and wi is the time it takes for a signal to travel from source to target.
    // We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
    // If it is impossible for all the n nodes to receive the signal, return -1.
    //
    // !! Only for positive Weights, No cycles !!
    
    test("Network Delay Time Dejkstra") {
        assertResult(2)(graphs.networkDelayTimeDejkstra(
                Array(Array(2, 1, 1), Array(2, 3, 1), Array(3, 4, 1)),
                4,2 ))
    }

    // Weights can be negative & positive
    //
    test("Network Delay Time BellmanFord") {
        assertResult(2)( graphs.networkDelayTimeBellmanFord(
            Array(Array(1, 4, 2), Array(1, 2, 9), Array(4, 2, -4), Array(2, 5, -3), Array(4, 5, 6), 
            Array(3, 2, 3), Array(5, 3, 7), Array(3, 1, 5)),
            5,1 ))
    }

}
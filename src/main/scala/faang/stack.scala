package faang

import scala.collection.mutable.Stack

object stack {

 	// pars := map[byte]byte{"(": ")", "[": "]", "{": "}"}
	// stack := make([]byte, 0)
	// for _, c := range s {
	// 	if v, ok := pars[byte(c)]; ok {
	// 		stack = append(stack, byte(v)) // push
	// 	} else {
	// 		if len(stack) > 0 {
	// 			var x byte
	// 			if x, stack = stack[len(stack)-1], stack[:len(stack)-1]; x != byte(c) { //  pop
	// 				return false
	// 			}
	// 		} else {
	// 			return false
	// 		}
	// 	}
	// }
	// return len(stack) == 0   

  def isValid_Parentheses(s: String): Boolean = {
    if (s.length() == 0) {
        return true
    }

    val pairs = Map[Char, Char]('(' -> ')', '[' -> ']', '{' -> '}')
    var stack = Stack.empty[Char]
    for (k <- s) {
        pairs.get(k) match {
            case Some(v) => stack = stack.push(v)
            case None => {
                if (stack.isEmpty) {
                    return false
                }
                if (k != stack.pop()) {
                    return false
                }
            }
        }
    }
    stack.isEmpty
  }
}

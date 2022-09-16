package faang

import org.scalatest.funsuite.AnyFunSuite

class StackTest extends AnyFunSuite {

    case class PRT(input : String, exp : Boolean)

	test("Is Valid Parentheses") {
        val ts = Vector[PRT](PRT("()", true), PRT("()[]{}", true), PRT("(]", false), PRT("]", false))
        for (t <- ts) {
            assert(stack.isValid_Parentheses(t.input) == t.exp)
        }
	}
} 
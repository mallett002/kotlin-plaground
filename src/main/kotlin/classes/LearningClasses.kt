package classes

class Someone(val firstName: String, val lastName: String, val age: Int = 5) {
    var otherName: String = "$lastName, $firstName"; 
}

class LearningClasses(val name: String) {
    val children: MutableList<LearningClasses> = mutableListOf();

    // secondary constructor
    constructor(name: String, parent: LearningClasses) : this(name) {
        parent.children.add(this);
    }
}

class Thing {
    init {
        println("this comes first.");
    }

    constructor() {
        println("this comes second.");
    }
}

// Classes final by default.
// need to use open if want to inherit from
open class Shape {
    open fun draw() {}
}

// Can override a non-abstract member with abstract one
abstract class Square : Shape() {
    abstract override fun draw()
}

class CoolSquare : Square() {
    override fun draw() {
        println("do it.");
    }
}

/*
    - Classes are final in kotlin by default. (Can't inherit from them)
    - Specify "open" or "abstract" if you want to inherit from them
    - You can override a non-abstract open member with an abstract one.
*/


fun eval(expr: Expr): Int = when (expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


/*
* Sealed Classes
* Has to be one of the Implemented interfaces, or extended classes
* */
fun evalSealed(expr: ExprSealed): Int = when (expr) {
    is NumSealed -> expr.value
    is SumSealed -> evalSealed(expr.left) + evalSealed(expr.right)
    is OtherOne -> expr.next
}

// Make the sealed interface:
sealed interface ExprSealed

// Implement the interface with some classes:
class NumSealed(val value: Int) : ExprSealed
class SumSealed(val left: ExprSealed, val right: ExprSealed) : ExprSealed
class OtherOne(val next: Int): ExprSealed
// in "evalSealed", we don't need the "else" case, "expr" can only be one of the implemented interfaces from the sealed interface.


/* ===========Extension Functions ============*/
// The "this" keyword represents the Type being extended
// Make ext fun "toRational", which extends "Int":
fun Int.toRational(): RationalNumber = RationalNumber(this, 1)

// Make ext fun "toRational" also extend Pair<Int, Int>
fun Pair<Int, Int>.toRational(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

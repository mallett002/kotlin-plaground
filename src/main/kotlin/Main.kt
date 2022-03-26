fun main(args: Array<String>) {
    val theIndex: Int = getNthChar("howdy", 'w');
    println("The index is $theIndex");
}

fun getNthChar(str: String, chr: Char): Int {
    println("Getting the char at $chr for $str");
    return str.indexOf(chr);
}

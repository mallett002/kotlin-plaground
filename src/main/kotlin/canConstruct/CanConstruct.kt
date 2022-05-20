fun main(args: Array<String>) {
    fun canConstruct(target: String, wordBank: List<String>): Boolean {
        if (target.isEmpty()) {
            return true
        }

        for (word in wordBank) {
            // Make sure it's a prefix:
            if (target.indexOf(word) == 0) {
                // take off the prefix
                val suffix = target.substring(word.length)

                if (canConstruct(suffix, wordBank)) {
                  return true
                }
            }

        }

        return false
    }

    println(canConstruct("hello", listOf("hi", "hel", "ll", "lo"))) // true
    println(canConstruct("", listOf("", "hel", "ll", "lo"))) // true
    println(canConstruct("blah", listOf("bla", "hel", "ll", "lah"))) // false
}



class Algorithms {
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

}

class Algorithms {
    fun canConstruct(
        target: String,
        wordBank: List<String>,
        memo: HashMap<String, Boolean> = hashMapOf()
    ): Boolean {
        if (memo.get(target) != null) return memo.getValue(target)
        if (target.isEmpty()) {
            return true
        }

        for (word in wordBank) {
            // Make sure it's a prefix:
            if (target.indexOf(word) == 0) {
                // take off the prefix
                val suffix = target.substring(word.length)

                if (canConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true
                }
            }

        }

        memo.put(target, false);
        return false
    }

}

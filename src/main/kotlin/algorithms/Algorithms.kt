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


    // Runtime without memoization: 1061ms
    // Runtime with memoization: 11ms
    fun countConstruct(target: String, wordBank: List<String>, memo: MutableMap<String, Int> = mutableMapOf()): Int {
        if (memo.containsKey(target)) return memo.get(target)!!
        if (target.isEmpty()) {
            memo[target] = 1;
            return 1;
        }

        var totalWays = 0;

        for (word in wordBank) {
            // make sure the word is a prefix for the target
            if (target.indexOf(word) == 0) {
                // get the suffix out from the target,
                val suffix = target.substring(word.length)
                val numWaysForSuffix = countConstruct(suffix, wordBank, memo)

                totalWays += numWaysForSuffix
            }
        }

        memo[target] = totalWays;
        return totalWays;
    }

    // Roman numerals algorithm:
    private fun getRomanNumeral(num: Int): String = when (num) {
        1 -> "I"
        4 -> "IV"
        5 -> "V"
        9 -> "IX"
        10 -> "X"
        40 -> "XL"
        50 -> "L"
        90 -> "XC"
        100 -> "C"
        400 -> "CD"
        500 -> "D"
        900 -> "CM"
        1000 -> "M"
        else -> ""
    }

    private fun findLargestRoman(num: Int): Int {
        if (num - 1000 > 0 ) return 1000
        if (num - 900 > 0 ) return 900
        if (num - 500 > 0 ) return 500
        if (num - 400 > 0 ) return 400
        if (num - 100 > 0 ) return 100
        if (num - 90 > 0 ) return 90
        if (num - 50 > 0 ) return 50
        if (num - 40 > 0 ) return 40
        if (num - 10 > 0 ) return 10
        if (num - 9 > 0 ) return 9
        if (num - 5 > 0 ) return 5
        if (num - 4 > 0 ) return 4
        if (num - 1 > 0 ) return 1
        return 0
    }

    private fun buildRomanString(num: Int, checker: Int, builder: String, cache: MutableMap<Int, String>): String {
        val newNum = num - checker
        val newRoman: String = getRomanNumeral(checker)

        return "${builder}${createRomans(newNum, newRoman, cache)}"
    }

    fun createRomans(num: Int, builder: String = "", cache: MutableMap<Int, String> = mutableMapOf()): String {
        // Base case: if we already did this operation, return the cached result
        if (cache.containsKey(num)) {
            return cache[num]!!
        }

        // Base case: Tries to find a romanNumeral, returns it if it finds it
        val roman = getRomanNumeral(num)

        if (roman.isNotEmpty()) {
            val updatedRoman = "$builder${roman}"
            cache[num] = updatedRoman
            return updatedRoman
        }

        // Otherwise, gets the largest number it can deduct from, that has a difference greater than 0
        // if it finds one that isn't zero, returns the roman string from it
        val largest: Int = findLargestRoman(num)
        if (largest != 0) {
            val updatedRoman = buildRomanString(num, largest, builder, cache)
            cache[num] = updatedRoman
            return updatedRoman
        }

        // In all other cases, just return the builder string
        cache[num] = builder
        return builder
    }


    /* allConstruct algorithm: Return all the combinations you can build the target */
    // new extension function that adds an element to the front of a list
    private fun <T> MutableList<T>.prepend(element: T) {
        add(0, element)
    }

    fun allConstruct(target: String, wordBank: List<String>): List<List<String>> {
        if (target.isEmpty()) return mutableListOf(mutableListOf()) // [[]]

        // Thing we'll return at the end
        val combinations: MutableList<List<String>> = mutableListOf()

        for (word in wordBank) {
            if (target.indexOf(word) == 0) { // make sure it's a prefix
                // remove the prefix off the target:
                val remainder = target.substring(word.length)
                val result = allConstruct(remainder, wordBank)

                if (result.isNotEmpty()) { // if we have an [[]]
                    val theList = result.get(0).toMutableList()

                    theList.prepend(word)

                    combinations.add(theList)
                }
            }
        }

        return combinations
    }


}


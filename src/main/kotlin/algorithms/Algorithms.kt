import classes.Expr
import classes.Num
import classes.Sum

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


    // Todo: make it fast!
    fun countConstruct(target: String, wordBank: List<String>): Int {
        if (target.isEmpty()) return 1;

        var totalWays = 0;

        for (word in wordBank) {
            // make sure the word is a prefix for the target
            if (target.indexOf(word) == 0) {
                // get the suffix out from the target,
                val suffix = target.substring(word.length)
                val numWaysForSuffix = countConstruct(suffix, wordBank)

                totalWays += numWaysForSuffix
            }
        }

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

    private fun buildRomanString(num: Int, checker: Int, builder: String): String {
        val newNum = num - checker
        val newRoman: String = getRomanNumeral(checker)

        return "${builder}${createRomans(newNum, newRoman)}"
    }

    fun createRomans(num: Int, builder: String = ""): String {
        val roman = getRomanNumeral(num)
        if (roman.isNotEmpty()) {
            return "$builder${roman}"
        }

        val largest: Int = findLargestRoman(num)
        if (largest != 0) {
            return buildRomanString(num, largest, builder)
        }

        return builder;
    }
}


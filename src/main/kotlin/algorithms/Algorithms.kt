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

    fun createRomans(num: Int, builder: String = ""): String {
        val roman = getRomanNumeral(num)
        if (roman.isNotEmpty()) {
            return "$builder${roman}"
        }

        if (num - 5 > 0) {
            val newNum = num - 5
            val newRoman: String = getRomanNumeral(5)

            return "${builder}${createRomans(newNum, newRoman)}"
        }

        return builder;
    }
}

class Introduction {
    // Named Arguments:
    fun joinOptions(
        options: Collection<String>,
        prefix: String = "[",
        postfix: String ="]"
    ): String {
        return options.joinToString(", ", prefix, postfix)
    }

    // Default Arguments:
    fun foo(
        name: String,
        number: Int = 42,
        toUpperCase: Boolean = false
    ) =
        (if (toUpperCase) name.uppercase() else name) + number

    fun useFoo(bar: String): List<String> = listOf(
        foo(bar),
        foo(bar, number = 1),
        foo(bar, toUpperCase = true),
        foo(name = bar, number = 2, toUpperCase = true)
    )

    // Triple quoted Strings:
    fun doTripleQuotedString(): String {
        val question = "life, the universe, and everything"
        val answer = 42
        val tripleQuotedString = """ #question = "$question"
            #answer = $answer""".trimMargin("#")

        println(tripleQuotedString)
        return tripleQuotedString;
    }

    // String templates:
    fun doStringTemplates(date: String): Boolean {
        val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

        fun getPattern() = """\d{2}\.\d{2}\.\d{4}"""

        return true;
    }
}
class Introduction {
    // Named Arguments:
    fun joinOptions(
        options: Collection<String>,
        prefix: String = "[",
        postfix: String ="]"
    ): String {
        return options.joinToString(", ", prefix, postfix)
    }

    // Default Arguments
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
}
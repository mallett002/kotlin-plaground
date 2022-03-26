class Introduction {
    fun joinOptions(
        options: Collection<String>,
        prefix: String = "[",
        postfix: String ="]"
    ): String {
        return options.joinToString(", ", prefix, postfix)
    }
}
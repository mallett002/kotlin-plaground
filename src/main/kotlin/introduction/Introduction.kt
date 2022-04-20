package introduction

import java.lang.IllegalArgumentException

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
        val regex = """\d{2} $month \d{4}""".toRegex()

        return regex.containsMatchIn(date);
    }

    // Nullable types:
    fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
        val email = client?.personalInfo?.email;

        if (email != null && message != null) {
            mailer.sendMessage(email, message);
        }
    }

    class Client(val personalInfo: PersonalInfo?)

    class PersonalInfo(val email: String?)

    interface Mailer {
        fun sendMessage(email: String, message: String)
    }

    class MyMailer : Mailer {
        override fun sendMessage(email: String, message: String) {
            println("Sending email $email with message $message")
        }
    }

    // Nothing type
    // Return type for functions that always throws an exception
    private fun failWithWrongAge(age: Int?): Nothing {
        throw IllegalArgumentException("Wrong age: $age");
    }

    fun checkAge(age: Int?) {
        if (age == null || age !in 0..150) { // between 0 - 150 (including 0 & 150)

            failWithWrongAge(age);
        }

        if (age != null) {
            println("Congrats! Next year you'll be ${age + 1}")
        };
    }
}

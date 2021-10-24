

fun inputDataFromUser(): String{
    print("> ")
    val str = readLine()!!
    return try { str.removeRange(0, 0) } catch (e: Exception) { "\n" }
}
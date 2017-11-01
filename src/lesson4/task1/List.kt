@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val m: Double = list.sum() / list.size
    for (i in 0 .. (list.size-1)) {
        list [i] -= m
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double = TODO()

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var ans: String = ""
    var remainder: Int = n
    var test = 0
    var root = (Math.sqrt(remainder.toDouble())).toInt()
    for (i in 2..root) {
        if ((remainder % i) == 0) {
                while ((remainder % i) == 0) {
                    if (test == 0) {
                        ans = "$i"
                        test += 1
                    }
                    else
                        ans += "*$i"
                    remainder /= i
                    root = (Math.sqrt(remainder.toDouble())).toInt()
            }
        }
    }
    return when {
        (remainder != 1) && (ans == "") -> remainder.toString()
        (remainder != 1) -> ans + "*" + remainder.toString()
        else -> ans
    }
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var m: Int = n
    var l: Int = 0
    var backAns: String = ""
    var ans: String = ""
    var c: Int = 0
    if (n == 0)
        ans = "0"
    fun translaition (x: Int): String =
            when {
            x == 0 -> "0"
            x == 1 -> "1"
            x == 2 -> "2"
            x == 3 -> "3"
            x == 4 -> "4"
            x == 5 -> "5"
            x == 6 -> "6"
            x == 7 -> "7"
            x == 8 -> "8"
            x == 9 -> "9"
            x == 10 -> "a"
            x == 11 -> "b"
            x == 12 -> "c"
            x == 13 -> "d"
            x == 14 -> "e"
            x == 15 -> "f"
            x == 16 -> "g"
            x == 17 -> "h"
            x == 18 -> "i"
            x == 19 -> "j"
            x == 20 -> "k"
            x == 21 -> "l"
            x == 22 -> "m"
            x == 23 -> "n"
            x == 24 -> "o"
            x == 25 -> "p"
            x == 26 -> "q"
            x == 27 -> "r"
            x == 28 -> "s"
            x == 29 -> "t"
            x == 30 -> "u"
            x == 31 -> "v"
            x == 32 -> "w"
            x == 33 -> "x"
            x == 34 -> "y"
           else -> "z"
        }
    while (m != 0) {
        l = m % base
        backAns += translaition(l)
        m /= base
        c ++
    }
    for (char in backAns) {
        ans += backAns [c-1]
        c --
    }
    return ans
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var ans = 0
    var c: Double = digits.size.toDouble()
    if (digits.size == 1)
        return digits[0]
    else {
        for (i in 0..(digits.size - 1)) {
            ans += digits[i] * Math.pow(base.toDouble(),c - 1.0).toInt()
            c --
        }
    }
    return ans
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var c: Double = 0.0
    var ans: Int = 0
    fun translation (x: String): Int =
            when {
                x == "0" -> 0
                x == "1" -> 1
                x == "2" -> 2
                x == "3" -> 3
                x == "4" -> 4
                x == "5" -> 5
                x == "6" -> 6
                x == "7" -> 7
                x == "8" -> 8
                x == "9" -> 9
                x == "a" -> 10
                x == "b" -> 11
                x == "c" -> 12
                x == "d" -> 13
                x == "e" -> 14
                x == "f" -> 15
                x == "g" -> 16
                x == "h" -> 17
                x == "i" -> 18
                x == "j" -> 19
                x == "k" -> 20
                x == "l" -> 21
                x == "m" -> 22
                x == "n" -> 23
                x == "o" -> 24
                x == "p" -> 25
                x == "q" -> 26
                x == "r" -> 27
                x == "s" -> 28
                x == "t" -> 29
                x == "u" -> 30
                x == "v" -> 31
                x == "w" -> 32
                x == "x" -> 33
                x == "y" -> 34
                else -> 35
            }
    for (char in str) {
        c ++
    }
    for (char in str) {
        ans += translation(char.toString()) * (Math.pow(base.toDouble(),(c - 1))).toInt()
        c --
    }
    return ans
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val o: Int = n % 10
    val t: Int = (n / 10) % 10
    val h: Int = (n / 100) % 10
    val th: Int = (n / 1000) % 1000
    val helpT: Int = n % 100
    val helpTh: Int = (n / 1000) % 100
    val first: Int = (th / 100) % 10
    val second: Int = (th / 10) % 10
    val third: Int = (th % 10)
    var ans: String
    fun mainTranslation (x: Int): String {
        return when {
            x == 1 -> "один "
            x == 2 -> "два "
            x == 3 -> "три "
            x == 4 -> "четыре "
            x == 5 -> "пять "
            x == 6 -> "шесть "
            x == 7 -> "семь "
            x == 8 -> "восемь "
            x == 9 -> "девять "
            x == 11 -> "одиннадцать "
            x == 12 -> "двенадцать "
            x == 13 -> "тринадцать "
            x == 14 -> "четырнадцать "
            x == 15 -> "пятнадцать "
            x == 16 -> "шестнадцать "
            x == 17 -> "семнадцать "
            x == 18 -> "восемнадцать "
            x == 19 -> "девятнадцать "
            else -> ""
        }
    }
    fun tTranslaition (x: Int, helpT: Int): String {
        return when {
            (helpT >= 11) && (helpT <= 19) -> mainTranslation(helpT)
            x == 1 -> "десять "
            x == 2 -> "двадцать "
            x == 3 -> "тридцать "
            x == 4 -> "сорок "
            x == 5 -> "пятьдесят "
            x == 6 -> "шестьдесят "
            x == 7 -> "семьдесят "
            x == 8 -> "восемьдесят "
            x == 9 -> "девяносто "
            else -> ""
        }
    }
    fun hTranslaition (x: Int): String {
        return when {
            x == 1 -> "сто "
            x == 2 -> "двести "
            x == 3 -> "триста "
            x == 4 -> "четыреста "
            x == 5 -> "пятьсот "
            x == 6 -> "шестьсот "
            x == 7 -> "семьсот "
            x == 8 -> "восемьсот "
            x == 9 -> "девятьсот "
            else -> ""
        }
    }
    fun thTranslation (x: Int, helpTh: Int): String {
        return when {
            ((helpTh >= 11) && (helpTh <= 19)) -> hTranslaition(first) +
                    mainTranslation(helpTh) + "тысяч "
            (third >= 1) && (third <= 4) -> when {
                third == 1 -> hTranslaition(first) +
                        tTranslaition(second, 0) + "одна тысяча "
                third == 2 -> hTranslaition(first) +
                        tTranslaition(second, 0) + "две тысячи "
                third == 3 -> hTranslaition(first) +
                        tTranslaition(second, 0) + "три тысячи "
                third == 4 -> hTranslaition(first) +
                        tTranslaition(second, 0) + "четыре тысячи "
                else -> ""
            }
            first == 0 && second == 0 && third == 0 -> ""
            mainTranslation(third) == "" -> hTranslaition(first) + tTranslaition(second, 0) + "тысяч "
            else -> hTranslaition(first) + tTranslaition(second, 0) +
                    mainTranslation(third) + "тысяч "
        }
    }
    if ((helpT >= 11) && (helpT <= 19))
        ans = thTranslation(th, helpTh) +
                hTranslaition(h) + tTranslaition(t, helpT)
    else
        ans = thTranslation(th, helpTh) + hTranslaition(h) +
            tTranslaition(t, helpT) + mainTranslation(o)
    return ans.trim()
}
@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 1
    var nvar = n
    if (nvar == 0) return 1
    while (nvar / 10 != 0) {
        count = count + 1
        nvar = nvar / 10
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var x1: Int = 1
    var x2: Int = 1
    var k: Int = 2
    var local: Int = 0
    if (n <= k) return 1
    else {
        while (k < n) {
            local = x1 + x2
            x1 = x2
            x2 = local
            k++
        }
        return local
    }
}



/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var ans = 0
    var maxDivisor = 0
    var k = m
    var z = n
    while (maxDivisor == 0) {
        if ((Math.max(k, z) % Math.min(k, z)) == 0 )
            maxDivisor = Math.min(k, z)
        else {
            if (k > z) k %= z
            else z %= k
        }
    }
    ans = n / maxDivisor * m
    return ans
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var d = 2
    val lim: Double = Math.ceil(Math.sqrt(n.toDouble()))
    while (d <= lim) {
        if (n % d == 0) return d
        d++
    }
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var k = 0
    for (i in n/2 downTo 1) {
        if (n % i == 0)
          return i
    }
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var maxDivisor = 0
    var k = m
    var z = n
    while (maxDivisor == 0) {
        if ((Math.max(k, z) % Math.min(k, z)) == 0 )
            maxDivisor = Math.min(k, z)
        else {
            if (k > z) k %= z
            else z %= k
        }
    }
    return maxDivisor == 1
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 1
    if (m == 0)  return true
    else {
        while (n / k >= k) {
            if ((n.toDouble() / k.toDouble()  >= k.toDouble())
                    && (m.toDouble() / k.toDouble() <= k.toDouble())) return true
            k++
        }
        return false
    }
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    fun sin2(x: Double, n: Int): Double {
        var mul: Double = 1.0
        val x = x % (2 * Math.PI)
        for (i: Int in 1..n) {
            mul = mul * x
            mul = mul / i
        }
        return mul
    }
    var sign: Double = 1.0
    var sum: Double = 0.0
    var p: Double
    var n: Int = 1
    do {
        p = sin2(x, n)
        sum = sum + sign * p
        n = n + 2
        sign = -sign
    } while (p >= eps)
    return sum
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var m = n
    var c = 0
    var ans = 0
    while (m > 0) {
        c ++
        m /= 10
    }
    m = n
    for (i in 1..c ) {
        ans += (m % 10) * Math.pow(10.0,(c-1.0)).toInt()
        m /= 10
        c --
    }
    return ans
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var count: Int = 0
    var z: Int = 0
    var num = 1
    var k: Int = 0
    var ans: Int = 0
    do {
        var countlocal: Int = 0
        z = num * num
        k = z
        while (k > 0) {
            k /= 10
            countlocal++
        }
        count += countlocal
        num++
        countlocal = 0
        }
    while (n > count)
    var y = count - n
    while (y > 0) {
        z /= 10
        y--
    }
    ans = z % 10
    return ans
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var count: Int = 2
    var z: Int = 0
    var countlocal: Int = 0
    var x1: Int = 1
    var x2: Int = 1
    var k: Int = 0
    var ans: Int = 0
    if ((n == 1) || (n == 2)) return 1
    else {
        do {
            z = x1 + x2
            k = z
            while (k > 0) {
                k /= 10
                countlocal++
            }
            count += countlocal
            x1 = x2
            x2 = z
            countlocal = 0
        }
        while (n > count)
        if (n == count) ans = z % 10
            var y: Int = count - n
            while (y > 0) {
             z /= 10
             y--
            ans = z % 10
        }
    }
    return ans
}

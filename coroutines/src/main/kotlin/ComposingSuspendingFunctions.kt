import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//fun main() = runBlocking {
    /**
     * Sequential by result
     *
     * coroutine, just like in the regular code, is sequential by default
     */

//    val time = measureTimeMillis {
//        val one = doSomethingUseFulOne()
//        val two = doSomethingUseFulTwo()
//        println("The answer is ${one + two}")
//    }
//    println("Completed in $time ms")

    /**
     * Concurrent Using async
     *
     * What if there are no dependencies between invocations
     * we want to get the answer faster, by doing both concurrently?
     * This is the twice as fast, because the two coroutines execute concurrently.
     * Note that concurrency with coroutines is always explicit
     *
     * we can wait the job of using `async` keyword
     */

//    val time2 = measureTimeMillis {
//        val one = async { doSomethingUseFulOne() }
//        val two = async { doSomethingUseFulTwo() }
//        println("answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time2 ms")

    /**
     * Lazily started async
     *
     * Optionally, async can be made lazy by setting its start parameter
     * its result is required by await, or if its Job's start function is invoked
     * if we just call await in println without first calling start
     */

//    val time3 = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doSomethingUseFulOne() }
//        val two = async(start = CoroutineStart.LAZY) { doSomethingUseFulTwo() }
//
//        one.start()
//        two.start()
//
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("completed in $time3 ms")
//}

//fun main() {
        /**
         * Async style functions
         *
         * We can define async style functions
         * xxxAsync functions are not suspending functions
         * They can be used from anywhere
         * Using this style with Kotlin coroutines is strongly discouraged
         * This problem does not happen with structured concurrency
         */

//        try {
//            val time4 = measureTimeMillis {
//                val one = somethingUsefulOneAsync()
//                val two = somethingUsefulTwoAsync()
//
//                println("my exception")
//                throw Exception("my exception")
//
//                runBlocking {
//                    println("The answer is ${one.await() + two.await()}")
//                }
//            }
//            println("Completed in $time4 ms")
//        } catch (e: Exception) {
//
//        }
//
//        runBlocking {
//            delay(10000L)
//        }
//}


//fun main() = runBlocking{
//    /**
//     * Structured concurrency with async
//     * This way, if throws an exception, all coroutines will be cancelled.
//     */
//
//    try {
//
//
//        println("myException")
//        throw Exception("My Exception")
//
//        val time5 = measureTimeMillis {
//            println("The answer is ${concurrentSum()}")
//        }
//
//        println("Completed in $time5 ms")
//    } catch (e: Exception) {
//
//    }
//}

//fun main() = runBlocking<Unit> {
    /**
     * Cancellation propagated coroutines hierarchy
     * - note how both the first async and the awaiting parent are cancelled on failure of one of the children (namely, two)
     */
//    try {
//        failedConcurrentSum()
//    } catch (e: Exception) {
//        println("Computation failed with ArithmeticException")
//    }
//}

//suspend fun failedConcurrentSum(): Int = coroutineScope {
//    val one = async<Int> {
//        try {
//            delay(Long.MAX_VALUE)
//            42
//        } finally {
//            println("first child was cancelled")
//        }
//    }
//
//    val two = async<Int> {
//        println("second child throws an exception")
//        throw ArithmeticException()
//    }
//    one.await() + two.await()
//}


//suspend fun concurrentSum(): Int = coroutineScope {
//    val one = async { doSomethingUseFulOne() }
//    val two = async { doSomethingUseFulTwo() }
//    one.await() + two.await()
//}
//
//
//suspend fun doSomethingUseFulOne(): Int {
//    println("start, doSomethingUseFulOne")
//    delay(3000L) // pretend wa are doing something useful here
//    println("end, doSomethingUseFulOne")
//    return 13
//}
//
//suspend fun doSomethingUseFulTwo(): Int {
//    println("start, doSomethingUseFulTwo")
//    delay(3000L) // pretend wa are doing something useful here, too
//    println("end, doSomethingUseFulTwo")
//    return 29
//}

//fun <T>println(msg: T) {
//    kotlin.io.println("$msg, [${Thread.currentThread().name}]")
//}

//fun somethingUsefulOneAsync() = GlobalScope.async {
//    println("start, somethingUsefulOneAsync")
//    val res = doSomethingUseFulOne()
//    println("end, somethingUsefulOneAsync")
//    res
//}
//fun somethingUsefulTwoAsync() = GlobalScope.async {
//    println("start, somethingUsefulTwoAsync")
//    val res = doSomethingUseFulTwo()
//    println("end, somethingUsefulTwoAsync")
//    res
//}

import kotlinx.coroutines.*


fun main() = runBlocking {

    /**
     * Cancelling coroutine execution
     */

//    val job = launch {
//        repeat(1000) { i ->
//            println("jobs: I'm sleeping $i")
//            delay(500L)
//        }
//    }
//
//    delay(1300L)
//    println("main: I'm tired of waiting")
//    job.cancel()
//    job.join()
//    println("main: Now I can quit")

    /**
     * Cancellation is cooperative
     *
     * 1. Coroutine cancellation is cooperative
     * 2. A coroutine code has to cooperate to be cancellable
     * 3. suspending functions are cancellable
     *
     * if suspending functions is not existing in the coroutine scope,
     * The coroutine scope is operating to go on until the main thread operating.
     * So if you want to suspend to use cancel() method in the other jobs.
     * you have to use the suspending functions.
     *
     * 1. way: to periodically invoke a suspending
     * 2. way: explicitly check the cancellation status (isActive)
     *
     */

//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        try {
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive) { // coroutine의 종료 상태를 확인하고 싶으면 isActive를 사용하면 된다. -> 하지만 isActive는 exception을 던지지 않음.
//                if (System.currentTimeMillis() > nextPrintTime) {
////                    yield()
//                    println("job: I'm sleeping ${i++} ...")
//                    nextPrintTime += 500L
//                }
//            }
//            println("isActive: $isActive")
//        } catch (e: Exception) {
//            print("Exception: $e")
//        }
//
//    }
//
//    delay(1300L)
//    println("main: I'm tired of waiting")
//    job.cancelAndJoin()
//    println("main: Now I can quit")

    /**
     * Non-cancellable bloc
     *
     * in the rare case
     * when you need to suspend in a cancelled coroutine
     * withContext(NonCancellable) {...}
     */

//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("job: I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("job: I'm running finally")
//                delay(1000L)
//                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
//
//            }
//        }
//    }
//    delay(1300L)
//    println("main: I'm tired of waiting")
//    job.cancelAndJoin()
//    println("main: Now I can quit")

    /**
     * Timeout
     *
     * its execution time has exceeded some timeout
     * there is a ready to use withTimeout function
     * CancellationException is considered to be a normal reason for coroutine completion
     * we have used withTimeout right inside the main function
     */

//    withTimeout(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i")
//            delay(500L)
//        }
//    }

    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i")
            delay(500L)
        }
        "Done"
    }
    println("result is [${result}]")
}

//fun <T>println(msg: T) {
//    kotlin.io.println("msg: $msg, [${Thread.currentThread().name}]")
//}
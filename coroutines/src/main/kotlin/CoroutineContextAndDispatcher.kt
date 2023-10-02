import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*

/**
 * Dispatchers and Threads
 *
 * 1. The coroutine context includes a coroutine dispatcher
 * 2. determines what thread for its execution
 * 3. All coroutines builders an optional CoroutineContext Parameter
 * 4. that can be used to explicitly specify the dispatcher
 */



fun main(): Unit = runBlocking {

    /**
     * option을 주지 않으면, 상위 CoroutineScope를 그대로 상속받아서 연산을 수행하게 됨.
     * 그래서 똑같이 main에서 작동하는 것임.
     */
    launch {
        println("main runBlocking, I'm working in Thread name")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined, I'm working in Thread name")
    }

    launch(Dispatchers.Default) {
        println("Default, I'm working in Thread name")
    }

    // newSingleThreadContext은 비용이 좀 높은 방식으로 아래와 같이 코드를 사용하지 말고
//    launch(newSingleThreadContext("MyOwnThread")) {
//        println("newSingleThreadContext, I'm working in Thread name")
//    }

    /**
     * 이렇게 사용해야 함. 왜? Thread를 새로 만드는데, 이거 무조건 close를 해줘야 한다.
     * close를 해주지 않으면, memory leak 남.
     * use 안에서 close 해줌 그래서 사용하는 것임.
     */
    newSingleThreadContext("MyOwnThread").use {
        launch(it) {
            println("newSingleThreadContext, I'm working in Thread name")
        }
    }


}

fun <T>println(msg: T) {
    kotlin.io.println("msg: $msg [${Thread.currentThread().name}]")
}
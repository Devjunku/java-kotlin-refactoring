import kotlinx.coroutines.*

/**
 * Coroutine Builder
 *  - launch
 *  - runBlocking
 *
 * Scope
 *  - CoroutineScope
 *  - GlobalScope
 *
 * Suspend Function
 *  - Suspend
 *  - delay
 *  - join
 *
 * Structured Concurrency
 */


fun main(args: Array<String>) = runBlocking {

//   GlobalScope.launch {
//      delay(1000L)
//      println("world")
//   }
//   println("hello")
//   Thread.sleep(2000L)

   /**
    * 함수 내에서 바로 launch
    */
//   launch {
//      delay(1000L)
//      println("world")
//   }
//   println("hello")

   /**
    * 함수 내에서 coroutines 로직만 수행
    */
//   launch {
//      doWorld()
//   }
//   println("hello")

   /**
    * 함수 자체가 coroutines scope = coroutines scope를 만듬 (suspend keyword 필수)
    */
//   doWorld2()

   /**
    * 동시성 처리
    * 지연시간이 다른 world1, world2가 출력 이때, 무엇부터 출력되는지?
    */
//   doWorld3()

   /**
    * 명시적 작업
    */
//   val job = launch {
//      delay(1000L)
//      println("world")
//   }
//   println("hello")
//   job.join() // job 작업이 끝날 떄까지 기다려줌
//   println("Done")

   /**
    * 반복
    */

//   repeat(50_000) {
//      Thread {
//         Thread.sleep(1000L)
//         println(".")
//      }
//   }

   /**
    * 일시중단과 재개 예제
    */

//   launch {
//      repeat(5) {
//            i -> println("Coroutine A: $i")
//         delay(10L)
//      }
//   }
//
//   launch {
//      repeat(5) {
//         i -> println("Coroutine B: $i")
//         delay(10L)
//      }
//   }
//   println("Croroutine Outer")
}

/**
 * println을 최상위 함수로 override
 */
// -Dkotlinx.coroutines.debug

//fun <T>println(msg: T) {
//   kotlin.io.println("$msg [${Thread.currentThread().name}]")
//}


//
//suspend fun doWorld1() {
//   delay(1000L)
//   println("world")
//}


//suspend fun doWorld2() = coroutineScope {
//   launch {
//      delay(1000L)
//      println("world")
//   }
//   println("hello")
//}

// 동시성 처리
//suspend fun doWorld3() = coroutineScope {
//   launch {
//      delay(2000L)
//      println("world1")
//   }
//   launch {
//      delay(1000L)
//      println("world2")
//   }
//   println("hello")
//}


import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

   GlobalScope.launch {
      delay(1000L)
      println("world")
   }
   println("hello")
   Thread.sleep(2000L)

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
//      launch {
//         delay(2000L)
//         println(".")
//      }
//   }

}

suspend fun doWorld1() {
   delay(1000L)
   println("world")
}


suspend fun doWorld2() = coroutineScope {
   launch {
      delay(1000L)
      println("world")
   }
   println("hello")
}

// 동시성 처리
suspend fun doWorld3() = coroutineScope {
   launch {
      delay(2000L)
      println("world1")
   }
   launch {
      delay(1000L)
      println("world2")
   }
   println("hello")
}


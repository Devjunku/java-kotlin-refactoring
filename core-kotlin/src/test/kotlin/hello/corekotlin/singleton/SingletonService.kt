package hello.corekotlin.singleton

//class SingletonService {
//
//    companion object {
//        val instance = SingletonService()
//
//        fun getInstance() {
//            return instance
//        }
//
//    }
//
//
//
//}

/**
 * Kotlin에서 Singleton Pattern을 만들 떄는 다양한 유형이 존재
 * 아래는 object 키워드로 컴파일 단계에서 바로 만들어버리는 것
 * Companion Object는 생성자 주입 방식으로 Singleton pattern을 만드는 방법이 있음
 * 상황에 따라서 적절하게 사용해야 함.
 */


object SingletonService {
    fun printMsg(msg: String) {
        println("$msg")
    }
}
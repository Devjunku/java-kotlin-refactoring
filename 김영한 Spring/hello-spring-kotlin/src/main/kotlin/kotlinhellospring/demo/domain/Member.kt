package kotlinhellospring.demo.domain

data class Member(
    var name: String? = null
) {
    /**
     * () 안에는 필수 생성자를 의미
     * 따로 뺴고 싶으면 {} 안에서 작성해야 함.
     */
    var id: Long? = null
}


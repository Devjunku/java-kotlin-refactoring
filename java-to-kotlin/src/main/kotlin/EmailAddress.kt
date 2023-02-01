data class EmailAddress(
    val localPart: String,
    val domain: String
) {
    override fun toString(): String = "{$localPart}@{$domain}"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be two parts separated by @"
            }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex+1)
            )
        }

    }
}

/**
 * 위 class를 java로 변환했을 때 필요한 것
 * 1. parse
 * 2. 생성자 선언 및 할당
 * 3. getter
 * 4. equals
 * 5. hashCode
 * 6. toString
 */
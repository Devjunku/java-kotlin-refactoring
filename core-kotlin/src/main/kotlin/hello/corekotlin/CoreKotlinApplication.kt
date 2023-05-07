package hello.corekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoreKotlinApplication

fun main(args: Array<String>) {
	runApplication<CoreKotlinApplication>(*args)
}

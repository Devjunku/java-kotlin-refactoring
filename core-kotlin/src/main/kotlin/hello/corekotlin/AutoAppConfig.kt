package hello.corekotlin


import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

/**
 * kotlin의 경우 @ComponentScan의 정보를 arrayOf()에 담아서 보내준다.
 */


@Configuration
@ComponentScan(
    excludeFilters = arrayOf(
        ComponentScan.Filter(type = FilterType.ANNOTATION),
        ComponentScan.Filter(Configuration::class)
    )
)
class AutoAppConfig {



}
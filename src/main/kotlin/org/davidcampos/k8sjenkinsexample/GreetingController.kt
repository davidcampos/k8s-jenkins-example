package org.davidcampos.k8sjenkinsexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter = AtomicLong()
    
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World!") name: String): Greeting {
        val envVar: String = System.getenv("EXAMPLE_VALUE") ?: "default_value"
        return Greeting(counter.incrementAndGet(), "Hello, $name.123", envVar)
    }
}
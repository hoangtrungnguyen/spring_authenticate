package com.gtap.authenticate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthenticateApplication

fun main(args: Array<String>) {
    runApplication<AuthenticateApplication>(*args)
}

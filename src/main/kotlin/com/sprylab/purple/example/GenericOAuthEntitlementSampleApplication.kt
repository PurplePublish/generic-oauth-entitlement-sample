package com.sprylab.purple.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GenericOAuthEntitlementSampleApplication

fun main(args: Array<String>) {
    runApplication<GenericOAuthEntitlementSampleApplication>(*args)
}

package com.forworkismail.kotlinspringboot.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    @GetMapping
    fun hello() = "<h1>Hello this is a Kotlin Spring Boot Application</h1>"
}
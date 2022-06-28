package com.forworkismail.kotlinspringboot.controller

import com.forworkismail.kotlinspringboot.model.Bank
import com.forworkismail.kotlinspringboot.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val bankService: BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = bankService.getBanks()

}
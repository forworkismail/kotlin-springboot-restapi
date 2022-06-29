package com.forworkismail.kotlinspringboot.controller

import com.forworkismail.kotlinspringboot.model.Bank
import com.forworkismail.kotlinspringboot.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val bankService: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getBanks(): Collection<Bank> = bankService.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank = bankService.getBank(accountNumber)
}
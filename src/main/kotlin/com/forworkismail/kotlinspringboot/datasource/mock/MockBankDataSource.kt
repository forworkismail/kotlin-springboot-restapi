package com.forworkismail.kotlinspringboot.datasource.mock

import com.forworkismail.kotlinspringboot.datasource.BankDataSource
import com.forworkismail.kotlinspringboot.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource: BankDataSource {

    val banks = listOf(
        Bank("123", 1.1, 0),
        Bank("123", 1.1, 0),
        Bank("123", 1.1, 10),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}
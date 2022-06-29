package com.forworkismail.kotlinspringboot.datasource.mock

import com.forworkismail.kotlinspringboot.datasource.BankDataSource
import com.forworkismail.kotlinspringboot.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource: BankDataSource {

    val banks = listOf(
        Bank("1234", 1.1, 0),
        Bank("1231231", 1.2, 0),
        Bank("12341231", 1.3, 10),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.first { it.accountNumber == accountNumber }
}
package com.forworkismail.kotlinspringboot.service

import com.forworkismail.kotlinspringboot.datasource.BankDataSource
import com.forworkismail.kotlinspringboot.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.addBank(bank)
}
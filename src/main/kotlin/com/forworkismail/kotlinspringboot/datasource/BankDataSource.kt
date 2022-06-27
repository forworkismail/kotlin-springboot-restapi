package com.forworkismail.kotlinspringboot.datasource

import com.forworkismail.kotlinspringboot.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
}
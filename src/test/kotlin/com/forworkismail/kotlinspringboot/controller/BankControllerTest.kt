package com.forworkismail.kotlinspringboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.forworkismail.kotlinspringboot.model.Bank
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {


    @Test
    fun `should return all banks`() {
        //when/then
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$[0].accountNumber") { value("123") }
            }
    }

    @Test
    fun `should return bank with the given account number`() {

        // given
        val accountNumber = 1234
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$.trust") { value(1.1) }
            }
    }

    @Test
    fun `should return NOT FOUND if the account number does not exists`() {

        // given
        val accountNumber = "does not exists"
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isNotFound() }
            }
    }

    @Test
    fun `should add the new bank`() {
        // given
        val bank = Bank(accountNumber = "123", trust = 1.1, transactionFee=1)

        // when
        val performPost = mockMvc.post("/api/banks/") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bank)
        }

        // then
        performPost.andDo { print() }
        .andExpect {
            status { isCreated() }
            content { contentType("application/json") }
            jsonPath("$.accountNumber") { value("123") }
            jsonPath("$.trust") { value(1.1) }
            jsonPath("$.transactionFee") { value(1) }
        }
    }

    @Test
    fun `should return BAD REQUEST if the account number is not valid`() {
        // given
        val bank = Bank(accountNumber = "123", trust = 1.1, transactionFee=1)

        // when
        val performPost = mockMvc.post("/api/banks/") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bank)
        }

        // then
        performPost.andDo { print() }
        .andExpect {
            status { isBadRequest() }
        }
    }
}
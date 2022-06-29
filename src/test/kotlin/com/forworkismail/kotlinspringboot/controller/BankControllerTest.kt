package com.forworkismail.kotlinspringboot.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

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
}
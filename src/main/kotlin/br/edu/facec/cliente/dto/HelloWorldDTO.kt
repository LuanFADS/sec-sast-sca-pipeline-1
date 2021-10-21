package br.edu.facec.cliente.dto

import java.time.LocalDateTime

data class HelloWorldDTO(
        val message: String = "Hello World!",
        val whenOccurs: LocalDateTime = LocalDateTime.now(),
)
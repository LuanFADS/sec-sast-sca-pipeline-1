package br.edu.facec.cliente.resource

import br.edu.facec.cliente.dto.HelloWorldDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.OutputStreamWriter


@RestController
class HelloWorldResource {

    @GetMapping("/hello-world")
    fun helloWorld(): HelloWorldDTO {
        return HelloWorldDTO()
    }

    fun failed() {
        val pass = "password=12345"
        val writer = OutputStreamWriter(ByteArrayOutputStream())
        writer.write(pass)
        writer.flush()
    }

}
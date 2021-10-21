package br.edu.facec.cliente.resource

import br.edu.facec.cliente.entity.Cidade
import br.edu.facec.cliente.service.CidadeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class CidadeResource(val service: CidadeService) {

    @GetMapping("/cidades")
    fun getAll(pageable: Pageable): ResponseEntity<Page<Cidade>> {
        val page = service.findAll(pageable)
        return ResponseEntity.ok(page)
    }

    @GetMapping("/cidades/{id}")
    fun getById(@PathVariable("id") id: UUID): ResponseEntity<Cidade> {
        val found = service.findById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/cidades")
    fun post(@Valid @RequestBody cidade: Cidade): ResponseEntity<Cidade> {
        val saved = service.save(cidade)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved)
    }

    @PutMapping("/cidades/{id}")
    fun put(@PathVariable("id") id: UUID, @Valid @RequestBody cidade: Cidade): ResponseEntity<Cidade> {
        if (!service.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build()
        }
        val toUpdate = Cidade(id = id, nome = cidade.nome, estadoId = cidade.estadoId)
        val saved = service.save(toUpdate)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/cidades/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Cidade> {
        if (!service.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build()
        }
        service.deleteById(id)
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
    }

}
package br.edu.facec.cliente.resource

import br.edu.facec.cliente.entity.Estado
import br.edu.facec.cliente.service.EstadoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class EstadoResource(val service: EstadoService) {

    @GetMapping("/estados")
    fun getAll(pageable: Pageable): ResponseEntity<Page<Estado>> {
        val page = service.findAll(pageable)
        return ResponseEntity.ok(page)
    }

    @GetMapping("/estados/{id}")
    fun getById(@PathVariable("id") id: UUID): ResponseEntity<Estado> {
        val found = service.findById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/estados")
    fun post(@Valid @RequestBody estado: Estado): ResponseEntity<Estado> {
        val saved = service.save(estado)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved)
    }

    @PutMapping("/estados/{id}")
    fun put(@PathVariable("id") id: UUID, @Valid @RequestBody estado: Estado): ResponseEntity<Estado> {
        if (!service.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build()
        }
        val toUpdate = Estado(id = id, nome = estado.nome, uf = estado.uf)
        val saved = service.save(toUpdate)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/estados/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Estado> {
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
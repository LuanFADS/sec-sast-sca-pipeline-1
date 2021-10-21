package br.edu.facec.cliente.entity

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Cidade(
        @Id
        @GeneratedValue
        val id: UUID?,

        @Column
        @field:NotBlank(message = "Nome deve ser informado!")
        @field:Length(message = "Nome deve ter no máximo 100 caracteres", max = 100)
        val nome: String,

        @Column(name = "estado_fk")
        @field:NotNull(message = "Estado deve ser informado!")
        val estadoId: UUID,
)
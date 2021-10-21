package br.edu.facec.cliente.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.findByIdOrNull

open class CrudService<T, ID>(protected open val repository: PagingAndSortingRepository<T, ID>) {

    fun findAll(pageable: Pageable): Page<T> = repository.findAll(pageable)

    fun findById(id: ID): T? = repository.findByIdOrNull(id)

    fun save(obj: T): T = repository.save(obj)

    fun exists(id: ID) = repository.existsById(id)

    fun deleteById(id: ID) = repository.deleteById(id)
}
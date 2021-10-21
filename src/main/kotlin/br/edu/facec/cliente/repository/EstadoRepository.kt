package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Estado
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface EstadoRepository : PagingAndSortingRepository<Estado, UUID>
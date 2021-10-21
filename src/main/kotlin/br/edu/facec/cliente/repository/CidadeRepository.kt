package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Cidade
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface CidadeRepository : PagingAndSortingRepository<Cidade, UUID>
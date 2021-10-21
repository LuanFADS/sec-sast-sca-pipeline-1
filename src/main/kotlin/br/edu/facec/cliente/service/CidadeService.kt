package br.edu.facec.cliente.service

import br.edu.facec.cliente.entity.Cidade
import br.edu.facec.cliente.repository.CidadeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CidadeService(override val repository: CidadeRepository) : CrudService<Cidade, UUID>(repository)
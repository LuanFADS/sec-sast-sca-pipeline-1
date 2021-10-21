package br.edu.facec.cliente.service

import br.edu.facec.cliente.entity.Estado
import br.edu.facec.cliente.repository.EstadoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EstadoService(override val repository: EstadoRepository) : CrudService<Estado, UUID>(repository)
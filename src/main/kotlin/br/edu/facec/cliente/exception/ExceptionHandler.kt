package br.edu.facec.cliente.exception

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.Instant
import java.util.*

@ControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, Any?>? {
        val erros: MutableMap<String, String?> = extractErrors(ex)
        val fieldsErrors = mapOf(Pair("fields", erros))
        val response = mutableMapOf<String, Any?>()
        response["status"] = HttpStatus.BAD_REQUEST.value().toString()
        response["error"] = fieldsErrors
        response["timestamp"] = Instant.now().toString()
        return response
    }

    private fun extractErrors(ex: MethodArgumentNotValidException): MutableMap<String, String?> {
        val errors: MutableMap<String, String?> = HashMap()
        for (error in ex.bindingResult.allErrors) {
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors[fieldName] = errorMessage
        }
        return errors
    }


}
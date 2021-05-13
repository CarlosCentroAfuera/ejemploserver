package com.ejemploserver.ejemploserver

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


class TareaNoEncontradaException(id: Long) : RuntimeException("La tarea con id = $id no existe.")

@ControllerAdvice
class TareaNoEncontrada {

    @ResponseBody
    @ExceptionHandler(TareaNoEncontradaException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun excepcionPorTareaNoEncontrada(exception: TareaNoEncontradaException) : String? {
        return exception.message
    }

}
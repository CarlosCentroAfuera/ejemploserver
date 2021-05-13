package com.ejemploserver.ejemploserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TareaController(private val tareaRepository: TareaRepository) {

    @GetMapping("/GetTareas")
    fun getTareas() : List<Tarea> {
        println("Se ha recibido un GetTareas")
        val list = tareaRepository.findAll()
        println(list)
        return list
    }

    @GetMapping("/GetTareasPares")
    fun getTareasPares() : List<Tarea> {
        println("Se ha recibido un GetTareas")
        val list = tareaRepository.findAll().filter { it.titulo.length % 2 == 0 }
        println(list)
        return list
    }

    @GetMapping("/GetTareaById/{id}")
    fun getTareaById(@PathVariable id : Long) : Tarea {
        try {
            println("Se ha recibido un GetTareaById")
            val tarea = tareaRepository.getOne(id)
            println(tarea)
            return tarea
        } catch (e:Exception) {
            throw TareaNoEncontradaException(id)
        }
    }

}
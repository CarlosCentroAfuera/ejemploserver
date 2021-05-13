package com.ejemploserver.ejemploserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class EjemploserverApplication


fun main(args: Array<String>) {
	println("Comenzamos el servidor")
	runApplication<EjemploserverApplication>(*args)
	println("Creación del servidor completada")
}

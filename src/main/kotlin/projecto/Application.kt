package com.example.teste

import com.example.projecto.Modelo.Mafioso
import com.example.projecto.Modelo.Padrinho
import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File


fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/1") {
                // Caminho absoluto ou relativo do arquivo
                val file = File("src/main/resources/html/index2.html")
                call.respondFile(file)
            }
            post("/Padrinho") {
                val params = call.receiveParameters()
                val nome = params["nome"] ?: ""
                val posto = params["posto"]?:""

                val padrinho = Padrinho(nome, posto)

                call.respondText("Padrinho criado: ${padrinho}")
            }
        }


    }.start(wait = true)

}
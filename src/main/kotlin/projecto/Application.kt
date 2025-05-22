package com.example.teste

import com.example.projecto.Modelo.Mafioso
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
            get("/Adicionar") {
                // Caminho absoluto ou relativo do arquivo
                val file = File("src/main/resources/html/Adicionar.html")
                call.respondFile(file)
            }
            post("/Adicionar") {
                val params = call.receiveParameters()
                val nome = params["nome"] ?: ""
                val posto = params["posto"] ?: ""
                val idade = params["idade"]?.toIntOrNull() ?: 0

                val mafioso = Mafioso(nome,posto,idade)

                call.respondText("Mafioso criado:  ${mafioso.nome}\nPosto: ${mafioso.posto}\nIdade: ${mafioso.idade}")
            }
        }
    }.start(wait = true)
}
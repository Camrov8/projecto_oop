package com.example.teste

import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.server.engine.*
import io.ktor.server.netty.*
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
        }
    }.start(wait = true)
}
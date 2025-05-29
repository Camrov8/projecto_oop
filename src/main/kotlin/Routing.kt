package com.example

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.Thymeleaf
import io.ktor.server.thymeleaf.ThymeleafContent
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.io.File

fun Application.configureRouting() {
    routing {


        // Static plugin. Try to access `/static/index.html`
        staticResources("/", "static") {
            enableAutoHeadResponse()
            // suas outras rotas aqui...

        }
    }
}

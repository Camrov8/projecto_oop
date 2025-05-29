package com.example.teste

import com.example.projecto.Modelo.Mafioso
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import java.io.File


fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            routing {
                get("/background") {
                    val file = File("src/main/resources/img/background.jpg")
                    if (file.exists()) {
                        call.respondFile(file)
                    } else {
                        call.respond(HttpStatusCode.NotFound, "Imagem não encontrada")
                    }
                }
            }

            get("/") {
                // Caminho absoluto ou relativo do arquivo
                val file = File("src/main/resources/html/Home.html")
                call.respondFile(file)
                println("a")
            }
            get("/form") {
                // Caminho absoluto ou relativo do arquivo
                val file = File("src/main/resources/html/Adicionar.html")
                call.respondFile(file)
                println("a")
            }
            get("/sucesso"){
                val htmlContent = """
        <!DOCTYPE html>
        <html>
        <head><title>Sucesso</title></head>
        <body>
            <h1>Mafioso criado com sucesso!</h1>
            <button onclick="window.location.href='/form'">Voltar ao Formulário</button>
        </body>
        </html>
    """.trimIndent()

                call.respondText(htmlContent, ContentType.Text.Html)
                }


            post("/Adicionar") {
                println("a")
                val params = call.receiveParameters()
                val nome = params["nome"] ?: ""
                val posto = params["posto"] ?: ""
                val familia = params["familia"] ?: ""
                val idade = params["idade"]?.toIntOrNull() ?: 0


                val mafioso = Mafioso(nome, posto, familia, idade.toString())
                //Ler o ficheiro e guardar o conteudo numa var Mafioso[]
                //adicionar a essa array o meu mafioso
                //transformar a array em JSON
                //escrever a array no ficheiro

                val mafia =
                    File("src/main/kotlin/projecto/Modelo/mafioso.json").readText()

                var ler: MutableList<Mafioso> = Json.decodeFromString(mafia)
                ler.add(mafioso)


                //call.respondText("Mafioso criado:  ${mafioso.nome}\nPosto: ${mafioso.posto}\nIdade: ${mafioso.idade}")
                call.respondRedirect("/sucesso")

// Serializa para JSON
                val json = Json { prettyPrint = true } // mais legível
                val jsonString = json.encodeToString(ler)


// Salva no arquivo
                File("src/main/kotlin/projecto/Modelo/mafioso.json").writeText(
                    jsonString
                )
            }
        }
    }.start(wait = true)
}
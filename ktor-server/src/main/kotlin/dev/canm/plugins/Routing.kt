package dev.canm.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    var count = 0
    routing {
        get("/") {
            println("Request #${++count}")
            call.respondText("Hello GraalVM!")
        }
    }

}

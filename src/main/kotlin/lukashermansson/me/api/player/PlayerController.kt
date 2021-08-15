package lukashermansson.me.api.player

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import lukashermansson.me.core.Player
import lukashermansson.me.core.PlayerService
import org.koin.ktor.ext.inject
import java.util.*

fun Application.configureRouting() {


    val playerService : PlayerService by inject()
    routing {
        get("/players") {
            call.respond(playerService.getAllPlayers())
        }
        get("/players/{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

            try{
                call.respond(playerService.getplayerById(UUID.fromString(id)))
            }catch (e : RuntimeException){
                call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
            }
        }

        post("/players/") {
            val player = call.receive<Player>()

            val saveplayer = playerService.saveplayer(player)

            call.respond(saveplayer)
        }
    }
}
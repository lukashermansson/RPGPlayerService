package lukashermansson.me.api

import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import lukashermansson.me.api.player.configureRouting
import lukashermansson.me.api.plugins.*
import lukashermansson.me.core.PlayerRepository
import lukashermansson.me.core.PlayerService
import lukashermansson.me.repository.PlayerInMemmoryRepository
import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy
import org.koin.ktor.ext.Koin

fun main() {

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {

        main()
    }.start(wait = true)
}



val PlayerServiceModule = module {
    singleBy<PlayerRepository, PlayerInMemmoryRepository>()

    single<PlayerService>()
}

fun Application.main() {
    install(Koin) {
        modules(PlayerServiceModule)
    }

    configureRouting()
    configureSerialization()
}
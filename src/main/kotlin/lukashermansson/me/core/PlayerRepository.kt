package lukashermansson.me.core

import java.util.*

interface PlayerRepository {

    fun getAllPlayers() : List<Player>

    fun getPlayerByUUID(uuid: UUID) : Player

    fun savePlayer(player: Player) : Player


}
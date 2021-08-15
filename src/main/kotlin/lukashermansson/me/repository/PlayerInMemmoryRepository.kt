package lukashermansson.me.repository

import lukashermansson.me.core.Player
import lukashermansson.me.core.PlayerRepository
import java.util.*

class PlayerInMemmoryRepository : PlayerRepository {
    val datastore = mutableMapOf<UUID, Player>()

    override fun getAllPlayers(): List<Player> {
        return datastore.values.stream().toList()
    }

    override fun getPlayerByUUID(uuid: UUID): Player {
        return datastore.get(uuid) ?: throw NullPointerException()
    }

    override fun savePlayer(player: Player): Player {
        return datastore.put(player.id, player) ?: throw IllegalArgumentException()
    }
}
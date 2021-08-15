package lukashermansson.me.core

import java.util.*

class PlayerService(private val playerRepository: PlayerRepository) {
    fun getplayerById(uuid: UUID) : Player{
        return playerRepository.getPlayerByUUID(uuid);
    }

    fun getAllPlayers(): List<Player> {
        return playerRepository.getAllPlayers();
    }
    fun saveplayer(player: Player) : Player {
        return playerRepository.savePlayer(player);
    }
}
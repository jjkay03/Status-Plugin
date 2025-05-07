package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.Saves
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

object StatusUtils {

    // Function that add player to status list if not already in it
    fun addStatusPlayer(player: Player) {
        if (StatusManager.PLAYERS_STATUSES.none { it.player == player }) {
            StatusManager.PLAYERS_STATUSES.add(PlayerStatus(player))
        }
    }

    // Function to get player from status list
    fun getStatusPlayer(player: Player): PlayerStatus? {
        return StatusManager.PLAYERS_STATUSES.find { it.player == player }
    }

    // Function to build the status string of a player
    fun buildPlayerStatusPrefix(status: PlayerStatus): Component {
        val status1Comp = Saves.TAB_PREFIX_SYMBOL.color(status.status1.color)
        val status2Comp = Saves.TAB_PREFIX_SYMBOL.color(status.status2.color)
        val nameComp = Component.text(status.player.name).color(NamedTextColor.WHITE)
        return status1Comp.append(status2Comp).append(nameComp)
    }

    // Function to apply status to player in tab
    fun setTabStatus(player: Player) {
        val playerStatus = getStatusPlayer(player) ?: return
        val nameComponent = buildPlayerStatusPrefix(playerStatus)
        player.playerListName(nameComponent)

        // TODO: DEBUG (REMOVE LATER)
        player.sendMessage("\n§bSetting ${player.name} status: ${getStatusPlayer(player).toString()}\n")
    }

}
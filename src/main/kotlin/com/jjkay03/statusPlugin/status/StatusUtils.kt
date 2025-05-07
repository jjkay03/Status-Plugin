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
        val status1Comp = Saves.TAB_PREFIX_SYMBOL.color(status.statusAvailability.color)
        val status2Comp = Saves.TAB_PREFIX_SYMBOL.color(status.statusMedia.color)
        val nameComp = Component.text(status.player.name).color(NamedTextColor.WHITE)
        return status1Comp.append(status2Comp).append(nameComp)
    }

    // Function to apply status to player in tab
    fun updateTabStatus(player: Player) {
        val playerStatus = getStatusPlayer(player) ?: return
        val nameComponent = buildPlayerStatusPrefix(playerStatus)
        player.playerListName(nameComponent)

        // TODO: DEBUG (REMOVE LATER)
        player.sendMessage("\n§bSetting ${player.name} status: ${getStatusPlayer(player).toString()}\n")
    }

    // Function to set a player's status
    fun setPlayerStatus(player: Player, status: Status, feedbackMsg: Boolean = true) {
        addStatusPlayer(player) // Add player to list if not already
        val playerStatus = getStatusPlayer(player) ?: return
        if (status.type == StatusType.AVAILABILITY) playerStatus.statusAvailability = status
        if (status.type == StatusType.MEDIA) playerStatus.statusMedia = status
        updateTabStatus(player) // Update status in tab
        if (feedbackMsg) player.sendMessage("§7Status type ${status.type} set to ${status.name}")
    }

}
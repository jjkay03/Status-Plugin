package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.Saves
import com.jjkay03.statusPlugin.StatusPlugin
import com.jjkay03.statusPlugin.Utils
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
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
    }

    // Function to set a player's status
    fun setPlayerStatus(player: Player, status: Status, feedbackMsg: Boolean = true) {
        addStatusPlayer(player) // Add player to list if not already
        val playerStatus = getStatusPlayer(player) ?: return

        // Check if the status is already set before applying
        if (status.type == StatusType.AVAILABILITY) {
            if (playerStatus.statusAvailability == status) return // Skip if already set
            playerStatus.statusAvailability = status
        }
        if (status.type == StatusType.MEDIA) {
            if (playerStatus.statusMedia == status) return // Skip if already set
            playerStatus.statusMedia = status
        }

        updateTabStatus(player) // Update status in tab
        if (feedbackMsg) player.sendMessage("§7Status type ${status.type} set to ${status.statusName}")
        mediaAlert(playerStatus) // Send media alert to all players
    }

    // Function that alerts player with media alerts (rec or stream) if feature is enabled in config
    fun mediaAlert(playerStatus: PlayerStatus) {
        // Checks
        if (!Saves.CONFIG_ENABLE_MEDIA_ALERTS) return
        if (playerStatus.statusMedia == Status.MEDIA_NONE) return

        // Prepare alert message
        val alertMessage = when (playerStatus.statusMedia) {
            Status.MEDIA_RECORDING -> Utils.replacePlaceholders(Saves.CONFIG_MEDIA_ALERT_RECORD, mapOf("player" to playerStatus.player.name))
            Status.MEDIA_STREAMING -> Utils.replacePlaceholders(Saves.CONFIG_MEDIA_ALERT_STREAM, mapOf("player" to playerStatus.player.name))
            else -> return
        }

        // Broadcast alert message
        Utils.messageAllPlayers(alertMessage)
    }

    // Function to send player join message (reminder to set status) if feature is enabled in config
    fun joinMessageReminder(player: Player, tickDelay: Long = 20L) {
        if (!Saves.CONFIG_ENABLE_JOIN_MESSAGE_REMINDER) return

        // Build clickable message
        val message = Component.text()
            .content(Saves.CONFIG_JOIN_MESSAGE_REMINDER)
            .clickEvent(ClickEvent.runCommand("/status"))
            .hoverEvent(HoverEvent.hoverEvent(HoverEvent.Action.SHOW_TEXT, Component.text("§eClick to set status")))
            .build()

        // Send message with delay
        Bukkit.getScheduler().runTaskLater(StatusPlugin.INSTANCE, Runnable {
            player.sendMessage(message)
        }, tickDelay)
    }
}
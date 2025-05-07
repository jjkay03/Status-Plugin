package com.jjkay03.statusPlugin.status

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class StatusManager: Listener {
    companion object {
        var PLAYERS_STATUSES = mutableListOf<PlayerStatus>()
    }

    // Deal with player status when they join
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        StatusUtils.addStatusPlayer(player) // Add player to PLAYERS_STATUSES
        StatusUtils.updateTabStatus(player) // Set status in tab
        StatusUtils.joinMessageReminder(player) // Send player reminder to set status
    }
}
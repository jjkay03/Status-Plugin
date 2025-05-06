package com.jjkay03.statusPlugin.status

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class StatusManager: Listener {
    companion object {
        var PLAYERS_STATUSES = mutableListOf<PlayerStatus>()
    }

    // Add player to PLAYERS_STATUSES when they join
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        StatusUtils.addPlayerToStatusList(player)
    }
}
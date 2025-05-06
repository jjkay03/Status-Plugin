package com.jjkay03.statusPlugin.status

import org.bukkit.entity.Player

object StatusUtils {

    // Function that add player to status list if not already in it
    fun addPlayerToStatusList(player: Player) {
        if (StatusManager.PLAYERS_STATUSES.none { it.player == player }) {
            StatusManager.PLAYERS_STATUSES.add(PlayerStatus(player))
        }
    }

}
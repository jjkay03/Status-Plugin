package com.jjkay03.statusPlugin.utils

import com.jjkay03.statusPlugin.Saves
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class TabServerName : Listener {

    // Send new tab to player on login
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        if (!Saves.CONFIG_ENABLE_TAB_SERVER_NAME) return // End if feature is disabled
        setTabHeaderFooter(event.player)
    }

    // Function to send a player the updated tab header and footer
    fun setTabHeaderFooter(player: Player) {
        val emptyLine = Component.text(" ")
        val header = Component.join(
            JoinConfiguration.separator(Component.newline()),
            emptyLine, Component.text(" ${Saves.CONFIG_TAB_SERVER_NAME} "), emptyLine
        )
        val footer = emptyLine
        player.sendPlayerListHeaderAndFooter(header, footer)
    }

}
package com.jjkay03.statusPlugin

import org.bukkit.Bukkit

object Utils {

    // Function that replace a placeholders (example: %player%) with a string
    fun replacePlaceholders(template: String, replacements: Map<String, String>): String {
        var result = template
        for ((key, value) in replacements) result = result.replace("%$key%", value)
        return result
    }

    // Function to send a message to all players online
    fun messageAllPlayers(message: String) {
        Bukkit.getOnlinePlayers().forEach { player -> player.sendMessage(message) }
    }

}
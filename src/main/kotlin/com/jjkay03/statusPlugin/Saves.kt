package com.jjkay03.statusPlugin

import com.jjkay03.statusPlugin.status.PlayerStatus
import net.kyori.adventure.text.format.TextColor

class Saves {
    companion object {
        // All colors
        val COLOR_GRAY = TextColor.fromHexString("#808080")
        val COLOR_RED = TextColor.fromHexString("#ff0014")
        val COLOR_GREEN = TextColor.fromHexString("#2eec23")
        val COLOR_PURPLE = TextColor.fromHexString("#8821ff")

        // Tab prefix
        const val TAB_PREFIX_SYMBOL = "▌"
    }
}
package com.jjkay03.statusPlugin

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor

class Saves {
    companion object {
        // All colors
        val COLOR_GRAY = TextColor.fromHexString("#808080")!!
        val COLOR_RED = TextColor.fromHexString("#ff0014")!!
        val COLOR_GREEN = TextColor.fromHexString("#2eec23")!!
        val COLOR_PURPLE = TextColor.fromHexString("#8821ff")!!

        // Tab prefix
        val TAB_PREFIX_SYMBOL = Component.text("▌")

        // Config options
        var CONFIG_ENABLE_JOIN_MESSAGE_REMINDER = false
        lateinit var CONFIG_JOIN_MESSAGE_REMINDER: String

        var CONFIG_ENABLE_MEDIA_ALERTS = false
        lateinit var CONFIG_MEDIA_ALERT_RECORD: String
        lateinit var CONFIG_MEDIA_ALERT_STREAM: String

        var ENABLE_TAB_SERVER_NAME = false
        lateinit var TAB_SERVER_NAME: String

    }

    init {
        // Get all data from config on initialization
        val config = StatusPlugin.INSTANCE.config
        CONFIG_ENABLE_JOIN_MESSAGE_REMINDER = config.getBoolean("enable-join-message-reminder")
        CONFIG_JOIN_MESSAGE_REMINDER = config.getString("join-message-reminder") ?: "§cJoin message reminder error, invalid config!"

        CONFIG_ENABLE_MEDIA_ALERTS = config.getBoolean("enable-media-alerts")
        CONFIG_MEDIA_ALERT_RECORD = config.getString("media-alert-record") ?: "§cMedia alert record error, invalid config!"
        CONFIG_MEDIA_ALERT_STREAM = config.getString("media-alert-stream") ?: "§cMedia alert stream error, invalid config!"

        ENABLE_TAB_SERVER_NAME = config.getBoolean("enable-tab-server-name")
        TAB_SERVER_NAME = config.getString("tab-server-name") ?: "§cServer name error, invalid config!"
    }
}
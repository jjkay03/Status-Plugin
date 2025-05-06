package com.jjkay03.statusPlugin

import com.jjkay03.statusPlugin.status.StatusManager
import org.bukkit.plugin.java.JavaPlugin

class StatusPlugin : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: StatusPlugin
    }

    // Plugin startup logic
    override fun onEnable() {
        INSTANCE = this

        // CONFIG STUFF
        saveDefaultConfig() // Save the default configuration if it doesn't exist
        reloadConfig() // Reload the configuration

        Saves() // Load all variables in saves class

        // COMMANDS
        // ...

        // REGISTER EVENTS
        server.pluginManager.registerEvents(StatusManager(), this)
    }

    // Plugin shutdown logic
    override fun onDisable() {

    }
}

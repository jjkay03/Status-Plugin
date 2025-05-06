package com.jjkay03.statusPlugin

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
    }

    // Plugin shutdown logic
    override fun onDisable() {

    }
}

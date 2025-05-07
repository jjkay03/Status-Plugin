package com.jjkay03.statusPlugin

import com.jjkay03.statusPlugin.status.StatusCommand
import com.jjkay03.statusPlugin.status.StatusManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.ipvp.canvas.MenuFunctionListener

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

        // CLASS VARIABLES
        val statusCommand = StatusCommand()

        // COMMANDS
        getCommand("status")?.apply { setExecutor(statusCommand); tabCompleter = statusCommand }

        // REGISTER EVENTS
        Bukkit.getPluginManager().registerEvents(MenuFunctionListener(), this) // Canvas MenuFunctionListener
        server.pluginManager.registerEvents(StatusManager(), this)
    }

    // Plugin shutdown logic
    override fun onDisable() {

    }
}

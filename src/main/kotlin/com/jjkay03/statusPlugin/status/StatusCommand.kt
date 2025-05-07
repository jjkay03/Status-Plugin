package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.status_gui.StatusGUI
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class StatusCommand : CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        // Is player check
        if (sender !is Player) {sender.sendMessage("§eOnly players can use this command!"); return true;}

        // Open GUI if no args provided
        if (args.isEmpty()) { openStatusGUI(sender); return true }

        // Deal with arguments
        when (args[0].lowercase()) {

            // SET
            "set" -> {
                // Checks
                if (args.size < 2) { sender.sendMessage("§cSpecify a status or use /$label gui!"); return true }
                val status = Status.entries.find { it.name == args[1].uppercase() }
                if (status == null) { sender.sendMessage("§cInvalid status name!"); return true }

                // Change status
                StatusUtils.setPlayerStatus(sender, status)
            }

            // GUI
            "gui" -> { openStatusGUI(sender) }
        }

        return true
    }

    // TAB COMPLETER
    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): List<String> {
        if (sender !is Player) return emptyList()

        return when (args.size) {
            1 -> listOf("gui", "set").filter { it.startsWith(args[0], ignoreCase = true) }

            2 -> if (args[0].equals("set", ignoreCase = true)) {
                Status.entries
                    .map { it.name }
                    .filter { it.startsWith(args[1], ignoreCase = true) }
            } else emptyList()

            else -> emptyList()
        }
    }

    // Function to open status GUI
    fun openStatusGUI(player: Player) {
        val statusGUIInstance = StatusGUI()
        statusGUIInstance.updateGUI(player)
        statusGUIInstance.statusGUIMenu.open(player)
    }
}
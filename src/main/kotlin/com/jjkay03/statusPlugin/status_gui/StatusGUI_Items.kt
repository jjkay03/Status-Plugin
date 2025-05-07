package com.jjkay03.statusPlugin.status_gui

import com.jjkay03.statusPlugin.status.StatusText
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object StatusGUI_Items {

    // Filter items
    val ITEM_GRAY = ItemStack(Material.GRAY_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_GREEN = ItemStack(Material.LIME_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_RED = ItemStack(Material.RED_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_PURPLE = ItemStack(Material.PURPLE_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }

    // Button AVAILABILITY_NONE
    fun buttonAvailabilityNone(): ItemStack {
        return ItemStack(Material.LIGHT_GRAY_CONCRETE).apply {
            editMeta { meta -> meta.displayName(StatusText.AVAILABILITY_NONE) }
        }
    }

    // Button AVAILABILITY_OPEN
    fun buttonAvailabilityOpen(): ItemStack {
        return ItemStack(Material.LIME_CONCRETE).apply {
            editMeta { meta ->
                meta.displayName(StatusText.AVAILABILITY_OPEN)
                meta.lore(listOf(
                    loreComponent(" "),
                    loreComponent("You are open for other players"),
                    loreComponent("to come hangout or talk with you."),
                    loreComponent(" ")
                ))
            }
        }
    }

    // Button AVAILABILITY_DO_NOT_DISTURB
    fun buttonAvailabilityDoNotDisturb(): ItemStack {
        return ItemStack(Material.RED_CONCRETE).apply {
            editMeta { meta ->
                meta.displayName(StatusText.AVAILABILITY_DO_NOT_DISTURB)
                meta.lore(listOf(
                    loreComponent(" "),
                    loreComponent("You don't want to be distributed"),
                    loreComponent("by other players."),
                    loreComponent(" ")
                ))
            }
        }
    }

    // Button MEDIA_NONE
    fun buttonMediaNone(): ItemStack {
        return ItemStack(Material.LIGHT_GRAY_CONCRETE).apply {
            editMeta { meta -> meta.displayName(StatusText.MEDIA_NONE) }
        }
    }

    // Button MEDIA_RECORDING
    fun buttonMediaRecording(): ItemStack {
        return ItemStack(Material.RED_CONCRETE).apply {
            editMeta { meta ->
                meta.displayName(StatusText.MEDIA_RECORDING)
                meta.lore(listOf(
                    loreComponent(" "),
                    loreComponent("You are recording your POV!"),
                    loreComponent(" ")
                ))
            }
        }
    }

    // Button MEDIA_STREAMING
    fun buttonMediaStreaming(): ItemStack {
        return ItemStack(Material.PURPLE_CONCRETE).apply {
            editMeta { meta ->
                meta.displayName(StatusText.MEDIA_STREAMING)
                meta.lore(listOf(
                    loreComponent(" "),
                    loreComponent("You are live streaming your POV!"),
                    loreComponent(" ")
                ))
            }
        }
    }

    // Helper function to create lore component
    private fun loreComponent(text: String): Component {
        return Component.text(text)
            .color(NamedTextColor.GRAY)
            .decoration(TextDecoration.ITALIC, false)
    }

}
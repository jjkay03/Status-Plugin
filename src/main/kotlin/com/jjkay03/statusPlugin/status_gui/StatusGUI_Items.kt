package com.jjkay03.statusPlugin.status_gui

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object StatusGUI_Items {

    // Filter items
    val ITEM_GRAY = ItemStack(Material.GRAY_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_GREEN = ItemStack(Material.LIME_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_RED = ItemStack(Material.RED_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }
    val ITEM_PURPLE = ItemStack(Material.PURPLE_STAINED_GLASS_PANE).apply { itemMeta = itemMeta?.apply { displayName(Component.text("§r")) } }

    

}
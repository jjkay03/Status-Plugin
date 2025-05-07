package com.jjkay03.statusPlugin.status_gui

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.ipvp.canvas.mask.BinaryMask
import org.ipvp.canvas.type.ChestMenu

class StatusGUI {

    // Creating GUI as an instance variable
    val statusGUIMenu: ChestMenu = ChestMenu.builder(3).title("STATUS").redraw(true).build()

    // Function to update GUI items
    fun updateGUI(player: Player) {

        // Filler item : Gray
        val fillerItemsGray = BinaryMask.builder(statusGUIMenu.dimensions)
            .item(StatusGUI_Items.ITEM_GRAY)
            .pattern("010001000")
            .pattern("000000000")
            .pattern("010001000")
            .build()
        fillerItemsGray.apply(statusGUIMenu)

        // Filler item : Green
        val fillerItemsGreen = BinaryMask.builder(statusGUIMenu.dimensions)
            .item(StatusGUI_Items.ITEM_GREEN)
            .pattern("001000000")
            .pattern("000000000")
            .pattern("001000000")
            .build()
        fillerItemsGreen.apply(statusGUIMenu)

        // Filler item : Red
        val fillerItemsRed = BinaryMask.builder(statusGUIMenu.dimensions)
            .item(StatusGUI_Items.ITEM_RED)
            .pattern("000100100")
            .pattern("000000000")
            .pattern("000100100")
            .build()
        fillerItemsRed.apply(statusGUIMenu)

        // Filler item : Purple
        val fillerItemsPurple = BinaryMask.builder(statusGUIMenu.dimensions)
            .item(StatusGUI_Items.ITEM_PURPLE)
            .pattern("000000010")
            .pattern("000000000")
            .pattern("000000010")
            .build()
        fillerItemsPurple.apply(statusGUIMenu)


    }
}
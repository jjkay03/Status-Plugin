package com.jjkay03.statusPlugin.status_gui

import com.jjkay03.statusPlugin.status.PlayerStatus
import com.jjkay03.statusPlugin.status.Status
import com.jjkay03.statusPlugin.status.StatusUtils
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.Sound
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

        // Set buttons
        val buttonAvailabilityNone = statusGUIMenu.getSlot(10).apply { item = StatusGUI_Items.buttonAvailabilityNone() }
        val buttonAvailabilityOpen = statusGUIMenu.getSlot(11).apply { item = StatusGUI_Items.buttonAvailabilityOpen() }
        val buttonAvailabilityDoNotDisturb = statusGUIMenu.getSlot(12).apply { item = StatusGUI_Items.buttonAvailabilityDoNotDisturb() }
        val buttonMediaNone = statusGUIMenu.getSlot(14).apply { item = StatusGUI_Items.buttonMediaNone() }
        val buttonMediaRecording = statusGUIMenu.getSlot(15).apply { item = StatusGUI_Items.buttonMediaRecording() }
        val buttonMediaStreaming = statusGUIMenu.getSlot(16).apply { item = StatusGUI_Items.buttonMediaStreaming() }

        // Click Handlers
        buttonAvailabilityNone.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.AVAILABILITY_NONE, false); clickSound(player) }
        buttonAvailabilityOpen.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.AVAILABILITY_OPEN, false); clickSound(player) }
        buttonAvailabilityDoNotDisturb.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.AVAILABILITY_DO_NOT_DISTURB, false); clickSound(player) }
        buttonMediaNone.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.MEDIA_NONE, false); clickSound(player) }
        buttonMediaRecording.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.MEDIA_RECORDING, false); clickSound(player) }
        buttonMediaStreaming.setClickHandler { clickPlayer, info -> StatusUtils.setPlayerStatus(clickPlayer, Status.MEDIA_STREAMING, false); clickSound(player) }

    }

    // Function to play click sound
    fun clickSound(player: Player) {
        player.playSound(player.location, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f)
    }
}
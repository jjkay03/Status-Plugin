package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.Saves
import net.kyori.adventure.text.format.TextColor

enum class StatusType() {
    AVAILABILITY,
    MEDIA
}

enum class Status(
    val type: StatusType,
    val statusName: String,
    val color: TextColor
) {

    // == AVAILABILITY STATUSES =======================================================================================

    AVAILABILITY_NONE(
        StatusType.AVAILABILITY,
        "None",
        Saves.COLOR_GRAY
    ),

    AVAILABILITY_DO_NOT_DISTURB(
        StatusType.AVAILABILITY,
        "Do Not Disturb",
        Saves.COLOR_RED
    ),

    AVAILABILITY_OPEN(
        StatusType.AVAILABILITY,
        "Open",
        Saves.COLOR_GREEN
    ),

    // == MEDIA STATUSES ==============================================================================================

    MEDIA_NONE(
        StatusType.MEDIA,
        "None",
        Saves.COLOR_GRAY
    ),

    MEDIA_RECORDING(
        StatusType.MEDIA,
        "Recording",
        Saves.COLOR_RED
    ),

    MEDIA_STREAMING(
        StatusType.MEDIA,
        "Streaming",
        Saves.COLOR_PURPLE
    );

}
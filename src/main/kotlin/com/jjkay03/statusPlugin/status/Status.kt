package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.Saves

enum class StatusType() {
    AVAILABILITY,
    MEDIA
}

enum class Status(
    type: StatusType,
    statusName: String,
    prefix: String
) {

    // == AVAILABILITY STATUSES =======================================================================================

    AVAILABILITY_NONE(
        StatusType.AVAILABILITY,
        "None",
        "${Saves.Companion.COLOR_GRAY}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    ),

    AVAILABILITY_DO_NOT_DISTURB(
        StatusType.AVAILABILITY,
        "Do Not Disturb",
        "${Saves.Companion.COLOR_RED}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    ),

    AVAILABILITY_OPEN(
        StatusType.AVAILABILITY,
        "Open",
        "${Saves.Companion.COLOR_GREEN}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    ),

    // == MEDIA STATUSES ==============================================================================================

    MEDIA_NONE(
        StatusType.MEDIA,
        "None",
        "${Saves.Companion.COLOR_GRAY}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    ),

    MEDIA_RECORDING(
        StatusType.MEDIA,
        "Recording",
        "${Saves.Companion.COLOR_RED}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    ),

    MEDIA_STREAMING(
        StatusType.MEDIA,
        "Streaming",
        "${Saves.Companion.COLOR_PURPLE}${Saves.Companion.TAB_PREFIX_SYMBOL}"
    );

}
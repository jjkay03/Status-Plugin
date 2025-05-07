package com.jjkay03.statusPlugin.status

import org.bukkit.entity.Player

data class PlayerStatus(
    val player: Player,
    var statusAvailability: Status = Status.AVAILABILITY_NONE,
    var statusMedia: Status = Status.MEDIA_NONE
)
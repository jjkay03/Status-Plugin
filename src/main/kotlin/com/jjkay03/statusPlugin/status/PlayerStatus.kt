package com.jjkay03.statusPlugin.status

import org.bukkit.entity.Player

data class PlayerStatus(
    val player: Player,
    var status1: Status = Status.AVAILABILITY_NONE,
    var status2: Status = Status.MEDIA_NONE
)
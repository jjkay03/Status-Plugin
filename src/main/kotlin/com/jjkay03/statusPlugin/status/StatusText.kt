package com.jjkay03.statusPlugin.status

import com.jjkay03.statusPlugin.Saves
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration

object StatusText {

    val AVAILABILITY_NONE = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.AVAILABILITY_NONE.color))
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Component.text(" ${Status.AVAILABILITY_NONE.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()

    val AVAILABILITY_OPEN = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.AVAILABILITY_OPEN.color))
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Component.text(" ${Status.AVAILABILITY_OPEN.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()

    val AVAILABILITY_DO_NOT_DISTURB = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.AVAILABILITY_DO_NOT_DISTURB.color))
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Component.text(" ${Status.AVAILABILITY_DO_NOT_DISTURB.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()

    val MEDIA_NONE = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.MEDIA_NONE.color))
        .append(Component.text(" ${Status.MEDIA_NONE.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()

    val MEDIA_RECORDING = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.MEDIA_RECORDING.color))
        .append(Component.text(" ${Status.MEDIA_RECORDING.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()

    val MEDIA_STREAMING = Component.text()
        .append(Saves.TAB_PREFIX_SYMBOL.color(NamedTextColor.WHITE))
        .append(Saves.TAB_PREFIX_SYMBOL.color(Status.MEDIA_STREAMING.color))
        .append(Component.text(" ${Status.MEDIA_STREAMING.statusName}").color(NamedTextColor.WHITE))
        .decoration(TextDecoration.ITALIC, false)
        .build()
}
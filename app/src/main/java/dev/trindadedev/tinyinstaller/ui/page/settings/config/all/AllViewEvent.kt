package dev.trindadedev.tinyinstaller.ui.page.settings.config.all

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

sealed class AllViewEvent {
    data class DeletedConfig(val configEntity: ConfigEntity) : AllViewEvent()
}

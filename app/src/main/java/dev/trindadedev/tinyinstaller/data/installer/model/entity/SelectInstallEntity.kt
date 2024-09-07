package dev.trindadedev.tinyinstaller.data.installer.model.entity

import dev.trindadedev.tinyinstaller.data.app.model.entity.AppEntity

data class SelectInstallEntity(
    val app: AppEntity,
    val selected: Boolean
)
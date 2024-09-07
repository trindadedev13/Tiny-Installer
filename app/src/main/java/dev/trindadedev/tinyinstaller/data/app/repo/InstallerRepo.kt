package dev.trindadedev.tinyinstaller.data.app.repo

import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallExtraEntity
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

interface InstallerRepo {
    suspend fun doWork(
        config: ConfigEntity,
        entities: List<InstallEntity>,
        extra: InstallExtraEntity
    )
}
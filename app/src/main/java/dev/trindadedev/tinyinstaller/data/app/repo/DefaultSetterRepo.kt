package dev.trindadedev.tinyinstaller.data.app.repo

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

typealias DSRepo = DefaultSetterRepo

interface DefaultSetterRepo {
    suspend fun doWork(
        config: ConfigEntity,
        enabled: Boolean
    )
}
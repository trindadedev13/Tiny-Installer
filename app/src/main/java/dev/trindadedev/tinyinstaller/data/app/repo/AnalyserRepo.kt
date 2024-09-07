package dev.trindadedev.tinyinstaller.data.app.repo

import dev.trindadedev.tinyinstaller.data.app.model.entity.AnalyseExtraEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.AppEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.DataEntity
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

interface AnalyserRepo {
    suspend fun doWork(
        config: ConfigEntity,
        data: List<DataEntity>,
        extra: AnalyseExtraEntity
    ): List<AppEntity>
}
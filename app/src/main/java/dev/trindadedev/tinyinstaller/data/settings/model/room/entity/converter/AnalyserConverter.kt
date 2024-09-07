package dev.trindadedev.tinyinstaller.data.settings.model.room.entity.converter

import androidx.room.TypeConverter

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

object AnalyserConverter {
    @TypeConverter
    fun revert(value: String): ConfigEntity.Analyser =
        ConfigEntity.Analyser.values().find { it.value == value }
            ?: ConfigEntity.Analyser.R0s

    @TypeConverter
    fun convert(value: ConfigEntity.Analyser): String = value.value
}
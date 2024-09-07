package dev.trindadedev.tinyinstaller.data.settings.model.room.entity.converter

import androidx.room.TypeConverter

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

object AuthorizerConverter {
    @TypeConverter
    fun revert(value: String?): ConfigEntity.Authorizer =
        (if (value != null) ConfigEntity.Authorizer.values().find { it.value == value }
        else null) ?: ConfigEntity.Authorizer.Shizuku

    @TypeConverter
    fun convert(value: ConfigEntity.Authorizer): String = value.value
}
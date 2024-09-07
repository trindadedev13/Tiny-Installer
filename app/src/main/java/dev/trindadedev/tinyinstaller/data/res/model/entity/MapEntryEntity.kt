package dev.trindadedev.tinyinstaller.data.res.model.entity

data class MapEntryEntity(
    val parent: Int,
    val valueMap: Map<Int, ValueEntity>
) : Entry

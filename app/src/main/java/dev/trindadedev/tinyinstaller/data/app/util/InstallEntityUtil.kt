package dev.trindadedev.tinyinstaller.data.app.util

import dev.trindadedev.tinyinstaller.data.app.model.entity.DataEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallEntity

fun List<InstallEntity>.sourcePath(): Array<String> = map {
    it.data.sourcePath()
}.filterNotNull().distinct().toTypedArray()

fun DataEntity.sourcePath(): String? = when (val source = this.getSourceTop()) {
    is DataEntity.FileEntity -> source.path
    is DataEntity.ZipFileEntity -> source.parent.path
    is DataEntity.ZipInputStreamEntity -> source.parent.sourcePath()
    else -> null
}
package dev.trindadedev.tinyinstaller.data.installer.repo

import android.app.Activity

import dev.trindadedev.tinyinstaller.data.app.model.entity.DataEntity
import dev.trindadedev.tinyinstaller.data.installer.model.entity.ProgressEntity
import dev.trindadedev.tinyinstaller.data.installer.model.entity.SelectInstallEntity
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

import kotlinx.coroutines.flow.Flow

import java.io.Closeable

interface InstallerRepo : Closeable {
    val id: String

    var error: Throwable

    var config: ConfigEntity

    var data: List<DataEntity>

    var entities: List<SelectInstallEntity>

    val progress: Flow<ProgressEntity>

    val background: Flow<Boolean>

    fun resolve(activity: Activity)

    fun analyse()

    fun install()

    fun background(value: Boolean)

    override fun close()
}
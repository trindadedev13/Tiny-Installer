package dev.trindadedev.tinyinstaller.data.app.model.impl.installer

import android.os.IBinder

import com.rosan.app_process.AppProcess
import com.rosan.app_process.NewProcessImpl

import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallExtraEntity
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

object NoneInstallerRepoImpl : IBinderInstallerRepoImpl() {
    private val newProcess = NewProcessImpl();

    override suspend fun doWork(
        config: ConfigEntity, entities: List<InstallEntity>, extra: InstallExtraEntity
    ) {
        super.doWork(config, entities, extra)
    }

    override suspend fun iBinderWrapper(iBinder: IBinder): IBinder =
        AppProcess.binderWrapper(newProcess, iBinder)

    override suspend fun onDeleteWork(
        config: ConfigEntity,
        entities: List<InstallEntity>,
        extra: InstallExtraEntity
    ) {
        super.onDeleteWork(config, entities, extra)
    }
}
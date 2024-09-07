package dev.trindadedev.tinyinstaller.data.app.model.impl.installer

import android.os.IBinder

import com.rosan.app_process.AppProcess

import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallExtraEntity
import dev.trindadedev.tinyinstaller.data.recycle.model.impl.AppProcessRecyclers
import dev.trindadedev.tinyinstaller.data.recycle.repo.Recyclable
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

object ProcessInstallerRepoImpl : IBinderInstallerRepoImpl() {
    private lateinit var recycler: Recyclable<AppProcess>

    override suspend fun doWork(
        config: ConfigEntity, entities: List<InstallEntity>, extra: InstallExtraEntity
    ) {
        recycler = AppProcessRecyclers.get(
            when (config.authorizer) {
                ConfigEntity.Authorizer.Root -> "su"
                ConfigEntity.Authorizer.Customize -> config.customizeAuthorizer
                else -> "sh"
            }
        ).make()
        super.doWork(config, entities, extra)
    }

    override suspend fun iBinderWrapper(iBinder: IBinder): IBinder =
        recycler.entity.binderWrapper(iBinder)

    override suspend fun doFinishWork(
        config: ConfigEntity,
        entities: List<InstallEntity>,
        extra: InstallExtraEntity,
        result: Result<Unit>
    ) {
        super.doFinishWork(config, entities, extra, result)
        recycler.recycle()
    }
}
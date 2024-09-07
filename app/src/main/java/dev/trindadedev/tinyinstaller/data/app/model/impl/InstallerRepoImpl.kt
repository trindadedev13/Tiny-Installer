package dev.trindadedev.tinyinstaller.data.app.model.impl

import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallEntity
import dev.trindadedev.tinyinstaller.data.app.model.entity.InstallExtraEntity
import dev.trindadedev.tinyinstaller.data.app.model.impl.installer.DhizukuInstallerRepoImpl
import dev.trindadedev.tinyinstaller.data.app.model.impl.installer.ProcessInstallerRepoImpl
import dev.trindadedev.tinyinstaller.data.app.model.impl.installer.ShizukuInstallerRepoImpl
import dev.trindadedev.tinyinstaller.data.app.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

object InstallerRepoImpl : InstallerRepo {
    override suspend fun doWork(
        config: ConfigEntity,
        entities: List<InstallEntity>,
        extra: InstallExtraEntity
    ) {
        val repo = when (config.authorizer) {
            ConfigEntity.Authorizer.Shizuku -> ShizukuInstallerRepoImpl
            ConfigEntity.Authorizer.Dhizuku -> DhizukuInstallerRepoImpl
            else -> ProcessInstallerRepoImpl
        }
        repo.doWork(config, entities, extra)
    }
}
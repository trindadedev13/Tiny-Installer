package dev.trindadedev.tinyinstaller.di

import dev.trindadedev.tinyinstaller.data.settings.model.room.InstallerRoom
import dev.trindadedev.tinyinstaller.data.settings.model.room.repo.AppRepoImpl
import dev.trindadedev.tinyinstaller.data.settings.model.room.repo.ConfigRepoImpl
import dev.trindadedev.tinyinstaller.data.settings.repo.AppRepo
import dev.trindadedev.tinyinstaller.data.settings.repo.ConfigRepo

import org.koin.dsl.module

val roomModule = module {
    single {
        InstallerRoom.createInstance()
    }

    single<AppRepo> {
        val roomDatabase by inject<InstallerRoom>()
        AppRepoImpl(roomDatabase.appDao)
    }

    single<ConfigRepo> {
        val roomDatabase by inject<InstallerRoom>()
        ConfigRepoImpl(roomDatabase.configDao)
    }
}
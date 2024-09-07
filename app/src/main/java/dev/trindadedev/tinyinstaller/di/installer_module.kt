package dev.trindadedev.tinyinstaller.di

import dev.trindadedev.tinyinstaller.data.installer.model.impl.InstallerRepoImpl
import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo

import org.koin.dsl.module

val installerModule = module {
    factory<InstallerRepo> {
        val id = getOrNull<String>()
        InstallerRepoImpl.getOrCreate(id)
    }
}
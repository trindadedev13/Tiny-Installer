package dev.trindadedev.tinyinstaller.data.installer.model.impl.installer

import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo

import kotlinx.coroutines.CoroutineScope

abstract class Handler(val scope: CoroutineScope, open val installer: InstallerRepo) {
    abstract suspend fun onStart()

    abstract suspend fun onFinish()
}
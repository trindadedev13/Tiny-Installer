package dev.trindadedev.tinyinstaller.di.init

import dev.trindadedev.tinyinstaller.di.installerModule
import dev.trindadedev.tinyinstaller.di.reflectModule
import dev.trindadedev.tinyinstaller.di.roomModule
import dev.trindadedev.tinyinstaller.di.serializationModule
import dev.trindadedev.tinyinstaller.di.viewModelModule
import dev.trindadedev.tinyinstaller.di.workerModule

val appModules = listOf(
    roomModule,
    viewModelModule,
    serializationModule,
    workerModule,
    installerModule,
    reflectModule
)

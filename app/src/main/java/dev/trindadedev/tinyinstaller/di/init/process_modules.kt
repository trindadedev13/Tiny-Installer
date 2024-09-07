package dev.trindadedev.tinyinstaller.di.init

import dev.trindadedev.tinyinstaller.di.reflectModule
import dev.trindadedev.tinyinstaller.di.serializationModule

val processModules = listOf(
    serializationModule,
    reflectModule
)



package dev.trindadedev.tinyinstaller.di

import androidx.work.WorkManager

import org.koin.dsl.module

val workerModule = module {
    single<WorkManager> {
        WorkManager.getInstance(get())
    }
}
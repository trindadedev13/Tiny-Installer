package dev.trindadedev.tinyinstaller.di

import android.os.Build

import dev.trindadedev.tinyinstaller.data.reflect.model.impl.ReflectRepoImpl
import dev.trindadedev.tinyinstaller.data.reflect.repo.ReflectRepo

import org.koin.dsl.module

import org.lsposed.hiddenapibypass.HiddenApiBypass

val reflectModule = module {
    single<ReflectRepo> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            HiddenApiBypass.addHiddenApiExemptions("")
        ReflectRepoImpl()
    }
}
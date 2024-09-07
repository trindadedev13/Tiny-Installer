package dev.trindadedev.tinyinstaller.di

import androidx.navigation.NavController

import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogViewModel
import dev.trindadedev.tinyinstaller.ui.page.settings.config.all.AllViewModel
import dev.trindadedev.tinyinstaller.ui.page.settings.config.apply.ApplyViewModel
import dev.trindadedev.tinyinstaller.ui.page.settings.config.edit.EditViewModel
import dev.trindadedev.tinyinstaller.ui.page.settings.preferred.PreferredViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (installer: InstallerRepo) ->
        DialogViewModel(installer)
    }

    viewModel {
        PreferredViewModel()
    }

    viewModel { (navController: NavController) ->
        AllViewModel(navController, get())
    }

    viewModel { (id: Long?) ->
        EditViewModel(get(), id)
    }

    viewModel { (id: Long) ->
        ApplyViewModel(get(), get(), id)
    }
}
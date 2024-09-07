package dev.trindadedev.tinyinstaller.ui.page.installer

import androidx.compose.runtime.Composable

import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogPage

@Composable
fun InstallerPage(installer: InstallerRepo) {
    DialogPage(installer = installer)
}
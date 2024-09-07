package dev.trindadedev.tinyinstaller.ui.page.installer.dialog.inner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogInnerParams
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogParams
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogParamsType
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.DialogViewModel

@Composable
fun InstallingDialog(
    installer: InstallerRepo, viewModel: DialogViewModel
): DialogParams {
    return InstallInfoDialog(installer, viewModel).copy(
        text = DialogInnerParams(
            DialogParamsType.InstallerInstalling.id
        ) {
            LinearProgressIndicator(Modifier.fillMaxWidth())
        }
    )
}
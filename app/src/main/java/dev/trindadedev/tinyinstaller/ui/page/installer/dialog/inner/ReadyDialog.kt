package dev.trindadedev.tinyinstaller.ui.page.installer.dialog.inner

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import dev.trindadedev.tinyinstaller.R
import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.*

@Composable
fun ReadyDialog(
    installer: InstallerRepo, viewModel: DialogViewModel
): DialogParams {
    return DialogParams(icon = DialogInnerParams(
        DialogParamsType.IconWorking.id, workingIcon
    ), title = DialogInnerParams(
        DialogParamsType.InstallerReady.id,
    ) {
        Text(stringResource(R.string.installer_ready))
    }, buttons = DialogButtons(
        DialogParamsType.ButtonsCancel.id
    ) {
        listOf(DialogButton(stringResource(R.string.cancel)) {
            viewModel.dispatch(DialogViewAction.Close)
        })
    })
}
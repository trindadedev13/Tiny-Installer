package dev.trindadedev.tinyinstaller.ui.page.installer.dialog.inner

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import dev.trindadedev.tinyinstaller.R
import dev.trindadedev.tinyinstaller.data.installer.repo.InstallerRepo
import dev.trindadedev.tinyinstaller.ui.page.installer.dialog.*

@Composable
fun ResolveFailedDialog(
    installer: InstallerRepo, viewModel: DialogViewModel
): DialogParams {
    return DialogParams(icon = DialogInnerParams(
        DialogParamsType.IconPausing.id, pausingIcon
    ), title = DialogInnerParams(
        DialogParamsType.InstallerResolveFailed.id
    ) {
        Text(stringResource(R.string.installer_resolve_failed))
    }, text = DialogInnerParams(
        DialogParamsType.InstallerResolveFailed.id, errorText(installer, viewModel)
    ), buttons = DialogButtons(
        DialogParamsType.ButtonsCancel.id
    ) {
        listOf(DialogButton(stringResource(R.string.cancel)) {
            viewModel.dispatch(DialogViewAction.Close)
        })
    })
}
package dev.trindadedev.tinyinstaller.ui.page.installer.dialog.inner

data class DialogButton(
    val text: String,
    val weight: Float = 1f,
    val onClick: () -> Unit,
)

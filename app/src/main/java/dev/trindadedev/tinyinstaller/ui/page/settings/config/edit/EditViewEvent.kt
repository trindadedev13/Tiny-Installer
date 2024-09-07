package dev.trindadedev.tinyinstaller.ui.page.settings.config.edit

sealed class EditViewEvent {
    data class SnackBar(val message: String) : EditViewEvent()
    object Saved : EditViewEvent()
}
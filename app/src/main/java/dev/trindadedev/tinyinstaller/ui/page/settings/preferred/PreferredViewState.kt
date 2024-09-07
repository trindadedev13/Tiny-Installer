package dev.trindadedev.tinyinstaller.ui.page.settings.preferred

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

data class PreferredViewState(
    val authorizer: ConfigEntity.Authorizer = ConfigEntity.Authorizer.Shizuku,
    val customizeAuthorizer: String = "",
    val installMode: ConfigEntity.InstallMode = ConfigEntity.InstallMode.Dialog
) {
    val authorizerCustomize = authorizer == ConfigEntity.Authorizer.Customize
}
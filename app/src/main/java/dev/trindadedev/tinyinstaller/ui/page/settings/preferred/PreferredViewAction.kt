package dev.trindadedev.tinyinstaller.ui.page.settings.preferred

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

sealed class PreferredViewAction {
    object Init : PreferredViewAction()
    data class ChangeGlobalAuthorizer(val authorizer: ConfigEntity.Authorizer) :
        PreferredViewAction()

    data class ChangeGlobalCustomizeAuthorizer(val customizeAuthorizer: String) :
        PreferredViewAction()

    data class ChangeGlobalInstallMode(val installMode: ConfigEntity.InstallMode) :
        PreferredViewAction()
}
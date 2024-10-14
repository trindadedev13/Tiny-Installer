package dev.trindadedev.tinyinstaller.tofix.dhizuku

import android.content.ComponentName
import com.rosan.dhizuku.shared.DhizukuVariables

class DhVariables : DhizukuVariables() {
    companion object {
        val COMPONENT_NAME = ComponentName(OFFICIAL_PACKAGE_NAME, "$OFFICIAL_PACKAGE_NAME.server.DhizukuDAReceiver")
    }
}

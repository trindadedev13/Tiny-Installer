package dev.trindadedev.tinyinstaller.data.recycle.model.entity

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context

import com.rosan.dhizuku.shared.DhizukuVariables

import dev.trindadedev.tinyinstaller.data.recycle.util.InstallIntentFilter
import dev.trindadedev.tinyinstaller.data.recycle.util.delete

class DhizukuPrivilegedService : BasePrivilegedService() {
    private val devicePolicyManager: DevicePolicyManager =
        context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

    override fun delete(paths: Array<out String>) = paths.delete()

    override fun setDefaultInstaller(component: ComponentName, enable: Boolean) {
        devicePolicyManager.clearPackagePersistentPreferredActivities(
            DhizukuVariables.COMPONENT_NAME,
            component.packageName
        )
        if (!enable) return
        devicePolicyManager.addPersistentPreferredActivity(
            DhizukuVariables.COMPONENT_NAME,
            InstallIntentFilter, component
        )
    }
}
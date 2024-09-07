package dev.trindadedev.tinyinstaller.data.recycle.util

import dev.trindadedev.tinyinstaller.IPrivilegedService
import dev.trindadedev.tinyinstaller.data.recycle.model.entity.DefaultPrivilegedService
import dev.trindadedev.tinyinstaller.data.recycle.model.impl.DhizukuUserServiceRecycler
import dev.trindadedev.tinyinstaller.data.recycle.model.impl.ProcessUserServiceRecyclers
import dev.trindadedev.tinyinstaller.data.recycle.model.impl.ShizukuUserServiceRecycler
import dev.trindadedev.tinyinstaller.data.recycle.repo.recyclable.UserService
import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity

private object DefaultUserService : UserService {
    override val privileged: IPrivilegedService = DefaultPrivilegedService()

    override fun close() {
    }
}

fun useUserService(
    config: ConfigEntity,
    special: (() -> String?)? = null,
    action: (UserService) -> Unit
) {
    // special为null时，遵循config
    val recycler = if (special == null) when (config.authorizer) {
        ConfigEntity.Authorizer.Root -> ProcessUserServiceRecyclers.get("su")
            .make()

        ConfigEntity.Authorizer.Shizuku -> ShizukuUserServiceRecycler.make()
        ConfigEntity.Authorizer.Dhizuku -> DhizukuUserServiceRecycler.make()
        ConfigEntity.Authorizer.Customize -> ProcessUserServiceRecyclers.get(config.customizeAuthorizer)
            .make()
        // 其余情况，不使用授权器
        else -> null
    } else {
        // special回调null时，不使用授权器
        special.invoke()?.let { ProcessUserServiceRecyclers.get(it).make() }
    }
    if (recycler != null) recycler.use { action.invoke(it.entity) }
    else action.invoke(DefaultUserService)
}

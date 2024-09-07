package dev.trindadedev.tinyinstaller.ui.page.settings.config.all

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.ConfigEntity
import dev.trindadedev.tinyinstaller.data.settings.util.ConfigOrder
import dev.trindadedev.tinyinstaller.data.settings.util.OrderType

data class AllViewState(
    val data: Data = Data()
) {
    data class Data(
        val configs: List<ConfigEntity> = emptyList(),
        val configOrder: ConfigOrder = ConfigOrder.Id(OrderType.Ascending),
        val progress: Progress = Progress.Loading,
    ) {
        sealed class Progress {
            object Loading : Progress()
            object Loaded : Progress()
        }
    }
}
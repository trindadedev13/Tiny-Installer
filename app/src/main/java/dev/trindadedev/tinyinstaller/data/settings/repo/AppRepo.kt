package dev.trindadedev.tinyinstaller.data.settings.repo

import dev.trindadedev.tinyinstaller.data.settings.model.room.entity.AppEntity
import dev.trindadedev.tinyinstaller.data.settings.util.AppOrder
import dev.trindadedev.tinyinstaller.data.settings.util.OrderType

import kotlinx.coroutines.flow.Flow

interface AppRepo {
    fun all(order: AppOrder = AppOrder.Id(OrderType.Ascending)): List<AppEntity>

    fun flowAll(order: AppOrder = AppOrder.Id(OrderType.Ascending)): Flow<List<AppEntity>>

    fun find(id: Long): AppEntity?

    fun flowFind(id: Long): Flow<AppEntity?>

    fun findByPackageName(packageName: String?): AppEntity?

    fun flowFindByPackageName(packageName: String?): Flow<AppEntity?>

    suspend fun update(entity: AppEntity)

    suspend fun insert(entity: AppEntity)

    suspend fun delete(entity: AppEntity)
}
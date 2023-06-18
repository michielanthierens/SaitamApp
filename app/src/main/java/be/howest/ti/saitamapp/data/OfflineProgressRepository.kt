package be.howest.ti.saitamapp.data

import be.howest.ti.saitamapp.model.ProgressDay
import kotlinx.coroutines.flow.Flow
import java.util.*

class OfflineProgressRepository(private val progressDao: ProgressDao): ProgressRepository {
    override fun getAllItemsStream(): Flow<List<ProgressDay>> = progressDao.getAllProgressDays()

    override fun getItemStream(date: Date): Flow<ProgressDay?> = progressDao.getProgressDay(date)

    override suspend fun insertItem(item: ProgressDay) = progressDao.addProgressDay(item)

    override suspend fun deleteItem(item: ProgressDay) = progressDao.delete(item)

    override suspend fun updateItem(item: ProgressDay) = progressDao.update(item)
}
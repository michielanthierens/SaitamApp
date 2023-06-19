package be.howest.ti.saitamapp.data

import be.howest.ti.saitamapp.model.ProgressDay
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface ProgressRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<ProgressDay>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(date: String): ProgressDay?

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: ProgressDay)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: ProgressDay)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: ProgressDay)
}
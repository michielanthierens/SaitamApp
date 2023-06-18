package be.howest.ti.saitamapp.data

import androidx.room.*
import be.howest.ti.saitamapp.model.ProgressDay
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface ProgressDao {

    @Query("SELECT * from progress ORDER BY date ASC")
    fun getAllProgressDays(): Flow<List<ProgressDay>>

    @Query("SELECT * from progress WHERE date = :date")
    fun getProgressDay(date: String): Flow<ProgressDay>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProgressDay(progressDay: ProgressDay)

    @Update
    suspend fun update(progressDay: ProgressDay)

    @Delete
    suspend fun delete(progressDay: ProgressDay)
}
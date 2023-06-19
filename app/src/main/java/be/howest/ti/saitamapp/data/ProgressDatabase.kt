package be.howest.ti.saitamapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.howest.ti.saitamapp.model.ProgressDay

@Database(entities = [ProgressDay::class], version = 2, exportSchema = false)
abstract class ProgressDatabase : RoomDatabase() {

    abstract fun progressDao(): ProgressDao

    companion object {
        @Volatile
        private var Instance:ProgressDatabase? = null

        fun getDatabase(context: Context): ProgressDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ProgressDatabase::class.java, "item_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
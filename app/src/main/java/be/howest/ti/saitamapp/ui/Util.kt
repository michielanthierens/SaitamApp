package be.howest.ti.saitamapp.ui

import android.content.Context
import android.widget.Toast
import androidx.room.Room
import be.howest.ti.saitamapp.data.ProgressDatabase

fun createDatabase(applicationContext: Context): ProgressDatabase {
    return Room.databaseBuilder(
        applicationContext,
        ProgressDatabase::class.java, "progress-database"
    ).fallbackToDestructiveMigration().build()
}

fun setToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
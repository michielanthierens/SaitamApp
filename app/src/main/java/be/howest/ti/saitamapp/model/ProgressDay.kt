package be.howest.ti.saitamapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress")
data class ProgressDay(
    @PrimaryKey
    val date: String,
    val progress: Int = 0
)
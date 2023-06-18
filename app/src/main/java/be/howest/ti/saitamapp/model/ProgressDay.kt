package be.howest.ti.saitamapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "progress")
data class ProgressDay(
    @PrimaryKey(autoGenerate = true)
    val progress : Int = 0,
    val date : Date
)

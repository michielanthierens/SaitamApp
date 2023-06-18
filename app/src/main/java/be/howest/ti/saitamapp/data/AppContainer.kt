package be.howest.ti.saitamapp.data

import android.content.Context

interface AppContainer {
    val progressRepository: ProgressRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val progressRepository: ProgressRepository by lazy {
        OfflineProgressRepository(ProgressDatabase.getDatabase(context).progressDao())
    }
}
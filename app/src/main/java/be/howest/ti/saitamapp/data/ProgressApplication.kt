package be.howest.ti.saitamapp.data

import android.app.Application

class ProgressApplication: Application() {

    // use appContainer for implementing dependencies
    private lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
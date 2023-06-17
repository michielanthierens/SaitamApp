package be.howest.ti.saitamapp.model

import androidx.annotation.StringRes
import be.howest.ti.saitamapp.R

enum class Navigation (@StringRes val title: Int){
    SETTINGS(title = R.string.settings),
    PROGRESS(title = R.string.progress),
    OVERVIEW(title = R.string.overview)
}
package be.howest.ti.saitamapp.model

import androidx.annotation.StringRes
import be.howest.ti.saitamapp.R

enum class Navigation (@StringRes val title: Int){
    INFO(title = R.string.info),
    PROGRESS(title = R.string.progress),
    OVERVIEW(title = R.string.overview)
}
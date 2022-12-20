package kr.hs.dgsw.b1nd.mentomen.widget.extension

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kr.hs.dgsw.b1nd.data.util.PreferenceManager

@HiltAndroidApp
class MenToMenApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceManager(applicationContext)
    }
}
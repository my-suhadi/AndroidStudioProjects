package id.go.dephub.itjen.portal.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class SharedPreferencesHelper {
    companion object {
        private const val PREF_TIME = "Pref time"
        private lateinit var prefs: SharedPreferences

        @Volatile
        private var anInstant: SharedPreferencesHelper? = null

        private val LOCK = Any()

        operator fun invoke(cx: Context): SharedPreferencesHelper =
            anInstant ?: synchronized(LOCK) {
                anInstant ?: buildHelper(cx).also {
                    anInstant = it
                }
            }

        private fun buildHelper(cx: Context): SharedPreferencesHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(cx)
            return SharedPreferencesHelper()
        }
    }

    internal fun savedUpdateTime(time: Long) {
        prefs.edit(commit = true) {
            putLong(PREF_TIME, time)
        }
    }

    internal fun getLastUpdateTime() = prefs.getLong(PREF_TIME,0)
}
package id.go.dephub.itjen.portal.model

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.collections.arrayListOf as arrayListOf


class Converters {
    companion object {
        // ===== Title converter =====
        @TypeConverter
        @JvmStatic
        internal fun fromTitle(t: Title) = t.text

        @TypeConverter
        @JvmStatic
        internal fun toTitle(s: String) = Title(s)

        // ===== Content converter =====
        @TypeConverter
        @JvmStatic
        internal fun fromContent(c: Content) = c.text

        @TypeConverter
        @JvmStatic
        internal fun toContent(s: String) = Content(false, s)

        // ===== Categories converter =====
        @TypeConverter
        @JvmStatic
        internal fun fromCategories(l: List<Int>): String {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Int>>() {}.type
            return gson.toJson(l, type)
        }

        @TypeConverter
        @JvmStatic
        internal fun toCategories(s: String): List<Int> {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Int?>?>() {}.type
            return listOf(gson.fromJson(s, type))
        }
    }
}
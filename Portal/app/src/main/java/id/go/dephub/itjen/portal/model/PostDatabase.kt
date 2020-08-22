package id.go.dephub.itjen.portal.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PostModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var anInstant: PostDatabase? = null

        private val KUNCI = Any()

        operator fun invoke(cx: Context) = anInstant ?: synchronized(KUNCI) {
            anInstant ?: buatDatabase(cx).also {
                anInstant = it
            }
        }

        private fun buatDatabase(cx: Context) = Room.databaseBuilder(
            cx.applicationContext,
            PostDatabase::class.java,
            "postdatabase"
        ).build()
    }
}
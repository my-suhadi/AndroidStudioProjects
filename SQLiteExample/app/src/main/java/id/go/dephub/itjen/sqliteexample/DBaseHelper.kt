package id.go.dephub.itjen.sqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBaseHelper(_cx: Context) : SQLiteOpenHelper(_cx, DB_name, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table $TB_name(id integer primary key autoincrement, s_title text, s_desc text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $TB_name")
    }

    fun tambahData(title_text: String, desc_title: String) {
        val dataBase = this.writableDatabase
        val values = ContentValues()
        values.put(s_title, title_text)
        values.put(s_desc, desc_title)

        dataBase.insert(TB_name, null, values)
    }

    fun hapusData(id: String): Int {
        val dataBase = this.writableDatabase
        return dataBase.delete(TB_name,"ID = ?", arrayOf(id))
    }

    val ambilData: Cursor
        get() {
            val dataBase = this.writableDatabase
            return dataBase.rawQuery("select * from $TB_name", null)
        }

    companion object {
        internal const val DB_name = "subjects.db"
        internal const val TB_name = "Subject"
        internal const val id = "ID"
        internal const val s_title = "s_title"
        internal const val s_desc = "s_desc"
    }
}
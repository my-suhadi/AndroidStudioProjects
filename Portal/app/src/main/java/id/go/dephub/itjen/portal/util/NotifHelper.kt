package id.go.dephub.itjen.portal.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.go.dephub.itjen.portal.MainActivity
import id.go.dephub.itjen.portal.R

class NotifHelper(_cx: Context) {
    private val cx = _cx
    private val CHANNEL_ID = "Post Channel ID"
    private val NOTIF_ID = 1901

    private fun createNotifChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val important = NotificationManager.IMPORTANCE_DEFAULT
            val ch = NotificationChannel(CHANNEL_ID, "Post Notification", important).apply {
                description = "Deskripsi notifikasi post"
            }
            val notifManager = cx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notifManager.createNotificationChannel(ch)
        }
    }

    internal fun createNotifikasi() {
        createNotifChannel()

        val intent = Intent(cx, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendIntent = PendingIntent.getActivity(cx, 0, intent,0)
        val icon_trimatra = BitmapFactory.decodeResource(cx.resources, R.drawable.trimatra)

        val notif = NotificationCompat.Builder(cx, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_trimatra)
            .setLargeIcon(icon_trimatra)
            .setContentTitle("Post retrieved")
            .setContentText("Notifikasi ini memiliki beberapa konten")
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(icon_trimatra)
                    .bigLargeIcon(null)
            )
            .setContentIntent(pendIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(cx).notify(NOTIF_ID, notif)
    }
}
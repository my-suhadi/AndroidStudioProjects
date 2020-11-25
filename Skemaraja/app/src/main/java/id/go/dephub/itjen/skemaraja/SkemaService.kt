package id.go.dephub.itjen.skemaraja

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class SkemaService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service is started.", Toast.LENGTH_SHORT).show();
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service is destroyed.", Toast.LENGTH_SHORT).show();
    }
}
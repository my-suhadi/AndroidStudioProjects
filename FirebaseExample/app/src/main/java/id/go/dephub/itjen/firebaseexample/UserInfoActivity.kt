package id.go.dephub.itjen.firebaseexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        val namaDepan = findViewById<TextView>(R.id.tv_nama_depan)
        val namaBelakang = findViewById<TextView>(R.id.tv_nama_belakang)
        val unitKerja = findViewById<TextView>(R.id.tv_unit_kerja)
        val mAuth = FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance()
        val dbaseRef = database.reference.child("Users").child(mAuth.currentUser!!.uid)

        dbaseRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    namaDepan.text = snapshot.child("namaDepan").value as String
                    namaBelakang.text = snapshot.child("namaBelakang").value as String
                    unitKerja.text = snapshot.child("unitKerja").value as String
                }
            }
        })

        val btnUpdateInfo = findViewById<Button>(R.id.btn_update_info)
        btnUpdateInfo.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
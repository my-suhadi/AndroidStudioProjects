package id.go.dephub.itjen.firebaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val namaDepan = findViewById<EditText>(R.id.et_nama_depan)
        val namaBelakang = findViewById<EditText>(R.id.et_nama_belakang)
        val unitKerja = findViewById<EditText>(R.id.et_unit_kerja)
        val btnSimpan = findViewById<Button>(R.id.btn_simpan)
        val mAuth = FirebaseAuth.getInstance()

        btnSimpan.setOnClickListener {
            saveUserInfo(mAuth, namaDepan.text.toString().trim(), namaBelakang.text.toString().trim(), unitKerja.text.toString().trim())
        }
    }

    private fun saveUserInfo(mAuth: FirebaseAuth, namaDepan: String, namaBelakang: String, unitKerja: String) {
        if (namaDepan.isEmpty() || namaBelakang.isEmpty() || unitKerja.isEmpty()) {
            Toast.makeText(applicationContext, "Harap melengkapi seluruh data Anda", Toast.LENGTH_SHORT).show()
        } else {
            val database = FirebaseDatabase.getInstance()
            val dbaseRef = database.getReference("Users").child(mAuth.currentUser!!.uid)

            val userInfo = HashMap<String, Any>()
            userInfo["namaDepan"] = namaDepan
            userInfo["namaBelakang"] = namaBelakang
            userInfo["unitKerja"] = unitKerja

            dbaseRef.updateChildren(userInfo).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
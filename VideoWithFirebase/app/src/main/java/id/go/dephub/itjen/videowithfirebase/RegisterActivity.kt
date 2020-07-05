package id.go.dephub.itjen.videowithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val email = findViewById<EditText>(R.id.daftar_et_email)
        val pass = findViewById<EditText>(R.id.daftar_et_pass)
        val regButton = findViewById<Button>(R.id.daftar_btn_submit)

        regButton.setOnClickListener {
            registerUser(email.text.toString().trim(), pass.text.toString())
        }
    }

    private fun registerUser(_email: String, _pass: String) {
        val mAuth = FirebaseAuth.getInstance()

        if (_email.isEmpty() || _pass.isEmpty()) {
            Toast.makeText(this, "Harap masukin alamat email dan password", Toast.LENGTH_SHORT).show()
        } else {
            mAuth.createUserWithEmailAndPassword(_email, _pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    Toast.makeText(this, it.exception!!.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
package id.go.dephub.itjen.firebaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var btnDaftar: Button
    private lateinit var btnMasuk: Button
    private lateinit var btnReset: Button
    private lateinit var etUserEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDaftar = findViewById(R.id.btn_daftar)
        btnMasuk = findViewById(R.id.btn_masuk)
        btnReset = findViewById(R.id.btn_reset)
        etUserEmail = findViewById(R.id.user_email)
        etPassword = findViewById(R.id.user_pass)
        mAuth = FirebaseAuth.getInstance()

        btnDaftar.setOnClickListener {
            registerNewUser(etUserEmail.text.toString().trim(), etPassword.text.toString())
        }

        btnMasuk.setOnClickListener {
            loginUser(etUserEmail.text.toString().trim(), etPassword.text.toString())
        }

        btnReset.setOnClickListener {
            resetAkun(etUserEmail.text.toString().trim())
        }
    }

    private fun registerNewUser(userEmail: String, userPass: String) {
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "Alamat email atau password tidak boleh kosong", Toast.LENGTH_LONG).show()
        } else {
            mAuth.createUserWithEmailAndPassword(userEmail, userPass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Akun sudah dibuat", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun loginUser(userEmail: String, userPass: String) {
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "Alamat email atau password tidak boleh kosong", Toast.LENGTH_LONG).show()
        } else {
            mAuth.signInWithEmailAndPassword(userEmail, userPass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Berhasil login", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun resetAkun(userEmail: String) {
        if (userEmail.isEmpty()) {
            Toast.makeText(applicationContext, "Alamat email tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else {
            mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Silakan cek email anda untuk mereset password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
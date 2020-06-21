package id.go.dephub.itjen.firebaseexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDaftar = findViewById<Button>(R.id.btn_daftar)
        val btnMasuk = findViewById<Button>(R.id.btn_masuk)
        val btnReset = findViewById<Button>(R.id.btn_reset)
        val etUserEmail = findViewById<EditText>(R.id.user_email)
        val etPassword = findViewById<EditText>(R.id.user_pass)
        val mAuth = FirebaseAuth.getInstance()

        btnDaftar.setOnClickListener {
            registerNewUser(mAuth, etUserEmail.text.toString().trim(), etPassword.text.toString())
        }

        btnMasuk.setOnClickListener {
            loginUser(mAuth, etUserEmail.text.toString().trim(), etPassword.text.toString())
        }

        btnReset.setOnClickListener {
            resetAkun(mAuth, etUserEmail.text.toString().trim())
        }
    }

    private fun registerNewUser(mAuth: FirebaseAuth, userEmail: String, userPass: String) {
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "Alamat email atau password tidak boleh kosong", Toast.LENGTH_LONG).show()
        } else {
            mAuth.createUserWithEmailAndPassword(userEmail, userPass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val curUser = mAuth.currentUser!!
                    curUser.sendEmailVerification()

                    Toast.makeText(applicationContext, "Akun sudah dibuat silakan cek email Anda", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun loginUser(mAuth: FirebaseAuth, userEmail: String, userPass: String) {
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "Alamat email atau password tidak boleh kosong", Toast.LENGTH_LONG).show()
        } else {
            mAuth.signInWithEmailAndPassword(userEmail, userPass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val curUser = mAuth.currentUser!!

                    if (curUser.isEmailVerified) {
                        startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                        Toast.makeText(applicationContext, "Berhasil login", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Silakan verifikasi email terlebih dahulu", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun resetAkun(mAuth: FirebaseAuth, userEmail: String) {
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
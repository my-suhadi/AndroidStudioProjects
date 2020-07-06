package id.go.dephub.itjen.videowithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.login_et_email)
        val pass = findViewById<EditText>(R.id.login_et_pass)
        val loginBtn = findViewById<Button>(R.id.login_btn_submit)

        loginBtn.setOnClickListener {
            loginUser(email.text.toString().trim(), pass.text.toString())
        }
    }

    private fun loginUser(_email: String, _pass: String) {
        if (_email.isEmpty() || _pass.isEmpty()) {
            Toast.makeText(this, "Hatap masukin alamat email dan password", Toast.LENGTH_SHORT).show()
        } else {
            val mAuth = FirebaseAuth.getInstance()
            mAuth.signInWithEmailAndPassword(_email, _pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, DashboardActivity::class.java))
                } else {
                    Toast.makeText(this, it.exception!!.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
// https://www.youtube.com/watch?v=XzXRoF3FjcE

package id.go.dephub.itjen.dailyshalattime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.go.dephub.itjen.dailyshalattime.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ISalatView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SalatPresenter(this).getDataFromApi("jakarta")
    }

    override fun onDataCompleteFromApi(salat: Item) {
        tvSubuhTime.text = salat.fajr
        tvDzuhurTime.text = salat.dhuhr
        tvAsarTime.text = salat.asr
        tvMaghribTime.text = salat.maghrib
        tvIsyaTime.text = salat.isha
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error ========> ${throwable.localizedMessage}")
        Toast.makeText(this,"Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }
}

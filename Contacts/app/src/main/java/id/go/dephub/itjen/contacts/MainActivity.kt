package id.go.dephub.itjen.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val people = ArrayList<ContactPerson>()

        people.add(ContactPerson(R.drawable.image1, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image2, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image3, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image4, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image5, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image1, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image2, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image3, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image4, "Sherlock", "Consultant detective", "221"))
        people.add(ContactPerson(R.drawable.image5, "Sherlock", "Consultant detective", "221"))

        val peopleView = findViewById<RecyclerView>(R.id.rv_contacts)
        val peopleAdapter = ContactAdapter(people, applicationContext)

        peopleView.layoutManager = GridLayoutManager(applicationContext, 2)
        peopleView.adapter = peopleAdapter
    }
}

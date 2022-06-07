package hr.tvz.android.listamiksik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.tvz.android.listamiksik.database.viewmodel.GrandPrixViewModel

class MainActivity :  AppCompatActivity(), ItemListFragment.Callbacks, ShowableActivity {
    private var noteViewModel: GrandPrixViewModel? = null
    override val displayName: String
        get() = "Lab 3 Fragmenti"
    override val description: String
        get() = "Lab 3 Fragmenti"
    private var landscape = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.grandprixView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val adapter = GrandPrixAdapter()
        recyclerView.adapter = adapter

        noteViewModel = ViewModelProviders.of(this)[GrandPrixViewModel::class.java]

        noteViewModel!!.getAllGrandPrix().observe(this
        ) { notes -> adapter.setGrandPrixs(notes) }

    }

    override fun onItemSelected(id: String?) {
        TODO("Not yet implemented")
    }
}
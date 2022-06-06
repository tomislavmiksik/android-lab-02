package hr.tvz.android.listamiksik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hr.tvz.android.listamiksik.database.GrandPrixDatabase
import hr.tvz.android.listamiksik.database.viewmodel.GrandPrixViewModel
import hr.tvz.android.listamiksik.databinding.ActivityMainBinding
import hr.tvz.android.listamiksik.parcelable.GrandPrix

class MainActivity : AppCompatActivity(), ItemListFragment.Callbacks, ShowableActivity {
    private lateinit var binding: ActivityMainBinding

    override val displayName: String
        get() = "Lab 3 Fragmenti"
    override val description: String
        get() = "Lab 3 Fragmenti"

    private var landscape = false
    override fun onItemSelected(id: String?) {

    }
    private lateinit var vm: GrandPrixViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = GrandPrixViewModel(application)

        vm.getAllGrandPrix().observe(this, androidx.lifecycle.Observer {
            Log.i("MainActivity", "Got ${it.size} grand prix")
            //val fragment = ItemListFragment.newInstance(adapter)
        })

        if (findViewById<FrameLayout>(R.id.item_detail_container) != null) {
            landscape = true
        } else {
            landscape = false
            val itemListFragment = ItemListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.list_detail, itemListFragment)
                .commit()
        }

    }
}
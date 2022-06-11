package hr.tvz.android.listamiksik

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listamiksik.database.viewmodel.GrandPrixViewModel

class MainActivity :  AppCompatActivity(), ItemListFragment.Callbacks, ShowableActivity {
    private var grandPrixViewModel: GrandPrixViewModel? = null
    override val displayName: String
        get() = "Lab 3 Fragmenti"
    override val description: String
        get() = "Lab 3 Fragmenti"
    private var landscape = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun onItemSelected(id: String?) {
        print("onItemSelected")
        val arguments = Bundle()
        arguments.putString(GrandPrixDetailFragment().ARG_ITEM_ID, id)
        val detailFragment = GrandPrixDetailFragment()
        detailFragment.arguments = arguments
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (landscape) {
            print("landscape")
            fragmentTransaction
                .replace(R.id.item_detail_container, detailFragment)
                .commit()
        } else {
            fragmentTransaction
                .addToBackStack(null)
                .replace(R.id.item_list, detailFragment)
                .commit()
        }

    }
}
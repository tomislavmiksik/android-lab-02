package hr.tvz.android.listamiksik

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import hr.tvz.android.listamiksik.database.viewmodel.GrandPrixViewModel


class ItemListFragment : ListFragment() {

    private val STATE_ACTIVATED_POSITION = "activated_position"
    private var mActivatedPosition = ListView.INVALID_POSITION
    private var grandPrixViewModel: GrandPrixViewModel? = null

    interface Callbacks {
        fun onItemSelected(id: String?)
    }

    private val sDummyCallbacks: Callbacks =
        object : Callbacks {
            override fun onItemSelected(id: String?) {}
        }

    private var mCallbacks: Callbacks = sDummyCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        grandPrixViewModel = ViewModelProvider(this).get(GrandPrixViewModel::class.java)

        grandPrixViewModel!!.getAllGrandPrix().observe(
            this,
            androidx.lifecycle.Observer { grandPrixList ->
                val grandPrixNameList = grandPrixList.map { it.name }.toMutableList()
                listAdapter = GrandPrixAdapterV2(
                    requireActivity(),
                    R.layout.grandprix_card,
                    grandPrixList
                )
            }
        )

//        listAdapter = ArrayAdapter(
//            requireActivity(),
//            R.layout.grandprix_card,
//            R.id.name,
//            grandPrixList
//        )
    }
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        print("onListItemClick")

        grandPrixViewModel = ViewModelProvider(this).get(GrandPrixViewModel::class.java)

        grandPrixViewModel!!.getAllGrandPrix().observe(
            this,
            androidx.lifecycle.Observer { grandPrixList ->
                mCallbacks.onItemSelected(grandPrixList[position].id.toString())
            }
        )


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION))
        }
    }

    private fun setActivatedPosition(position: Int) {
        if (position == ListView.INVALID_POSITION) {
            listView.setItemChecked(mActivatedPosition, false)
        } else {
            listView.setItemChecked(position, true)
        }

        mActivatedPosition = position
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Activities containing this fragment must implement its callbacks
        check(context is Callbacks) { "Activity must implement fragment's callbacks." }

        mCallbacks = context
    }

    override fun onDetach() {
        super.onDetach()
        mCallbacks = sDummyCallbacks
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition)
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
package hr.tvz.android.listamiksik

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import hr.tvz.android.listamiksik.database.viewmodel.GrandPrixViewModel
import hr.tvz.android.listamiksik.databinding.GrandprixDetailBinding

class GrandPrixDetailFragment : Fragment(R.layout.grandprix_detail) {


    val ARG_ITEM_ID = "item_id"
    private var grandPrixViewModel: GrandPrixViewModel? = null
    var grandprix: GrandPrix? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val grandPrixId = requireArguments().getInt(ARG_ITEM_ID)

        grandPrixViewModel = ViewModelProvider(this).get(GrandPrixViewModel::class.java)

        grandprix = grandPrixViewModel?.getGrandPrixById(grandPrixId)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.grandprix_detail, container, false)
        val binding = GrandprixDetailBinding.bind(rootView)
        if (grandprix != null) {
            binding.name.text = grandprix!!.name.toString()
            binding.flag.setImageResource(grandprix!!.flag)
            binding.podium.text = grandprix!!.podium
            binding.trackLayout.setImageResource(grandprix!!.layout)

            val grandprixName = grandprix!!.name


            binding.openWebsite.setOnClickListener {
                val url = "https://www.formula1.com/en/racing/2022.html"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        return rootView
    }

}
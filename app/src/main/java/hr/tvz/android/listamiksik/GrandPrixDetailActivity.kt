package hr.tvz.android.listamiksik

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listamiksik.databinding.GrandprixDetailBinding
import hr.tvz.android.listamiksik.parcelable.GrandPrix

class GrandPrixDetailActivity : AppCompatActivity() {

    private lateinit var binding: GrandprixDetailBinding

    var grandprix: GrandPrix? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GrandprixDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        print(grandprix)

        binding.apply {
            grandprix = intent.extras!!.getParcelable("grandprix")
            if (grandprix != null)
                trackLayout.setImageResource(grandprix!!.layout)
        }
    }

}
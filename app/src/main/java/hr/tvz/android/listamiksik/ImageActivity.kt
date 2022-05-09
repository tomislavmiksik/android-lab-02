package hr.tvz.android.listamiksik

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listamiksik.databinding.GrandprixImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: GrandprixImageBinding

    var grandprixLayout: Int? = null
    var isZoomedIn : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GrandprixImageBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.apply {
            grandprixLayout = intent.getIntExtra("grandprixLayout", 0)
            if (grandprixLayout != null) {
                trackLayout.setImageResource(grandprixLayout!!)
            }

            trackLayout.setOnClickListener {
                if(!isZoomedIn) {
                    trackLayout.animate().apply {
                        duration = 300
                        scaleX(2f)
                        scaleY(2f)
                        isZoomedIn = true
                    }
                }else {
                    trackLayout.animate().apply {
                        duration = 300
                        scaleX(1f)
                        scaleY(1f)
                        isZoomedIn = false
                    }
                }

            }
        }
    }
}
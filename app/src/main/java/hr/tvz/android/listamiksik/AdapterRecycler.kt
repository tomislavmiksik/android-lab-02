package hr.tvz.android.listamiksik

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.tvz.android.listamiksik.parcelable.GrandPrix


class AdapterRecycler : RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {


    private val grandprixs: MutableList<GrandPrix> = arrayListOf(
        GrandPrix(
            "Bahrain Grand Prix",
            "20th of March",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            true,
            podium = arrayListOf("Leclerc", "Sainz", "Hamilton"),
            R.drawable.bahrain,
            R.drawable.bahrain_layout
        ),
        GrandPrix(
            "Saudi Arabian Grand Prix",
            "27th of March",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            true,
            podium = arrayListOf("Leclerc", "Sainz", "Hamilton"),
            R.drawable.saudi,
            R.drawable.saudi_layout
        ),
        GrandPrix(
            "Australian Grand Prix",
            "10th of April",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            true,
            podium = arrayListOf("Leclerc", "Sainz", "Hamilton"),
            R.drawable.australia,
            R.drawable.australia_layout
        ),
        GrandPrix(
            "Emilia Romagna Grand Prix",
            "24th of April",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            true,
            podium = arrayListOf("Leclerc", "Sainz", "Hamilton"),
            R.drawable.italy,
            R.drawable.italy_imola_layout
        ),
        GrandPrix(
            "Miami Grand Prix",
            "8th of May",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            true,
            podium = arrayListOf("Leclerc", "Sainz", "Hamilton"),
            R.drawable.us,
            R.drawable.us_miami_layout
        ),
        GrandPrix(
            "Catalunya Grand Prix",
            "22nd of May",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.spain,
            R.drawable.spain_layout
        ),
        GrandPrix(
            "Monaco Grand Prix",
            "27th of May",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.monaco,
            R.drawable.monaco_layout
        ),
        GrandPrix(
            "Azerbaijan Grand Prix",
            "12th of June",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.azerbaijan,
            R.drawable.azerbaijan_layout
        ),
        GrandPrix(
            "Canadian Grand Prix",
            "19th of June",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.canada,
            R.drawable.canada_layout
        ),
        GrandPrix(
            "Silverstone Grand Prix",
            "3rd of July",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.uk,
            R.drawable.uk_layout
        ),
        GrandPrix(
            "Austrian Grand Prix",
            "10th of July",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.austria,
            R.drawable.austria_layout
        ),
        GrandPrix(
            "French Grand Prix",
            "24th of July",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.france,
            R.drawable.france_layout
        ),
        GrandPrix(
            "Hungarian Grand Prix",
            "31st of July",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.hungary,
            R.drawable.hungary_layout
        ),
        GrandPrix(
            "Belgian Grand Prix",
            "28th of August",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.belgium,
            R.drawable.belgium_layout
        ),
        GrandPrix(
            "Dutch Grand Prix",
            "4th of September",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.netherlands,
            R.drawable.netherlands_layout
        ),
        GrandPrix(
            "Italian Grand Prix",
            "11th of September",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.italy,
            R.drawable.italy_monza_layout
        ),
        GrandPrix(
            "Singapore Grand Prix",
            "2nd of October",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.singapore,
            R.drawable.singapore_layout
        ),
        GrandPrix(
            "Japanese Grand Prix",
            "9th of October",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.japan,
            R.drawable.japan_layout
        ),
        GrandPrix(
            "US Grand Prix",
            "23rd of October",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.us,
            R.drawable.us_cota_layout
        ),
        GrandPrix(
            "Mexican Grand Prix",
            "30th of October",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.mexico,
            R.drawable.mexico_layout
        ),
        GrandPrix(
            "Brazilian Grand Prix",
            "13th of November",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.brazil,
            R.drawable.brazil_layout
        ),
        GrandPrix(
            "Abu Dhabi Grand Prix",
            "20th of November",
            sessions = arrayListOf("FP1", "FP2", "FP3", "Q", "R"),
            false,
            null,
            R.drawable.uae,
            R.drawable.uae_layout
        ),

        )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView
        val itemName: TextView
        val grandprixDate: TextView

        init {
            itemImage = itemView.findViewById(R.id.grandprix_image)
            itemName = itemView.findViewById(R.id.grandprix_name)
            grandprixDate = itemView.findViewById(R.id.grandprix_date)

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedVehicle = grandprixs[position]
                    selectGrandPrix(itemView, selectedVehicle)
                }
            }
        }
    }

    fun selectGrandPrix(itemView: View, grandPrix: GrandPrix) {
        val intent = Intent(itemView.context, GrandPrixDetailActivity::class.java)
        intent.putExtra("grandprix", grandPrix)
        itemView.context.startActivity(intent)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecycler.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.grandprix_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterRecycler.ViewHolder, position: Int) {
        holder.itemImage.setImageResource(grandprixs[position].flag)
        holder.itemName.text = grandprixs[position].name
        holder.grandprixDate.text = grandprixs[position].date
    }

    override fun getItemCount(): Int {
        return grandprixs.size
    }
}
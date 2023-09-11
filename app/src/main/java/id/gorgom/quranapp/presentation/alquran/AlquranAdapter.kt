package id.gorgom.quranapp.presentation.alquran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gorgom.quranapp.domain.model.alquran.Surah
import id.gorgom.quranapp.databinding.ItemSurahAlquranBinding

class AlquranAdapter(private val callback: AlquranCallback) :
    RecyclerView.Adapter<AlquranAdapter.ViewHolder>() {
    private val listSurahAlquran = ArrayList<Surah>()

    inner class ViewHolder(private val binding: ItemSurahAlquranBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: Surah) {
            binding.apply {
                tvNumber.text = surah.nomor
                tvSurahLatin.text = surah.nama
                tvSurahArab.text = surah.asma
                tvInfo.text = "${surah.type} - ${surah.ayat} Ayat"

                itemView.setOnClickListener {
                    callback.onDetailSurahAlquran(surah)
                }
            }
        }
    }

    fun setOnSurahAlquran(surah: List<Surah>) {
        listSurahAlquran.clear()
        listSurahAlquran.addAll(surah)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSurahAlquranBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSurahAlquran[position])
    }

    override fun getItemCount(): Int = listSurahAlquran.size
}
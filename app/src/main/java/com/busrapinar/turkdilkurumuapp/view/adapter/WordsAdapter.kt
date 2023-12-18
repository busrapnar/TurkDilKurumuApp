package com.busrapinar.turkdilkurumuapp.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busrapinar.turkdilkurumuapp.data.Atasozu
import com.busrapinar.turkdilkurumuapp.databinding.WordAdapterRowBinding

class WordsAdapter(
    var list: List<Atasozu>,
    private val adapterItemClick : (Int) -> Unit
): RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    class ViewHolder(val binding : WordAdapterRowBinding):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WordAdapterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val words = list[position]

        holder.binding.apply {
            root.setOnClickListener {
                adapterItemClick.invoke(list[position].id)
            }
            title.text = words.turu2
            word.text = words.sozum
            explanation.text = words.anlami
        }
    }
}
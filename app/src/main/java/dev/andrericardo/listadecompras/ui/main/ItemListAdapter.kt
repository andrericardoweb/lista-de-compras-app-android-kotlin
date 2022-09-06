package dev.andrericardo.listadecompras.ui.main

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.andrericardo.listadecompras.data.ItemList
import dev.andrericardo.listadecompras.databinding.CardItemListBinding

class ItemListAdapter(private val listItems: List<ItemList>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {
    private lateinit var binding: CardItemListBinding

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: ItemList) {
            binding.apply {
                tvProduct.text = item.product
                tvQuantity.text = item.quantity
                cbItemAdd.isChecked = item.isAdd
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = listItems[position])
    }

    override fun getItemCount(): Int = listItems.size
}
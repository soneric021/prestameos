package com.ericson.prestameos.ui.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo
import com.ericson.prestameos.databinding.ItemUserBinding

class ClientAdapter : RecyclerView.Adapter<ClientAdapter.ViewHolder>() {
    private var data = emptyList<ClientWithPrestameo>()
    fun submitList(list:List<ClientWithPrestameo>){
        data = list
        notifyDataSetChanged()
    }
     class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(client:ClientWithPrestameo){
            binding.tvLetter.text = client.cliente.names[0].toString()
            binding.tvName.text = client.cliente.names
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            R.layout.item_user -> ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context)))
            else -> throw Exception("this viewtype is not correct $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int  = R.layout.item_user

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ViewHolder -> {
                holder.bind(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size
}
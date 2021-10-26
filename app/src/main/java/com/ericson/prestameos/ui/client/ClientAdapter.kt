package com.ericson.prestameos.ui.client

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.Tables
import com.ericson.prestameos.databinding.LayoutClientsBinding

class ClientAdapter(private val context: Context, var list: List<Client>): RecyclerView.Adapter<ClientAdapter.ViewHolder>() {

    fun submitList(l:List<Client>){
        list = l
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_clients, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameClient.text = list[position].names
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ClientActivity::class.java)
            intent.putExtra(Tables.CLIENTE, list[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
         val binding = LayoutClientsBinding.bind(itemView)

    }
}
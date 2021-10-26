package com.ericson.prestameos.ui.prestameos

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.databinding.LayoutPrestameosBinding
import com.ericson.prestameos.ui.payment.PaymentDialogFragment

class PrestameoAdapter(private val context:Context, private var list:List<Prestameo>): RecyclerView.Adapter<PrestameoAdapter.ViewHolder>()  {

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val binding = LayoutPrestameosBinding.bind(itemView)
    }

    fun submitList(l:List<Prestameo>){
        list = l
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_prestameos, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = list[position]
        holder.binding.tvAmount.text = data.Balance.toString()
        holder.binding.tvDescription.text = data.description
        holder.binding.tvLoan.text = "Prestameo #$position"

        holder.itemView.setOnClickListener {
            val f = PaymentDialogFragment()
            f.arguments = bundleOf("prestameo" to data)
            f.show((context as FragmentActivity).supportFragmentManager, PaymentDialogFragment.TAG)
        }
    }

    override fun getItemCount(): Int = list.size
}
package com.ericson.prestameos.ui.loan

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo
import com.ericson.prestameos.databinding.LoanFragmentBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.client.ClientAdapter
import javax.inject.Inject


open class LoanFragment : Fragment(R.layout.loan_fragment) {
    private lateinit var binding:LoanFragmentBinding
    @Inject lateinit var model: LoanViewModel
    private lateinit var clientAdapter:ClientAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = LoanFragmentBinding.bind(view)
        clientAdapter = ClientAdapter()
        model.clients.observe(viewLifecycleOwner){
            clientAdapter.submitList(it)
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.bottomSheetParent.rvUsers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = clientAdapter
        }
    }
}
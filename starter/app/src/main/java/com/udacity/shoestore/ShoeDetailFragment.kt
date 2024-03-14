package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private var shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.shoeViewModel = viewModel

        binding.shoeObj = shoe

        viewModel.addOrCancel.observe(viewLifecycleOwner, Observer { status ->
            if (status){
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.addCompleted()
            }
        })

        return binding.root
    }


}
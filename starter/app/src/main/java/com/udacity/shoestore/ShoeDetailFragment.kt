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
    private var shoe = Shoe("test", 0.0, "", "")
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        initBinding()
        observe()



        return binding.root
    }

    private fun initBinding(){
        binding.shoeViewModel = viewModel

        binding.shoeObj = shoe
    }

    private fun observe(){
        viewModel.addOrCancel.observe(viewLifecycleOwner, Observer { status ->
            if (status){
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.addCompleted()
            }
        })
    }
}
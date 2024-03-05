package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.viewmodel.WelcomeViewModel


class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel

        viewModel.moveToList.observe(viewLifecycleOwner, Observer { move ->
            if (move){
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToShoeListFragment())
            }
        })
        // Inflate the layout for this fragment
        return binding.root
    }


}
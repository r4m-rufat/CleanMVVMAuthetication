package com.codeworld.serverregister.ui.register_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeworld.serverregister.R
import com.codeworld.serverregister.base.BaseFragment
import com.codeworld.serverregister.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint


class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun getViewModel() = RegisterViewModel::class.java

    override fun getViewBinding() = FragmentRegisterBinding.inflate(layoutInflater)


}
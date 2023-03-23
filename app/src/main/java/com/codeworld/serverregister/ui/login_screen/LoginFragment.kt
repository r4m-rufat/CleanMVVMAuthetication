package com.codeworld.serverregister.ui.login_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.codeworld.serverregister.R
import com.codeworld.serverregister.base.BaseFragment
import com.codeworld.serverregister.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        editTextWatcher()
        observeLoginStateChange()

        return binding.root
    }

    private fun editTextWatcher() {

        val textChangedListener = object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.loginStateChanged(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                )
            }
        }

        binding.username.addTextChangedListener(textChangedListener)
        binding.password.addTextChangedListener(textChangedListener)

    }

    private fun observeLoginStateChange() {

        viewModel.loginFormState.observe(viewLifecycleOwner) { state ->

            state.usernameError?.let { error ->

                binding.username.error = getString(error)

            }

            state.passwordError?.let { error ->

                binding.password.error = getString(error)

            }

            binding.login.isEnabled = state.isValid

        }

    }

    override fun getViewModel() = LoginViewModel::class.java

    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)

}
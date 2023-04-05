package com.codeworld.serverregister.ui.register_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codeworld.serverregister.MainActivity
import com.codeworld.serverregister.base.BaseFragment
import com.codeworld.serverregister.common.ApiResult
import com.codeworld.serverregister.databinding.FragmentRegisterBinding
import com.codeworld.serverregister.domain.model.register.RegisterRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private lateinit var registerRequest: RegisterRequest
    private lateinit var activity: MainActivity
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        activity = requireActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        initializeRegisterUserInstance()
        editTextWatcher()
        clickedRegisterButton()
        observeRegisterStateChange()
        observeRegisterState()

        return binding.root
    }

    private fun observeRegisterState() {

        viewModel.registerState.observe(viewLifecycleOwner) { result ->

            when(result) {

                is ApiResult.Success -> {
                        activity.navigateLoginFragment()
                    Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

                is ApiResult.Error -> {

                    Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT)
                        .show()

                }

            }

        }

    }

    private fun clickedRegisterButton() {

        binding.signUp.setOnClickListener {

            viewModel.registerUser(registerRequest)

        }

    }

    private fun initializeRegisterUserInstance() {

        registerRequest = RegisterRequest(
            "",
            "",
            "Nasirov",
            "male",
            "",
            true,
            "Rufat",
            "Rufat",
            ""
        )

    }
    private fun editTextWatcher() {

        val textChangedListener = object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                registerRequest.email = binding.username.text.toString()
                registerRequest.password = binding.password.text.toString()
                viewModel.registerStateChanged(
                    registerRequest
                )
            }
        }

        binding.username.addTextChangedListener(textChangedListener)
        binding.password.addTextChangedListener(textChangedListener)

    }

    private fun observeRegisterStateChange() {

        viewModel.registerFormState.observe(viewLifecycleOwner) { state ->

            state.usernameError?.let { error ->

                binding.username.error = getString(error)

            }

            state.passwordError?.let { error ->

                binding.password.error = getString(error)

            }

            binding.signUp.isEnabled = state.isValid

        }

    }

    override fun getViewBinding() = FragmentRegisterBinding.inflate(layoutInflater)


}


package com.github.baraja.feature_joke

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.baraja.base.viewModelOf
import com.github.baraja.feature_joke.databinding.FragmentJokeBinding
import com.github.baraja.feature_joke.di.JokeUiState
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class JokeFragment: Fragment(), HasAndroidInjector {

    companion object {
        val TAG = JokeFragment::class.java.name
        fun newInstance() = JokeFragment()
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val jokeViewModel by lazy { viewModelOf<JokeViewModel>(viewModelProvider) }

    private var binding: FragmentJokeBinding? = null

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJokeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    private fun initView() {
        binding?.btnFetch?.setOnClickListener {
            jokeViewModel.fetchJoke()
        }
    }

    private fun initViewModel() {
        lifecycleScope.launchWhenCreated {
            jokeViewModel.uiState.collect { state ->
                binding?.run {
                    progressCircular.visibility = View.GONE

                    when(state) {
                        is JokeUiState.Loading -> {
                            progressCircular.visibility = View.VISIBLE
                            tvTitle.visibility = View.GONE
                            btnFetch.visibility = View.GONE
                        }
                        is JokeUiState.Success -> {
                            tvTitle.apply {
                                text = state.joke?.joke
                                visibility = View.VISIBLE
                            }

                            val stringArray = resources.getStringArray(R.array.feature_joke_fetch_button)
                            btnFetch.text = stringArray[(stringArray.indices).random()]
                            btnFetch.visibility = View.VISIBLE
                        }
                        is JokeUiState.Error -> {
                            //Handle Error Here
                        }
                    }
                }
            }
        }

        jokeViewModel.fetchJoke()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package uz.amirdev.retrofitintro.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.amirdev.retrofitintro.databinding.ActivityMainBinding
import uz.amirdev.retrofitintro.ui.adapters.RVAdapter
import uz.amirdev.retrofitintro.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    val adapter = RVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainViewModel()

        initRV()

        subscribeToLiveData()

        viewModel.loadData()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadData()
        }
    }

    private fun initRV() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribeToLiveData() {
        viewModel.photos.observe(this) { photos ->
            adapter.refreshData(photos)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.swipeRefreshLayout.isRefreshing = isLoading
        }
    }
}
package uz.amirdev.retrofitintro.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.amirdev.retrofitintro.data.global.ApiClient
import uz.amirdev.retrofitintro.data.models.PhotoModel
import uz.amirdev.retrofitintro.data.repository.MainRepository

class MainViewModel : ViewModel() {

    private val _photos = MutableLiveData<ArrayList<PhotoModel>>()
    val photos get() = _photos

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading get() = _isLoading

    val _service = ApiClient().getApiService()

    val repo = MainRepository(_service)

    fun loadData() {
        _isLoading.value = true
        repo.getPhotos().enqueue(object : Callback<ArrayList<PhotoModel>> {
            override fun onResponse(
                call: Call<ArrayList<PhotoModel>>,
                response: Response<ArrayList<PhotoModel>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful && response.body() != null) {
                    _photos.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<PhotoModel>>, t: Throwable) {
                _isLoading.value = false
            }
        })
    }
}
package uz.amirdev.retrofitintro.data.repository

import uz.amirdev.retrofitintro.data.global.ApiService

class MainRepository(val apiService: ApiService) {
    fun getPhotos() = apiService.getAllPhotos()
}
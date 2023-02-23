package uz.amirdev.retrofitintro.data.global

import retrofit2.Call
import retrofit2.http.GET
import uz.amirdev.retrofitintro.data.models.PhotoModel

interface ApiService {
    @GET("/photos")
    fun getAllPhotos(): Call<ArrayList<PhotoModel>>
}
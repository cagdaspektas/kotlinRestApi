package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
//moshi json verilerini kotlin objelerine dönüştürür.Retrofitle uyumludur
private val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()




    //MarsApiService içine retrofitin http ile konuşmasını sağlayacağız
    //retrofit get kullanarakta /photos endpointli datayı alacağız
    //getphotos :String diyerek functan return edilen tipi söylüyoruz
    interface MarsApiService{
        @GET("photos")
      suspend  fun getPhotos():List<MarsPhoto>

    }



object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}
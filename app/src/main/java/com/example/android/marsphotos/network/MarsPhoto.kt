package com.example.android.marsphotos.network

import com.squareup.moshi.Json

//bu kısım modelimiz
data class  MarsPhoto (
    //img_src alt treli olduğundan json anahtarı içinde tanımlıyoruz
    val id :String,@Json(name="img_src") val imgSrcUrl:String
        )


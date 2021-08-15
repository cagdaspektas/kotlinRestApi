package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView:ImageView,imgUrl:String?){
//let kotlinin scope fonklarından biridir.Kodu objenin içindeki içeriğe göre execute eder
//aynı zamanda nesneyi nullable yapıyoruz ki null değer dönülürse blok içi çalışmasın
imgUrl?.let {
val imgUri=imgUrl.toUri().buildUpon().scheme("https").build()
    imgView.load(imgUri){
        placeholder(R.drawable.loading_animation)
        error(R.drawable.ic_broken_image)
    }
}
    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView,data: List<MarsPhoto>?){
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }
}
package com.azimzada.taskmvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.azimzada.taskmvvm.R
import com.azimzada.taskmvvm.databinding.ActivityDetailBinding
import com.azimzada.taskmvvm.databinding.ActivityMainBinding
import com.azimzada.taskmvvm.model.Results
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var  binding: ActivityDetailBinding
    lateinit var post  : Results
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Salam" , "GGGGGG")
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        post = intent.getSerializableExtra("Post") as Results
        binding.textView.setText(post.Country)
        binding.textView2.setText(post.Mfr_Name)
        binding.textView3.setText(post.Mfr_CommonName)
    }
}
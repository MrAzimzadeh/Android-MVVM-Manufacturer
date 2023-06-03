package com.azimzada.taskmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.taskmvvm.ViewModels.MainVM
import com.azimzada.taskmvvm.activity.DetailActivity
import com.azimzada.taskmvvm.adapter.MainAdapter
import com.azimzada.taskmvvm.adapter.OnItemClickListener
import com.azimzada.taskmvvm.databinding.ActivityMainBinding
import com.azimzada.taskmvvm.model.Results

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProvider(this)[MainVM::class.java]
        viewModel.getData(this, "json")

        viewModel.observResult().observe(this, Observer { result ->
            if (result.Results != null) {
                binding.recyclerView.adapter = MainAdapter(result.Results, object :
                    OnItemClickListener {
                    override fun OnItemClick(item: Results) {
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("Post", item)
                        Log.d("Salam", "Gonder ")
                        startActivity(intent)
                    }
                })
            }
        })


    }


}
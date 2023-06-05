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
import com.azimzada.taskmvvm.adapter.SearchAdapter
import com.azimzada.taskmvvm.databinding.ActivityMainBinding
import com.azimzada.taskmvvm.model.Results

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainVM
    private lateinit var viewModelSearch: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        GetdDatas()
        getSearch()
    }

    //
    fun GetdDatas() {
        viewModel = ViewModelProvider(this).get(MainVM::class.java)
        viewModel.getData(this, "json")

        viewModel.observResult().observe(this, Observer { result ->
            result?.let {
                if (it.Results != null) {
                    binding.recyclerView.adapter = MainAdapter(it.Results, object :
                        OnItemClickListener {
                        override fun OnItemClick(item: Results) {
                            val intent = Intent(this@MainActivity, DetailActivity::class.java)
                            intent.putExtra("Post", item)
                            Log.d("Salam", "Gonder ")
                            startActivity(intent)
                        }
                    })
                }
            }
        })
    }

    fun getSearch() {
        binding.button2.setOnClickListener {
            Log.d("Salamm", "ds")
            val text = binding.searchView.text.toString()
            if (text == "")
            {
                GetdDatas()
            }
                viewModelSearch = ViewModelProvider(this).get(MainVM::class.java)
                viewModelSearch.getSearch(this, text)
                viewModelSearch.observResult().observe(this, Observer { result ->
                    result?.let {
                        if (it.Results != null) {
                            binding.recyclerView.adapter = SearchAdapter(it.Results, object :
                                OnItemClickListener {
                                override fun OnItemClick(item: Results) {

                                    val intent =
                                        Intent(this@MainActivity, DetailActivity::class.java)
                                    intent.putExtra("Post", item)
                                    Log.d("Salam", "Gonder ")
                                    Log.d("Salamm", "  ---------------------- ")

                                    startActivity(intent)
                                }
                            })
                        }
                    }
                })

        }
    }
}

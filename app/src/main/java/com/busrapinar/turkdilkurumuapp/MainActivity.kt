package com.busrapinar.turkdilkurumuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busrapinar.turkdilkurumuapp.databinding.ActivityMainBinding
import com.busrapinar.turkdilkurumuapp.view.activities.HomeActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cl.setOnClickListener {

            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }
    }
}
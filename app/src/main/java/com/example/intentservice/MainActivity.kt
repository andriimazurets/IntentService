package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btnStartService.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startActivity(it)
                binding.tvServiceInfo.text = "Service running"
            }
        }

        binding.btnStopService.setOnClickListener {
            MyIntentService.stopService()
            binding.tvServiceInfo.text = "Service stopped"
        }
    }
}
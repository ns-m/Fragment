package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.placeHolder, BlankFragment2.newInstance()).commit()
        }
        supportFragmentManager.beginTransaction().replace(R.id.placeHolder, BlankFragment.newInstance()).commit()
    }
}
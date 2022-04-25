package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrgm(BlankFragmentTop.newInstance(),R.id.myPlaceHolder1)
        openFrgm(BlankFragmentBottom.newInstance(),R.id.myPlaceHolder2)
        dataModel.messageForActivity.observe(this,{
            binding.textView.text = it
        })
        /*binding.buttonFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.placeHolder, BlankFragment2.newInstance()).commit()
        }*/
//        supportFragmentManager.beginTransaction().replace(R.id.placeHolder, BlankFragment.newInstance()).commit()
    }
    private fun openFrgm(f: Fragment, idHolder: Int){
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()
    }
}
package com.csroid.moduleapp

import android.R.attr
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.csroid.feature1.GetDetailsActivity
import com.csroid.moduleapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFeature1.setOnClickListener {
            startActivityForResult(GetDetailsActivity.getInstacne(this),100)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode === 100) {
            if (resultCode === RESULT_OK) {
                val result: String = data?.getStringExtra("result")!!
                binding.tvTodo.text=result
            }
        }
    }

}
package com.csroid.feature1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.csroid.feature1.databinding.ActivityGetDetailsBinding


class GetDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetDetailsBinding
    private lateinit var todoMVVM:GetTodoViewModel
    private lateinit var  result:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoApi=RetrofitHelper.getInstance().create(TodoAPI::class.java)
        val todoRepository=TodoRepository(todoApi)
        todoMVVM=ViewModelProvider(this, GetTodoViewModelFactory(todoRepository)).get(GetTodoViewModel::class.java)

        binding.btnGetQuotes.setOnClickListener {

            binding.pgGetDetails.visibility=View.VISIBLE
            todoMVVM.getTodos()
            todoMVVM.todo.observe(this,{
                result=it.title
                binding.pgGetDetails.visibility=View.VISIBLE
                val returnIntent = Intent()
                returnIntent.putExtra("result", result)
                setResult(RESULT_OK, returnIntent)
                finish()
            })

        }

    }
    companion object{
        fun getInstacne(context:Context)=Intent(context,GetDetailsActivity::class.java)
    }
}
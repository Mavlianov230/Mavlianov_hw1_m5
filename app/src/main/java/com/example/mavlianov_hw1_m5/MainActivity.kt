package com.example.mavlianov_hw1_m5

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mavlianov_hw1_m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachView(this)

        binding.apply {
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }

            btnIncrement.setOnClickListener {
                presenter.onIncrementClick()
            }
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColorToGreen() {
        binding.tvResult.setTextColor(Color.GREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
    }
}

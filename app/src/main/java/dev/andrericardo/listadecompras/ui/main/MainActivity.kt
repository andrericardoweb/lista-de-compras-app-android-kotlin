package dev.andrericardo.listadecompras.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.andrericardo.listadecompras.databinding.ActivityMainBinding
import dev.andrericardo.listadecompras.ui.addproduct.AddProductActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        configListeners()
    }

    private fun configListeners() {
        configFabListener()
    }

    private fun configFabListener() {
        binding.fabAddNewProduct.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }
    }
}
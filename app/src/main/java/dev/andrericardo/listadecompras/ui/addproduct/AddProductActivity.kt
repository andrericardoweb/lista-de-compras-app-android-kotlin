package dev.andrericardo.listadecompras.ui.addproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dev.andrericardo.listadecompras.R
import dev.andrericardo.listadecompras.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        configListeners()
    }

    private fun configListeners() {
        configBtnBackListener()
        configBtnCancelListener()
        configBtnSave()
    }

    private fun configBtnSave() {
        binding.btnSave.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        binding.apply {
            val product = tietProduct.text.toString()
            val quantity = tietQuantity.text.toString()
            val isAdd = cbAddedToCart.isChecked
            Log.i("AddNewItem", "product: ${product}")
            Log.i("AddNewItem", "quantity: ${quantity}")
            Log.i("AddNewItem", "IsAdd: ${isAdd}")

            tilProduct.error = if (product.isEmpty()) {
                getString(R.string.errorNoProduct)
            } else {
                null
            }

            tilQuantity.error = if (quantity.isEmpty()) {
                getString(R.string.errorNoQuantity)
            } else {
                null
            }

            if (product.isNotEmpty() && quantity.isNotEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Produto: ${product}, Quant: ${quantity}, Adquirido: ${isAdd}",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }

    private fun configBtnCancelListener() {
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun configBtnBackListener() {
        binding.ibBack.setOnClickListener {
            finish()
        }
    }
}
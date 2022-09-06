package dev.andrericardo.listadecompras.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dev.andrericardo.listadecompras.data.ItemList
import dev.andrericardo.listadecompras.databinding.ActivityMainBinding
import dev.andrericardo.listadecompras.ui.addproduct.AddProductActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val returnItem = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(RETURN_ITEM_LIST)) {
                    Log.i("LogInfo", "Retorno ${it.getParcelableExtra<ItemList>(RETURN_ITEM_LIST)}")
                    viewModel.saveItem(it.getParcelableExtra(RETURN_ITEM_LIST)!!)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        startData()
        configListeners()
        configObservers()
    }

    private fun configObservers() {
        configRecyclerView()
    }

    private fun configRecyclerView() {
        viewModel.itemsList.observe(this) { list ->
            Log.i("IGTIinfo", "$list" )
            updateList(list)
        }
    }

    private fun updateList(list: List<ItemList>) {
        if (list.isNullOrEmpty()) {
            binding.rvItems.visibility = View.GONE
            binding.tvNoItemList.visibility = View.VISIBLE
        } else {
            binding.tvNoItemList.visibility = View.GONE
            binding.rvItems.visibility = View.VISIBLE
            binding.rvItems.adapter = ItemListAdapter(listItems = list)
        }

    }

    private fun startData() {
        viewModel.startData()
    }

    private fun configListeners() {
        configFabListener()
    }

    private fun configFabListener() {
        binding.fabAddNewProduct.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            intent.let {
                returnItem.launch(it)
            }
        }
    }

    companion object {
        const val RETURN_ITEM_LIST = "return_item"
    }
}
package dev.andrericardo.listadecompras.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.andrericardo.listadecompras.data.ItemList
import dev.andrericardo.listadecompras.data.repository.MemoryRepository

class MainViewModel: ViewModel() {
    private var memoryRepository: MemoryRepository = MemoryRepository(mutableListOf())
    private val _listItems = MutableLiveData<List<ItemList>>()

    val itemsList: LiveData<List<ItemList>> = _listItems

    fun startData() {
        _listItems.value = memoryRepository.returnList()
    }

    fun saveItem(itemList: ItemList) {
        Log.i("IGTIinfo", "Item recebido: ${itemList}")
        memoryRepository.save(itemList)

        updateItemList()
    }

    private fun updateItemList() {
        _listItems.value = memoryRepository.returnList()
    }
}
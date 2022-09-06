package dev.andrericardo.listadecompras.data.repository

import dev.andrericardo.listadecompras.data.ItemList

class MemoryRepository(newList: MutableList<ItemList>) {
    private val listDb: MutableList<ItemList> = newList

    fun save(itemList: ItemList) {
        listDb.add(itemList)
    }

    fun returnList() = listDb.toList()
}
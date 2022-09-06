package dev.andrericardo.listadecompras.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemList(
    var product: String,
    var quantity: String,
    var isAdd: Boolean
): Parcelable

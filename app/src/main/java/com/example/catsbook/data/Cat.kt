package com.example.catsbook.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Cat( val breed: String, val woolLength: String, val details: String?): Parcelable
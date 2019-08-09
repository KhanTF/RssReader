package ru.rage.rssreader.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RssUrlModel(val name: String, val url: String): Parcelable
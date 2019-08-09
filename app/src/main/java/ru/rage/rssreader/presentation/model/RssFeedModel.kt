package ru.rage.rssreader.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RssFeedModel(
    val title: String,
    val description: String,
    val link: String
) : Parcelable
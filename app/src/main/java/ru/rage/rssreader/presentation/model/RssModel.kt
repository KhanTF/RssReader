package ru.rage.rssreader.presentation.model

data class RssModel(
    val title: String,
    val description: String,
    val feeds: List<RssFeedModel>)
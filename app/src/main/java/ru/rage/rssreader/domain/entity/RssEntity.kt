package ru.rage.rssreader.domain.entity

data class RssEntity(
    val title: String,
    val description: String,
    val link: String,
    val feeds: List<RssFeedEntity>
)
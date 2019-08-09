package ru.rage.rssreader.presentation.base.common.exception

interface ExceptionMapper{
    fun process(t: Throwable) : String
}
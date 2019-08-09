package ru.rage.rssreader.di.module.data

import dagger.Module

@Module(includes = [DatabaseModule::class, NetworkModule::class, RepositoryBinder::class])
class DataModule
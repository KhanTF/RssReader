package ru.rage.rssreader.data.db.dao

import androidx.room.*
import io.reactivex.Single

@Dao
interface BaseDbDao<T> {
    @Insert
    @Transaction
    fun insert(data: T): Single<Long>

    @Update
    @Transaction
    fun update(data: T): Single<Int>

    @Delete
    @Transaction
    fun delete(data: T): Single<Int>
}
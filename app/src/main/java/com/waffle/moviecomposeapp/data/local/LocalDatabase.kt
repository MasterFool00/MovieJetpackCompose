package com.waffle.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waffle.moviecomposeapp.data.local.dao.PopularDao
import com.waffle.moviecomposeapp.data.local.entity.PopularEntity

@Database(
    entities = [
        PopularEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun popularDao(): PopularDao
}
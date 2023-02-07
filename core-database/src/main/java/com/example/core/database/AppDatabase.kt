package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core.database.dao.PaymentDao
import com.example.core.database.entity.PaymentEntity
import com.example.core.database.utils.LocalDateTimeConverter

@Database(
    entities = [PaymentEntity::class],
    version = 2
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun paymentDao(): PaymentDao
}
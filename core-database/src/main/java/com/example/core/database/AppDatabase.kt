package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.dao.PaymentDao
import com.example.core.database.entity.PaymentEntity

@Database(
    entities = [PaymentEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun paymentDao(): PaymentDao
}
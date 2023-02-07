package com.example.core.database.dao

import androidx.room.*
import com.example.core.database.entity.PaymentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(payment: PaymentEntity)

    @Query("SELECT * FROM payments WHERE paymentId LIKE :paymentId")
    fun findOne(paymentId: Long): Flow<PaymentEntity>

    @Delete
    suspend fun delete(payment: PaymentEntity)
}
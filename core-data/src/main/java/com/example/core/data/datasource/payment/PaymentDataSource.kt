package com.example.core.data.datasource.payment

import com.example.code.domain.entity.Payment

interface PaymentDataSource {
    suspend fun addPayment(payment: Payment)
}
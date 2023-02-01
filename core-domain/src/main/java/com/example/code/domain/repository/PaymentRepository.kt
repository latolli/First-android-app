package com.example.code.domain.repository

import com.example.code.domain.entity.Payment

interface PaymentRepository {
    suspend fun addPayment(payment: Payment)
}
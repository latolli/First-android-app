package com.example.core.data.repository

import com.example.code.domain.entity.Payment
import com.example.code.domain.repository.PaymentRepository
import com.example.core.data.datasource.payment.PaymentDataSource

class PaymentRepositoryImp(
    private val paymentDataSource: PaymentDataSource
): PaymentRepository {
    override suspend fun addPayment(payment: Payment) {
        paymentDataSource.addPayment(payment)
    }
}
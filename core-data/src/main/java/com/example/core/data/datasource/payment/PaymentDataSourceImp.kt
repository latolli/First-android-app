package com.example.core.data.datasource.payment

import com.example.code.domain.entity.Payment
import com.example.core.database.dao.PaymentDao
import com.example.core.database.entity.PaymentEntity
import javax.inject.Inject

class PaymentDataSourceImp @Inject constructor(
    private val paymentDao: PaymentDao
        ): PaymentDataSource{
    override suspend fun addPayment(payment: Payment) {
        paymentDao.insertOrUpdate(payment.toEntity())
    }

    private fun Payment.toEntity() = PaymentEntity(
        paymentId = this.paymentId,
        title = this.title,
        categoryId = this.categoryId,
        amount = this.amount,
        date = this.date
    )

    private fun PaymentEntity.toNormal() = Payment(
        paymentId = this.paymentId,
        title = this.title,
        categoryId = this.categoryId,
        amount = this.amount,
        date = this.date
    )
}
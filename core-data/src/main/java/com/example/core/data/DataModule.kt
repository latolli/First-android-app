package com.example.core.data

import com.example.code.domain.repository.PaymentRepository
import com.example.core.data.datasource.payment.PaymentDataSource
import com.example.core.data.datasource.payment.PaymentDataSourceImp
import com.example.core.data.repository.PaymentRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindPaymentDataSource(
        paymentDataSource: PaymentDataSourceImp
    ): PaymentDataSource

    @Singleton
    @Binds
    fun bindPaymentRepository(
        paymentRepository: PaymentRepositoryImp
    ): PaymentRepository
}
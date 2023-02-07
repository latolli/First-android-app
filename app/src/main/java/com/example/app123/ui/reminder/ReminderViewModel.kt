package com.example.app123.ui.reminder

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat.from
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code.domain.entity.Payment
import com.example.code.domain.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app123.Graph
import com.example.app123.R
import java.util.jar.Manifest

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val paymentRepository: PaymentRepository
): ViewModel() {

    init {
        createNotificationChannel()
    }

    fun savePayment(payment: Payment) {
        viewModelScope.launch {
            paymentRepository.addPayment(payment)
            print("Added new payment: ${payment.amount}, ${payment.date}")
            notifyUser(payment)
        }
    }

    private fun notifyUser(payment: Payment) {
        val notificationId = 10
        val builder = NotificationCompat.Builder(
            Graph.appContext,
            "channel_id"
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("New reminder added")
            .setContentText("You are ass: ${payment.amount} hole")
            .setPriority(NotificationCompat.PRIORITY_HIGH)


        with(from(Graph.appContext)) {
            notify(
                notificationId, builder.build()
            )
        }
    }

    private fun createNotificationChannel() {
        val name = "NotificationChannel"
        val descText = "NotificationChannelDescription"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("channel_id", name, importance).apply {
            description = descText
        }
        val notificationManager = Graph.appContext
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
package com.shiokority.shiokoritypay.model

import java.io.Serializable
import java.util.Date

data class HistoryItem(
    val id: String,
    val transactionId: String,
    val merchantName: String,
    val amount: Double,
    val transactionDate: Date,
    val transactionType: TransactionType,
    val status: TransactionStatus,
    val description: String?,
    val merchantId: String,
//    val category: TransactionCategory,
    val metadata: Map<String, Any>? = null,
    val date: Date
) : Serializable {

    // Enum classes for transaction properties
    enum class TransactionType {
        PAYMENT,
        REFUND,
        TRANSFER,
        COMPLETED
    }

    enum class TransactionStatus {
        SUCCESS,
        PENDING,
        FAILED,
        CANCELLED,
        REFUNDED,
        COMPLETED
    }

//    enum class TransactionCategory {
//        FOOD_AND_BEVERAGE,
//        SHOPPING,
//        TRANSPORTATION,
//        ENTERTAINMENT,
//        UTILITIES,
//        OTHERS
//    }
}
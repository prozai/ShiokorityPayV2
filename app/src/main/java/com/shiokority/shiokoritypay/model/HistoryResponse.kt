package com.shiokority.shiokoritypay.model

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: HistoryData?,

    @SerializedName("error")
    val error: ErrorResponse?
) {
    data class HistoryData(
        @SerializedName("transactions")
        val transactions: List<HistoryItem>,

        @SerializedName("pagination")
        val pagination: PaginationInfo
    )

    data class PaginationInfo(
        @SerializedName("current_page")
        val currentPage: Int,

        @SerializedName("total_pages")
        val totalPages: Int,

        @SerializedName("total_items")
        val totalItems: Int,

        @SerializedName("items_per_page")
        val itemsPerPage: Int
    )

    data class ErrorResponse(
        @SerializedName("code")
        val code: String,

        @SerializedName("message")
        val message: String,

        @SerializedName("details")
        val details: Map<String, Any>?
    )

    companion object {
        fun createEmpty() = HistoryResponse(
            success = true,
            message = null,
            data = HistoryData(
                transactions = emptyList(),
                pagination = PaginationInfo(
                    currentPage = 1,
                    totalPages = 1,
                    totalItems = 0,
                    itemsPerPage = 20
                )
            ),
            error = null
        )
    }
}
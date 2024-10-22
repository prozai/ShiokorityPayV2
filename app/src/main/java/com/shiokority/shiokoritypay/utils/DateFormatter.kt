package com.shiokority.shiokoritypay.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateFormatter {
    @SuppressLint("ConstantLocale")
    private val fullFormat = SimpleDateFormat("MMM dd, yyyy • HH:mm", Locale.getDefault())
    @SuppressLint("ConstantLocale")
    private val dateOnlyFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    fun format(date: Date, includeTime: Boolean = true): String {
        return try {
            if (includeTime) fullFormat.format(date)
            else dateOnlyFormat.format(date)
        } catch (e: Exception) {
            ""
        }
    }

    fun formatRelative(date: Date): String {
        val now = System.currentTimeMillis()
        val diff = now - date.time

        return when {
            diff < 60_000 -> "Just now"
            diff < 3600_000 -> "${diff / 60_000}m ago"
            diff < 86400_000 -> "${diff / 3600_000}h ago"
            diff < 604800_000 -> "${diff / 86400_000}d ago"
            else -> dateOnlyFormat.format(date)
        }
    }
}
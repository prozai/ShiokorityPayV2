import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.shiokority.shiokoritypay.databinding.FragmentHistoryItemBinding
import com.shiokority.shiokoritypay.model.HistoryItem
import com.shiokority.shiokoritypay.R
import com.shiokority.shiokoritypay.utils.DateFormatter

class HistoryViewHolder(
    private val binding: FragmentHistoryItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("DefaultLocale")
    fun bind(item: HistoryItem) {
        binding.apply {

            textMerchantName.text = item.merchantName
            textAmount.text = String.format("$%.2f", item.amount)
            textDate.text = DateFormatter.format(item.date)

            val statusColor = when (item.status) {
                HistoryItem.TransactionStatus.COMPLETED -> R.color.status_success
                HistoryItem.TransactionStatus.PENDING -> R.color.status_pending
                HistoryItem.TransactionStatus.FAILED -> R.color.status_failed
                HistoryItem.TransactionStatus.REFUNDED -> R.color.status_refunded
                HistoryItem.TransactionStatus.SUCCESS -> TODO()
                HistoryItem.TransactionStatus.CANCELLED -> TODO()
            }

            textStatus.setTextColor(itemView.context.getColor(statusColor))
            textStatus.text = item.status.name

            val transactionIcon = when (item.transactionType) {
                HistoryItem.TransactionType.PAYMENT -> R.drawable.ic_payment
                HistoryItem.TransactionType.REFUND -> R.drawable.ic_refund
                HistoryItem.TransactionType.TRANSFER -> R.drawable.ic_transfer
                HistoryItem.TransactionType.COMPLETED -> TODO()
            }

            imageTransactionType.setImageResource(transactionIcon)
        }
    }
}
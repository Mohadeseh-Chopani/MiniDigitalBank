package com.example.minidigitalbank.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.SwapHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import com.example.minidigitalbank.ui.home.model.TransactionType
import com.example.minidigitalbank.ui.home.model.TransactionUiState
import com.example.minidigitalbank.ui.theme.ExpenseRed
import com.example.minidigitalbank.ui.theme.ExpenseSurface
import com.example.minidigitalbank.ui.theme.IncomeGreen
import com.example.minidigitalbank.ui.theme.IncomeSurface
import com.example.minidigitalbank.ui.theme.TransferBlue
import com.example.minidigitalbank.ui.theme.TransferSurface

@Composable
fun TransactionItem(
    transaction: TransactionUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Amount (left side)
        val amountColor = when (transaction.type) {
            TransactionType.INCOME -> IncomeGreen
            TransactionType.EXPENSE -> ExpenseRed
            TransactionType.TRANSFER -> TransferBlue
        }
        Text(
            text = "%,.2f".format(transaction.amount),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
            ),
            color = amountColor,
        )

        // Title + date (right side)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = transaction.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        textDirection = TextDirection.Rtl,
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.labelSmall.copy(
                        textDirection = TextDirection.Rtl,
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            TransactionTypeIcon(type = transaction.type)
        }
    }
}

@Composable
private fun TransactionTypeIcon(
    type: TransactionType,
    modifier: Modifier = Modifier,
) {
    val (icon, iconTint, bgColor) = when (type) {
        TransactionType.INCOME -> Triple(Icons.Outlined.ArrowUpward, IncomeGreen, IncomeSurface)
        TransactionType.EXPENSE -> Triple(Icons.Outlined.ArrowDownward, ExpenseRed, ExpenseSurface)
        TransactionType.TRANSFER -> Triple(Icons.Outlined.SwapHoriz, TransferBlue, TransferSurface)
    }

    Box(
        modifier = modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(18.dp),
        )
    }
}

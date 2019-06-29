package com.aiden.aiden.architecturepatternstudy.util

import java.math.BigDecimal

object StringUtil {

    fun getKrwCommaPrice(price: BigDecimal) =
        String.format("%1$,.1f", price)

    fun getBtcEthCommaPrice(price: Double) =
        String.format("%.8f", price)

    fun getUsdtCommaPrice(price: Double): String {
        if (price < 1) {
            return String.format("%.8f", price)
        }
        return if (price.toString().split(".")[1].toInt() > 0) {
            String.format("%1$,.2f", price)
        } else {
            String.format("%.8f", price)
        }
    }

    fun getPercent(closingPrice: Double, tradePrice: Double): String {
        var percent = Math.abs(tradePrice - closingPrice) / closingPrice
        percent *= 100
        return if (closingPrice - tradePrice > 0) {
            "-${String.format("%.2f", percent)}%"
        } else {
            "${String.format("%.2f", percent)}%"
        }
    }

    fun getKrwTotalDealPrice(totalPrice: Double) =
        "${String.format("%,d", (totalPrice / 1_000_000).toInt())} M"

    fun getBtcEthTotalDealPrice(totalPrice: Double) =
        String.format("%1$,.3f", totalPrice)

    fun getUsdtTotalDealPrice(totalPrice: Double) =
        if (totalPrice > 1_000_000) {
            "${String.format("%,d", (totalPrice / 1_000).toInt())} K"
        } else {
            String.format("%,d", totalPrice.toInt())
        }

}
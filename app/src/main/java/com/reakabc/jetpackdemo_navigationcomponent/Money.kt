package com.reakabc.jetpackdemo_navigationcomponent

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@SuppressLint("ParcelCreator")
@Parcelize
data class Money(val amount: BigDecimal): Parcelable {

}

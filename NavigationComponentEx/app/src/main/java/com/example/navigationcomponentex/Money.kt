package com.example.navigationcomponentex

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class Money(val amout:BigDecimal): Parcelable {

}
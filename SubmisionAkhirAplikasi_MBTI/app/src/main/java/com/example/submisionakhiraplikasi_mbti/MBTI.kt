package com.example.submisionakhiraplikasi_mbti

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MBTI(
    val name: String,
    val description: String,
    val photo: String,
    val type: String
): Parcelable

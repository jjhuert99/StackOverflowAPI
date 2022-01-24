package com.example.stackoverflowapi.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data(
    val items: List<Items>
) : Parcelable

@Parcelize
class Items(
    val tags: List<String>,
    val owner: Owner,
    val is_answered: Boolean,
    val accepted_answer_id: Int?,
    val answer_count: Int,
    val link: String,
    val title: String
) :Parcelable

@Parcelize
class Owner(
    val display_name: String
): Parcelable

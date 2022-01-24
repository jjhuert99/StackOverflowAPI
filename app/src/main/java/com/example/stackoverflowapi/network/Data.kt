package com.example.stackoverflowapi.network

class Data(
    val items: List<Items>
) {}

class Items(
    val tags: List<String>,
    val owner: Owner,
    val is_answered: Boolean,
    val accepted_answer_id: Int?,
    val answer_count: Int,
    val link: String,
    val title: String
) {}

class Owner(
    display_name: String
) {}

package com.example.testapp.data.response

import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("results")
    val news: List<NewsResponse>
) {
}
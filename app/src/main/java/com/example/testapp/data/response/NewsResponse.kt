package com.example.testapp.data.response


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("click_url")
    val clickUrl: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("top")
    val top: String,
    @SerializedName("type")
    val type: String
)
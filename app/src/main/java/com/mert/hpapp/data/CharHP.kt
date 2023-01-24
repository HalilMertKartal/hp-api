package com.mert.hpapp.data

import com.google.gson.annotations.SerializedName

data class CharHP(
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("actor")
    val actor: String,
    @SerializedName("image")
    val profilePictureURL: String
)

package com.mert.hpapp.data

import com.google.gson.annotations.SerializedName

data class CharHP(
    val name: String,
    val gender: String,
    val actor: String,
    @SerializedName("image")
    val profilePictureURL: String,

    val house: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val hairColour: String,
    val ancestry: String
)

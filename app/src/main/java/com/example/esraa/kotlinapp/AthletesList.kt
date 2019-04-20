package com.example.esraa.kotlinapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class AthletesList {
    @SerializedName("athletes")
    @Expose
    var athlete: ArrayList<Athletes>? = null
}


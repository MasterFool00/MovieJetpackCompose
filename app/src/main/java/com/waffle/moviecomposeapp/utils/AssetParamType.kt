package com.waffle.moviecomposeapp.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.waffle.moviecomposeapp.domain.model.Popular

class AssetParamType : NavType<Popular>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Popular? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Popular {
        return Gson().fromJson(value, Popular::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Popular) {
        bundle.putParcelable(key, value)
    }
}
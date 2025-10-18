package com.example.a30daysofmusic

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MusicChallenge(
    @StringRes val dayRes: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)
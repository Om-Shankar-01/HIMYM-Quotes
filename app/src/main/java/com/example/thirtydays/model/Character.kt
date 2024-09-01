package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtydays.R

data class Character(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val auth: Int,
    @DrawableRes val image: Int
)

val materials = listOf<Character>(
    Character(R.string.title_1, R.string.desc_1, R.string.auth_1, R.drawable.image_1),
    Character(R.string.title_2, R.string.desc_2, R.string.auth_2, R.drawable.image_2),
    Character(R.string.title_3, R.string.desc_3, R.string.auth_3, R.drawable.image_3),
    Character(R.string.title_4, R.string.desc_4, R.string.auth_4, R.drawable.image_4),
    Character(R.string.title_5, R.string.desc_5, R.string.auth_5, R.drawable.image_5),
    Character(R.string.title_6, R.string.desc_6, R.string.auth_6, R.drawable.image_6),
    Character(R.string.title_7, R.string.desc_7, R.string.auth_7, R.drawable.image_7),
    Character(R.string.title_8, R.string.desc_8, R.string.auth_8, R.drawable.image_8),
    Character(R.string.title_9, R.string.desc_9, R.string.auth_9, R.drawable.image_9),
    Character(R.string.title_10, R.string.desc_10, R.string.auth_10, R.drawable.image_10),
    Character(R.string.title_11, R.string.desc_11, R.string.auth_11, R.drawable.image_11),
    Character(R.string.title_12, R.string.desc_12, R.string.auth_12, R.drawable.image_12),
    Character(R.string.title_13, R.string.desc_13, R.string.auth_13, R.drawable.image_13),
    Character(R.string.title_14, R.string.desc_14, R.string.auth_14, R.drawable.image_14),
    Character(R.string.title_15, R.string.desc_15, R.string.auth_15, R.drawable.image_15),
    Character(R.string.title_16, R.string.desc_16, R.string.auth_16, R.drawable.image_16),
    Character(R.string.title_17, R.string.desc_17, R.string.auth_17, R.drawable.image_17),
    Character(R.string.title_18, R.string.desc_18, R.string.auth_18, R.drawable.image_18),
)

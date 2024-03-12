package com.alex.yang.alexnewscompose.onboading.presentation

import androidx.annotation.DrawableRes
import com.alex.yang.alexnewscompose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Page1 - United parasites, to the holodeck. ",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Page2 - Lorem Ipsum is simply dummy",
        description = "The particle is never twisted.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Everyone loves the sourness of sauerkraut mousse soakd with fluffy chipotle chile powder.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Page3 - Searious lights gains most sainthoods. ",
        description = "Combine rhubarb, carrots and turkey. jumble with ripe basil and serve smashed with bok choy. Enjoy! Small, cloudy comrades loudly haul a cold, salty plank.Virtual klingons, to the universe. Sunt decores imperium regius, barbatus guttuses.",
        image = R.drawable.onboarding3
    )
)
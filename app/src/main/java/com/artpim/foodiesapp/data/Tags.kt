package com.artpim.foodiesapp.data

class Tags : ArrayList<TagsItem>()

data class TagsItem(
    val id: Int,
    val name: String
)

val tagsList = listOf(
    TagsItem(
        1,
        "Новинка"
    ),
    TagsItem(
        2,
        "Вегетарианское блюдо"
    ),
    TagsItem(
        3,
        "Хит!"
    ),
    TagsItem(
        4,
        "Острое"
    ),
    TagsItem(
        5,
        "Экспресс-меню"
    )
)
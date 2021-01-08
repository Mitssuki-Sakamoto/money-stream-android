package com.example.moneystream.presenters

import com.example.moneystream.R

fun ListItems() : List<ListItem> {
    var ls: MutableList<ListItem> = mutableListOf()
    for (i in 0..15) {
        var item = ListItem(
            icon = R.mipmap.ic_launcher_round,
            title = "Title $i",
            detail = "detail in this area."
        )
        ls.add(item)
    }
    return ls
}
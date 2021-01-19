package com.example.moneystream.presenters

import com.example.moneystream.R
import com.example.moneystream.presenters.views.EventItem

fun EventItems() : List<EventItem> {
    var ls: MutableList<EventItem> = mutableListOf()
    for (i in 0..15) {
        var item = EventItem(
            icon = R.mipmap.ic_launcher_round,
            title = "Title $i",
            detail = "detail in this area."
        )
        ls.add(item)
    }
    return ls
}


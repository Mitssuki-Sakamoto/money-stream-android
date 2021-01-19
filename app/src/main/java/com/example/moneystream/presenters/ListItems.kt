package com.example.moneystream.presenters

import com.example.moneystream.R
import com.example.moneystream.presenters.views.EventItem
import com.example.moneystream.presenters.views.MemberItem

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

fun MemberItems() : List<MemberItem> {
    var ls: MutableList<MemberItem> = mutableListOf()
    for (i in 0..15) {
        var item = MemberItem(
            icon = R.mipmap.ic_launcher_round,
            name = "Name $i"
        )
        ls.add(item)
    }
    return ls
}

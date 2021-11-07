package com.viveksahani.quizeappeee.activites.utils

import com.viveksahani.quizeappeee.R

object Iconpick {
    object IconPick {
        private val icons = arrayOf(
            R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8
        )
        private var currentIcon = 0

        fun getIcon(): Int {
            currentIcon = (currentIcon + 1) % icons.size
            return icons[currentIcon]
        }
    }
}
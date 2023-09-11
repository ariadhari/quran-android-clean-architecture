package id.gorgom.quranapp.utils

import id.gorgom.quranapp.R
import id.gorgom.quranapp.domain.model.dummy.MainMenu

object DataDummy {

    fun generateDummyOnMainMenu(): ArrayList<MainMenu> {
        val mainMenu = ArrayList<MainMenu>()

        mainMenu.add(
            MainMenu(
                idMenu = 1,
                imageMenu = R.drawable.ic_quran,
                titleMenu = "Al-Qur'an",
                titleMenuEng = "Al-Qur'an"
            )
        )

        return mainMenu
    }
}
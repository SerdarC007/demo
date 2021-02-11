package com.example.myapplication

import java.util.ArrayList

object Constants {

    fun getQuestions(): ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()

        val q1 = Questions(
            1,
            "Vad Älskar Bekir mest i livet?",
            "Glass",
            "Mesut",
            "Okan",
            "Mat",
            1
        )
        questionsList.add(q1)

        val q2 = Questions(
            2,
            "Vad är mitt Yrke?",
            "KPMG Assistent?",
            "Okans Assistent?",
            "Civilingenjör",
            "Parkerings Vakt",
            3
        )
        questionsList.add(q2)


        val q3 = Questions(
            3,
            "Vad är mitt Favorit Resemål?",
            "Maldiverna",
            "Bali",
            "Thailand",
            "Kulu",
            4
        )
        questionsList.add(q3)


        val q4 = Questions(
            4,
            "Vad gör mig Arg?",
            "Fenerbahce",
            "Kinensen & BRF",
            "StoreBror",
            "Kulu Borgmästare",
            2
        )
        questionsList.add(q4)

        val q5 = Questions(
            5,
            "Vad gör mig Glad?",
            "Slå Okan",
            "Spela spel",
            "Äta Glass",
            "Allt Ovan",
            4
        )
        questionsList.add(q5)


        return questionsList

    }
}
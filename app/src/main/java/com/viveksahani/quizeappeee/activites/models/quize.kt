package com.viveksahani.quizeappeee.activites.models
class Quiz (
    var id : String = "",
    var title: String = "",
    var questions: MutableMap<String, Question> = mutableMapOf()
)



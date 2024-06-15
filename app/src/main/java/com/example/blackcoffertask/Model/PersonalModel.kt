package com.example.blackcoffertask.Model

data class PersonalModel(
    var image: Int,
    var name: String? = null,
    var address: String? = null,
    var hobby1: String? = null,
    var hobby2: String? = null,
    var hobby3: String? = null,
    var showMessage: String? = null,
    var status: Status? = null,
    var profession: String? = null,
    var score: Int? = null
) {
    enum class Status {
        ACCEPTED,
        INVITED,
        PENDING
    }
}

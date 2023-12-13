package com.example.augustmoringnavigationapp.models

class Opportunity {
    var funderName:String = ""
    var opportunityTitle:String = ""
    var opportunityDescription:String = ""
    var opportunitydeadline:String = ""
    var opportunityAmount:String = ""

    var id:String = ""
    constructor(
        funderName: String,
        opportunityTitle: String,
        opportunityDescription:String,
        opportunitydeadline: String,
        opportunityAmount: String,
        id: String
    ) {
        this.funderName = funderName
        this.opportunityTitle = opportunityTitle
        this.opportunityDescription = opportunityDescription
        this.opportunitydeadline = opportunitydeadline
        this.opportunityAmount = opportunityAmount
        this.id = id
    }


    constructor()
}
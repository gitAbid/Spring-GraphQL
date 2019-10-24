package com.abid.springraphql.model

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Book(
        @Id var id: String,
        var title: String,
        var authors: Array<String>,
        var publisher: String,
        var publishDate: String,
        var isbn: String)
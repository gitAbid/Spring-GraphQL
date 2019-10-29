package com.abid.springraphql.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Author (@Id var id:String, var name:String)

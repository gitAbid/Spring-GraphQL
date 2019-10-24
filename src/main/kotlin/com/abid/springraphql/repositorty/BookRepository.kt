package com.abid.springraphql.repositorty

import com.abid.springraphql.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, String>
package com.abid.springraphql.service.datafetcher

import com.abid.springraphql.model.Book
import com.abid.springraphql.repositorty.BookRepository
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class AllBooksDataFetcher(val repository: BookRepository) : DataFetcher<List<Book>> {
    override fun get(environment: DataFetchingEnvironment?): List<Book> {
        return repository.findAll()
    }

}

package com.abid.springraphql.service.datafetcher

import com.abid.springraphql.model.Book
import com.abid.springraphql.repositorty.BookRepository
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class BookDataFetcher(val repository: BookRepository) : DataFetcher<Book> {
    override fun get(environment: DataFetchingEnvironment?): Book {
        val id = environment?.getArgument<String>("id")
        id?.let {
            return repository.getOne(id)
        } ?: throw Exception("Id=:$id is not valid")
    }
}

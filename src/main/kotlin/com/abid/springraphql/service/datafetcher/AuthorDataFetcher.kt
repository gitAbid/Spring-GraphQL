package com.abid.springraphql.service.datafetcher

import com.abid.springraphql.model.Author
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class AuthorDataFetcher : DataFetcher<Author> {
    override fun get(environment: DataFetchingEnvironment?): Author {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

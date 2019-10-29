package com.abid.springraphql.service.datafetcher

import com.abid.springraphql.model.Author
import graphql.schema.DataFetcher

class AuthorFromBookDataFetcher : DataFetcher<List<Author>> {

}

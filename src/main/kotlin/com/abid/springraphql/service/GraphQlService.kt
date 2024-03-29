package com.abid.springraphql.service

import com.abid.springraphql.service.datafetcher.*
import graphql.GraphQL
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.io.IOException
import javax.annotation.PostConstruct

@Service
class GraphQlService(val allBooksDataFetcher: AllBooksDataFetcher,
                     val bookDataFetcher: BookDataFetcher,
                     val allAuthorsDataFetcher: AllAuthorsDataFetcher,
                     val authorDataFetcher: AuthorDataFetcher,
                     val authorFromBookDataFetcher: AuthorFromBookDataFetcher) {

    @Value("classpath:book.graphql")
    lateinit var resource: Resource
    lateinit var graphQl: GraphQL


    @PostConstruct
    @Throws(IOException::class)
    fun loadSchema() {
        val typeRegistry = SchemaParser().parse(resource.file)
        val schema = SchemaGenerator().makeExecutableSchema(typeRegistry, buildRuntimeDateWire())
        graphQl = GraphQL.newGraphQL(schema).build()
    }

    private fun buildRuntimeDateWire(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query") { typeWiring ->
                    typeWiring.dataFetchers(mapOf("allBooks" to allBooksDataFetcher,
                            "book" to bookDataFetcher,
                            "allAuthors" to allAuthorsDataFetcher,
                            "author" to authorDataFetcher))
                }.type("Book") {
                    typeWiring -> typeWiring.dataFetchers(
                        mapOf("authors" to authorFromBookDataFetcher)
                )
                }.build()
    }

}
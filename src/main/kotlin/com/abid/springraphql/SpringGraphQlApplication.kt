package com.abid.springraphql

import com.abid.springraphql.model.Book
import com.abid.springraphql.repositorty.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.stream.Stream

@SpringBootApplication
class SpringGraphQlApplication {


    @Bean
    fun init(bookRepository: BookRepository) = CommandLineRunner {
        listOf(
                Book("123", "Book of Clouds", arrayOf("Chloe Aridjis"), "Kindle Edition",
                        "Nov 2017", "asdasd"),
                Book("124", "Cloud Arch & Engineering", arrayOf("Peter", "Sam"), "Orielly",
                        "Jan 2015", "adasdad"),
                Book("125", "Java 9 Programming", arrayOf("Venkat", "Ram"), "Orielly",
                        "Dec 2016", "asdadas")
        ).forEach { book -> bookRepository.save(book) }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringGraphQlApplication>(*args)
}

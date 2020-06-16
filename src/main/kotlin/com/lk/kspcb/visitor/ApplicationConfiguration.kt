package com.lk.kspcb.visitor

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.stream.Stream

@Component
class ApplicationConfiguration {


    @Bean
    fun runner(visitorRepository: VisitorRepository, db: DatabaseClient) = ApplicationRunner {
        val initDb = db.execute {
            """
                CREATE TABLE visiters (
                    id SERIAL PRIMARY KEY,
                    first_name VARCHAR(255) NOT NULL,
                    last_name VARCHAR(255) NOT NULL,
                    mobile VARCHAR(15) NOT NULL
                );
            """
        }

        val stream = Stream.of(
                Visitors(null, "SSS", "S", "9090909090"),
                Visitors(null, "MMM", "M", "90123213")
        )
        val saveAll = visitorRepository.saveAll(Flux.fromStream(stream))


        initDb
                .then()
                .thenMany(saveAll)
                .subscribe()
    }
}
package com.lk.kspcb.visitor

import org.springframework.data.r2dbc.repository.query.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface VisitorRepository : ReactiveCrudRepository<Visitors, Long> {

    @Query("select e.* from visiters e where e.last_name = :lastName")
    fun findEmployeeByLastName(lastName: String): Mono<Visitors>
}
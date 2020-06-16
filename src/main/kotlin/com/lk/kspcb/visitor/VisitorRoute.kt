package com.lk.kspcb.visitor

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/visiters")
class VisitorRoute(val repo: VisitorRepository) {

    @GetMapping
    fun getAll() = repo.findAll()

    @GetMapping("/{lastName}")
    fun getByLastName(@PathVariable lastName: String) = repo.findEmployeeByLastName(lastName)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody visitors: Visitors) = repo.save(visitors)


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun save(@PathVariable id: Long) = repo.deleteById(id)
}
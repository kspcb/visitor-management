package com.lk.kspcb.visitor

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("visiters")
data class Visitors(@Id val id: Long?,
                    @Column("first_name") val firstName: String,
                    @Column("last_name") val lastName: String,
                    @Column("mobile") val mobile: String) {
}
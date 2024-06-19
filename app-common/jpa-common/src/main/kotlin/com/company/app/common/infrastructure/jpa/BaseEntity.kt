package com.company.app.common.infrastructure.jpa

import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
data class BaseEntity(
    @CreatedDate
    @ColumnDefault("current_timestamp()")
    private val registerDatetime: LocalDateTime,
    @CreatedDate
    @ColumnDefault("current_timestamp()")
    private val updateDatetime: LocalDateTime
) {
}
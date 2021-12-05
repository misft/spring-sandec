package com.example.sandecspring.models

import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.File
import java.sql.Timestamp
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Table(name = "movies")
@Entity
data class Movie(
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Long?,

    @NotBlank(message = "Empty")
    @NotNull(message = "Null")
    @Column
    @Length(max = 25, min = 1, message = "Length")
    var name: String?,

    @Column var description: String?,
    @Column var genre: String?,

    @Temporal(TemporalType.TIMESTAMP)
    @Column var created_at: Date? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @Column var updated_at: Date? = null
) {
    @PrePersist
    fun onCreate() {
        this.created_at = Date()
        this.updated_at = Date()
    }

    @PreUpdate
    fun onUpdate() {
        this.updated_at = Date()
    }
}
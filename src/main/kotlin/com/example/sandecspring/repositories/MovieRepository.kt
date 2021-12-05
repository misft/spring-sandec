package com.example.sandecspring.repositories;

import com.example.sandecspring.models.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MovieRepository : JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM WHERE name '%?1%'", nativeQuery = true)
    fun findByName(name: String): List<Movie>
}
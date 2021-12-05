package com.example.sandecspring.data.responses

import com.example.sandecspring.models.Movie

data class ListMovieResponse(
    override val code: Int,
    override val message: String,
    val movies: List<Movie>
) : Response()

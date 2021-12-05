package com.example.sandecspring.data.responses

import com.example.sandecspring.models.Movie

data class MovieResponse (
    override var code: Int,
    override var message: String,
    val movie: Movie,
) : Response(code, message)

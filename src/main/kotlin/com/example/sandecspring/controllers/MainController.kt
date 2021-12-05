package com.example.sandecspring.controllers

import com.example.sandecspring.data.responses.ListMovieResponse
import com.example.sandecspring.data.responses.MovieResponse
import com.example.sandecspring.models.Movie
import com.example.sandecspring.repositories.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class MainController(
    @Autowired
    val movieRepository: MovieRepository
) {
    @GetMapping("/")
    @ResponseBody
    fun index(): ListMovieResponse {
        val movies = movieRepository.findAll()
        return ListMovieResponse(200, "Success", movies)
    }

    @PostMapping("/store")
    @ResponseBody
    fun create(@RequestBody movie : Movie) : MovieResponse {
        val result = movieRepository.save(Movie(null, movie.name, movie.description, movie.genre))

        return MovieResponse(200, "Success", result)
    }

    @GetMapping("/find")
    @ResponseBody
    fun find(@RequestParam("id") id: Long): MovieResponse {
        val movie = movieRepository.findById(id).get()

        return MovieResponse(200, "Success", movie)
    }

    @GetMapping("/search")
    @ResponseBody
    fun search(@RequestParam("name") name: String): ListMovieResponse {
        val movies = movieRepository.findByName(name)

        return ListMovieResponse(200, "Success", movies)
    }

    @DeleteMapping("/delete")
    @ResponseBody
    fun delete(@RequestParam("id") id: Long) : MovieResponse {
        val movie = movieRepository.findById(id).get()
        movieRepository.delete(movie)

        return MovieResponse(200, "Success", movie)
    }

    @PutMapping("/update")
    @ResponseBody
    fun update(@RequestParam("id") id: Long, @Valid @RequestBody _movie : Movie) : MovieResponse {
        var movie = _movie
        movie.id = id

        val result = movieRepository.save(Movie(movie.id, movie.name, movie.description, movie.genre ?: ""))

        return MovieResponse(200, "Success", result)
    }
}
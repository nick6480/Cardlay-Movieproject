package com.example.movies.controller

import com.example.movies.model.Movie
import com.example.movies.service.MovieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
data class CreateMovieRequest(val name: String, val releaseYear: Int)


@Controller("/api/movies")
class MovieController(private val service: MovieService) {

    @Post
    fun createMovie(@Body request: CreateMovieRequest): HttpResponse<Map<String, UUID>> {
        val id = service.createMovie(request.name, request.releaseYear)
        return HttpResponse.created(mapOf("id" to id))
    }

    @Get
    fun getAllMovies(): List<Movie> = service.getAllMovies()

    @Get("/{id}")
    fun getMovieById(@PathVariable id: UUID): HttpResponse<Movie> {
        val movie = service.getMovieById(id)
        return if (movie != null) HttpResponse.ok(movie)
        else HttpResponse.notFound()
    }
}

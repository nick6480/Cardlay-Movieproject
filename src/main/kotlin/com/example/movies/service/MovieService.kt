package com.example.movies.service

import com.example.movies.model.Movie
import com.example.movies.repository.MovieRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class MovieService(private val repository: MovieRepository) {

    fun createMovie(name: String, releaseYear: Int): UUID {
        val movie = Movie(name = name, releaseYear = releaseYear)
        return repository.save(movie)
    }

    fun getAllMovies(): List<Movie> = repository.findAll()

    fun getMovieById(id: UUID): Movie? = repository.findById(id)
}

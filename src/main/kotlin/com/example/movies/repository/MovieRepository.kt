package com.example.movies.repository

import com.example.movies.model.Movie //Impots the movie model class
import jakarta.inject.Singleton
import java.util.*

@Singleton
class MovieRepository {

    private val movies = mutableMapOf<UUID, Movie>() // In-memory database -- mutableMapOf() == Dictionary

    // fun == function declaration
    // -- Function name == save
    // -- Parameter == movie of type Movie
    // -- Returns type is UUID

    fun save(movie: Movie): UUID {
        movies[movie.id] = movie
        return movie.id
    }

    // Finds all movie objects and returns them in a list
    fun findAll(): List<Movie> = movies.values.toList()

    // Finds 1 movie based on UUID
    // Movie? == Return type is either Movie or null
    fun findById(id: UUID): Movie? = movies[id]
}

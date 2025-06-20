package com.example.movies.model // Tells compiler that file is in com.example.movies.model

import java.util.UUID // Universally Unique Identifier - used to give a unique id

data class Movie(
    val id: UUID = UUID.randomUUID(), // Val = Immutable - Automaticly generates UUID when object is created
    val name: String,
    val releaseYear: Int
)
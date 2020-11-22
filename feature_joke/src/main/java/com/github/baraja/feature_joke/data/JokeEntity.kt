package com.github.baraja.feature_joke.data

class JokeEntity(
    val id: String,
    val joke: String
) {
    val imageUrl = "https://icanhazdadjoke.com/j/$id.png"
}
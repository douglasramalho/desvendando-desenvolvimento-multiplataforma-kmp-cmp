package org.example.project.ui.movies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.domain.model.movie1
import org.example.project.ui.components.MoviesSection

@Composable
fun MoviesListRoute() {
    MoviesListScreen()
}

@Composable
fun MoviesListScreen() {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                MoviesSection(
                    title = "Popular Movies",
                    movies = List(10) {
                        movie1
                    }
                )
            }

            item {
                MoviesSection(
                    title = "Top Rated Movies",
                    movies = List(10) {
                        movie1
                    },
                    modifier = Modifier
                        .padding(top = 32.dp),
                )
            }

            item {
                MoviesSection(
                    title = "Upcoming Movies",
                    movies = List(10) {
                        movie1
                    },
                    modifier = Modifier
                        .padding(top = 32.dp),
                )
            }
        }
    }
}
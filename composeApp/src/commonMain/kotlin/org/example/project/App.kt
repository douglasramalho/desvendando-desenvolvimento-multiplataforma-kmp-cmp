package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.di.dataModule
import org.example.project.di.networkModule
import org.example.project.di.viewModelModule
import org.example.project.navigation.AppRoutes
import org.example.project.ui.moviedetail.MovieDetailRoute
import org.example.project.ui.movies.MoviesListRoute
import org.example.project.ui.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule)
        }
    ) {
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(navController, startDestination = AppRoutes.MoviesList) {
                composable<AppRoutes.MoviesList> {
                    MoviesListRoute(
                        navigateToMovieDetail = { movieId ->
                            navController.navigate(AppRoutes.MovieDetail(movieId))
                        }
                    )
                }

                composable<AppRoutes.MovieDetail> {
                    MovieDetailRoute()
                }
            }
        }
    }
}
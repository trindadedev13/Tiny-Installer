package dev.trindadedev.tinyinstaller.ui.page.settings

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

import dev.trindadedev.tinyinstaller.ui.page.settings.config.apply.ApplyPage
import dev.trindadedev.tinyinstaller.ui.page.settings.config.edit.EditPage
import dev.trindadedev.tinyinstaller.ui.page.settings.main.MainPage

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SettingsPage() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = SettingsScreen.Main.route,
    ) {
        composable(
            route = SettingsScreen.Main.route,
            enterTransition = { null },
            exitTransition = { null },
            popEnterTransition = { null },
            popExitTransition = { null }
        ) {
            MainPage(navController = navController)
        }
        composable(
            route = SettingsScreen.EditConfig.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                }
            ),
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                null
            },
            popEnterTransition = {
                null
            },
            popExitTransition = {
                slideOutVertically(
                    targetOffsetY = { fullHeight -> -fullHeight },
                    animationSpec = tween(durationMillis = 300)
                )
            }
        ) {
            val id = it.arguments?.getLong("id")
            EditPage(
                navController = navController,
                id = if (id != -1L) id else null
            )
        }

        composable(
            route = SettingsScreen.ApplyConfig.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                }
            ),
            enterTransition = { null },
            exitTransition = { null },
            popEnterTransition = { null },
            popExitTransition = { null }
        ) {
            val id = it.arguments?.getLong("id")!!
            ApplyPage(
                navController = navController,
                id = id
            )
        }
    }
}

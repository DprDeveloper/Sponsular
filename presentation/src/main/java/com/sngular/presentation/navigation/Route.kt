package com.sngular.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object Main: Route()
}
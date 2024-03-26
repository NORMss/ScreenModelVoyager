package com.norm.myscreenmodelvoyager.tab.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.norm.myscreenmodelvoyager.screen.home.HomeScreen

object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() = remember {
            TabOptions(
                index = 0u,
                title = "Home"
            )
        }

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen()) { navigator ->
            SlideTransition(navigator = navigator)
        }
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center,
//        ) {
//            Text(
//                text = "Home tab"
//            )
//        }
    }
}
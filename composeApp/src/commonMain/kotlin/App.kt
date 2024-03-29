import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import data.NetworkApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.details.DetailsViewModel
import screen.home.HomeScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    initKoin()
    MaterialTheme {
        Navigator(HomeScreen()) {
            SlideTransition(it)
        }
    }
}

val myModule = module {
    factory {
        DetailsViewModel(NetworkApi())
    }
}

fun initKoin() {
    startKoin {
        modules(
            myModule
        )
    }
}
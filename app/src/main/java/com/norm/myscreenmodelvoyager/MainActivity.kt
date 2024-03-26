package com.norm.myscreenmodelvoyager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.norm.myscreenmodelvoyager.tab.home.HomeTab
import com.norm.myscreenmodelvoyager.tab.profile.ProfileTab
import com.norm.myscreenmodelvoyager.tab.settings.SettingsTab

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabNavigator(tab = HomeTab) {
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            TabNavigationItem(HomeTab)
                            TabNavigationItem(ProfileTab)
                            TabNavigationItem(SettingsTab)
                        }
                    }
                ) {
                    CurrentTab()
                }
            }

//            Navigator(screen = HomeScreen()) { navigator ->
//                SlideTransition(navigator = navigator)
//            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = { Text(text = tab.options.title) },
        icon = { })
}
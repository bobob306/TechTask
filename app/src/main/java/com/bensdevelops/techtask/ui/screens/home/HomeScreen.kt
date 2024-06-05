package com.bensdevelops.techtask.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bensdevelops.techtask.R
import com.bensdevelops.techtask.core.ViewData
import com.bensdevelops.techtask.core.base.ui.GenericLoading
import com.bensdevelops.techtask.core.base.ui.components.TechButton
import com.bensdevelops.techtask.core.base.ui.components.TechText
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyListViewData
import com.bensdevelops.techtask.ui.theme.SizeTokens

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val nullableViewData by viewModel.viewData.observeAsState()
    val viewData = nullableViewData ?: return
    HomeScreenContent(
        viewData = viewData,
        onClick = { viewModel.onClick() },
    )
}

@Composable
private fun HomeScreenContent(
    viewData: ViewData<PropertyListViewData>?,
    onClick: () -> Unit,
) {
    Surface(
        // just using the specified background colour, white = FFFFFF
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(SizeTokens.Large)
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            ) {
                TechText(
                    // use string resources
                    text = stringResource(R.string.question),
                    modifier = Modifier
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = SizeTokens.Medium),
            ) {
                when (viewData) {
                    is ViewData.Data -> {
                        viewData.content.averagePrice?.let {
                            TechText(
                                text = "$it",
                                modifier = Modifier.padding(bottom = SizeTokens.Medium)
                            )
                        }
                    }

                    is ViewData.Error -> {
                        TechText(
                            text = viewData.throwable.message ?: "oops",
                            modifier = Modifier.padding(bottom = SizeTokens.Medium)
                        )
                    }

                    is ViewData.Loading -> {
                        GenericLoading()
                    }

                    null -> Unit

                }
                TechButton(
                    onClick = onClick,
                    text = "Click here to answer the question",
                    modifier = Modifier,
                )
            }
        }

    }
}
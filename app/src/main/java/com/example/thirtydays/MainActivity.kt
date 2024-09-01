package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydays.model.Character
import com.example.thirtydays.model.materials
import com.example.thirtydays.ui.theme.ThirtyDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysTheme {
                App()
            }
        }
    }
}


@Composable
fun Item (
    text: Character,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
//    val color by animateColorAsState(
//        targetValue = if (expanded) {MaterialTheme.colorScheme.secondaryContainer}
//                        else MaterialTheme.colorScheme.tertiaryContainer
//    )

    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.large_padding)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.very_small_padding)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer),
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .padding(
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding),
                top = dimensionResource(id = R.dimen.small_padding),
                bottom = dimensionResource(id = R.dimen.medium_padding)
            )
    ) {
        Box {
            Image(
                painterResource(id = text.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.edge_padding))
                    .clickable { expanded = !expanded }
                    .aspectRatio(1.777777f)
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.large_padding)))
            )
            Text(
                text = stringResource(id = text.title),
                style = MaterialTheme.typography.displayMedium,
                color = Color(1f, 1f, 1f, 0.8f),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.small_padding))
            )
        }
        if (expanded) {
            Text(
                text = stringResource(id = text.description),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.large_padding),
                        end = dimensionResource(id = R.dimen.large_padding),
                        top = dimensionResource(id = R.dimen.small_padding)
                    )
            )
            Text(
                text = stringResource(id = text.auth),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.large_padding),
                        bottom = dimensionResource(id = R.dimen.small_padding),
                        end = dimensionResource(id = R.dimen.small_padding)
                    )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        topBar = { ThirtyDaysTopAppBar(scrollBehaviour) },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehaviour.nestedScrollConnection)
    ) { it ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.very_small_padding)),
            contentPadding = it
        ) {
            items(materials) {
                Item(text = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior
) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.heading_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
        )
    },
        scrollBehavior = scrollBehavior,
        )
}

@Preview (showBackground = true)
@Composable
fun AppPreview () {
    ThirtyDaysTheme {
        App()
    }
}
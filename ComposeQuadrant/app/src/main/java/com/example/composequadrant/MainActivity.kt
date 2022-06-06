package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FourQuadrantComposable()
                }
            }
        }
    }
}


/**
 * This is the basic component which plays the role of a single quadrant.
 * The `modifier` parameter makes weighting possible.
 */
@Composable
fun SingleQuadrantComposable(
    title: String,
    description: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(bgColor)
            .padding(all = 16.dp)
            .fillMaxSize(),
        /* make text aligned center */
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun FourQuadrantComposable() {
    Column(modifier = Modifier.fillMaxWidth()) {
        /* the upper two quadrants, weighting makes it only occupy half of the screen */
        Row(modifier = Modifier.weight(1f)) {
            /* from left to right, weighting makes each quadrant occupy one-fourth of the screen */
            SingleQuadrantComposable(
                stringResource(R.string.text_composable_title),
                stringResource(R.string.text_composable_description),
                Color.Green,
                Modifier.weight(1f)
            )
            SingleQuadrantComposable(
                stringResource(R.string.image_composable_title),
                stringResource(R.string.image_composable_description),
                Color.Yellow,
                Modifier.weight(1f)
            )
        }
        /* the lower two quadrants, weighting makes it only occupy half of the screen */
        Row(modifier = Modifier.weight(1f)) {
            /* from left to right, weighting makes each quadrant occupy one-fourth of the screen */
            SingleQuadrantComposable(
                stringResource(R.string.row_composable_title),
                stringResource(R.string.row_composable_description),
                Color.Cyan,
                Modifier.weight(1f)
            )
            SingleQuadrantComposable(
                stringResource(R.string.column_composable_title),
                stringResource(R.string.column_composable_description),
                Color.LightGray,
                Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        FourQuadrantComposable()
    }
}
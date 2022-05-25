package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JetpackComposeTutorialHomePage()
                }
            }
        }
    }
}

@Composable
fun JetpackComposeTutorialHomePage() {
    Column {
        TutorialBanner()
        TutorialHeader()
        ComposeDescription()
        TutorialAbstract()
    }
}

@Composable
fun TutorialBanner() {
    Image(
        painterResource(R.drawable.bg_compose_background),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top),
    )
}

@Composable
fun TutorialHeader() {
    Text(
        text = "Jetpack Compose tutorial",
        fontSize = 24.sp,
        modifier = Modifier.padding(all = 16.dp),
    )
}

@Composable
fun ComposeDescription() {
    Text(
        text = stringResource(R.string.compose_description),
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
    )
}

@Composable
fun TutorialAbstract() {
    Text(
        text = stringResource(R.string.tutorial_abstract),
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(all = 16.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun JetpackComposeTutorialPreview() {
    JetpackComposeTutorialTheme {
        JetpackComposeTutorialHomePage()
    }
}
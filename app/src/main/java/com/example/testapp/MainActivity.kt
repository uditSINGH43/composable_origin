package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        JJKList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi yo $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        Greeting("Android")
    }
}

@Composable
fun CardOne(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "welcome to Jetpack Compose",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(text = "14 July, 2024")
        Text(text = "Udit Singh")

    }
}

@Preview
@Composable
private fun CardOnePreview() {
    CardOne()
}

@Composable
fun RatingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(White)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(8.dp)
            )
            Text(
                text = "Do You LIke This Recommendation",
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "🤬")
            Text(text = "☹️")
            Text(text = "😐")
            Text(text = "😊")
            Text(text = "😍")

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "VERY BAD")
            Text(text = "VERY GOOD")

        }


    }

}




@Preview
@Composable
private fun RatingCardPreview() {
    RatingCard()
}

@Composable
fun infoCard(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier.fillMaxWidth()
    ){
        Row {
            Column(
                modifier = Modifier.weight(1f).height(300.dp)
            ) {
                Text(text = "welcome to the world of one piece")
                Text(text = "Story start with execution of Gol.D.Roger")
                Text(text = "Main protagonist is Monkey.D.Luffy")

            }
            Image(painter = painterResource(id = R.drawable.one_piece), contentDescription = null,
                modifier = Modifier.weight(01f).height(300.dp))
        }
    }

}

@Preview
@Composable
private fun infoCardPreview() {
    infoCard()

}

@Composable
fun JJKList(modifier: Modifier = Modifier) {
    val jjk = listOf(
        "Monkey.D.luffy", "Roronoa zoro", "Nami",
        "Brook", "Jimbe",
    )
    val jjkImages = listOf(
        R.drawable.luffy, R.drawable.zoro,
        R.drawable.nami ,R.drawable.brook,
        R.drawable.jimbei,
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        itemsIndexed(jjk) { index, name ->
            val imgScale = 1f
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                modifier = Modifier.padding(8.dp).width(300.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = jjkImages[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .size(200.dp)
                            .drawBehind {
                                drawCircle(
                                    color = Color.Blue.copy(alpha = 0.1f),
                                    radius = 400f,
                                )
                                drawContext.transform.scale(
                                    scaleX = imgScale,
                                    scaleY = imgScale
                                )
                                drawContext.transform.translate(
                                    left = 0f,
                                    top = 100f
                                )
                                drawCircle(
                                    color = Color.Red.copy(alpha = 0.2f),
                                    radius = 300f,
                                )

                            }
                    )
                    Text(
                        text = name,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun JJKListPrevieew() {
    JJKList()
}



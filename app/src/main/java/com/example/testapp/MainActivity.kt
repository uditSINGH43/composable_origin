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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.geometry.Offset
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
                    Strawhats(modifier = Modifier.padding(innerPadding))
                    Strawhats()

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
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .height(300.dp)
                    .background(Color.Blue.copy(alpha = 0.5f))
            ) {
                Column(
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "welcome to the world of one piece",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(23.dp))
                    Text(
                        text = "Story start with execution of Gol.D.Roger",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold

                    )
                    Spacer(modifier = Modifier.height(23.dp))
                    Text(
                        text = "Main protagonist is Monkey.D.Luffy",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            Image(
                painter = painterResource(id = R.drawable.one_piece), contentDescription = null,
                modifier = Modifier
                    .weight(01f)
                    .height(300.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Blue.copy(alpha = 0.6f), radius = 250f, center = Offset(
                                x = 250f,
                                y = 400f
                            )
                        )
                    }
            )

        }
    }

}

@Preview
@Composable
private fun infoCardPreview() {
    infoCard()

}

@Composable
fun TaskList(modifier: Modifier = Modifier) {
    val myTasks = listOf(
        "do laundry", "buy snacks", "sleep", "go to gym", "buy cloths", "buy shoes"

    )
    LazyColumn {
        items(myTasks) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillParentMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text(text = it, style = MaterialTheme.typography.headlineSmall)

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun TaskListPreview() {
    TaskList()

}


@Composable
fun Strawhats(modifier: Modifier = Modifier) {
    val OnePiece = listOf("Monkey.D.Luffy", "zoro", "Nami", "Brook", "jimbei")

    val CrewImages = listOf(
        R.drawable.luffy,
        R.drawable.zoro_onepiece,
        R.drawable.nami,
        R.drawable.brook,
        R.drawable.jimbei
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        itemsIndexed(OnePiece) { index, name ->
            val imgScale = 1f
            Card(
                colors = CardDefaults.cardColors(
                    contentColor = Color.White

                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(1f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = CrewImages[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .size(300.dp)
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
                                    color = Color.Black.copy(alpha = .2f),
                                    radius = 300f,
                                )

                            }
                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )


                }
            }


        }
    }
}










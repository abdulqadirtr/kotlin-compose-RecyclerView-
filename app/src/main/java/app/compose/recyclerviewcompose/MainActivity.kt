package app.compose.recyclerviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.compose.recyclerviewcompose.ui.theme.RecyclerViewComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ObjectViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  CourseListScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun ListItem(name : String){

    var showMore by remember { mutableStateOf(true) }
    var extraPadding = if (showMore) 48.dp else 0.dp


   Surface(color = MaterialTheme.colors.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp )) {

        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
        ) {

            Row {

                Column(modifier = Modifier
                    .weight(1f)
                    .padding(start = 1.dp)) {

                    Text(text = "Course")
                    Text(text = name)
                }
                OutlinedButton(onClick = { showMore = !showMore }) {
                    Text(if (showMore) "Show less" else "Show more" )
                }

            }

        }

    }
}

@Composable
fun CourseListScreen(viewModel: ObjectViewModel) {
    val objects by viewModel.objects.collectAsState()

    LazyColumn (modifier = Modifier.padding(vertical = 4.dp)){
        items(objects) { course ->
            ListItem(name = course.name)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecyclerViewComposeTheme {

    }
}
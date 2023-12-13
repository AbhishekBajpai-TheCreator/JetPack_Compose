package com.example.jetpackcompose.lazycolom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Portfolio()
                // StateManagement()
            }
        }
    }
}


@Composable
fun Portfolio() {

    val isOpen = remember {
        mutableStateOf(false)
    }

    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Abhishek Bajpai", style = TextStyle(
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Android Developer", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(12.dp))

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.instagram), contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "/vision_android",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Row {
                Image(
                    painter = painterResource(id = R.drawable.github), contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "/Not Available",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { isOpen.value = !isOpen.value },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "My Projects")
            }

            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(it)
                    }
                }

            }

        }

    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile), contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = project.desc, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


fun getProjectList(): List<Project> {
    return listOf(
        Project("Social Media App", "Connect With Your Apps"),
        Project("Media Player App", "Listen Music Endlessly"),
        Project("Gaming Media App", "God Of War With Ragnork Lover"),
        Project("Social Media App", "Connect With Your Apps"),
        Project("Media Player App", "Listen Music Endlessly"),
        Project("Gaming Media App", "God Of War With Ragnork Lover"),
        Project("Social Media App", "Connect With Your Apps"),
        Project("Media Player App", "Listen Music Endlessly"),
        Project("Gaming Media App", "God Of War With Ragnork Lover"),
        Project("Social Media App", "Connect With Your Apps"),
        Project("Media Player App", "Listen Music Endlessly")
    )
}


data class Project(
    val name: String, val desc: String
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        Greeting("Android")
    }
}
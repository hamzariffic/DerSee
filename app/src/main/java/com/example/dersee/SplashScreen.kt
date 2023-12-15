import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dersee.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)) {
        Box(modifier = Modifier.align(alignment = Alignment.TopCenter)) {
            Text(text = "Der See")
        }
        LaunchedEffect(key1 = true) {
            delay(3000L)
            navController.navigate("MainScreen"){
                popUpTo("SplashScreen") {
                    inclusive = true
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.oceania),
            contentDescription = "SPH Splash Image",
            modifier = Modifier.fillMaxSize()
        )

    }

}

@Preview
@Composable
fun PreviewSplashScreen() {
    MaterialTheme {
        SplashScreen(rememberNavController())
    }
}
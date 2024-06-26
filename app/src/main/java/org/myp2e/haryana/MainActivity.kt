package org.myp2e.haryana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import org.myp2e.haryana.ui.theme.HaryanaP2ETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HaryanaP2ETheme {
                ProvideWindowInsets {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .navigationBarsPadding(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        WebViewScreen("https://haryana.myp2e.org")
                    }
                }
            }
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    val state = rememberWebViewState(url)

    WebView(
        state = state,
        modifier = Modifier.fillMaxSize(),
        onCreated = { webView ->
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
        }
    )
}
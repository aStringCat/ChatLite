package com.project.chatlight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.project.chat.ui.ChatApp
import com.project.chat.ui.theme.ChatLiteTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ChatLiteTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    val windowSize = calculateWindowSizeClass(this)

                    ChatApp(
                        windowSize = windowSize.widthSizeClass,
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ChatAppCompactPreview() {
    ChatLiteTheme {
        Surface {
            ChatApp(
                windowSize = WindowWidthSizeClass.Compact,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ChatAppMediumPreview() {
    ChatLiteTheme {
        Surface {
            ChatApp(
                windowSize = WindowWidthSizeClass.Medium,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ChatAppExpandedPreview() {
    ChatLiteTheme {
        Surface {
            ChatApp(
                windowSize = WindowWidthSizeClass.Expanded,
            )
        }
    }
}
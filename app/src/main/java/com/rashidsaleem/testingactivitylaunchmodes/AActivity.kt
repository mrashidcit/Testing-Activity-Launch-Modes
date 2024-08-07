package com.rashidsaleem.testingactivitylaunchmodes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rashidsaleem.testingactivitylaunchmodes.ui.theme.TestingActivityLaunchModesTheme

class AActivity : ComponentActivity() {
    private val TAG = "AActivity"
    val currentActivityLabel = "Activity A"
    val nextTargetActivityLabel = "B"
    val nextTargetActivityClass = BActivity::class.java
//    val nextTargetActivityLabel = "A"
//    val nextTargetActivityClass = AActivity::class.java

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(TAG, "AActivity - onNewIntent: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingActivityLaunchModesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = currentActivityLabel,
                            modifier = Modifier
                                .padding(
                                    top = 20.dp
                                )
                                .align(Alignment.TopCenter)
                        )

                        Button(
                            onClick = {
                                val intent = Intent(this@AActivity, nextTargetActivityClass).apply {

                                }
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .align(Alignment.Center)
                        ) {
                            Text(nextTargetActivityLabel)
                        }
                    }

                }
            }
        }
    }
}
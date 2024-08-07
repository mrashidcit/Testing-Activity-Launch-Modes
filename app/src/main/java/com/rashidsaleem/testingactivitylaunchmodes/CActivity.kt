package com.rashidsaleem.testingactivitylaunchmodes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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

class CActivity : ComponentActivity() {
    val currentActivityLabel = "Activity C"
    val nextTargetActivityLabel = "A"
    val nextTargetActivityClass = AActivity::class.java

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
                                val intent = Intent(this@CActivity, nextTargetActivityClass).apply {
                                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                }
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .align(Alignment.Center),
                        ) {
                            Text(nextTargetActivityLabel)
                        }
                    }

                }
            }
        }
    }
}
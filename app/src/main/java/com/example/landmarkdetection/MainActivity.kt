package com.example.landmarkdetection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.landmarkdetection.ui.theme.LandmarkDetectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LandmarkDetectionTheme {
               val controller = remember {
                   LifecycleCameraController(applicationContext).apply {
                       setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
                       setImageAnalysisAnalyzer(
                           ContextCompat.getMainExecutor(applicationContext)
                       )
                   }
               }
            }
        }
    }
}


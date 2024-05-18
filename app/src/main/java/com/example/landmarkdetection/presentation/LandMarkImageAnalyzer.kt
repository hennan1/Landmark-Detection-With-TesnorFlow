package com.example.landmarkdetection.presentation

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.landmarkdetection.domain.Classification
import com.example.landmarkdetection.domain.LandmarkClassifier

class LandMarkImageAnalyzer(
    private val classifier:LandmarkClassifier,
    private val onResults:(List<Classification>)->Unit
):ImageAnalysis.Analyzer {


    override fun analyze(image: ImageProxy) {
        val rotationDegrees = image.imageInfo.rotationDegrees
        val bitmap = image.toBitmap()
    }

}
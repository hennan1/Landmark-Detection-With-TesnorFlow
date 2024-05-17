package com.example.landmarkdetection.data

import android.content.Context
import android.graphics.Bitmap
//import androidx.camera.core.ImageProcessor
import com.example.landmarkdetection.domain.Classification
import com.example.landmarkdetection.domain.LandmarkClassifier
import com.sun.istack.Builder
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.classifier.ImageClassifier
import java.lang.IllegalStateException
import org.tensorflow.lite.support.image.ImageProcessor

class TfLiteDataClassifier(
    private val context : Context,
    private  val threshold : Float = 0.5f,
    private  val maxResults : Int = 1
) : LandmarkClassifier{

    private var classifier : ImageClassifier? = null

    private fun setupClassifier(){
        val baseOptions = BaseOptions.builder().
        setNumThreads(2).build()

        val options = ImageClassifier.ImageClassifierOptions.
        builder().
        setBaseOptions(baseOptions).
        setMaxResults(maxResults).
        setScoreThreshold(threshold).
        build()

        try {
            classifier = ImageClassifier.createFromFileAndOptions(
                context,
                "landmarks.tflite",
                options
            )


        }catch (e : IllegalStateException){
            e.printStackTrace()
        }
    }


    override fun classify(bitmap: Bitmap, rotation: Int): List<Classification> {
        if(classifier == null) {
            setupClassifier()
        }
        val imageProcessor = ImageProcessor.Builder().build()
        val tensorImage = imageProcessor.process(TensorImage.fromBitmap(bitmap))
    }
}
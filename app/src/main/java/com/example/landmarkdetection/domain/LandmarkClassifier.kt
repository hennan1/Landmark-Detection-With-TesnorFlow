package com.example.landmarkdetection.domain

import android.graphics.Bitmap

interface LandmarkClassifier {


    //bitmap  is used to feed frames to the camera
    fun classify(bitmap: Bitmap,rotation:Int):List<Classification>
}
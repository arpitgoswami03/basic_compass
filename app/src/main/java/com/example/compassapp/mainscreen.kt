package com.example.compassapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.tv.TvView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.compassapp.databinding.ActivityMainscreenBinding

class mainscreen : AppCompatActivity(), SensorEventListener {
//    private lateinit var binding: ActivityMainscreenBinding
    private var sensor: Sensor? = null
    private var sensorManager: SensorManager? = null
    private var currentDegree=0f
    private lateinit var directionT:TextView
    private lateinit var compassImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        binding=ActivityMainscreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_mainscreen)
        supportActionBar?.title="Compass"
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor= sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        directionT= findViewById(R.id.directionText)
        compassImage=findViewById(R.id.compassImg)
        var degree=Math.round(event!!.values[0])
        directionT.text=degree.toString()+"°"
        var rotationAnimation = RotateAnimation(currentDegree,(-degree).toFloat(),
            Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f,)
        rotationAnimation.duration=210
        rotationAnimation.fillAfter=true
        compassImage .startAnimation(rotationAnimation)
        currentDegree=(-degree).toFloat()

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    //Register the listener for the sensor
    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    //Be sure to unregister the sensor when the activity pauses
    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}
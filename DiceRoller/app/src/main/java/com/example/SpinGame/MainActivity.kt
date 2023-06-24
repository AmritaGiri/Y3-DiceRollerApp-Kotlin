/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.SpinGame

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This activity allows the user to spin the images and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    // Number of Spins, Number of Wins and Win/Spin Ratio.
    var countW = 0
    var RatioWS = 0

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the spin button in the layout
        val spinButton: Button = findViewById(R.id.button)

        Log.d("OnCreate","Main Activity this is the onCreate function")
        // Finding the percentage of the number of wins

       //var RatioWS = countW/Spin.countS

        // Set a click listener on the button to spin the game when the user taps the button
        spinButton.setOnClickListener { SpinGame()
            // Set a counter on the button to output the spin/win count when the user taps the button

        val resultTextView1 : TextView = findViewById(R.id.textView1)
            resultTextView1.text = "" + Spin.countS

        val resultTextView2 : TextView = findViewById(R.id.textView2)
            resultTextView2.text = "" + countW

        val resultTextView3 : TextView = findViewById(R.id.textView3)
            resultTextView3.text = "" + RatioWS + " %"

        }

        // Do a spin when the app starts
        SpinGame()
    }

    /**
     * Spin and update the screen with the result.
     */
    private fun SpinGame() {
        Log.d("SpinGame","This is the SpinGame Function : all the major working of the App is done here ")

        // Create new spin object with 3 images and spin it
        val spin = Spin(3)
        val SpinAll = spin.spin()


        // Get references to the three ImageViews of the main images
        val SpinImage1: ImageView = findViewById(R.id.imageView1)
        val SpinImage2: ImageView = findViewById(R.id.imageView2)
        val SpinImage3: ImageView = findViewById(R.id.imageView3)
        val SpinImage4: ImageView = findViewById(R.id.imageView4) // is the reference for win/lose when the spin game works


        val value1 = spin.spin()
        // Determines which drawable ID to use based on the spin
        val drawable1: Int = when (value1) {
            1 -> R.drawable.burger
            2 -> R.drawable.ramen
            else -> R.drawable.musical
        }

        val value2 = spin.spin()
        // Determines which drawable ID to use based on the spin
        val drawable2: Int = when (value2) {
            1 -> R.drawable.burger
            2 -> R.drawable.ramen
            else -> R.drawable.musical
        }

        val value3 = spin.spin()
        // Determines which drawable ID to use based on the spin
        val drawable3: Int = when (value3) {
            1 -> R.drawable.burger
            2 -> R.drawable.ramen
            else -> R.drawable.musical
        }

        // Updating the ImageView with the correct drawable ID
        SpinImage1.setImageResource(drawable1)
        SpinImage2.setImageResource(drawable2)
        SpinImage3.setImageResource(drawable3)

        // CHECKING IF ALL THE 3 IMAGES MATCH THEN A WIN IMAGE IS DISPLAYED OR ELSE A LOSE IS DISPLAYED
        if(value1==value2&&value1==value3&&value2==value3)
        {
            SpinImage4.setImageResource(R.drawable.win)
            countW ++
        }
        else
        {
            SpinImage4.setImageResource(R.drawable.lose)
        }
    }
}

/*
 * SpinGame with a fixed number of Images.
 */
class Spin(private val numImages: Int) {

    /*
     * Do a random image spin and return the result.
     */
    fun spin(): Int {
        var S:Int = 0
        countS++
        return (1..numImages).random()
    }

    companion object {
        var countS: Int = 0
    }
}
package com.example.usingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UseConstraintLayout()
        }
    }

    @Composable
    fun UseConstraintLayout() {
        val constraints = ConstraintSet {
            val box1 = createRefFor("one")
            val box2 = createRefFor("two")
            val box3 = createRefFor("three")

            constrain(box1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            constrain(box2){
                top.linkTo(parent.top)
                start.linkTo(box1.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            constrain(box3){
                top.linkTo(parent.top)
                start.linkTo(box2.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
        }
        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()){
            Box(modifier = Modifier.layoutId("one")
                    .background(Color.Magenta))
            Box(modifier = Modifier.layoutId("two")
                .background(Color.Black))
            Box(modifier = Modifier.layoutId("three")
                .background(Color.LightGray))
        }
    }
}
package com.jcompanny.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.jcompanny.unitconverter.compose.BaseScreen
import com.jcompanny.unitconverter.data.ConvertDatabase
import com.jcompanny.unitconverter.data.ConvertRespositoryImpl
import com.jcompanny.unitconverter.data.ConverterRepository
import com.jcompanny.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao=ConvertDatabase.getInstance(application).convertDAO
        val repository=ConvertRespositoryImpl(dao)
        val factory=ConverterViewModelFactory(repository)

        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                ) {
                    BaseScreen(factory=factory)
                }
            }
        }
    }

}
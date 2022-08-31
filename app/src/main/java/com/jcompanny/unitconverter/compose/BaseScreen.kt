package com.jcompanny.unitconverter.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jcompanny.unitconverter.ConvertViewModel
import com.jcompanny.unitconverter.ConverterViewModelFactory
import com.jcompanny.unitconverter.compose.converter.TopScreen
import com.jcompanny.unitconverter.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier:Modifier = Modifier,
    convertViewModel: ConvertViewModel = viewModel(factory = factory)

) {
    var  list=convertViewModel.getConversions()
    val historyList=convertViewModel.resultList.collectAsState(initial = emptyList())
    Column(
        modifier=modifier.padding(30.dp)
    ) {
        TopScreen(list){
            message1,message2->
                convertViewModel.addResult(message1,message2)
        }
        Spacer(modifier=modifier.height(20.dp))
        HistoryScreen(historyList,{
            item->convertViewModel.removeResult(item)
        }
        , { convertViewModel.clearAll() }
            )
    }
}
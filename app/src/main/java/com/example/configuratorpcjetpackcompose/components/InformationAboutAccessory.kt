package com.example.configuratorpcjetpackcompose.components

import android.net.wifi.ScanResult.InformationElement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun InformationAboutAccessory(accessory: Accessory) {

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .verticalScroll(
                rememberScrollState()
            ),
    ) {
        Text(
            text = stringResource(id = R.string.accessory_name) + ": " + accessory.name,
            color = AppTheme.colors.textMainColor,
            modifier = Modifier.padding(
                vertical = 5.dp
            ),
            style = AppTheme.typography.text
        )
        Text(
            text = stringResource(id = R.string.btn_text_price) + ": " + accessory.price.toString() + " " + stringResource(
                id = R.string.ruble_symbol
            ),
            color = AppTheme.colors.textMainColor,
            modifier = Modifier.padding(
                vertical = 5.dp
            ),
            style = AppTheme.typography.text
        )
        Text(
            text = stringResource(id = R.string.accessory_description),
            color = AppTheme.colors.textMainColor,
            style = AppTheme.typography.titleMain,
            textAlign = TextAlign.Center
        )
        Text(
            text = accessory.description,
            color = AppTheme.colors.textMainColor,
            modifier = Modifier.padding(
                vertical = 5.dp
            ),
            style = AppTheme.typography.text
        )
    }

}

@Preview
@Composable
fun InformationAboutAccessoryPreview() {
    AppTheme() {
        InformationAboutAccessory(
            Accessory(
                _nameAccessory = "i7",
                _priceAccessory = 1923.0,
                _descriptionAccessory = "12dsfert",
                _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                _uriAccessory = ""
            )
        )
    }
}
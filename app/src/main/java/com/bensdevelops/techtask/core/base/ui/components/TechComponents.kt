package com.bensdevelops.techtask.core.base.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bensdevelops.techtask.ui.theme.TechTaskTheme

// Set a specific colour and size of the text as spec
@Composable
fun TechText(text: String, modifier: Modifier) {
    Text(
        text = text,
        color = Color(0xFF262637),
        fontSize = 14.sp,
        modifier = modifier,
    )
}

// Use the text specific color and size in spec and set width to always max width
@Composable
fun TechButton(onClick: () -> Unit, text: String, modifier: Modifier) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        TechText(text = text, modifier)
    }
}

// so that i can check the colour and size of the text
// set a minimal width to make it easy to see in a preview pane
// not using background as it is easier to see the color being berry is easier against black
// because black would be invisible on black
@Preview(
    widthDp = 200,
)
@Composable
fun TextPreview() {
    TechTaskTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TechText(text = "String", modifier = Modifier)
            TechButton(onClick = {}, text = "Click here", modifier = Modifier)
        }
    }

}
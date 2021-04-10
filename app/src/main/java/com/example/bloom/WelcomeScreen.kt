package com.example.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.ui.theme.BloomTheme
import com.example.bloom.ui.theme.Pink900
import com.example.bloom.ui.theme.White

@Composable
fun WelcomeScreen() {
    WelcomeScreenContent()
}

@Composable
private fun WelcomeScreenContent() {

    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        val isLight = MaterialTheme.colors.isLight

        WelcomeScreenBackground(isLight)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.padding(72.dp))

            LeafImage(isLight)

            Spacer(modifier = Modifier.padding(48.dp))

            LogoImage(isLight)

            AppDescription()

            CreateAccountButton()

            Spacer(modifier = Modifier.padding(8.dp))

            LoginButton(isLight)

        }

    }
}

@Composable
private fun WelcomeScreenBackground(isLight: Boolean) {

    val imageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }

    Image(
        painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
private fun LeafImage(isLight: Boolean) {
    val leafImage = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }

    Image(
        painter = painterResource(id = leafImage),
        contentDescription = stringResource(R.string.leaf_image),
        modifier = Modifier.offset(x = 88.dp)
    )
}

@Composable
private fun LogoImage(isLight: Boolean) {
    val logoImage = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = logoImage),
        contentDescription = stringResource(R.string.app_logo)
    )
}

@Composable
private fun AppDescription() {
    Text(
        style = MaterialTheme.typography.subtitle1,
        text = stringResource(R.string.app_description),
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp, bottom = 40.dp)
    )
}

@Composable
private fun CreateAccountButton() {
    Button(
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
        onClick = {/*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)

    ) {
        Text(text = stringResource(R.string.create_account))
    }
}

@Composable
private fun LoginButton(isLight: Boolean) {

    val loginColor = if (isLight) {
        Pink900
    } else {
        White
    }

    TextButton(onClick = {/*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.login),
            color = loginColor
        )
    }
}

@Preview
@Composable
fun PreviewWelcomeDarkScreen() {
    BloomTheme(darkTheme = true) {
        WelcomeScreen()
    }
}

@Preview
@Composable
fun PreviewWelcomeLightScreen() {
    BloomTheme(darkTheme = false) {
        WelcomeScreen()
    }
}



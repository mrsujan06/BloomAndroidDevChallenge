package com.example.bloom.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.R


@Composable
fun LoginScreen() {
    LoginScreenContent()
}

@Composable
fun LoginScreenContent() {

    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            var email: String by remember { mutableStateOf("") }
            var password: String by remember { mutableStateOf("") }

            LoginHeader()

            EmailIOutlineTextField(email = email, onEmailChange = { email = it })

            PasswordOutlineTextField(password = password, onPasswordChange = { password = it })

            LoginDescription()
            LogInButton()
        }
    }
}


@Composable
private fun LoginHeader() {
    Text(
        text = stringResource(R.string.login_header),
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .padding(bottom = 16.dp)
    )
}

@Composable
private fun EmailIOutlineTextField(email: String, onEmailChange: (String) -> Unit) {

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            focusedBorderColor = MaterialTheme.colors.onPrimary,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        label = {
            Text(
                text = stringResource(R.string.email_address),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp)
    )
}

@Composable
private fun PasswordOutlineTextField(password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            focusedBorderColor = MaterialTheme.colors.onPrimary,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        label = {
            Text(
                text = stringResource(R.string.password),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)

    )
}

@Composable
fun LoginDescription() {

    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val description = stringResource(R.string.terms_description)
        val startIndex = description.indexOf("Terms of use")
        val endIndex = startIndex.plus(12)

        append(description)

        addStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose",
            start = startIndex,
            end = endIndex
        )

        addStyle(
            style = SpanStyle(textDecoration = TextDecoration.Underline),
            startIndex,
            endIndex
        )
        addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), 62, 76)

    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedLinkString,
        style = MaterialTheme.typography.body2.merge(
            TextStyle(
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary
            )
        ),
        onClick = {
            annotatedLinkString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        },
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            .fillMaxWidth(),
    )
}

@Composable
private fun LogInButton() {
    Button(
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)

    ) {
        Text("Log in")
    }
}


@Preview
@Composable
fun PreviewLoginScreenDark() {
    BloomTheme(darkTheme = true) {
        LoginScreen()
    }

}

@Preview
@Composable
fun PreviewLoginScreenLight() {
    BloomTheme(darkTheme = false) {
        LoginScreen()
    }

}
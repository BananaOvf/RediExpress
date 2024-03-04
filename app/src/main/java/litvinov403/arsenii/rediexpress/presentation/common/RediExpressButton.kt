package litvinov403.arsenii.rediexpress.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import litvinov403.arsenii.rediexpress.R
import litvinov403.arsenii.rediexpress.presentation.onboarding.pages
import litvinov403.arsenii.rediexpress.ui.theme.RediExpressTheme
import litvinov403.arsenii.rediexpress.ui.theme.RobotoBold

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.brand_primary),
            contentColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(size = 6.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    onClick: () -> Unit
) {
    OutlinedButton (
        onClick = onClick,
        modifier = modifier, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(R.color.brand_primary)
        ),
        border = BorderStroke(1.dp, colorResource(R.color.brand_primary)),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun DisabledButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    onClick: () -> Unit
) {
    OutlinedButton (
        onClick = onClick,
        modifier = modifier, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(R.color.text_light)
        ),
        border = BorderStroke(1.dp, colorResource(R.color.gray_dark)),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    RediExpressTheme {
        PrimaryButton(text = "Button") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    RediExpressTheme {
        SecondaryButton(text = "Button") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisabledButtonPreview() {
    RediExpressTheme {
        DisabledButton(text = "Button") {

        }
    }
}
package litvinov403.arsenii.rediexpress.presentation.onboarding.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import litvinov403.arsenii.rediexpress.R
import litvinov403.arsenii.rediexpress.presentation.Dimens.MediumPadding1
import litvinov403.arsenii.rediexpress.presentation.Dimens.MediumPadding2
import litvinov403.arsenii.rediexpress.presentation.Dimens.SmallPadding
import litvinov403.arsenii.rediexpress.presentation.onboarding.Page
import litvinov403.arsenii.rediexpress.presentation.onboarding.pages
import litvinov403.arsenii.rediexpress.ui.theme.RediExpressTheme
import litvinov403.arsenii.rediexpress.ui.theme.RobotoBold
import litvinov403.arsenii.rediexpress.ui.theme.RobotoRegular

@Composable
fun OnBoardingPage(
    page: Page
) {
    Column(
        modifier = Modifier.height(520.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = page.image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2).fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = colorResource(id = R.color.brand_primary),
                fontSize = 24.sp,
                fontFamily = RobotoBold
            )
        )
        Spacer(modifier = Modifier.height(SmallPadding))
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2).fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = colorResource(id = R.color.text_light),
                fontSize = 16.sp,
                fontFamily = RobotoRegular
            )
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    RediExpressTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}
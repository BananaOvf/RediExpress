package litvinov403.arsenii.rediexpress.presentation.onboarding

import android.service.autofill.OnClickAction
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import litvinov403.arsenii.rediexpress.R
import litvinov403.arsenii.rediexpress.presentation.Dimens.MediumPadding2
import litvinov403.arsenii.rediexpress.presentation.common.PrimaryButton
import litvinov403.arsenii.rediexpress.presentation.common.SecondaryButton
import litvinov403.arsenii.rediexpress.presentation.onboarding.components.OnBoardingPage
import litvinov403.arsenii.rediexpress.ui.theme.RobotoBold
import litvinov403.arsenii.rediexpress.ui.theme.RobotoMedium
import litvinov403.arsenii.rediexpress.ui.theme.RobotoRegular

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("Skip", "Next", "")
                    1 -> listOf("Skip", "Next", "")
                    2 -> listOf("", "", "Sign Up")
                    else -> listOf("", "", "")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val scope = rememberCoroutineScope()

            if (buttonState.value[0].isNotEmpty()) {
                Column {
                    SecondaryButton(
                        text = buttonState.value[0],
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = RobotoBold
                        ),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.pageCount - 1,
                                    animationSpec = tween(durationMillis = 200)
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }

            if (buttonState.value[1].isNotEmpty()) {
                Column {
                    PrimaryButton(
                        text = buttonState.value[1],
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = RobotoBold
                        ),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1,
                                    animationSpec = tween(durationMillis = 550)
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                }

            }

            if(buttonState.value[2].isNotEmpty()) {
                Column {
                    PrimaryButton(
                        text = buttonState.value[2],
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = RobotoBold
                        ),
                        onClick = {
                            scope.launch {
                                //TODO: Navigate to Home Screen
                            }
                        }
                    )
                    Row(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Already have an account?",
                            style = TextStyle(
                                color = colorResource(id = R.color.gray_dark),
                                fontSize = 14.sp,
                                fontFamily = RobotoRegular
                            )
                        )
                        Text(
                            text = "Sign in",
                            style = TextStyle(
                                color = colorResource(id = R.color.brand_primary),
                                fontSize = 14.sp,
                                fontFamily = RobotoMedium
                            ),
                            modifier = Modifier.clickable {
                                scope.launch {
                                    //TODO: Navigate to Home Screen
                                }
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.6f))
    }
}
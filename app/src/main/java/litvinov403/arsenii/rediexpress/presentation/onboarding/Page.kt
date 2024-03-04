package litvinov403.arsenii.rediexpress.presentation.onboarding

import androidx.annotation.DrawableRes
import litvinov403.arsenii.rediexpress.R

data class Page(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val pages = listOf(
    Page (
        image = R.drawable.onboarding1,
        title = "Quick Delivery At Your Doorstep",
        description = "Enjoy quick pick-up and delivery to your destination"
    ),
    Page (
        image = R.drawable.onboarding2,
        title = "Flexible Payment",
        description = "Different modes of payment either before and after delivery without stress"
    ),
    Page (
        image = R.drawable.onboarding3,
        title = "Real-time Tracking",
        description = "Track your packages/items from the comfort of your home till final destination"
    )
)
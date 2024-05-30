package com.sinasamaki.flipboardanimation.ui.flip

import androidx.compose.ui.graphics.Shape

internal sealed class PageFlapType(val shape: Shape) {
    data object Top : PageFlapType(TopShape)
    data object Bottom : PageFlapType(BottomShape)
    data object Left : PageFlapType(LeftShape)
    data object Right : PageFlapType(RightShape)
}
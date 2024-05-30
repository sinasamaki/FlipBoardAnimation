package com.sinasamaki.flipboardanimation.ui.flip

sealed class FlipPagerOrientation {
    data object Vertical : FlipPagerOrientation()
    data object Horizontal : FlipPagerOrientation()
}
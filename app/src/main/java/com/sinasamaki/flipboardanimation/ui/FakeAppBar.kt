package com.sinasamaki.flipboardanimation.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sinasamaki.flipboardanimation.R
import com.sinasamaki.flipboardanimation.ui.flip.FlipPagerOrientation

@Composable
fun ColumnScope.FakeAppBar(
    modifier: Modifier = Modifier,
    orientation: FlipPagerOrientation,
    darkMode: Boolean,
    setOrientation: (FlipPagerOrientation) -> Unit,
    setDarkMode: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .align(Alignment.CenterHorizontally)
            .widthIn(max = 480.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "App News",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        Row {
            IconButton(onClick = { setDarkMode(!darkMode) }) {
                AnimatedContent(
                    targetState = darkMode,
                    transitionSpec = {
                        scaleIn(
                            transformOrigin = TransformOrigin(1f, .5f)
                        ) togetherWith scaleOut(
                            transformOrigin = TransformOrigin(0f, .5f)
                        ) using SizeTransform(clip = false)
                    },
                    label = ""
                ) {
                    Icon(
                        painter = painterResource(id = if (it) R.drawable.ic_dark_mode else R.drawable.ic_light_mode),
                        contentDescription = "dark mode"
                    )
                }
            }
            IconButton(
                onClick = {
                    setOrientation(
                        when (orientation) {
                            FlipPagerOrientation.Vertical -> FlipPagerOrientation.Horizontal
                            FlipPagerOrientation.Horizontal -> FlipPagerOrientation.Vertical
                        }
                    )
                }
            ) {
                val rotation by animateFloatAsState(
                    targetValue = when (orientation) {
                        FlipPagerOrientation.Vertical -> 0f
                        FlipPagerOrientation.Horizontal -> 90f
                    },
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    ),
                    label = "icon rotation"
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_flip_orientation),
                    contentDescription = "flip page orientation",
                    modifier = Modifier.rotate(rotation)
                )
            }
        }

    }
}
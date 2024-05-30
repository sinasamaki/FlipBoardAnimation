package com.sinasamaki.flipboardanimation.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sinasamaki.flipboardanimation.data.Headline
import com.sinasamaki.flipboardanimation.ui.theme.FlipBoardAnimationTheme

@Composable
fun HeadlineArticle(
    modifier: Modifier = Modifier,
    headline: Headline,
) {

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .widthIn(max = 480.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground.copy(alpha = .1f))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://source.unsplash.com/random/1080x1920/?${headline.image}")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = headline.category.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .56f)
            )
            Text(
                text = headline.title,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = headline.description,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .84f)
            )
            Row {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HeadlineArticlePreview() {
    FlipBoardAnimationTheme {
        HeadlineArticle(
            headline = Headline(
                title = "Historic Win for Local Soccer Team",
                description = "In an unexpected turn of events, the local soccer team clinched a historic victory against their arch-rivals. The match, held at the city stadium, was attended by thousands of enthusiastic fans who witnessed a nail-biting finish. The team's captain led from the front, scoring the decisive goal in the final minutes. This win has reignited hopes of a league title for the first time in decades. Fans are ecstatic and celebrations have erupted across the city. The coach praised the team's resilience and tactical discipline. This triumph marks a significant milestone in the team's journey. Supporters are now eagerly looking forward to the upcoming fixtures. The community has rallied behind the team, showcasing immense pride and support.",
                category = "sports",
                image = "soccer_stadium.jpg"
            )
        )
    }
}
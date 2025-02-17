package com.example.signatureapp.signature.panelView

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.signatureapp.R

@Composable
internal fun ColorRow(
    rowElementsCount: Int,
    colorRow: List<List<Color>>,
    colorIntensity: Int,
    defaultColor: Color,
    unSelectedSize: Dp,
    selectedSize: Dp,
    clickedColor: (List<Color>, Color) -> Unit
) {
    Row {
        repeat(rowElementsCount) { rowIndex ->
            if (colorRow.size - 1 < rowIndex) {
                Spacer(Modifier.weight(1f, true))
                return@repeat
            }
            val color = colorRow[rowIndex]
            ColorDots(
                color[colorIntensity],
                color.contains(defaultColor),
                unSelectedSize,
                selectedSize
            ) {
                clickedColor(color, it)
            }
        }
    }
}

/**
 * horizontal stack to show shades of a selected color
 * */
@Composable
internal fun SubColorRow(
    rowElementsCount: Int,
    colorRow: List<Color>,
    defaultColor: Color,
    unSelectedSize: Dp,
    selectedSize: Dp,
    clickedColor: (Color) -> Unit
) {
    Row {
        repeat(rowElementsCount) { rowIndex ->
            if (colorRow.size - 1 < rowIndex) {
                Spacer(Modifier.weight(1f, true))
                return@repeat
            }
            val color = colorRow[rowIndex]
            ColorDots(
                color,
                color == defaultColor,
                unSelectedSize,
                selectedSize, clickedColor = clickedColor
            )
        }
    }
}


/**
 * animated wrapper to manipulate visibility in a specific way
 * */
@Composable
internal fun ChangeVisibility(
    isVisible: Boolean,
    density: Density,
    content: @Composable() AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) {
                -40.dp.roundToPx()
            }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically(
            shrinkTowards = Alignment.Top
        ) + fadeOut(),
        content = content
    )
}

/**
 * Base entity to show a single color
 * */
@Composable
internal fun RowScope.ColorDots(
    color: Color,
    selected: Boolean,
    unSelectedSize: Dp = 26.dp,
    selectedSize: Dp = 36.dp,
    dotDescription: String = " ",
    clickedColor: (Color) -> Unit
) {
    val dbAnimateAsState: Dp by animateDpAsState(
        targetValue = if (selected) selectedSize else unSelectedSize
    )
    IconButton(
        onClick = {
            clickedColor(color)
        }, modifier = Modifier
            .weight(1f, true)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_color),
            contentDescription = dotDescription,
            tint = color,
            modifier = Modifier.size(dbAnimateAsState)
        )
    }
}
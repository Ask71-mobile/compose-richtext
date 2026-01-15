package com.halilibo.richtext.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize

/**
 * Data class representing a resource tag from markdown content.
 *
 * @param resourceType The type of resource (e.g., "email_thread", "calendar_event")
 * @param uri The unique identifier for this resource
 * @param index The 1-based display index of this resource in the content (1, 2, 3...)
 */
public data class ResourceTagInfo(
    val resourceType: String,
    val uri: String,
    val index: Int = 0
)

/**
 * Callback interface for resource tag click events.
 */
public fun interface OnResourceTagClick {
    public fun onClick(info: ResourceTagInfo)
}

/**
 * Configuration for rendering resource tags inline.
 *
 * @param initialSize Function to calculate the initial size of the inline badge.
 * @param onResourceTagClick Callback when a resource tag is clicked.
 * @param content Composable content to render for each resource tag.
 */
public class ResourceTagRenderer(
    public val initialSize: (Density.() -> IntSize)? = null,
    public val onResourceTagClick: OnResourceTagClick? = null,
    public val content: @Composable (ResourceTagInfo, () -> Unit) -> Unit
)

/**
 * CompositionLocal for providing ResourceTagRenderer throughout the composition tree.
 * When null, resource tags will be rendered as plain text.
 */
public val LocalResourceTagRenderer: androidx.compose.runtime.ProvidableCompositionLocal<ResourceTagRenderer?> =
    staticCompositionLocalOf { null }

/**
 * CompositionLocal for providing URI to index mapping.
 * This allows resource tags to display their correct index number.
 */
public val LocalResourceTagIndices: androidx.compose.runtime.ProvidableCompositionLocal<Map<String, Int>> =
    staticCompositionLocalOf { emptyMap() }

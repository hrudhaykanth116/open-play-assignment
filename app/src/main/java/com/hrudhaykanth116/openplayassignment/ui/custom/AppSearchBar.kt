package com.hrudhaykanth116.openplayassignment.ui.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hrudhaykanth116.openplayassignment.R
import com.hrudhaykanth116.openplayassignment.domain.models.toImageHolder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(
            query = text,
            onQueryChange = onTextChange,
            onSearch = {
                // String is ignored here to be derived from state directly.
                onSearch()
            },
            active = false,
            onActiveChange = {

            },
            content = content
        )
        AppIcon(
            imageHolder = R.drawable.ic_search.toImageHolder(),
            modifier = Modifier.clickable {
                onSearch()
            }
        )
    }

}
package com.alex.yang.alexnewscompose.home.presentation

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.alex.yang.alexnewscompose.home.domain.model.Article
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.yang.alexnewscompose.R
import com.alex.yang.alexnewscompose.home.presentation.components.ArticleList
import com.alex.yang.alexnewscompose.home.presentation.components.SearchBar
import com.alex.yang.alexnewscompose.navgraph.Route
import com.alex.yang.alexnewscompose.ui.theme.AlexNewsComposeTheme

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Image(
            modifier = Modifier
                .padding(start = 8.dp)
                .width(170.dp)
                .height(60.dp),
            painter = painterResource(id = R.drawable.ic_logo2),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(12.dp))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigate(Route.SearchScreen.route)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .basicMarquee(),
            text = titles,
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(4.dp))

        ArticleList(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            articles = articles,
            onClick = {

            }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AlexNewsComposeTheme() {

    }
}
package com.example.presentation.screens.articles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.model.serializeArticleItemModel
import com.example.presentation.R
import com.example.presentation.screens.article_details.ArticlesDetailsActivity
import com.example.presentation.screens.articles.component.ItemArticle
import com.example.presentation.theme.NewsAppTheme
import com.example.presentation.theme.darkWhite
import com.example.presentation.theme.grey
import com.example.presentation.utils.ErrorHolder
import com.example.presentation.utils.LoadingIndicator
import com.example.presentation.utils.TopBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticlesActivity : ComponentActivity() {
    private val viewModel: ArticlesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = grey
                ) {
                    ArticlesScreen()
                }
            }
        }
    }



    @Composable
    fun ArticlesScreen() {
            Column(
                modifier = Modifier
                    .background(darkWhite)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Surface(shadowElevation = 3.dp) {
                    TopBar(
                        title = stringResource(R.string.main_title),

                    )
                }

                Articles(viewModel)

            }

    }

    @Composable
    fun Articles(articlesViewModel: ArticlesViewModel) {
        if (articlesViewModel.articlesState.value.isLoading) {
            LoadingIndicator()
        } else if (articlesViewModel.articlesState.value.listArticles.isNotEmpty()) {

            LazyColumn {
                items(articlesViewModel.articlesState.value.listArticles) { article ->
                    ItemArticle(article){
                        val intent = Intent(this@ArticlesActivity, ArticlesDetailsActivity::class.java)
                        intent.putExtra("article", serializeArticleItemModel(it))
                        startActivity(intent)
                    }
                }
            }
        } else if (articlesViewModel.articlesState.value.error.isNotEmpty()) {
            ErrorHolder(text = articlesViewModel.articlesState.value.error)
        } else if (articlesViewModel.articlesState.value.listArticles.isEmpty()) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.no_result),
                    contentDescription = "no_result",
                    modifier = Modifier.size(width = 250.dp, height = 250.dp)
                )
            }
        }

    }

}


 

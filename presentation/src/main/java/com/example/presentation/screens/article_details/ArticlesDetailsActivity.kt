package com.example.presentation.screens.article_details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.model.ArticleItemModel
import com.example.domain.model.deserializeArticleItemModel
import com.example.presentation.R
import com.example.presentation.theme.NewsAppTheme
import com.example.presentation.theme.darkWhite
import com.example.presentation.theme.grey
import com.example.presentation.utils.CoilImage
import com.example.presentation.utils.TopBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticlesDetailsActivity : ComponentActivity() {
    lateinit var article: ArticleItemModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = grey
                ) {
                    val extras = intent.extras
                    if (extras != null) {
                        val value = extras.getString("article")
                        article = value?.let { deserializeArticleItemModel(it) }!!
                    }
                    ArticlesDetailsScreen()
                }
            }
        }
    }


    @Composable
    fun ArticlesDetailsScreen() {
        Column(
            modifier = Modifier
                .background(darkWhite)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Surface(shadowElevation = 3.dp) {
                TopBar(
                    title = stringResource(R.string.article_details),
                )
            }

            CoilImage(
                data = if (article.media.isNotEmpty()) article.media.first().mediaMetaData.last().url.toString() else "",
                contentDescription = article.media.first().caption ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.title ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.byline ?: "",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.published_date, article.publishedDate ?: ""),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.abstract ?: "",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.keywords, article.adxKeywords ?: ""),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }

    }


}


 

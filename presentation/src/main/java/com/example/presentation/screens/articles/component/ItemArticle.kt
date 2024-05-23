package com.example.presentation.screens.articles.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.ArticleItemModel
import com.example.presentation.theme.White
import com.example.presentation.utils.CoilImage


@Composable
fun ItemArticle(item: ArticleItemModel, onClick: (ArticleItemModel) -> Unit){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
             onClick(item)
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            item.title?.let {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = it,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            item.publishedDate?.let {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = it,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            CoilImage(
                data = if (item.media.isNotEmpty()) item.media.first().mediaMetaData[1].url.toString() else "",
                contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
            )


            item.byline?.let {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = it,
                    style = TextStyle(color = MaterialTheme.colorScheme.primary)
                )
            }
        }
    }
}
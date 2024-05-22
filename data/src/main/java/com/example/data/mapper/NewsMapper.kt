package com.example.data.mapper

import com.example.data.remote.responses.ArticleItemJson
import com.example.data.remote.responses.ArticlesJson
import com.example.data.remote.responses.MediaJson
import com.example.data.remote.responses.MediaMetaDataJson
import com.example.domain.model.ArticleItemModel
import com.example.domain.model.ArticlesModel
import com.example.domain.model.MediaMetaDataModel
import com.example.domain.model.MediaModel


fun ArticlesJson.toDomain(): ArticlesModel =
    ArticlesModel(
    results = results.map { it.toDomain() } as ArrayList<ArticleItemModel>
    )

fun ArticleItemJson.toDomain(): ArticleItemModel =
    ArticleItemModel(
        id = id,
        assetId = assetId,
        source = source,
        publishedDate = publishedDate,
        section = section,
        adxKeywords = adxKeywords,
        byline = byline,
        title = title,
        abstract = abstract,
        media = media.map {
            it.toDomain()
        } as ArrayList<MediaModel>
    )


fun MediaMetaDataJson.toDomain(): MediaMetaDataModel =
    MediaMetaDataModel(
        url = url,
        format = format,
        height = height,
        width = width
    )

fun MediaJson.toDomain(): MediaModel =
    MediaModel(
        type = type,
        subtype = subtype,
        caption = caption,
        copyright = copyright,
        approvedForSyndication = approvedForSyndication,
        mediaMetaData = mediaMetaData.map {
            it.toDomain()
        } as ArrayList<MediaMetaDataModel>


    )











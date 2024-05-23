package com.example.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class ArticlesModel(
    var results: ArrayList<ArticleItemModel> = arrayListOf()
)

@Serializable
data class MediaMetaDataModel(
    var url: String? = null,
    var format: String? = null,
    var height: Int? = null,
    var width: Int? = null
)

@Serializable
data class MediaModel(

    var type: String? = null,
    var subtype: String? = null,
    var caption: String? = null,
    var copyright: String? = null,
    var approvedForSyndication: Int? = null,
    var mediaMetaData: ArrayList<MediaMetaDataModel> = arrayListOf()

)

@Serializable
data class ArticleItemModel(

    var id: Long? = null,
    var assetId: Long? = null,
    var source: String? = null,
    var publishedDate: String? = null,
    var section: String? = null,
    var adxKeywords: String? = null,
    var byline: String? = null,
    var title: String? = null,
    var abstract: String? = null,
    var media: ArrayList<MediaModel> = arrayListOf(),

)
fun serializeArticleItemModel(obj: ArticleItemModel): String {
    return Json.encodeToString(obj)
}

fun deserializeArticleItemModel(jsonString: String): ArticleItemModel {
    return Json.decodeFromString(jsonString)
}

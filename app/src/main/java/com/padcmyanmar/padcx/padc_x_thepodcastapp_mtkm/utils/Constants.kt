package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.BuildConfig

const val DATABASE_NAME="Podcast.DB"

//HeaderParam
const val PARAM_API_KEY = "X-ListenAPI-Key"
const val PARAM_API_VALUE = BuildConfig.API_VALUE

//BaseUrl
const val BASE_URL = "https://bdc6de61-2fa1-48c3-8e5e-ca59d3fc651b.mock.pstmn.io/"

//EndPoint
const val GET_GENRES_LIST ="genres"
const val GET_RAMDOM = "just_listen"
const val GET_PLAYLIST="playlists/{PODCAST_ID}"
const val GET_DETAIL="episodes/{DETAIL_ID}"

//PathVariables
const val PODCAST_ID = "SgTozE1ZAe3"
const val DETAIL_VALUE ="e1495b84d26d4c2d9ea1fc6db47a78f8"


//QueryParam
const val PARAM_TOP_LEVEL_ONLY = "top_level_only"
const val VALUE_TOP_LEVEL_ONLY=0

const val PARAM_TYPE="type"
const val VALUE_TYPE="episode_list"

const val PARAM_LAST_TIMESTAMP="last_timestamp_ms"
const val VALUE_LAST_TIMESTAMP=0

const val PARAM_SORT="sort"
const val VALUE_SORT="recent_added_first"

const val HOMEPAGE = "home"
const val DOWNLOADPAGE = "downlod"


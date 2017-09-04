package com.cabbage.mylibrary.manager

import com.cabbage.mylibrary.geocoding.GeocodingService
import okhttp3.logging.HttpLoggingInterceptor.Level

object MapsApiManager {

    var globalLogLevel: Level = Level.NONE
        set(value) {
            field = value
            geocodingService.let { if (it.isNonDefault()) it.configure(logLevel = value) }
        }

    var globalAuthMethod: AuthMethod = AuthMethod.None()
        set(value) {
            field = value
            geocodingService.let { if (it.isNonDefault()) it.configure(authMethod = value) }
        }

    val geocodingService: GeocodingService by lazy { GeocodingService.create() }

//    fun geocodeByAddressName(name: String,
//                             bounds: ReqBounds? = null,
//                             language: String = "en",
//                             region: String? = null,
//                             components: Map<String, String>? = null)
//            : Observable<GeocodingResponse>
//            = geocodingService.queryByAddressName(name, bounds, language, region, components)
//
//    fun geocodeByLocation(latitude: Double,
//                          longitude: Double,
//                          language: String = "en",
//                          resultType: List<String>? = null,
//                          locationType: List<String>? = null)
//            : Observable<GeocodingResponse>
//            = geocodingService.queryByLocation(latitude, longitude, language, resultType, locationType)
//
//    fun geocodeByPlaceId(placeId: String,
//                         language: String = "en",
//                         resultType: List<String>? = null,
//                         locationType: List<String>? = null)
//            : Observable<GeocodingResponse>
//            = geocodingService.queryByPlaceId(placeId, language, resultType, locationType)
}
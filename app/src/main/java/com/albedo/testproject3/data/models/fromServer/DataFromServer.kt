package com.albedo.testproject3.data.models.fromServer

import com.google.gson.annotations.SerializedName

data class DataFromServer(
    @SerializedName("results")
    val results : List<UserDataUIState>,
    @SerializedName("info")
    val info : InfoInner? = null
)

data class InfoInner(
    val seed : String = "",
    val results : Int = 0,
    val page : Int = 0,
    val version : String = "",
)


//{"results"
//    :[
//    {
//        "gender":"male",
//        "name":{"title":"Mr","first":"Lucas","last":"Lam"},
//        "location":{
//        "street":{"number":4350,"name":"Coastal Highway"},
//        "city":"Field",
//        "state":"Northwest Territories",
//        "country":"Canada",
//        "postcode":"K7W 1T7",
//        "coordinates":{"latitude":"-66.8065","longitude":"-30.7499"},
//        "timezone":{"offset":"-1:00","description":"Azores, Cape Verde Islands"}
//    },
//        "email":"lucas.lam@example.com",
//        "login":{
//        "uuid":"9766456c-71fc-4f98-9d6c-b9b1cb2b2264",
//        "username":"happysnake729",
//        "password":"smackdow",
//        "salt":"Ce0X9MGM",
//        "md5":"3e2090585b55f142fea12a512103da5f",
//        "sha1":"1324582bc4ae6731dedb734d62cf20727a237bc0",
//        "sha256":"b9b0aaf8ab448e9e98b637b1644f0462b717e552ca00d3b2a183e21e63585870"
//    },
//        "dob":{"date":"1979-05-28T14:44:50.118Z","age":44},
//        "registered":{"date":"2017-03-06T06:35:51.613Z","age":6},
//        "phone":"U71 S11-3246",
//        "cell":"Q10 M94-3340",
//        "id":{"name":"SIN","value":"947514337"},
//        "picture":{
//        "large":"https://randomuser.me/api/portraits/men/9.jpg",
//        "medium":"https://randomuser.me/api/portraits/med/men/9.jpg",
//        "thumbnail":"https://randomuser.me/api/portraits/thumb/men/9.jpg"
//    },
//        "nat":"CA"
//    },
//],
//
//
//
//    "info":{
//        "seed":"f56bd9d95071d235",
//        "results":2,
//        "page":1,
//        "version":"1.4"
//    }
//}

package com.android.mivi.activities.info.dal

import org.json.JSONObject
import java.lang.StringBuilder

class Information(jsonObject: JSONObject) {
    private val jsonObject = jsonObject
    fun getHeader(): String? {
        return jsonObject.optString("type")
    }
    fun getDetails():String? {
        val attributes = jsonObject.optJSONObject("attributes")
        val list = attributes.keys()
        val builder = StringBuilder()
        for ( e in list) {
            builder.append(e+" : "+attributes.opt(e)+"\n")
        }
        return builder.toString()
    }
}
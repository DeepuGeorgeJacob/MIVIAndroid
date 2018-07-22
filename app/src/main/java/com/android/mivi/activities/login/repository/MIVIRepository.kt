package com.android.mivi.activities.login.repository

import com.android.mivi.components.assets.AssetsController
import java.io.IOException
import java.nio.charset.Charset

class MIVIRepository constructor(assetController: AssetsController) : MIVDataSource  {
    private val assetController = assetController

    companion object {
        @Volatile
        private var INSTANCE: MIVIRepository? = null

        fun getInstance(assetController: AssetsController): MIVIRepository = INSTANCE
                ?: synchronized(this) {
                    INSTANCE ?: MIVIRepository(assetController).also { INSTANCE = it }
                }
    }

    override fun getJson(): String? {
        var json: String? = null
        try {
            val inputstream = assetController.open("collections.json")
            val size = inputstream.available()
            val buffer = ByteArray(size)
            inputstream.read(buffer)
            inputstream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

}
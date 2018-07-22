package com.android.mivi.components.assets

import android.content.res.AssetManager
import java.io.InputStream

class MIVIAssetManager(manger:AssetManager) : AssetsController {
    private val assetMngr = manger
    override fun open(filename: String): InputStream {
        return assetMngr.open(filename)
    }

}
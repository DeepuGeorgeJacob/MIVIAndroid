package com.android.mivi.components.assets

import java.io.InputStream

interface AssetsController {
    fun open(filename:String):InputStream;
}
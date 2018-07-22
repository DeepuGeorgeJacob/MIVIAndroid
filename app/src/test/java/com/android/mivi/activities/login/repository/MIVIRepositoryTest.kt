package com.android.mivi.activities.login.repository

import com.android.mivi.components.assets.AssetsController
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.io.InputStream

class MIVIRepositoryTest {
    private  var miviRepository: MIVIRepository? = null
    private var assetsController: AssetsController = mock<AssetsController>(AssetsController::class.java)
    private var inputStream = mock(InputStream::class.java)
    @Before
    fun onBefore() {
        miviRepository = MIVIRepository.getInstance(assetsController)
    }

    @After
    fun tearDown() {
        miviRepository = null
    }

    @Test
    fun getJson() {
        `when`(assetsController.open("collections.json")).thenReturn(inputStream)
        Assert.assertNotNull(miviRepository)
        Assert.assertNotNull(miviRepository!!.getJson())
    }
}
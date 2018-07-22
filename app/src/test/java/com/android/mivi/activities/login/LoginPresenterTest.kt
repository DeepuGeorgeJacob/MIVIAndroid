package com.android.mivi.activities.login

import com.android.mivi.activities.login.repository.MIVDataSource
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.internal.util.reflection.Whitebox
import java.nio.charset.Charset

class LoginPresenterTest {
    private var presenter: LoginPresenter? = null
    private val view: LoginContract.View = mock(LoginContract.View::class.java)
    private val dataSource: MIVDataSource = mock(MIVDataSource::class.java)
    @Before
    fun setUp() {
        presenter = LoginPresenter(view, dataSource)
    }

    @After
    fun tearDown() {
        presenter = null
    }

    @Test
    fun test_OnStart() {
        `when`(dataSource.getJson()).thenReturn(mockJson())
        presenter!!.onStart()
        val email: String = Whitebox.getInternalState(presenter, "email") as String
        assertTrue(email.equals("test@mivi.com"))

    }

    @Test
    fun test_keyBoardDonePressed() {
        val key = 0
        `when`(view.getIMEDone()).thenReturn(6)
        `when`(view.getIMENull()).thenReturn(0)
        presenter!!.keyboardNextPressed(key)
        assertTrue("Pressed next success",key == view.getIMEDone() || key == view.getIMENull())
    }

    @Test
    fun test_OnInteractedSubmit_Failed() {
        val username = "Deepu"
        val password = "Hello"
        Whitebox.setInternalState(presenter,"email","abc@cse.com")
        presenter!!.onSubmit(username, password)
        val email: String = Whitebox.getInternalState(presenter, "email") as String
        assertFalse("Invalid Email", email.equals("test@mivi.com"))
        verify(view).showDialog("Invalid Email/Wrong password", "Please enter valid email/password")
    }

    @Test
    fun test_OnInteractedSubmit_Success() {
        val username = "test@mivi.com"
        val password = "Hello"
        Whitebox.setInternalState(presenter,"email",username)
        presenter!!.onSubmit(username, password)
        val email: String = Whitebox.getInternalState(presenter, "email") as String
        assertTrue("Correct Email", email.equals("test@mivi.com"))
        verify(view).navigateToInfoActivity()
    }


    fun mockJson(): String {
        val byte = "{\"data\":{\"type\":\"accounts\",\"id\":\"2593177\",\"attributes\":{\"payment-type\":\"prepaid\",\"unbilled-charges\":null,\"next-billing-date\":null,\"title\":\"Ms\",\"first-name\":\"Joe\",\"last-name\":\"Bloggs\",\"date-of-birth\":\"1985-01-01\",\"contact-number\":\"0404000000\",\"email-address\":\"test@mivi.com\",\"email-address-verified\":false,\"email-subscription-status\":false}}}".toByteArray()
        return String(byte, Charset.forName("UTF-8"))
    }
}
package com.android.mivi.activities.login

import com.android.mivi.activities.login.repository.MIVDataSource
import org.json.JSONObject

class LoginPresenter(view: LoginContract.View, miviRepository: MIVDataSource) : LoginContract.Presenter {
    private var miviRepository = miviRepository
    private lateinit var email: String
    private val view = view

    init {
        view.setPresenter(this)
    }

    override fun onStart() {
        val response = miviRepository.getJson()
        val json = JSONObject(response)
        val attribute: JSONObject = json.getJSONObject("data").getJSONObject("attributes")
        email = attribute.optString("email-address")
    }

    override fun onSubmit(username: String?, password: String?) {
        if (email.equals(username) && password!!.length > 0) {
            view.navigateToInfoActivity()
        } else {
            view.showDialog("Invalid Email/Wrong password", "Please enter valid email/password")
        }
    }

    override fun keyboardNextPressed(key: Int): Boolean {
        return (key == view.getIMENull() || key == view.getIMEDone())
    }
}
package com.android.mivi.activities.login

import com.android.mivi.activities.base.BasePresenter
import com.android.mivi.activities.base.BaseView

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun showDialog(title: String, message: String)
        fun navigateToInfoActivity()
        fun getIMEDone(): Int
        fun getIMENull(): Int

    }

    interface Presenter : BasePresenter {
        fun onSubmit(username:String?,password:String?)
        fun keyboardNextPressed(key: Int):Boolean
    }
}
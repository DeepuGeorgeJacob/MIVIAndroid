package com.android.mivi.activities.login

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.android.mivi.R
import com.android.mivi.activities.login.repository.MIVIRepository
import com.android.mivi.activities.welcome.WelcomeActivity
import com.android.mivi.base.BaseActivity
import com.android.mivi.components.assets.MIVIAssetManager
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity(), LoginContract.View {


    private lateinit var presenter: LoginContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            return@OnEditorActionListener presenter.keyboardNextPressed(id)
        })
        email_sign_in_button.setOnClickListener { attemptLogin() }
        LoginPresenter(this, MIVIRepository.getInstance(MIVIAssetManager(assets))).onStart()
    }
    override fun getIMEDone(): Int {
        return EditorInfo.IME_ACTION_DONE
    }

    override fun getIMENull(): Int {
        return EditorInfo.IME_NULL
    }


    override fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }
    override fun navigateToInfoActivity() {
        startActivity(Intent(this,WelcomeActivity::class.java))
    }


    private fun attemptLogin() {
        presenter.onSubmit(email.text.toString(), password.text.toString())
    }


}

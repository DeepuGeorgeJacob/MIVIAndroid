package com.android.mivi.activities.welcome

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.android.mivi.R
import com.android.mivi.activities.info.InformationActivity
import com.android.mivi.base.BaseActivity


class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        Handler().postDelayed({
            startActivity(Intent(this,InformationActivity::class.java))
        }, resources.getInteger(R.integer.activity_splash_delay).toLong())
    }
}

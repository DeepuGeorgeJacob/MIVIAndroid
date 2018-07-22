package com.android.mivi.base

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DialogTitle
import com.android.mivi.R
import org.json.JSONObject
import java.io.IOException

open class BaseActivity : AppCompatActivity() {
    private var dialog:AlertDialog? = null
    var builder:AlertDialog.Builder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.title = getString(R.string.app_name)
        builder =  AlertDialog.Builder(this)
    }
    fun showDialog(title: String,message:String) {
        builder!!.setMessage(message)
                .setTitle(title)
         dialog = builder!!.create()
        dialog!!.show()
    }
    fun dismissDialog() {
        if( dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}
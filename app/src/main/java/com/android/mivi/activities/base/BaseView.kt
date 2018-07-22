package com.android.mivi.activities.base

interface BaseView<in E : BasePresenter> {
    fun setPresenter(presenter: E)
}
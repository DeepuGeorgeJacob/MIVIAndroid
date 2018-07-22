package com.android.mivi.activities.info

import com.android.mivi.activities.base.BasePresenter
import com.android.mivi.activities.base.BaseView
import com.android.mivi.activities.info.dal.Information

interface InformationContract {
    interface View : BaseView<Presenter> {
        fun updateDataset(list: ArrayList<Information>)

    }

    interface Presenter : BasePresenter {

    }
}
package com.android.mivi.activities.info

import com.android.mivi.activities.info.dal.Information
import com.android.mivi.activities.login.repository.MIVDataSource
import org.json.JSONObject

class InformationPresenter(view: InformationContract.View, datasource: MIVDataSource) : InformationContract.Presenter {
    private val datasource = datasource
    private val view = view
    init {
        view.setPresenter(this)
    }
    override fun onStart() {
       val jsonObject =JSONObject(datasource.getJson())
        val jsonArray = jsonObject.getJSONArray("included")
        val list = ArrayList<Information>()
       for (i in 0..(jsonArray.length() - 1)) {
            list.add(Information(jsonArray.getJSONObject(i)))
       }
       view.updateDataset(list)
    }
}
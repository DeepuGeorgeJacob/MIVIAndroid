package com.android.mivi.activities.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.android.mivi.R
import com.android.mivi.activities.info.dal.Information
import com.android.mivi.activities.info.recyclear.InformationAdapter
import com.android.mivi.activities.login.repository.MIVIRepository
import com.android.mivi.components.assets.MIVIAssetManager

class InformationActivity : AppCompatActivity(), InformationContract.View {


    private lateinit var presenter: InformationContract.Presenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: InformationAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        viewManager = LinearLayoutManager(this)
        viewAdapter = InformationAdapter()
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        InformationPresenter(this, MIVIRepository.getInstance(MIVIAssetManager(assets))).onStart()
    }
    override fun updateDataset(list: ArrayList<Information>) {
        viewAdapter.setData(list)
    }

    override fun setPresenter(presenter: InformationContract.Presenter) {
        this.presenter = presenter
    }
}

package com.domui.uicomponent.view

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.text.TextUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.domui.uicomponent.R
import com.domui.uicomponent.adapter.PanelAdapter
import com.domui.uicomponent.model.PanelItemDescription
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData() {
        showTitle(resources.getString(R.string.app_name))
        val functionArray = resources.getStringArray(R.array.type)
        val list = ArrayList<PanelItemDescription>()
        for (i in functionArray.indices) {
            val itemDescription = PanelItemDescription()
            itemDescription.setmKitName(functionArray[i])
            list.add(itemDescription)
        }

        val mAdapter = PanelAdapter(list)
        recycle.layoutManager = GridLayoutManager(this, 3)
        recycle.adapter = mAdapter
        mAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, _, position ->
            val itemDescription = adapter.getItem(position) as PanelItemDescription?
            if (itemDescription != null && !TextUtils.isEmpty(itemDescription.getmKitName()))
                launchActivity(itemDescription.getmKitName())
        }
    }

    private fun launchActivity(prefixName: String) {

        val fullName = "com.domui.uicomponent.view." + prefixName + "Activity"
        var mclass: Class<*>? = null
        try {
            mclass = Class.forName(fullName)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        if (mclass != null)
            startActivity(Intent(this@MainActivity, mclass))
    }
}

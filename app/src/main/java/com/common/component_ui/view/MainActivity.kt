package com.common.component_ui.view

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.common.component_ui.adapter.PanelAdapter
import com.common.componentui.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData() {
        showTitle(resources.getString(R.string.app_name))
        val functionArray = resources.getStringArray(R.array.type).toList()

        val mAdapter = PanelAdapter(functionArray)
        recycle.layoutManager = GridLayoutManager(this, 2)
        recycle.adapter = mAdapter
        mAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, _, position ->
            val itemDescription = adapter.getItem(position) as String
            if (itemDescription.isNotEmpty())
                launchActivity(itemDescription)
        }
    }

    private fun launchActivity(prefixName: String) {

        val fullName = "com.common.component_ui.view." + prefixName + "Activity"
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

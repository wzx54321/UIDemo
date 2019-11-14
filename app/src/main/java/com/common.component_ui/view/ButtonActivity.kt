package com.domui.uicomponent.view

import com.domui.uicomponent.R

class ButtonActivity : BaseActivity() {
    override fun getLayoutId(): Int {

        return R.layout.activity_button
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.button))
    }

}
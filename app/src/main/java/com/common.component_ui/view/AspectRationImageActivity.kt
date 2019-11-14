package com.common.component_ui.view

import com.domui.uicomponent.R

class AspectRationImageActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_aspect_ration_image
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.aspectRationImage))
    }

}
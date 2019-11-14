package com.domui.uicomponent.view

import com.domui.uicomponent.R

class AnimActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_transition_anim
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.animation))

    }
}
package com.common.component_ui.view

import com.domui.uicomponent.R
import kotlinx.android.synthetic.main.activity_transition_anim.*

class AnimActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_transition_anim
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.animation))
        go.setOnClickListener({
            finish()
        })

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out)
    }
}
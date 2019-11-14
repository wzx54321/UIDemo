package com.common.component_ui.view

import android.view.Gravity
import com.common.component_ui.widget.Toast.ToastUtils
import com.domui.uicomponent.R
import kotlinx.android.synthetic.main.activity_toast.*

class ToastActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_toast
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.toast))
        ToastUtils.init(this.application)//设置全局统一样式
        normalDialog.setOnClickListener({
            ToastUtils.show(resources.getText(R.string.normalToast))
        })
        customDialog.setOnClickListener({
            ToastUtils.setView(R.layout.toast_image_layout)
            ToastUtils.show(resources.getText(R.string.global_style))
        })

        bottomDialog.setOnClickListener({
            ToastUtils.setGravity(Gravity.BOTTOM, 0, 0)
            ToastUtils.show(resources.getText(R.string.bottomToast))
        })
        centerDialog.setOnClickListener({
            ToastUtils.setGravity(Gravity.CENTER, 0, 0)
            ToastUtils.show(resources.getText(R.string.centerToast))
        })
    }
}

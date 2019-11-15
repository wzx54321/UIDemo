package com.common.component_ui.view

import com.common.component_ui.widget.dialog.CommonDialog
import com.domui.uicomponent.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_dialog
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.dialog))
        btnTwoNormal.setOnClickListener {
            val dialog = CommonDialog.newInstance("续费升级，开启新生活", "再想想", "取消", true, true)

            dialog.show(supportFragmentManager)
                    .setCancleOnClickListener {
                        dialog.dismiss()
                    }.setOkOnClickListener {
                        dialog.dismiss()
                    }
        }
        btnOneNormal.setOnClickListener {
            val dialog = CommonDialog.newInstance("升级成功", "知道了", true, false)
            dialog.show(supportFragmentManager)
                    .setCancleOnClickListener {
                        dialog.dismiss()
                    }.setOkOnClickListener {
                        dialog.dismiss()
                    }

        }
        btnTwoYellow.setOnClickListener {
            val dialog = CommonDialog.newInstance("续费升级，开启新生活", "再想想", "取消", true, true)

            dialog.setYellowStyle(true).show(supportFragmentManager)
                    .setCancleOnClickListener {
                        dialog.dismiss()
                    }.setOkOnClickListener {
                        dialog.dismiss()
                    }
        }
        btnOneYellow.setOnClickListener {
            val dialog = CommonDialog.newInstance("升级成功", "知道了", true, false)
            dialog.setYellowStyle(true).show(supportFragmentManager)
                    .setCancleOnClickListener {
                        dialog.dismiss()
                    }.setOkOnClickListener {
                        dialog.dismiss()
                    }

        }
    }

}
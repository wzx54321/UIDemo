package com.common.component_ui.view

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.common.component_ui.widget.bottomsheet.XinPopWindow
import com.domui.uicomponent.R
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import java.util.*

class BottomSheetActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_bottom_sheet
    }

    override fun initData() {
        showBack()
        showTitle(resources.getString(R.string.bottom_sheet))
        btnBottomSheetList.setOnClickListener {
            createSelectPhotoListDialog(this, it, false)
        }
        btnBottomSheetGrid.setOnClickListener {
            createSelectPhotoGridDialog(this, it, true)
        }
    }

    fun createSelectPhotoListDialog(context: Activity, bindView: View, isGridLayout: Boolean) {
        val mPopUpload = XinPopWindow(context, isGridLayout)
        val menuItems = ArrayList<XinPopWindow.MenuItem>()
        menuItems.add(XinPopWindow.MenuItem("拍照", 1))
        menuItems.add(XinPopWindow.MenuItem("从相册选择", 2))
        mPopUpload.setData(menuItems)
        mPopUpload.setOnItemClickListener { view, position, type ->
            mPopUpload.dismiss()
            when (type) {
                //拍照
                1 -> {
                    Toast.makeText(this@BottomSheetActivity, "拍照", Toast.LENGTH_LONG).show()
                    //相册选择
                }
                2 -> {
                    Toast.makeText(this@BottomSheetActivity, "从相册选择", Toast.LENGTH_LONG).show()
                }
            }
        }
        mPopUpload.showAtLocation(bindView, Gravity.BOTTOM, 0, 0)
    }

    fun createSelectPhotoGridDialog(context: Activity, bindView: View, isGridLayout: Boolean) {
        val mPopUpload = XinPopWindow(context, isGridLayout)
        val menuItems = ArrayList<XinPopWindow.MenuItem>()
        menuItems.add(XinPopWindow.MenuItem("朋友圈", 1, R.drawable.icon_more_operation_share_friend))
        menuItems.add(XinPopWindow.MenuItem("微信", 2, R.drawable.icon_more_operation_share_friend))
        mPopUpload.setData(menuItems)
        mPopUpload.setOnItemClickListener { view, position, type ->
            mPopUpload.dismiss()
            when (type) {
                //拍照
                1 -> {
                    Toast.makeText(this@BottomSheetActivity, "朋友圈", Toast.LENGTH_LONG).show()
                    //相册选择
                }
                2 -> {
                    Toast.makeText(this@BottomSheetActivity, "微信", Toast.LENGTH_LONG).show()
                }
            }
        }
        mPopUpload.showAtLocation(bindView, Gravity.BOTTOM, 0, 0)
    }
}
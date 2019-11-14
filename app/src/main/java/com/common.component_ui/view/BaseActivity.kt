package com.common.component_ui.view

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.domui.uicomponent.R
import kotlinx.android.synthetic.main.activity_layout_base.*
import kotlinx.android.synthetic.main.base_tool_bar.*

abstract class BaseActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setPortrait())
        // 强制竖屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_layout_base)
        //添加虚拟导航栏遮挡问题，部分界面在未遮挡的情况下有布局高度变小的bug，取消此代码，子view在需要的时候各自添加
        //AndroidVirtualKeyAdaptive.assistActivity(findViewById(android.R.id.content))
        when {
            getTitleLayoutId() < 0 -> {
                base_title.visibility = View.GONE
            }
            getTitleLayoutId() > 0 -> {
                base_title.visibility = View.GONE
                //自定义title实现
            }
            else -> {
                base_title.layoutResource = R.layout.base_tool_bar
                base_title.visibility = View.VISIBLE
                initTitle()
            }
        }
        if (getLayoutId() > 0) {
            base_content.layoutResource = getLayoutId()
            base_content.inflate()
        } else
            base_content.visibility = View.GONE
        initData()
    }

    open fun setPortrait(): Boolean {
        return true
    }

    private var mOnBackListener: View.OnClickListener? = null

    fun setOnBackListener(onBackListener: View.OnClickListener) {
        this.mOnBackListener = onBackListener
    }

    override fun onBackPressed() {
        if (mOnBackListener != null)
            mOnBackListener?.onClick(back_imageView)
        else
            super.onBackPressed()
    }

    //-------------------初始化title--------------------------------------------------

    private fun initTitle() {
        //返回按钮
        back_imageView.setOnClickListener {
            onBackPressed()
        }
        //关闭按钮-webview
        close_webview.setOnClickListener {
            finish()
        }
    }

    fun setToolBarBgColor(colorInt: Int) {
//        toolbar.background = ContextCompat.getDrawable(this,colorInt)
        toolbar.setBackgroundColor(colorInt)
    }

    fun showBack() {
        back_imageView.visibility = View.VISIBLE
    }

    fun setBackImage(resourceId: Int) {
        back_icon.setImageResource(resourceId)
    }

    fun getMainTitle(): TextView {
        return mainTitle!!
    }


    //显示标题
    fun showTitle(title: String) {
        mainTitle?.visibility = View.VISIBLE
        if (title.isNotEmpty())
            mainTitle?.text = title
    }

//-------------------初始化title--------------------------------------------------

    /**
     * 初始化LayoutId
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 返回0时 使用默认title
     * 返回>0时 使用自定义title 并隐藏默认title
     * 返回<0时 隐藏默认title
     */
    @LayoutRes
    open fun getTitleLayoutId(): Int {
        return 0
    }

    /**
     * 初始化数据
     */
    abstract fun initData()


}
package com.common.component_ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.common.componentui.R

class PanelAdapter(data: List<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.main_item_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {

        helper.setText(R.id.item_name, item)
    }
}

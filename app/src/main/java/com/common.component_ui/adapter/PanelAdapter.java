package com.domui.uicomponent.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.domui.uicomponent.R;
import com.domui.uicomponent.model.PanelItemDescription;

import java.util.List;

public class PanelAdapter extends BaseQuickAdapter<PanelItemDescription, BaseViewHolder> {


    public PanelAdapter(List<PanelItemDescription> data) {
        super(R.layout.main_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PanelItemDescription item) {

        helper.setText(R.id.item_name, item.getmKitName());
    }
}

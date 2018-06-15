package com.d.lib.common.view.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.d.lib.common.R;
import com.d.lib.common.view.ToggleButton;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;
import com.d.lib.xrv.adapter.MultiItemTypeSupport;

import java.util.List;

/**
 * BottomDialog
 * Created by D on 2017/7/27.
 */
public class BottomShareSheetDialog extends AbsBottomSheetDialog<BottomShareSheetDialog.Bean> {

    public BottomShareSheetDialog(Context context, List<Bean> datas, String title) {
        super(context);
        this.datas = datas;
        this.title = title;
        initView(rootView);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_dialog_bottom_style_share;
    }

    @Override
    protected void initView(View rootView) {
        RecyclerView list = (RecyclerView) rootView.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        TextView tvCancle = (TextView) rootView.findViewById(R.id.tv_cancle);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        BottomAdapter adapter = new BottomAdapter(context, datas, new MultiItemTypeSupport<Bean>() {
            @Override
            public int getLayoutId(int viewType) {
                if (viewType == Bean.TYPE_CONTENT) {
                    return R.layout.lib_pub_adapter_dlg_bottom_share_content;
                } else if (viewType == Bean.TYPE_PASSWORD) {
                    return R.layout.lib_pub_adapter_dlg_bottom_share_psw;
                }
                return R.layout.lib_pub_adapter_dlg_bottom_share_content;
            }

            @Override
            public int getItemViewType(int position, Bean bean) {
                return bean.type;
            }
        });
        list.setAdapter(adapter);
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(-1, "");
            }
        });
    }

    public class BottomAdapter extends CommonAdapter<Bean> {

        BottomAdapter(Context context, List<Bean> datas, MultiItemTypeSupport<Bean> multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        @Override
        public void convert(final int position, CommonHolder holder, final Bean item) {
            if (holder.mLayoutId == R.layout.lib_pub_adapter_dlg_bottom_share_content) {
                holder.setText(R.id.tv_title, item.title);
                holder.setText(R.id.tv_content, item.content);
            } else if (holder.mLayoutId == R.layout.lib_pub_adapter_dlg_bottom_share_psw) {
                holder.setText(R.id.tv_title, item.title);
                holder.setText(R.id.tv_psw, item.password);
                ToggleButton toggleButton = holder.getView(R.id.tbtn_toggle);
                toggleButton.setOpen(item.isChecked);
            }
        }
    }

    public static class Bean {
        public final static int TYPE_CONTENT = 0;
        public final static int TYPE_PASSWORD = 1;

        public int type;
        public String title;
        public String content;
        public String password;
        public boolean isChecked;

        public Bean(String title, String content) {
            this.type = TYPE_CONTENT;
            this.title = title;
            this.content = content;
        }

        public Bean(String title, String password, boolean isChecked) {
            this.type = TYPE_PASSWORD;
            this.title = title;
            this.password = password;
            this.isChecked = isChecked;
        }
    }
}

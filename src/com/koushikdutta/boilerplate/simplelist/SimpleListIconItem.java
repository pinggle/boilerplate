package com.koushikdutta.boilerplate.simplelist;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.koushikdutta.boilerplate.R;
import com.koushikdutta.boilerplate.tint.TintedImageView;

/**
 * Created by koush on 3/29/15.
 */
public class SimpleListIconItem extends SimpleListOneLineItem {
    private Drawable icon;
    private boolean selectableIcon;

    public SimpleListIconItem(Resources resources) {
        super(resources);
    }

    public SimpleListIconItem(SimpleListFragmentAdapter adapter) {
        super(adapter);
    }

    public SimpleListIconItem(SimpleListFragment fragment) {
        this(fragment.getAdapter());
    }

    public SimpleListIconItem icon(Drawable icon) {
        this.icon = icon;
        notifyDataSetChanged();
        return this;
    }

    public SimpleListIconItem icon(int icon) {
        return icon(getResources().getDrawable(icon));
    }

    public SimpleListIconItem tintableIcon(int icon) {
        selectableIcon = true;
        return icon(icon);
    }

    public SimpleListIconItem tintableIcon(Drawable drawable) {
        selectableIcon = true;
        return icon(drawable);
    }

    protected void bindImageView(TintedImageView tiv) {
        tiv.setImageDrawable(icon);
        if (selectableIcon)
            tiv.setStateListFilter(TintedImageView.StateListFilter.Normal);
        else
            tiv.setStateListFilter(TintedImageView.StateListFilter.None);
    }

    protected void bindView(View v) {
        super.bindView(v);
        TintedImageView tiv = ((TintedImageView)v.findViewById(R.id.icon_list_fragment_icon));
        bindImageView(tiv);
    }

    int getViewType() {
        return R.layout.simple_list_fragment_icon_one_line_item;
    }
}

package com.xpple.graduates.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 基础的适配器
 */
public abstract class BaseListAdapter<E> extends BaseAdapter {

    private List<E> list;

    LayoutInflater mInflater;

    BaseListAdapter(Context context, List<E> list) {
        super();
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addAll(List<E> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = bindView(position, convertView, parent);
        return convertView;
    }

    protected abstract View bindView(int position, View convertView,
                                     ViewGroup parent);
}

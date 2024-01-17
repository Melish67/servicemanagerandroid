package com.example.mybrsmail.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mybrsmail.R;
import com.example.mybrsmail.data.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterSubList extends RecyclerView.Adapter<AdapterSubList.ItemViewHolder> implements Filterable {
    private List<Item> itemList;
    private List<Item> itemListFull;
    private Activity activity;


    public AdapterSubList(Activity activity, List<Item> itemList) {
        this.activity = activity;
        this.itemList = itemList;
        itemListFull = new ArrayList<>(itemList);
    }

    @NonNull
    @Override
    public AdapterSubList.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_list2, viewGroup, false);
        isOnline();
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSubList.ItemViewHolder itemViewHolder, int i) {
        Item item = itemList.get(i);
        itemViewHolder.title.setText(item.getItemTitle());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format1.parse(item.getItemTitle3());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        itemViewHolder.createdDate.setText(format2.format(date));
        if (item.getItemTitle4().equalsIgnoreCase("true")){
            itemViewHolder.statusLinear.setBackgroundResource(R.drawable.success_back);
            itemViewHolder.statusIcon.setBackgroundResource(R.drawable.success_white_ico);
            itemViewHolder.isStatus.setText("active");
        }else {
            itemViewHolder.statusLinear.setBackgroundResource(R.drawable.error_back);
            itemViewHolder.statusIcon.setBackgroundResource(R.drawable.error_white_ico);
            itemViewHolder.isStatus.setText("error");
        }

        itemViewHolder.desc.setText(item.getItemTitle2());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public Filter getFilter() {
        return ItemFilter;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView isStatus,title,createdDate,desc;
        private ImageView statusIcon;
        private LinearLayout statusLinear;

        ItemViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            isStatus = itemView.findViewById(R.id.status_text);
            desc = itemView.findViewById(R.id.desc);
            statusIcon = itemView.findViewById(R.id.status_ico);
            createdDate = itemView.findViewById(R.id.date);

            statusLinear = itemView.findViewById(R.id.linearStatus);
        }

    }

    private Filter ItemFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Item> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(itemListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Item item : itemListFull) {
                    if (item.getItemTitle().toLowerCase().contains(filterPattern) || item.getItemTitle2().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemList.clear();
            itemList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
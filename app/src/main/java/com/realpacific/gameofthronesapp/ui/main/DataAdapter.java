package com.realpacific.gameofthronesapp.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realpacific.gameofthronesapp.R;
import com.realpacific.gameofthronesapp.entitiy.Characters;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ListViewHolder> {
    List<Characters> list;
    Context context;

    public DataAdapter(Context context, List<Characters> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Characters characters = list.get(position);
        holder.title.setText(characters.getName());
        if(characters.getPlayedBy().size()>0)
            holder.preview.setText(characters.getPlayedBy().get(0));

        StringBuilder sb = new StringBuilder();
        for(String titles : characters.getTitles())
            sb.append(titles).append(", ");
        holder.titles.setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.single_name) TextView title;
        @BindView(R.id.single_played_by) TextView preview;
        @BindView(R.id.single_titles) TextView titles;
        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

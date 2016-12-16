package com.masomohub.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.masomohub.R;
import com.masomohub.models.NotesModel;

import java.util.ArrayList;

/**
 * Created by StartappzKE on 16-Dec-16.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private ArrayList<NotesModel> notes;
    public static  String path;
    public NotesAdapter(ArrayList<NotesModel>notes) {
        this.notes = notes;
    }

    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_title.setText(notes.get(i).getFilename());
        viewHolder.tv_size.setText(notes.get(i).getFilesize());
        viewHolder.tv_date.setText(notes.get(i).getDatecreated());
        viewHolder.tv_type.setText(notes.get(i).getFiletype());
        String type = notes.get(i).getFiletype();
        if (type.equals("pdf")||type.equals("PDF")){
            viewHolder.filetype.setImageResource(R.drawable.pdf);
        }
        path= notes.get(i).getFilepath();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_size,tv_date,tv_type;
        private ImageView filetype;
       
        public ViewHolder(View view) {
            super(view);

            tv_title = (TextView)view.findViewById(R.id.title);
            tv_size = (TextView)view.findViewById(R.id.size);
            tv_date = (TextView)view.findViewById(R.id.date);
            tv_type = (TextView)view.findViewById(R.id.type);
            tv_type = (TextView)view.findViewById(R.id.type);
            filetype = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }

}

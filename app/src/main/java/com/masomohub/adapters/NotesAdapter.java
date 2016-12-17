package com.masomohub.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.masomohub.Login;
import com.masomohub.R;
import com.masomohub.models.NotesModel;

import java.util.ArrayList;

/**
 * Created by StartappzKE on 16-Dec-16.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private ArrayList<NotesModel> notes;
    public static String path = "", url_path;
    public NotesAdapter(ArrayList<NotesModel>notes) {
        this.notes = notes;
    }
    private static Context mContext;

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
        path = notes.get(i).getFilepath();
        viewHolder.setListeners(path);
        if (type.equalsIgnoreCase("pdf")){
            viewHolder.filetype.setImageResource(R.drawable.pdf);
        }
        else if (type.startsWith("doc")||type.startsWith("odt")||type.equalsIgnoreCase("doc")){
            viewHolder.filetype.setImageResource(R.drawable.word);
        }
        else if (type.startsWith("xl")){
            viewHolder.filetype.setImageResource(R.drawable.excel);
        }
        else if (type.startsWith("ppt")){
            viewHolder.filetype.setImageResource(R.drawable.powerpoint);
        }
        else if (type.equals("rtf")){
            viewHolder.filetype.setImageResource(R.drawable.rtf);
        } else{
            viewHolder.filetype.setImageResource(R.drawable.pdf);
        }


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_title,tv_size,tv_date,tv_type;
        private ImageView filetype, more;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            mContext=view.getContext();

            tv_title = (TextView)view.findViewById(R.id.title);
            tv_size = (TextView)view.findViewById(R.id.size);
            tv_date = (TextView)view.findViewById(R.id.date);
            tv_type = (TextView)view.findViewById(R.id.type);
            tv_type = (TextView)view.findViewById(R.id.type);
            filetype = (ImageView) view.findViewById(R.id.thumbnail);
            more = (ImageView) view.findViewById(R.id.more);
            cardView = (CardView) view.findViewById(R.id.card_recycler_view);

        }

        public void setListeners(String path) {
            more.setOnClickListener(ViewHolder.this);
            cardView.setOnClickListener(ViewHolder.this);
            url_path = path;
        }



        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.more:

                    /*Intent intent = new Intent(mContext, Login.class);
                    mContext.startActivity(intent);*/
                   // Toast.makeText(mContext, path , Toast.LENGTH_SHORT).show();
                    showPopupMenu(v);
                    break;

                case R.id.card_recycler_view:

                    /*Intent intent = new Intent(mContext, Login.class);
                    mContext.startActivity(intent);*/
                   // Toast.makeText(mContext, path , Toast.LENGTH_SHORT).show();
                    showPopupMenu(v);
                    break;
            }
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.doc_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_download:
                    Toast.makeText(mContext, url_path, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_tag:
                    Toast.makeText(mContext, "tag me", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_library:
                    Toast.makeText(mContext, "add lib", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}

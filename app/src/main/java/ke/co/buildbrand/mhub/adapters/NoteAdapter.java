package ke.co.buildbrand.mhub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ke.co.buildbrand.mhub.R;
import ke.co.buildbrand.mhub.controller.volley.CustomVolleyRequest;
import ke.co.buildbrand.mhub.models.NotesModel;

/**
 * Created by StartappzKE on 29-Dec-16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    //Imageloader to load image
    private ImageLoader imageLoader;
    private Context context;

    //List to store all superheroes
    List<NotesModel> notes;

    //Constructor of this class
    public NoteAdapter(List<NotesModel> notes, Context context){
        super();
        //Getting all superheroes
        this.notes = notes;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.documents, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Getting the particular item from the list
        NotesModel note =  notes.get(position);


        //Showing data on the views
        holder.textViewTitle.setText(note.getFilename());
        holder.textViewDate.setText(note.getDatecreated());
        holder.textViewType.setText(note.getFiletype());
        holder.textViewSize.setText(note.getFilesize());
        String type = note.getFiletype();
        
        if (type.equalsIgnoreCase("pdf")){
            holder.imageView.setImageResource(R.drawable.ic_doc_pdf);
        }
        else if (type.startsWith("doc")||type.startsWith("odt")||type.equalsIgnoreCase("doc")){
            holder.imageView.setImageResource(R.drawable.ic_doc_docx);
        }
        else if (type.startsWith("xl")){
            holder.imageView.setImageResource(R.drawable.ic_doc_xl);
        }
        else if (type.startsWith("ppt")){
            holder.imageView.setImageResource(R.drawable.ic_doc_ppt);
        }
        else if (type.equals("rtf")){
            holder.imageView.setImageResource(R.drawable.ic_doc_rtf);
        } else{
            holder.imageView.setImageResource(R.drawable.ic_doc_rtf);
        }


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Views

        public TextView textViewTitle,textViewDate,textViewType,textViewSize;
          public CircleImageView imageView;
        //Initializing Views
        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDate = (TextView) itemView.findViewById(R.id.date);
            textViewType = (TextView) itemView.findViewById(R.id.type);
            textViewSize = (TextView) itemView.findViewById(R.id.size_);
            imageView=(CircleImageView) itemView.findViewById(R.id.image_doc);
        }
    }
}
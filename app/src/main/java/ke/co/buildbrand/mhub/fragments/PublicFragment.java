package ke.co.buildbrand.mhub.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ke.co.buildbrand.mhub.R;
import ke.co.buildbrand.mhub.adapters.NoteAdapter;
import ke.co.buildbrand.mhub.controller.AppController;
import ke.co.buildbrand.mhub.controller.Config;
import ke.co.buildbrand.mhub.models.NotesModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFragment extends Fragment {


    public PublicFragment() {
        // Required empty public constructor
    }

    View v;

    //Creating a List of superheroes
    private List<NotesModel> listNotes;

    //Creating Views
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //Volley Request Queue
    private RequestQueue requestQueue;

    private String tag_string_req = "string_req";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        v = inflater.inflate(R.layout.fragment_public, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        listNotes = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getActivity());

        //Calling method to get data to fetch data
        getData();

        //Adding an scroll change listener to recyclerview
        //recyclerView.setOnScrollChangeListener(getActivity());

        //initializing our adapter
        adapter = new NoteAdapter(listNotes, getActivity());

        //Adding adapter to recyclerview
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        
        return  v;
    }

    private void getData() {
//   Toast.makeText(getActivity(), customer_order_id, Toast.LENGTH_SHORT).show();
        StringRequest billionaireReq = new StringRequest(Config.DATA_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Log.i("Application Data", response);

                        try {


                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray data= jsonObject.getJSONArray("notesArray");


                            for(int j=0;j<data.length();j++){


                                JSONObject obj = data.getJSONObject(j);


                                NotesModel notemodel = new NotesModel();

                                notemodel.setFilename(obj.getString(Config.TAG_FILE_NAME));
                                notemodel.setFilesize(obj.getString(Config.TAG_FILE_SIZE));
                                notemodel.setFiletype(obj.getString(Config.TAG_FILE_TYPE));
                                notemodel.setFilepath(obj.getString(Config.TAG_FILE_PATH));
                                notemodel.setDatecreated(obj.getString(Config.TAG_CREATED_AT));


                                listNotes.add(notemodel);

                                /*HashMap<String, String> map = new HashMap<String, String>();

                                map.put("title", obj.getString("item"));
                                map.put("description", obj.getString("image_url"));
                                map.put("price",obj.getString("price"));
                                map.put("email",obj.getString("email"));
                                String order_id = obj.getString("email");
                                oslist.add(map);
                                // toolbar.setSubtitle(order_id);*/

                            }





                            //Log.i("Application Data", result.toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//                        pDialog.dismiss();

                        adapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
            }
        });

// Adding request to request queue
        //  AppController.getInstance().addToRequestQueue(billionaireReq);

        AppController.getInstance().addToRequestQueue(billionaireReq, tag_string_req);

        // AppController.getInstance().getRequestQueue().getCache().invalidate(billionaireReq, true);
    }
}

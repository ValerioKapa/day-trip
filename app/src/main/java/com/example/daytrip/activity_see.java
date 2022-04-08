package com.example.daytrip;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class activity_see extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Costumer> costumerArrayList;
    Costumer costumer;
    MyAdapter myAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);

        this.setTitle("See stuff");

        recyclerView = findViewById(R.id.recyclerThing);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        costumerArrayList = new ArrayList<Costumer>();
        myAdapter = new MyAdapter(activity_see.this,costumerArrayList);
        recyclerView.setAdapter(myAdapter);

        //ProgressDialog progressDialog = new ProgressDialog(this);//while the firestore data is beeing loaded, we see this message
        //progressDialog.setCancelable(false);
        //progressDialog.setMessage("Ferno pramata..");
        //progressDialog.show();

        EventChangeListener();
    }

    private void EventChangeListener(){
        db.collection("Trip001").orderBy("sirname", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){
                            //if (progressDialog.isShowing()){
                            //   progressDialog.dismiss();
                            //}
                            Log.e("Firestore error!", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if(dc.getType() == DocumentChange.Type.ADDED){
                                costumerArrayList.add(dc.getDocument().toObject(Costumer.class));
                            }
                            myAdapter.notifyDataSetChanged();
                            //if (progressDialog.isShowing()){
                            //    progressDialog.dismiss();
                            //}
                        }
                    }
                });
    }
}
package com.example.daytrip;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class activity_add extends AppCompatActivity {

    private static final String TAG = "Activity Add";

    private static final String KEY_NAME = "name";
    private static final String KEY_SIRNAME = "sirname";
    //private static final String KEY_TRIP = "trip";
    private static final String KEY_HOTEL = "hotel";

    private EditText editTextName;
    private EditText editTextSirname;
    private EditText editTextTrip;
    private EditText editTextHotel;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.setTitle("Add stuff");

        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextTrip = findViewById(R.id.editTextTextPersonTrip);
        editTextSirname = findViewById(R.id.editTextTextPersonSirname);
        editTextHotel = findViewById(R.id.editTextTextPersonHotel);
    }

    public void saveNote(View v){
        String name = editTextName.getText().toString();
        String sirname = editTextSirname.getText().toString();
        String trip = editTextTrip.getText().toString();
        String hotel = editTextHotel.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_NAME, name);
        note.put(KEY_SIRNAME, sirname);
        note.put(KEY_HOTEL, hotel);

        db.collection(trip).document(sirname+" "+name.charAt(0)).set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(activity_add.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity_add.this,"Erra!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }
}
package org.techtown.drbundo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AskActivity extends AppCompatActivity {

    private ArrayList<AskItem> arrayList;
    private AskAdapter adapter;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Button often;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        recyclerView = (RecyclerView) findViewById(R.id.asklist);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();

        adapter = new AskAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        Button buttonInsert = (Button)findViewById(R.id.addbutton);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AskActivity.this);
                View view = LayoutInflater.from(AskActivity.this).inflate(R.layout.edit_question, null, false);
                builder.setView(view);
                Button ButtonSubmit = (Button) view.findViewById(R.id.complete);
                final EditText editquest = (EditText) view.findViewById(R.id.edit_quest);
                final EditText editanswer = (EditText) view.findViewById(R.id.edit_answer);

                ButtonSubmit.setText("등록");


                final AlertDialog dialog = builder.create();
                ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String quest = editquest.getText().toString();
                        String answer = editanswer.getText().toString();

                        AskItem ai = new AskItem(quest, answer);

                        arrayList.add(0, ai);
                        adapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        often = (Button)findViewById(R.id.often);
        often.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QActivity.class);
                startActivity(intent);
            }
        });

    }

}
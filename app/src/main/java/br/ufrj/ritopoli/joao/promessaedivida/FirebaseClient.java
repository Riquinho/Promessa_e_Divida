package br.ufrj.ritopoli.joao.promessaedivida;


import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;


public class FirebaseClient  {

    Context c;
    String DB_URL;
    ListView listView;
    Firebase firebase;
    ArrayList<Politico> Politicos= new ArrayList<>();
    CustomAdapter customAdapter;


    public  FirebaseClient(Context c, String DB_URL, ListView listView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.listView= listView;


        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    public  void savedata(String name, String url, String idade)
    {
        Politico d= new Politico();
        d.setName(name);
        d.setUrl(url);
        d.setIdade(idade);

        firebase.child("Politico").push().setValue(d);


    }

    public  void refreshdata()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getupdates(DataSnapshot dataSnapshot){

        Politicos.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Politico d= new Politico();
            d.setName(ds.getValue(Politico.class).getName());
            d.setUrl(ds.getValue(Politico.class).getUrl());
            d.setIdade(ds.getValue(Politico.class).getIdade());
            d.setPartido(ds.getValue(Politico.class).getPartido());
            d.setContato(ds.getValue(Politico.class).getContato());
            d.setCargo(ds.getValue(Politico.class).getCargo());
            d.setVotos(ds.getValue(Politico.class).getVotos());
            Politicos.add(d);

        }
        if(Politicos.size()>0)
        {
            customAdapter=new CustomAdapter(c, Politicos);
            listView.setAdapter((ListAdapter) customAdapter);
        }else
        {
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}
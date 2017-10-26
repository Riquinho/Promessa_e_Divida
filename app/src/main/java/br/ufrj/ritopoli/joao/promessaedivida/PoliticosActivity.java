package br.ufrj.ritopoli.joao.promessaedivida;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;

public class PoliticosActivity extends AppCompatActivity {

    final static  String DB_URL= "https://promessa-e-divida-6fe8a.firebaseio.com/";
    ListView listView;
    FirebaseClient firebaseClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=(ListView)findViewById(R.id.listview);
        firebaseClient= new FirebaseClient(this, DB_URL,listView);
        firebaseClient.refreshdata();

    }


}
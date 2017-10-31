package br.ufrj.ritopoli.joao.promessaedivida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VotoActivity extends AppCompatActivity {

    private ExpandableListView expLV;
    private ExpLVAdapter adapter;
    private ArrayList<String> listCategorias;
    private Map<String, ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voto);

        expLV = (ExpandableListView) findViewById(R.id.expLV);
        listCategorias = new ArrayList<>();
        mapChild = new HashMap<>();

        cargarDatos();
    }

    private void cargarDatos(){
        ArrayList<String> listAves = new ArrayList<>();
        ArrayList<String> listMamiferos = new ArrayList<>();
        ArrayList<String> listReptiles = new ArrayList<>();
        ArrayList<String> listPeces = new ArrayList<>();

        listCategorias.add("Aves");
        listCategorias.add("Mamiferos");
        listCategorias.add("Reptiles");
        listCategorias.add("Peces");

        listAves.add("Loro");
        listAves.add("Aguila");
        listAves.add("Pajaros");

        listMamiferos.add("Perro");
        listMamiferos.add("Gato");
        listMamiferos.add("Ballena");

        listReptiles.add("Cocodrilo");
        listReptiles.add("Lagartija");

        listPeces.add("Caballa");
        listPeces.add("Jurel");

        mapChild.put(listCategorias.get(0), listAves);
        mapChild.put(listCategorias.get(1), listMamiferos);
        mapChild.put(listCategorias.get(2), listReptiles);
        mapChild.put(listCategorias.get(3), listPeces);

        adapter = new ExpLVAdapter(this, listCategorias, mapChild);
        expLV.setAdapter(adapter);
    }
}

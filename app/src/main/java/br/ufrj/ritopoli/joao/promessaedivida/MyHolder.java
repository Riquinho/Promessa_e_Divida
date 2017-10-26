package br.ufrj.ritopoli.joao.promessaedivida;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 5/26/2017.
 */

public class MyHolder {

    TextView nameTxt;
    ImageView img;
    TextView idade;
    TextView partido;
    TextView contato;
    TextView cargo;
    TextView votos;

    public MyHolder(View itemView) {


        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img=(ImageView) itemView.findViewById(R.id.PoliticoImage);
        partido= (TextView) itemView.findViewById(R.id.partido);
        contato= (TextView) itemView.findViewById(R.id.contato);
        cargo= (TextView) itemView.findViewById(R.id.cargo);
        votos= (TextView) itemView.findViewById(R.id.votos);


    }
}

package br.ufrj.ritopoli.joao.promessaedivida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 5/26/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Politico> Politicos;
    LayoutInflater inflater;


    public CustomAdapter(Context c, ArrayList<Politico> Politicos) {
        this.c = c;
        this.Politicos = Politicos;
    }





    @Override
    public int getCount() {
        return Politicos.size();
    }

    @Override
    public Object getItem(int i) {
        return Politicos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (inflater== null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } if(convertview==null)
        {
            convertview= inflater.inflate(R.layout.listview_layout,viewGroup,false);

        }

        MyHolder holder= new MyHolder(convertview);
        holder.nameTxt.setText(Politicos.get(i).getName());
        PicassoClient.downloadimg(c,Politicos.get(i).getUrl(),holder.img);



        return convertview;
    }
}
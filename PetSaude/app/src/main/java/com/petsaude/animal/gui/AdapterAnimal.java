package com.petsaude.animal.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.petsaude.R;
import com.petsaude.animal.dominio.Animal;

import java.util.ArrayList;

/**
 * Created by Matheus Uehara on 14/11/2015.
 */
public class AdapterAnimal extends BaseAdapter{

    private LayoutInflater mInflater;
    private ArrayList<Animal> itens;

    public AdapterAnimal(Context context, ArrayList<Animal> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return itens.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Animal getItem(int position)
    {
        return itens.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posção.
        Animal item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.menu_animal_list_view, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.nome_animal)).setText(item.getNome());
        ((TextView) view.findViewById(R.id.raca_animal)).setText(item.getRaca());

        return view;
    }
}
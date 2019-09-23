package com.example.connectsys.ui.cidade;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.connectsys.R;
import com.example.connectsys.classes.cidade.Cidade;
import com.example.connectsys.uteis.Sessao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CidadeFragment extends Fragment {
    private ListView listCidade;
    private Cidade cidade = new Cidade();
    private List<Cidade> cidadeList = new ArrayList<>();

    public CidadeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cidade, container, false);
        listCidade = view.findViewById(R.id.listCidade);
        this.setHasOptionsMenu(true);
        cidadeList = Sessao.retornaCidade();
        ArrayAdapter<Cidade> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, cidadeList);
        listCidade.setEmptyView(view.findViewById(R.id.semdados));
        listCidade.setAdapter(adapter);
        return view;
    }

}

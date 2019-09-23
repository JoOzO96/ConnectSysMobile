package com.example.connectsys.ui.cliente;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.uteis.Sessao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteFragment extends Fragment {

    private ListView listaCliente;

    public ClienteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cliente, container, false);
        listaCliente = view.findViewById(R.id.listCliente);
        Cliente cli = new Cliente();
        List<Cliente> clientes = Sessao.retornaClientes();
        this.setHasOptionsMenu(true);
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, clientes);
        listaCliente.setEmptyView(view.findViewById(R.id.semdados));
        listaCliente.setAdapter(adapter);


        return view;
    }

}

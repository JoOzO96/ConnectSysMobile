package com.example.connectsys.ui.pedido;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import androidx.fragment.app.Fragment;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
import com.example.connectsys.uteis.Sessao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidoDados extends Fragment {
    GetSetDinamicoTelas getSetDinamicoTelas = new GetSetDinamicoTelas();
    List<Field> fieldListPassar = new ArrayList<>(Arrays.asList(PedidoDados.class.getDeclaredFields()));
    private AutoCompleteTextView auNomeCliente;

    public PedidoDados() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pedido_dados, container, false);
        List<Cliente> clienteList = Sessao.retornaClientes();

        auNomeCliente = view.findViewById(R.id.auNomecliente);
        getSetDinamicoTelas.colocaValorEditText(fieldListPassar.get(i), view, fieldListPassar, "", null);


        return view;

    }

}

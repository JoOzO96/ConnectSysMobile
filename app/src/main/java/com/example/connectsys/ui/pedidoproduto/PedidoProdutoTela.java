package com.example.connectsys.ui.pedidoproduto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.connectsys.R;
import com.example.connectsys.classes.produto.Produto;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;
import com.example.connectsys.uteis.SimpleFilterableAdapter;

import java.util.List;

/**
 * Created by Jose on 30/06/2017.
 */

public class PedidoProdutoTela extends DialogFragment {
    private Button btCancelar;
    private Button btSalvar;
    private EditText txquantidade;
    private AutoCompleteTextView auCodproduto;
    private EditText txvalorunitario;
    private EditText txvalortotal;
    //    private Spinner spProduto;
    private Long contaAcessos;
    private Boolean evitaLoop;
    private TextView ultimo_valor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.pop_up_pedido_produto, container);
        contaAcessos = 0L;

        auCodproduto = view.findViewById(R.id.auCodproduto);
        txquantidade = view.findViewById(R.id.txquantidade);
        txvalorunitario = view.findViewById(R.id.txvalorunitario);
        txvalortotal = view.findViewById(R.id.txvalortotal);
        btSalvar = view.findViewById(R.id.btSalvar);
        btCancelar = view.findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostraToast mostraToast = new MostraToast();
                boolean salvar = true;
            }
        });

        List<Produto> listaCidade = Sessao.retornaProduto();
        SimpleFilterableAdapter<Produto> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaCidade);
        auCodproduto.setAdapter(adapter);

        auCodproduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Produto produto = (Produto) adapterView.getItemAtPosition(i);

                produto = produto.retornaProduto(getContext(), produto.getCodproduto());

                txquantidade.setText("");

            }
        });


        if (true == false) {
            txvalortotal.setText("0");
            txvalorunitario.setText("0");
            txquantidade.setText("0");
        }

        return view;
    }


}
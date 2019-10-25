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
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.classes.pedidoproduto.PedidoItem;
import com.example.connectsys.classes.produto.Produto;
import com.example.connectsys.classes.produtoprecotabela.ProdutoPrecoTabela;
import com.example.connectsys.classes.tabelapreco.TabelaPreco;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;
import com.example.connectsys.uteis.SimpleFilterableAdapter;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jose on 30/06/2017.
 */

public class PedidoProdutoTela extends DialogFragment {
    GetSetDinamicoTelas getSetDinamicoTelas = new GetSetDinamicoTelas();
    List<Field> fieldListTela = new ArrayList<>(Arrays.asList(PedidoProdutoTela.class.getDeclaredFields()));
    List<Field> fieldListClasse = new ArrayList<>(Arrays.asList(PedidoItem.class.getDeclaredFields()));
    DecimalFormat format = new DecimalFormat("0.00");
    MostraToast mostraToast = new MostraToast();
    GetSetDinamico getSetDinamico = new GetSetDinamico();
    private PedidoItem pedidoItem = new PedidoItem();
    private Boolean controlaLoop = true;
    private Double quantidade;
    private Double valorunitario;
    private Double valortotal;
    private Button btCancelar;
    private Button btSalvar;
    private EditText txQuantidade;
    private AutoCompleteTextView auCodproduto;
    private EditText txValorunitario;
    private EditText txValortotal;
    private Long codtabela;
    private Long codpedido;
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
        Bundle bundle = Sessao.retornaBundle();
        codtabela = bundle.getLong("codtabela");
        codpedido = bundle.getLong("codpedido");
        auCodproduto = view.findViewById(R.id.auCodproduto);
        txQuantidade = view.findViewById(R.id.txQuantidade);
        txValorunitario = view.findViewById(R.id.txValorunitario);
        txValortotal = view.findViewById(R.id.txValortotal);
        btSalvar = view.findViewById(R.id.btSalvar);
        btCancelar = view.findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Sessao.setaContext(getContext());
        List<Produto> listaCidade = Sessao.retornaProduto();
        SimpleFilterableAdapter<Produto> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaCidade);
        auCodproduto.setAdapter(adapter);


        auCodproduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Produto produto = (Produto) adapterView.getItemAtPosition(i);
                TabelaPreco tabelaPreco = new TabelaPreco();
                ProdutoPrecoTabela produtoPrecoTabela = new ProdutoPrecoTabela();
                produto = produto.retornaProduto(getContext(), produto.getCodproduto());
                produtoPrecoTabela = produtoPrecoTabela.retornaProdutoPrecoTabela(getContext(), produto.getCodproduto(), codtabela);

                if (produtoPrecoTabela.getValor() != null) {
                    txValorunitario.setText(produtoPrecoTabela.getValor().toString());
                } else {
                    txValorunitario.setText("0.00");
                }
                txQuantidade.setText("");
            }
        });

        txQuantidade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (!b) {
                    if (!txQuantidade.getText().equals("") && !txValorunitario.getText().equals("")) {
                        controlaLoop = false;
                        if (txQuantidade.getText().toString().equals("")) {
                            quantidade = 0D;
                        } else {
                            quantidade = Double.parseDouble(txQuantidade.getText().toString());
                        }
                        valorunitario = Double.parseDouble(txValorunitario.getText().toString());
                        valortotal = quantidade * valorunitario;
                        txValortotal.setText(format.format(valortotal));
                    }
                }
            }
        });

        txValorunitario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (!b) {
                    if (!txQuantidade.getText().equals("") && !txValorunitario.getText().equals("")) {
                        controlaLoop = false;
                        if (txQuantidade.getText().toString().equals("")) {
                            quantidade = 0D;
                        } else {
                            quantidade = Double.parseDouble(txQuantidade.getText().toString());
                        }
                        valorunitario = Double.parseDouble(txValorunitario.getText().toString());
                        valortotal = quantidade * valorunitario;
                        txValortotal.setText(format.format(valortotal));
                    }
                }
            }
        });

        txValortotal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (!b) {
                    if (!txQuantidade.getText().equals("") && !txValortotal.getText().equals("")) {
                        controlaLoop = false;
                        if (txQuantidade.getText().toString().equals("")) {
                            quantidade = 0D;
                        } else {
                            quantidade = Double.parseDouble(txQuantidade.getText().toString());
                        }
                        valortotal = Double.parseDouble(txValortotal.getText().toString());
                        valorunitario = valortotal / quantidade;
                        txValorunitario.setText(format.format(valorunitario));
                    }
                }
            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaPedidoItem(view);
                dismiss();
//                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.);
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_self);

//                new PedidoDados().atualizalista(Sessao.retornaContext(),codpedido);
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_self);
//                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.);
//                new PedidoDados().atualizalista(Sessao.retornaContext(),codpedido);
            }
        });

        return view;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private void salvaPedidoItem(View view) {

        for (int i = 0; fieldListTela.size() > i; i++) {
            if (fieldListTela.get(i).getName().substring(0, 2).equals("au") || fieldListTela.get(i).getName().substring(0, 2).equals("tx")) {
                String nomeCampo = "";
                nomeCampo = fieldListTela.get(i).getName();
                if (nomeCampo.toLowerCase().substring(0, 2).equals("tx")) {
                    nomeCampo = nomeCampo.substring(2);
                }
                String valorCampo = "";
                if (!nomeCampo.equals("")) {
                    valorCampo = getSetDinamicoTelas.retornaValorEditText(view, nomeCampo);

                    for (int p = 0; fieldListClasse.size() != p; p++) {
                        if (fieldListClasse.get(p).getName().toLowerCase().equals(nomeCampo.replace("au", "").toLowerCase())) {
                            Object retorno = getSetDinamico.insereField(fieldListClasse.get(p), pedidoItem, valorCampo);
                            pedidoItem = (PedidoItem) retorno;
                        }
                    }
                }
            }
        }
        Produto produto = new Produto();
        produto = new Produto().retornaProduto(getContext(), pedidoItem.getCodproduto());
        if (produto.getCodnaturezapadrao() == 0 && produto.getCodnaturezarevenda() == 0) {
            pedidoItem.setCodnaturezaoperacao(new Pedido().retornaPedido(getContext(), codpedido).getCodnaturezaoperacao());
        } else {
            pedidoItem.setCodnaturezaoperacao(produto.getCodnaturezapadrao()); //SE FOR FINAL VER ISSO
        }

        pedidoItem.setCodpedido(codpedido);
        pedidoItem.cadastraPedidoItem(getContext(), pedidoItem);
    }


}
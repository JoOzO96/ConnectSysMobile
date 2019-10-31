package com.example.connectsys.ui.pedido;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.cliente.ClienteEndereco;
import com.example.connectsys.classes.configuracaogeral.ConfiguracaoGeral;
import com.example.connectsys.classes.formapagto.FormaPagto;
import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.classes.pedidoproduto.PedidoItem;
import com.example.connectsys.classes.praca.Praca;
import com.example.connectsys.classes.produto.Produto;
import com.example.connectsys.classes.tabelapreco.TabelaPreco;
import com.example.connectsys.classes.vendedor.Vendedor;
import com.example.connectsys.ui.pedidoproduto.PedidoProdutoTela;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;
import com.example.connectsys.uteis.SimpleFilterableAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidoDados extends Fragment {
    GetSetDinamicoTelas getSetDinamicoTelas = new GetSetDinamicoTelas();
    List<Field> fieldListTela = new ArrayList<>(Arrays.asList(PedidoDados.class.getDeclaredFields()));
    List<Field> fieldListClasse = new ArrayList<>(Arrays.asList(Pedido.class.getDeclaredFields()));
    boolean salvo = false;
    GetSetDinamico getSetDinamico = new GetSetDinamico();
    private AutoCompleteTextView auCodcliente;
    private AutoCompleteTextView auCodvendedor;
    private AutoCompleteTextView auCodformapagto;
    private AutoCompleteTextView auCodendereco;
    String descricao = "";
    List<PedidoItem> itensPedido = new ArrayList<>();
    private AutoCompleteTextView auCodtabela;
    private TextView txCodpedido;
    private Button btAdicionaritens;
    private Button btCancelar;
    private Button btSalvar;
    private AutoCompleteTextView auCodpraca;
    private Pedido pedido = new Pedido();
    private ListView listItenspedido;
    private List<String> pedidoProdutoList = new ArrayList<>();
    private PedidoItem pedidoItem = new PedidoItem();
    private Produto produto = new Produto();

    public PedidoDados() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pedido_dados, container, false);
        final List<Cliente> clienteList = Sessao.retornaClientes();
        final MostraToast mostraToast = new MostraToast();
        listItenspedido = view.findViewById(R.id.listItenspedido);
        auCodcliente = view.findViewById(R.id.auCodcliente);
        txCodpedido = view.findViewById(R.id.txCodpedido);
        auCodvendedor = view.findViewById(R.id.auCodvendedor);
        auCodendereco = view.findViewById(R.id.auCodendereco);
        auCodformapagto = view.findViewById(R.id.auCodformapagto);
        auCodpraca = view.findViewById(R.id.auCodpraca);
        auCodtabela = view.findViewById(R.id.auCodtabela);
        btAdicionaritens = view.findViewById(R.id.btAdicionaritens);
        btCancelar = view.findViewById(R.id.btCancelar);
        btSalvar = view.findViewById(R.id.btSalvar);
        final Bundle bundle = Sessao.retornaBundle();
        Long codpedido = bundle.getLong("codpedido");
        Sessao.salvaView(view);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaPedido(view, true, false);
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_pop);
            }
        });

        listItenspedido.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                        final PedidoItem pedidoItem = itensPedido.get(i);
                        produto = new Produto().retornaProduto(getContext(), pedidoItem.getCodproduto());
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        builder.setTitle("Confirm");
                        builder.setMessage("Confirma a exclusao do item " + produto.getDescricao() + "?");

                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                MostraToast toast = new MostraToast();
                                boolean retorno = pedidoItem.removerPedidoItem(getContext(), pedidoItem.getCodpedidoitem());
                                if (retorno == true) {
                                    toast.mostraToastShort(getContext(), "Item excluido com sucesso");
                                    Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_self);
                                } else {
                                    toast.mostraToastShort(getContext(), "Erro ao deletar item");
                                }

                                dialog.dismiss();
                            }
                        });

                        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Do nothing
                                dialog.dismiss();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                        return true;
                    }
                }
        );

        listItenspedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                salvo = salvaPedido(view, false, false);

                if (salvo) {
                    FragmentManager fragmentManager = getFragmentManager();
                    PedidoProdutoTela pedidoProdutoTela = new PedidoProdutoTela();
                    Bundle bundle = new Bundle();
                    bundle.putLong("codtabela", Long.parseLong(getSetDinamicoTelas.retornaValorEditText(view, "auCodtabela")));
                    if (txCodpedido.getText().toString().equals("")) {
                        bundle.putLong("codpedido", new Pedido().retornaMaiorCod(getContext()));
                    } else {
                        bundle.putLong("codpedido", Long.parseLong(getSetDinamicoTelas.retornaValorEditText(view, "codpedido")));
                    }

                    bundle.putLong("codproduto", Long.parseLong(listItenspedido.getItemAtPosition(i).toString().substring(0, (listItenspedido.getItemAtPosition(i).toString().indexOf("-") - 1))));
                    Sessao.setBundle(bundle);
                    pedidoProdutoTela.show(fragmentManager, "Pedido Produto");

                }

            }
        });

        if (codpedido > 0) {
            pedido = new Pedido().retornaPedido(getContext(), codpedido);
            for (int i = 0; fieldListTela.size() > i; i++) {
                if (fieldListTela.get(i).getName().substring(0, 2).equals("au")) {

                    if (fieldListTela.get(i).getName().toLowerCase().equals("aucodcliente")) {
                        Sessao.setaContext(getContext());
                        List<Cliente> listaClientes = Sessao.retornaClientes();
                        SimpleFilterableAdapter<Cliente> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaClientes);
                        auCodcliente.setAdapter(adapter);
                        Cliente cliente = new Cliente().retornaCliente(getContext(), pedido.getCodcliente());
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, cliente.toString(), null);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodvendedor")) {
                        Sessao.setaContext(getContext());
                        List<Vendedor> listaVendedores = Sessao.retornaVendedores();
                        SimpleFilterableAdapter<Vendedor> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaVendedores);
                        auCodvendedor.setAdapter(adapter);
                        Vendedor vendedor = new Vendedor().retornaVendedorObjeto(getContext(), pedido.getCodvendedor());
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, vendedor.toString(), null);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodformapagto")) {
                        Sessao.setaContext(getContext());
                        List<FormaPagto> listaFormaPagtos = new FormaPagto().retornaListaFormaPagto(getContext());
                        SimpleFilterableAdapter<FormaPagto> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaFormaPagtos);
                        auCodformapagto.setAdapter(adapter);
                        FormaPagto formaPagto = new FormaPagto().retornaFormapagto(getContext(), pedido.getCodformapagto());
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, formaPagto.toString(), null);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodtabela")) {
                        Sessao.setaContext(getContext());
                        List<TabelaPreco> tabelaPrecos = new TabelaPreco().retornaListaTabelaPrecos(getContext());
                        TabelaPreco tabelaPreco = new TabelaPreco().retornaTabelaPreco(getContext(), pedido.getCodtabela());
                        SimpleFilterableAdapter<TabelaPreco> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, tabelaPrecos);
                        auCodtabela.setAdapter(adapter);
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, tabelaPreco.toString(), null);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodpraca")) {
                        Sessao.setaContext(getContext());
                        List<Praca> pracaList = new Praca().retornaListaPraca(getContext());
                        Praca praca = new Praca().retornaPraca(getContext(), pedido.getCodpraca());
                        SimpleFilterableAdapter<Praca> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, pracaList);
                        auCodpraca.setAdapter(adapter);
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, praca.toString(), null);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodendereco")) {
                        Sessao.setaContext(getContext());
                        List<ClienteEndereco> clienteEnderecos = new ClienteEndereco().retornaClienteEndereco(getContext(), pedido.getCodcliente());
                        ClienteEndereco clienteEndereco = new ClienteEndereco().retornaEndereco(getContext(), pedido.getCodendereco());
                        SimpleFilterableAdapter<ClienteEndereco> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, clienteEnderecos);
                        auCodpraca.setAdapter(adapter);
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, clienteEndereco.toString(), null);
                    }
                } else if (fieldListTela.get(i).getName().substring(0, 2).equals("tx")) {
                    if (fieldListTela.get(i).getName().toLowerCase().equals("txcodpedido")) {
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, pedido.getCodpedido(), null);
                    }
                }

            }
            itensPedido = pedidoItem.retornaItensPedido(getContext(), codpedido);
            for (int i = 0; itensPedido.size() > i; i++) {
                //pedidoProdutoList.add(itensPedido.get(i).toString());
                produto = new Produto().retornaProduto(getContext(), Long.parseLong(itensPedido.get(i).toString()));
                descricao = itensPedido.get(i).getCodproduto() + " - " + produto.getDescricao() + " - Quant: " + itensPedido.get(i).getQuantidade() + " - Vl. Un.: " + itensPedido.get(i).getValorunitario() + " - Vl. Tot.: " + itensPedido.get(i).getValortotal();
                pedidoProdutoList.add(descricao);
                descricao = "";
            }
            ArrayAdapter<String> adapterItens = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, pedidoProdutoList);
            listItenspedido.setAdapter(adapterItens);

        } else {


            for (int i = 0; fieldListTela.size() > i; i++) {
                if (fieldListTela.get(i).getName().substring(0, 2).equals("au")) {

                    if (fieldListTela.get(i).getName().toLowerCase().equals("aucodcliente")) {
                        Sessao.setaContext(getContext());
                        List<Cliente> listaClientes = Sessao.retornaClientes();
                        SimpleFilterableAdapter<Cliente> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaClientes);
                        auCodcliente.setAdapter(adapter);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodvendedor")) {
                        Sessao.setaContext(getContext());
                        List<Vendedor> listaVendedores = Sessao.retornaVendedores();
                        SimpleFilterableAdapter<Vendedor> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaVendedores);
                        auCodvendedor.setAdapter(adapter);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodformapagto")) {
                        Sessao.setaContext(getContext());
                        List<FormaPagto> listaFormaPagtos = new FormaPagto().retornaListaFormaPagto(getContext());
                        SimpleFilterableAdapter<FormaPagto> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaFormaPagtos);
                        auCodformapagto.setAdapter(adapter);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodtabela")) {
                        Sessao.setaContext(getContext());
                        List<TabelaPreco> tabelaPrecos = new TabelaPreco().retornaListaTabelaPrecos(getContext());
                        SimpleFilterableAdapter<TabelaPreco> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, tabelaPrecos);
                        auCodtabela.setAdapter(adapter);
                    } else if (fieldListTela.get(i).getName().toLowerCase().equals("aucodpraca")) {
                        Sessao.setaContext(getContext());
                        List<Praca> pracaList = new Praca().retornaListaPraca(getContext());
                        SimpleFilterableAdapter<Praca> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, pracaList);
                        auCodpraca.setAdapter(adapter);
                    }

                }
            }
        }

        auCodcliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cliente cliente = clienteList.get(i);
                List<ClienteEndereco> clienteEndereco = new ClienteEndereco().retornaClienteEndereco(getContext(), cliente.getCodcliente());
                SimpleFilterableAdapter<ClienteEndereco> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, clienteEndereco);
                auCodendereco.setAdapter(adapter);
                auCodendereco.setText(clienteEndereco.get(0).toString());
            }
        });


        btAdicionaritens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvo = salvaPedido(view, false, false);

                if (salvo) {
                    FragmentManager fragmentManager = getFragmentManager();
                    PedidoProdutoTela pedidoProdutoTela = new PedidoProdutoTela();
                    Bundle bundle = new Bundle();
                    bundle.putLong("codtabela", Long.parseLong(getSetDinamicoTelas.retornaValorEditText(view, "auCodtabela")));
                    if (txCodpedido.getText().toString().equals("")) {
                        bundle.putLong("codpedido", new Pedido().retornaMaiorCod(getContext()));
                    } else {
                        bundle.putLong("codpedido", Long.parseLong(getSetDinamicoTelas.retornaValorEditText(view, "codpedido")));
                    }
                    bundle.putLong("codproduto", 0L);
                    Sessao.setBundle(bundle);

//                    Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_to_popup_pedido);
                    pedidoProdutoTela.show(fragmentManager, "Pedido Produto");

                }

            }
        });
        return view;

    }

    private boolean salvaPedido(View view, boolean voltarparalista, boolean imprimir) {
        for (int i = 0; fieldListTela.size() > i; i++) {
            if (fieldListTela.get(i).getName().substring(0, 2).equals("au")) {
                String nomeCampo = "";
                nomeCampo = fieldListTela.get(i).getName();
                nomeCampo = nomeCampo.substring(2);
                String valorCampo = "";
                if (!nomeCampo.equals("")) {
                    valorCampo = getSetDinamicoTelas.retornaValorEditText(view, fieldListTela.get(i).getName());

                    for (int p = 0; fieldListClasse.size() != p; p++) {
                        if (fieldListClasse.get(p).getName().toLowerCase().equals(nomeCampo.toLowerCase())) {
                            Object retorno = getSetDinamico.insereField(fieldListClasse.get(p), pedido, valorCampo);
                            pedido = (Pedido) retorno;
                        }
                    }
                }
            }
        }
        ConfiguracaoGeral configuracaoGeral = new ConfiguracaoGeral();
        configuracaoGeral = configuracaoGeral.retornaConfiguracaoGeral(getContext(), 4L);
        pedido.setCodnaturezaoperacao(configuracaoGeral.getCodcfoppadraoproduto());
        Cliente cliente = new Cliente().retornaCliente(getContext(), pedido.getCodcliente());
        FormaPagto formaPagto = new FormaPagto().retornaFormapagto(getContext(), pedido.getCodformapagto());
        Vendedor vendedor = new Vendedor().retornaVendedorObjeto(getContext(), pedido.getCodvendedor());
        if (!cliente.equals(new Cliente())) {
            pedido.setNomecliente(cliente.getRazaosocial());
        }
        pedido.setCodemitente(1L);
        pedido.setData(new Date());
        pedido.setOrcamentopedido("Pedido");
        pedido.setCodrepresentante(vendedor.getCodvendedor());
        pedido.getUsuario();
        salvo = pedido.cadastraPedido(getContext(), pedido);
        if (voltarparalista) {
            Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_pop);
        }
        return salvo;
    }

//    public void atualizalista(Context context,  Long codpedido){
//        pedidoProdutoList = new ArrayList<>();
//        itensPedido = pedidoItem.retornaItensPedido(context, codpedido);
//        for (int i = 0; itensPedido.size() > i; i++) {
//            //pedidoProdutoList.add(itensPedido.get(i).toString());
//            produto = new Produto().retornaProduto(context, Long.parseLong(itensPedido.get(i).toString()));
//            descricao = itensPedido.get(i).getCodproduto() + " - " + produto.getDescricao() + " - Quant: " + itensPedido.get(i).getQuantidade() + " - Vl. Un.: " + itensPedido.get(i).getValorunitario() + " - Vl. Tot.: " + itensPedido.get(i).getValortotal();
//            pedidoProdutoList.add(descricao);
//            descricao = "";
//        }
//        ArrayAdapter<String> adapterItens = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, pedidoProdutoList);
//        listItenspedido.setAdapter(adapterItens);
//    }

}

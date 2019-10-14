package com.example.connectsys.ui.pedido;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.formapagto.FormaPagto;
import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.classes.vendedor.Vendedor;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
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
    private TextView txCodpedido;
    private Button btAdicionaritens;
    private Button btCancelar;
    private Button btSalvar;
    private Pedido pedido = new Pedido();

    public PedidoDados() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pedido_dados, container, false);
        List<Cliente> clienteList = Sessao.retornaClientes();

        auCodcliente = view.findViewById(R.id.auCodcliente);
        auCodvendedor = view.findViewById(R.id.auCodvendedor);
        auCodformapagto = view.findViewById(R.id.auCodformapagto);
        btAdicionaritens = view.findViewById(R.id.btAdicionaritens);
        btCancelar = view.findViewById(R.id.btCancelar);
        btSalvar = view.findViewById(R.id.btSalvar);
        Bundle bundle = Sessao.retornaBundle();
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
                    }
                } else if (fieldListTela.get(i).getName().substring(0, 2).equals("tx")) {
                    if (fieldListTela.get(i).getName().toLowerCase().equals("txcodpedido")) {
                        getSetDinamicoTelas.colocaValorEditText(fieldListTela.get(i), view, fieldListTela, pedido.getCodpedido(), null);
                    }
                }

            }


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
                    }

                }
            }
        }

        btAdicionaritens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvo = salvaPedido(view, false, false);

                if (salvo) {

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

        Cliente cliente = new Cliente().retornaCliente(getContext(), pedido.getCodcliente());
        FormaPagto formaPagto = new FormaPagto().retornaFormapagto(getContext(), pedido.getCodformapagto());
        Vendedor vendedor = new Vendedor().retornaVendedorObjeto(getContext(), pedido.getCodvendedor());
        if (!cliente.equals(new Cliente())) {
            pedido.setNomecliente(cliente.getRazaosocial());
        }
        pedido.setData(new Date());

        salvo = pedido.cadastraPedido(getContext(), pedido);


        if (voltarparalista) {
            Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_dados_pop);
        }
        return salvo;
    }

}

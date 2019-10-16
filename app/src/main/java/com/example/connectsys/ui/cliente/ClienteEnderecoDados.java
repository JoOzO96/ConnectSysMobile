package com.example.connectsys.ui.cliente;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.bairro.Bairro;
import com.example.connectsys.classes.cidade.Cidade;
import com.example.connectsys.classes.cliente.ClienteEndereco;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
import com.example.connectsys.uteis.Mascara;
import com.example.connectsys.uteis.Sessao;
import com.example.connectsys.uteis.SimpleFilterableAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteEnderecoDados extends Fragment {
    ClienteEndereco clienteEndereco = new ClienteEndereco();
    GetSetDinamico getSetDinamico = new GetSetDinamico();
    GetSetDinamicoTelas getSetDinamicoTelas = new GetSetDinamicoTelas();
    private EditText txCodendereco;
    private EditText txNumero;
    private EditText txEndereco;
    private EditText txComplemento;
    private EditText txBairro;
    private EditText txCep;
    private EditText txInscricaoestadual;
    private EditText txFone;
    private AutoCompleteTextView auCodcidade;
    private AutoCompleteTextView auCodbairro;
    private Button btCancelar;
    private Button btSalvar;

    public ClienteEnderecoDados() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cliente_endereco_dados, container, false);
        Bundle bundle = Sessao.retornaBundle();
        btCancelar = view.findViewById(R.id.btCancelar);
        btSalvar = view.findViewById(R.id.btSalvar);
        final Long codcliente = bundle.getLong("codcliente");
        Long codendereco = bundle.getLong("codendereco");

        if (codendereco == 0) {
            preencheComDados(view, codcliente, 0L);
        } else {
            preencheComDados(view, codcliente, codendereco);
        }
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_nav_cliente_endereco_dados_pop);
            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (salvaCadastro(view, codcliente)) {
                    Navigation.findNavController(view).navigate(R.id.action_nav_cliente_endereco_dados_pop);
                }
            }
        });
        return view;
    }

    private boolean salvaCadastro(View view, Long codcliente) {
        List<Field> fieldList = new ArrayList<Field>(Arrays.asList(ClienteEndereco.class.getDeclaredFields()));
        String valorCampo = "";
        String nomecampo = "";
        for (int i = 0; fieldList.size() != i; i++) {
            valorCampo = "";
            nomecampo = fieldList.get(i).getName();
            if (nomecampo.equals("codbairro")) {
                nomecampo = "auCodbairro";
                Sessao.setaContext(getContext());
                valorCampo = getSetDinamicoTelas.retornaValorEditTextCadastro(view, nomecampo);
            } else {
                if (nomecampo.equals("codcidade")) {
                    nomecampo = "auCodcidade";
                }
                valorCampo = getSetDinamicoTelas.retornaValorEditText(view, nomecampo);
            }

            if (fieldList.get(i).getName().equals("fone")) {
                valorCampo = Mascara.unmask(valorCampo);
            }
            if (fieldList.get(i).getName().equals("cep")) {
                valorCampo = Mascara.unmask(valorCampo);
            }
            if (valorCampo != null) {
                Object retorno = null;
                retorno = getSetDinamico.insereField(fieldList.get(i), clienteEndereco, valorCampo);
                clienteEndereco = (ClienteEndereco) retorno;
            }


        }

        clienteEndereco.setCodcliente(codcliente);
        return clienteEndereco.cadastraClienteEndereco(getContext(), clienteEndereco);
    }

    private void preencheComDados(View view, Long codcliente, Long codendereco) {
        if (!codendereco.equals(0L)) {
            clienteEndereco = new ClienteEndereco().retornaEndereco(getContext(), codendereco);
        }
        List<Field> fieldListPassar = new ArrayList<>(Arrays.asList(ClienteEnderecoDados.class.getDeclaredFields()));
        String mascara = null;
        String nomecampo = "";
        String tipo;
        Object retorno;

        for (int i = 0; fieldListPassar.size() != i; i++) {

            if (fieldListPassar.get(i).getName().toLowerCase().equals("$change") ||
                    fieldListPassar.get(i).getName().toLowerCase().equals("serialversionuid")) {
            } else {
                if (fieldListPassar.get(i).getName().substring(0, 2).equals("tx")) {
                    tipo = getSetDinamico.retornaTipoCampo(fieldListPassar.get(i));
                    nomecampo = fieldListPassar.get(i).getName().replace("tx", "").toLowerCase();
                    mascara = null;
                    if (nomecampo.equals("cep")) {
                        mascara = "#####-###";
                    }
                    if (nomecampo.equals("fone")) {
                        mascara = "(##)#####-####";
                    }

                    retorno = getSetDinamico.retornaValorCampoTela(fieldListPassar.get(i).getName().replace("tx", "").toLowerCase(), clienteEndereco);
                    if (retorno != null) {
                        getSetDinamicoTelas.colocaValorEditText(fieldListPassar.get(i), view, fieldListPassar, retorno.toString(), mascara);
                    } else {
                        getSetDinamicoTelas.colocaValorEditText(fieldListPassar.get(i), view, fieldListPassar, "", mascara);
                    }
                } else if (fieldListPassar.get(i).getName().substring(0, 2).equals("au")) {

                    if (fieldListPassar.get(i).getName().equals("auCodcidade")) {
                        auCodcidade = (AutoCompleteTextView) getSetDinamicoTelas.retornaIDCampo(view, "auCodcidade");
                        List<Cidade> listaCidade = Sessao.retornaCidade();
                        SimpleFilterableAdapter<Cidade> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, listaCidade);
                        auCodcidade.setAdapter(adapter);
                        if (clienteEndereco.getCodcidade() != null) {
                            auCodcidade.setText(new Cidade().retornaCidadeObjeto(getContext(), clienteEndereco.getCodcidade()).toString());
                        }
                    } else if (fieldListPassar.get(i).getName().equals("auCodbairro")) {
                        auCodbairro = (AutoCompleteTextView) getSetDinamicoTelas.retornaIDCampo(view, "auCodbairro");
                        List<Bairro> bairros = Sessao.retornaBairros();
                        SimpleFilterableAdapter<Bairro> adapter = new SimpleFilterableAdapter<>(getContext(), android.R.layout.simple_list_item_1, bairros);
                        auCodbairro.setAdapter(adapter);
                        if (clienteEndereco.getCodbairro() != null) {
                            auCodbairro.setText(new Bairro().retornaBairro(getContext(), clienteEndereco.getCodbairro()).toString());
                        }
                    }

                }

            }
        }
    }

}

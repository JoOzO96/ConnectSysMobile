package com.example.connectsys.ui.cliente;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.cliente.ClienteEndereco;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.GetSetDinamicoTelas;
import com.example.connectsys.uteis.Mascara;
import com.example.connectsys.uteis.Sessao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteDados extends Fragment {
    Cliente cliente = new Cliente();
    List<ClienteEndereco> clienteEnderecos = new ArrayList<>();
    GetSetDinamico getSetDinamico = new GetSetDinamico();
    GetSetDinamicoTelas getSetDinamicoTelas = new GetSetDinamicoTelas();
    private ListView listEnderecos;
    private EditText txCodcliente;
    private EditText txRazaosocial;
    private EditText txNomefantasia;
    private EditText txInscricaoestadual;
    private EditText txFone;
    private EditText txEmail;
    private EditText txEmailnfe;
    private EditText txObs;
    private EditText txCnpj;
    private EditText txCpf;
    private CheckBox ckFisica;
    private CheckBox ckJuridica;
    private CheckBox ckEnviarxml;
    private CheckBox ckEnviarpdf;
    private CheckBox ckConsumidorfinal;
    private Button btCancelar;
    private Button btSalvar;
    private Button btCadastroendereco;

    public ClienteDados() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cliente_dados, container, false);
        final Bundle bundle = Sessao.retornaBundle();
        Long codigoCliente = bundle.getLong("codcliente");
        btCancelar = view.findViewById(R.id.btCancelar);
        btSalvar = view.findViewById(R.id.btSalvar);
        btCadastroendereco = view.findViewById(R.id.btCadastroendereco);
        ckFisica = view.findViewById(R.id.ckFisica);
        ckJuridica = view.findViewById(R.id.ckJuridica);
        txCnpj = view.findViewById(R.id.txCnpj);
        txCpf = view.findViewById(R.id.txCpf);
        ckEnviarxml = view.findViewById(R.id.ckEnviarxml);
        ckEnviarpdf = view.findViewById(R.id.ckEnviarpdf);
        listEnderecos = view.findViewById(R.id.listEnderecos);
        Sessao.salvaView(view);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_nav_cliente_dados_pop);
            }
        });
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaCadastro(view);
                Navigation.findNavController(view).navigate(R.id.action_nav_cliente_dados_pop);
            }
        });
        if (codigoCliente > 0) {

            preencheComDados(view, codigoCliente);

        } else {

            preencheComDados(view, codigoCliente);

        }

        ckFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ckJuridica.setChecked(false);
                txCnpj.setEnabled(false);
                txCpf.setEnabled(true);
            }
        });

        ckJuridica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ckFisica.setChecked(false);
                txCpf.setEnabled(false);
                txCnpj.setEnabled(true);
            }
        });

        btCadastroendereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaCadastro(view);
                Bundle bundle = new Bundle();
                bundle.putLong("codcliente", cliente.getCodcliente());
                bundle.putLong("codendereco", 0L);
                Sessao.setBundle(bundle);
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_cliente_dados_to_nav_cliente_endereco_dados);
            }
        });

        listEnderecos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                ClienteEndereco clienteEndereco = (ClienteEndereco) listEnderecos.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putLong("codcliente", cliente.getCodcliente());
                bundle.putLong("codendereco", clienteEndereco.getCodendereco());
                Sessao.setBundle(bundle);
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_cliente_dados_to_nav_cliente_endereco_dados);
            }
        });

        return view;
    }


    private void salvaCadastro(View view) {
        List<Field> fieldList = new ArrayList<Field>(Arrays.asList(Cliente.class.getDeclaredFields()));
        String valorCampo = "";
        String nomecampo = "";
        for (int i = 0; fieldList.size() != i; i++) {
            valorCampo = "";
            nomecampo = fieldList.get(i).getName();
            if (fieldList.get(i).getType().getSimpleName().toUpperCase().equals("BOOLEAN")) {
                valorCampo = getSetDinamicoTelas.retornaValorEditText(view, nomecampo);
            } else {
                valorCampo = getSetDinamicoTelas.retornaValorEditText(view, nomecampo);
            }
            if (fieldList.get(i).getName().equals("fone")) {
                valorCampo = Mascara.unmask(valorCampo);
            }
            if (fieldList.get(i).getName().equals("cpf")) {
                valorCampo = Mascara.unmask(valorCampo);
            }
            if (fieldList.get(i).getName().equals("cnpj")) {
                valorCampo = Mascara.unmask(valorCampo);
            }
            if (valorCampo != null) {
                Object retorno = null;
                retorno = getSetDinamico.insereField(fieldList.get(i), cliente, valorCampo);
                cliente = (Cliente) retorno;
            }

        }

        if (!ckFisica.isChecked()) {
            cliente.setFisicajuridica("Jurídica");
            cliente.setCpf("");
        } else {
            cliente.setFisicajuridica("Física");
            cliente.setCnpj("");
        }

        cliente.cadastraCliente(getContext(), cliente, false);
        if (cliente.getCodcliente() == null) {
            cliente = cliente.retornaCliente(getContext(), cliente.retornaMaiorCod(getContext()));
        }
        Sessao.atualizaListaCliente(cliente);
//        Navigation.findNavController(view).navigate(R.id.action_nav_cliente_dados_pop);
    }

    private void preencheComDados(View view, Long codigoCliente) {

        List<Field> fieldListPassar = new ArrayList<>(Arrays.asList(ClienteDados.class.getDeclaredFields()));
        if (codigoCliente > 0) {
            cliente = new Cliente().retornaCliente(getContext(), codigoCliente);
        }
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
                    if (nomecampo.equals("cpf")) {
                        mascara = "###.###.###-##";
                    }
                    if (nomecampo.equals("fone")) {
                        mascara = "(##)#####-####";
                    }
                    if (nomecampo.equals("cnpj")) {
                        mascara = "##.###.###/####-##";
                    }

                    retorno = getSetDinamico.retornaValorCampoTela(fieldListPassar.get(i).getName().replace("tx", "").toLowerCase(), cliente);
                    if (retorno != null) {
                        getSetDinamicoTelas.colocaValorEditText(fieldListPassar.get(i), view, fieldListPassar, retorno.toString(), mascara);
                    } else {
                        getSetDinamicoTelas.colocaValorEditText(fieldListPassar.get(i), view, fieldListPassar, "", mascara);
                    }
                } else if (fieldListPassar.get(i).getName().substring(0, 2).equals("ck")) {
                    if (fieldListPassar.get(i).getName().equals("ckFisica") || fieldListPassar.get(i).getName().equals("ckJuridica")) {
                        if (!cliente.equals(new Cliente())) {
                            if (cliente.getFisicajuridica().equals("Física")) {
                                ckFisica.setChecked(true);
                                txCnpj.setEnabled(false);
                                txCpf.setEnabled(true);
                            } else {
                                ckJuridica.setChecked(true);
                                txCpf.setEnabled(false);
                                txCnpj.setEnabled(true);
                            }
                        }

                    } else {
                        retorno = getSetDinamico.retornaValorCampoTela(fieldListPassar.get(i).getName().replace("ck", "").toLowerCase(), cliente);
                        getSetDinamicoTelas.colocaValorCheckBox(fieldListPassar.get(i), view, fieldListPassar, retorno);
                    }
                } else if (fieldListPassar.get(i).getName().equals("listEnderecos")) {
                    clienteEnderecos = new ClienteEndereco().retornaListaClienteEndereco(getContext(), codigoCliente);
                    ArrayAdapter<ClienteEndereco> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, clienteEnderecos);
                    listEnderecos.setAdapter(adapter);
                }
            }
        }

    }

}

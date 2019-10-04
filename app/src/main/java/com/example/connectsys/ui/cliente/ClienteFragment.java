package com.example.connectsys.ui.cliente;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteFragment extends Fragment {
    private Cliente cliente = new Cliente();
    private ListView listaCliente;

    public ClienteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cliente, container, false);
        listaCliente = view.findViewById(R.id.listCliente);
        Cliente cli = new Cliente();
        List<Cliente> clientes = Sessao.retornaClientes();
        this.setHasOptionsMenu(true);
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, clientes);
        listaCliente.setEmptyView(view.findViewById(R.id.semdados));
        listaCliente.setAdapter(adapter);

        listaCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Cliente cliente1 = (Cliente) listaCliente.getItemAtPosition(i);
                ClienteDados clienteDados = new ClienteDados();

                //VERIFICA SE O CLIENTE FOI CADASTRADO E NAO SINCRONIZADO AINDA PARA NAO PODER EDITAR ANTES DE SINCRONIZAR

                cliente = cliente.retornaCliente(getContext(), cliente1.getCodcliente());

                if (cliente.getCadastroandroid() == true) {
                    MostraToast mostraToast = new MostraToast();
                    mostraToast.mostraToastLong(getContext(), "Não é possivel alterar um cliente que foi cadastrado no sistema, antes de sincronizar com o servidor.");

                } else {
                    Bundle bundle = new Bundle();
                    bundle.putLong("codcliente", cliente1.getCodcliente());
                    Sessao.setBundle(bundle);
                    Navigation.findNavController(view).navigate(R.id.action_nav_cliente_to_nav_cliente_dados);
//                    fragmentTransaction.
                }
            }
        });
        Sessao.salvaView(view);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.cliente_opcoes, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cliente_opcoes) {
            ClienteDados clienteDados = new ClienteDados();
            Bundle bundle = new Bundle();
            bundle.putLong("codcliente", -1L);
            Sessao.setBundle(bundle);
            Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_cliente_to_nav_cliente_dados);
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.connectsys.ui.pedido;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.connectsys.R;
import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.uteis.Sessao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidoFragment extends Fragment {
    List<Pedido> pedidoList = new ArrayList<>();
    private ListView listaPedido;

    public PedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pedido, container, false);
        this.setHasOptionsMenu(true);
        pedidoList = new Pedido().retornaListaPedido(getContext());
        listaPedido = view.findViewById(R.id.listPedido);
        listaPedido.setEmptyView(view.findViewById(R.id.semdados));
        ArrayAdapter<Pedido> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, pedidoList);
        listaPedido.setAdapter(adapter);
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
            Bundle bundle = new Bundle();
            bundle.putLong("codpedido", -1L);
            Sessao.setBundle(bundle);
            Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_to_nav_pedido_dados);
        }

        return super.onOptionsItemSelected(item);
    }
}

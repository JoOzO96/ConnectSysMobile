package com.example.connectsys.ui.pedido;


import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.uteis.MostraToast;
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

        listaPedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Pedido pedido = (Pedido) listaPedido.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putLong("codpedido", pedido.getCodpedido());
                Sessao.setBundle(bundle);
                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.action_nav_pedido_to_nav_pedido_dados);
            }
        });

        listaPedido.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v, int i, long l) {
                final Pedido pedido = (Pedido) listaPedido.getItemAtPosition(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Confirma a exclusao do pedido " + pedido.getCodpedido() + "?");

                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        MostraToast toast = new MostraToast();
                        boolean retorno = pedido.removerPedido(getContext(), pedido.getCodpedido());
                        if (retorno == true) {
//                            retorno = pedido.removerPedidoProduto(getContext(), pedido.getCodpedido());
                            if (retorno == true) {
                                toast.mostraToastShort(getContext(), "Pedido excluido com sucesso");
                                Navigation.findNavController(Sessao.retornaView()).navigate(R.id.nav_pedido);
                            } else {
                                toast.mostraToastShort(getContext(), "Erro ao deletar pedido");
                            }
                            dialog.dismiss();
                        } else {
                            toast.mostraToastShort(getContext(), "Erro ao deletar pedido");
                        }
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
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

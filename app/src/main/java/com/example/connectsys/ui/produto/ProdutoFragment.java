package com.example.connectsys.ui.produto;


import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.connectsys.R;
import com.example.connectsys.classes.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFragment extends Fragment {
    List<Produto> produtoList = new ArrayList<>();
    private ListView listaProduto;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    public static ProdutoFragment newInstance() {
        return new ProdutoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.produto_fragment, container, false);
        listaProduto = view.findViewById(R.id.listProduto);
        this.setHasOptionsMenu(true);

        Produto produto = new Produto();

        Cursor cursor = produto.retornaProduto(getContext());

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            for (Long cont = 0L; cursor.getCount() != cont; cont++) {

                produto = new Produto();
                produto.setCodproduto(cursor.getLong(cursor.getColumnIndex("codproduto")));
                produto.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
                cursor.moveToNext();
                produtoList.add(produto);
            }

            cursor.close();
            ArrayAdapter<Produto> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, produtoList);
            listaProduto.setAdapter(adapter);
            listaProduto.setEmptyView(view.findViewById(R.id.semdados));

        }
        return view;
    }
}

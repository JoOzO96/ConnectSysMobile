package com.example.connectsys.ui.sincroniza;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.connectsys.R;
import com.example.connectsys.sincronizacao.Sincroniza;
import com.example.connectsys.uteis.Sessao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SincronizaFragment extends Fragment {

    private ProgressBar progressBar;
    private TextView textoSinc;


    public SincronizaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sincroniza, container, false);
        List<String> listString = new ArrayList<>();
        progressBar = view.findViewById(R.id.progressBar);
        textoSinc = view.findViewById(R.id.textoSinc);
        Sessao.setTextView(textoSinc);
        Sessao.setProgressBar(progressBar);
        final Handler handler = new Handler();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Sessao.setHandler(handler);
                Sincroniza sincroniza = new Sincroniza();
                sincroniza.iniciaSincronizacao(Sessao.retornaContext());
            }
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        return view;
    }

}

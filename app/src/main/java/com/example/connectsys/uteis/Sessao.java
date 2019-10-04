package com.example.connectsys.uteis;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.connectsys.classes.cidade.Cidade;
import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.main.MainActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sessao {
    private static Thread thread;
    private static Handler handler;
    private static ProgressBar progressBar;
    private static List<Cliente> listCliente = new ArrayList<>();
    private static List<Cidade> listCidade = new ArrayList<>();
    private static TextView textoSinc;
    private static Sessao instance;
    private static Context contextSalvo;
    private static ProgressDialog progressDialog;
    private static Bundle bundleSalvo;
    private static View viewSalva;

    private Sessao() {
    }

    public static void salvaView(View view) {
        viewSalva = view;
    }

    public static View retornaView() {
        return viewSalva;
    }

    public static void setBundle(Bundle bundle) {
        bundleSalvo = bundle;
    }

    public static Bundle retornaBundle() {
        return bundleSalvo;
    }

    public static List<Cliente> retornaClientes() {
        if (listCliente.size() == 0) {
            Cliente cliente = new Cliente();
            listCliente = cliente.retornaListaCliente(contextSalvo, true);
        }
        return listCliente;
    }

    public static List<Cidade> retornaCidade() {
        if (listCidade.size() == 0) {
            Cidade cidade = new Cidade();
            listCidade = cidade.retornaListaCidade(contextSalvo);
        }
        return listCidade;
    }

    public static Double retornaFormatado(Double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.parseDouble(decimalFormat.format(numero).replace(",", "."));
    }

    public static Sessao getInstance() {
        if (instance == null)
            instance = new Sessao();
        return instance;
    }

    public static void setInstance(Sessao instance) {
        Sessao.instance = instance;
    }

    public static TextView getTextView() {
        return textoSinc;
    }

    public static void setTextView(TextView texto) {
        textoSinc = texto;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void setHandler(Handler h) {
        handler = h;
    }

    public static ProgressBar getProgressBar() {
        return progressBar;
    }

    public static void setProgressBar(ProgressBar p) {
        progressBar = p;
    }

    public static void colocaTexto(final String texto) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textoSinc.setText(texto);
            }
        });

    }

    public static ProgressDialog getProgress() {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(contextSalvo);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        return progressDialog;
    }

    public static ProgressDialog getProgress(String titulo) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(contextSalvo);
            progressDialog.setTitle(titulo);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            if (!progressDialog.isShowing()) {
                progressDialog.show();
            }
        }
        return progressDialog;
    }

    public static void removeProgress() {
        progressDialog = null;
    }

    public static void setaContext(Context context) {
        contextSalvo = context;
    }

    public static Context retornaContext() {
        return contextSalvo;
    }

    public static void colocaTextoProgress(String mensagem) {
        if (mensagem.length() > 28) {
            progressDialog.setMessage(mensagem.substring(0, 28));
        } else {
            progressDialog.setMessage(mensagem);
        }
    }

    public static void terminaProgress() {
        Intent intent = new Intent(contextSalvo, MainActivity.class);
        contextSalvo.startActivity(intent);
    }

    public static void iniciaProgress() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    public static void atualizaListaCliente(Cliente cliente) {
        boolean encontrou = false;
        for (int i = 0; listCliente.size() > i; i++) {
            if (listCliente.get(i).getCodcliente().equals(cliente.getCodcliente())) {
                listCliente.set(i, cliente);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            listCliente.add(cliente);
        }
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        Sessao.progressDialog = progressDialog;
    }



/*
    Pode criar outros métodos que precise aqui, como getters e setters.
    */
}

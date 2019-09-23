package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;

/**
 * Created by Jose on 26/05/2017.
 */

public class Sincroniza {

    public void iniciaSincronizacao(final Context context) {


        SincMac sincMac = new SincMac();
        SincCidade sincCidade = new SincCidade();
        SincProduto sincProduto = new SincProduto();
        SincCliente sincCliente = new SincCliente();
        SincClienteEndereco sincClienteEndereco = new SincClienteEndereco();
        String ip = null;
        Sessao.iniciaProgress();
        Sessao.colocaTexto("Verificando dados do IP.");

        ip = sincMac.iniciasinc(context);
        if (ip == null) {
            Sessao.terminaProgress();
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "ERRO AO OBTER O IP");
        } else {
            sincCidade.iniciaAsinc(context, ip);
            sincProduto.iniciaASinc(context, ip);
            sincCliente.iniciaAsinc(context, ip);
            sincClienteEndereco.iniciaAsinc(context, ip);
            Sessao.terminaProgress();
        }
    }


}



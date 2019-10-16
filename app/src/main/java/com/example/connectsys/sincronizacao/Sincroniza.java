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
        SincBairro sincBairro = new SincBairro();
        SincProduto sincProduto = new SincProduto();
        SincCliente sincCliente = new SincCliente();
        SincClienteEndereco sincClienteEndereco = new SincClienteEndereco();
        SincFormaPagto sincFormaPagto = new SincFormaPagto();
        SincVendedor sincVendedor = new SincVendedor();
        SincProdutoPrecoTabela sincProdutoPrecoTabela = new SincProdutoPrecoTabela();
        SincTabelaPreco sincTabelaPreco = new SincTabelaPreco();
        String ip = null;
        Sessao.iniciaProgress();
        Sessao.colocaTexto("Verificando dados do IP.");

        ip = sincMac.iniciasinc(context);
        if (ip == null) {
            Sessao.terminaProgress();
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "ERRO AO OBTER O IP");
        } else {
            sincProduto.iniciaASinc(context, ip);
            sincProdutoPrecoTabela.iniciaAsinc(context, ip);
            sincTabelaPreco.iniciaAsinc(context, ip);
            sincCliente.iniciaAsinc(context, ip);
            sincClienteEndereco.iniciaAsinc(context, ip);
            sincFormaPagto.iniciaASinc(context, ip);
            sincCidade.iniciaAsinc(context, ip);
            sincBairro.iniciaAsinc(context, ip);
            sincVendedor.iniciaASinc(context, ip);
            sincBairro.iniciaenvio(context, ip);
            sincCliente.iniciaenvio(context, ip);
            sincClienteEndereco.iniciaenvio(context, ip);
            Sessao.terminaProgress();
        }
    }


}



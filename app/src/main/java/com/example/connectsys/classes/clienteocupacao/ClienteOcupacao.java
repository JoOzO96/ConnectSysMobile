package com.example.connectsys.classes.clienteocupacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.connectsys.banco.Banco;
import com.example.connectsys.uteis.DadosBanco;
import com.example.connectsys.uteis.GetSetDinamico;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClienteOcupacao {

    Long codocupacao;
    String descricao;

    public Long getCodocupacao() {
        return codocupacao;
    }

    public void setCodocupacao(Long codocupacao) {
        this.codocupacao = codocupacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteOcupacao)) return false;
        ClienteOcupacao that = (ClienteOcupacao) o;
        return Objects.equals(getCodocupacao(), that.getCodocupacao()) &&
                Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodocupacao(), getDescricao());
    }

    @Override
    public String toString() {
        return codocupacao + " - " + descricao;
    }

    public Cursor retornaConfiguracaoGeralFiltradoCursor(Context context, Long codocupacao) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clienteocupacao where codocupacao = " + codocupacao, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public ClienteOcupacao retornaClienteOcupacao(Context context, Long codocupacao) {
        Banco myDb = new Banco(context);
        ClienteOcupacao clienteocupacao = new ClienteOcupacao();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteocupacao where codocupacao = " + codocupacao, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(ClienteOcupacao.class.getDeclaredFields()));

        for (int f = 0; fieldList.size() != f; f++) {
            if (fieldList.get(f).getName().toLowerCase().equals("alteradoandroid")) {
                fieldList.remove(f);
            }
            if (fieldList.get(f).getName().toLowerCase().equals("cadastroandroid")) {
                fieldList.remove(f);
            }
            if (fieldList.get(f).getName().toLowerCase().equals("deletadooandroid")) {
                fieldList.remove(f);
            }
        }

        for (int j = 0; cursor.getCount() != j; j++) {
            clienteocupacao = new ClienteOcupacao();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), clienteocupacao, retorno);
                    clienteocupacao = (ClienteOcupacao) ret;
                }
            }
        }
        db.close();
        return clienteocupacao;

    }

    public List<ClienteOcupacao> retornaListaClienteOcupacao(Context context) {
        Banco myDb = new Banco(context);
        List<ClienteOcupacao> clienteOcupacaoList = new ArrayList<>();
        ClienteOcupacao clienteOcupacao = new ClienteOcupacao();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteocupacao", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(ClienteOcupacao.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            clienteOcupacao = new ClienteOcupacao();

            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldListCliente.get(f), clienteOcupacao, retorno);
                    clienteOcupacao = (ClienteOcupacao) ret;
                }
            }
            clienteOcupacaoList.add(clienteOcupacao);
        }
        db.close();
        return clienteOcupacaoList;
    }

    public Boolean cadastraClienteOcupacao(Context context, ClienteOcupacao clienteocupacao) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(clienteocupacao.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), clienteocupacao, valores);
        }

        if (valores.get("codocupacao") == null) {
            db.insert("clienteocupacao", null, valores);
            db.close();
            valores.clear();
            return true;
        } else {
            Cursor cursor = clienteocupacao.retornaConfiguracaoGeralFiltradoCursor(context, Long.parseLong(valores.get("codocupacao").toString()));

            if (cursor.getCount() > 0) {
                long retorno = db.update("clienteocupacao", valores, "codocupacao = " + valores.get("codocupacao").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                db.insert("clienteocupacao", null, valores);
                db.close();
                valores.clear();
                return true;
            }

        }
    }
}

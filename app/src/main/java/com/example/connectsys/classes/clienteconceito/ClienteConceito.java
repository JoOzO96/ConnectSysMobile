package com.example.connectsys.classes.clienteconceito;

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

public class ClienteConceito {

    Long codconceito;
    String nome;
    String descricao;

    public Long getCodconceito() {
        return codconceito;
    }

    public void setCodconceito(Long codconceito) {
        this.codconceito = codconceito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(o instanceof ClienteConceito)) return false;
        ClienteConceito that = (ClienteConceito) o;
        return Objects.equals(getCodconceito(), that.getCodconceito()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodconceito(), getNome(), getDescricao());
    }

    @Override
    public String toString() {
        return codconceito + " - " + nome;
    }

    public Cursor retornaConceitoFiltradoCursor(Context context, Long codconceito) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clienteconceito where codconceito = " + codconceito, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public ClienteConceito retornaClienteConceito(Context context, Long codconceito) {
        Banco myDb = new Banco(context);
        ClienteConceito clienteConceito = new ClienteConceito();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteconceito where codconceito = " + codconceito, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(ClienteConceito.class.getDeclaredFields()));

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
            clienteConceito = new ClienteConceito();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), clienteConceito, retorno);
                    clienteConceito = (ClienteConceito) ret;
                }
            }
        }
        db.close();
        return clienteConceito;

    }

    public List<ClienteConceito> retornaListaClienteConceito(Context context) {
        Banco myDb = new Banco(context);
        List<ClienteConceito> clienteOcupacaoList = new ArrayList<>();
        ClienteConceito clienteConceito = new ClienteConceito();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteconceito", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(ClienteConceito.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            clienteConceito = new ClienteConceito();

            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldListCliente.get(f), clienteConceito, retorno);
                    clienteConceito = (ClienteConceito) ret;
                }
            }
            cursor.moveToNext();
            clienteOcupacaoList.add(clienteConceito);
        }
        db.close();
        return clienteOcupacaoList;
    }

    public Boolean cadastraClienteConceito(Context context, ClienteConceito clienteConceito) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(clienteConceito.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), clienteConceito, valores);
        }

        if (valores.get("codconceito") == null) {
            db.insert("clienteconceito", null, valores);
            db.close();
            valores.clear();
            return true;
        } else {
            Cursor cursor = clienteConceito.retornaConceitoFiltradoCursor(context, Long.parseLong(valores.get("codconceito").toString()));

            if (cursor.getCount() > 0) {
                long retorno = db.update("clienteconceito", valores, "codconceito = " + valores.get("codconceito").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                db.insert("clienteconceito", null, valores);
                db.close();
                valores.clear();
                return true;
            }

        }
    }
}

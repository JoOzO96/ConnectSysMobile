package com.example.connectsys.classes.bairro;

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

public class Bairro {

    Long codbairro;
    String nome;
    Boolean cadastroandroid;

    public Long getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(Long codbairro) {
        this.codbairro = codbairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getCadastroandroid() {
        return cadastroandroid;
    }

    public void setCadastroandroid(Boolean cadastroandroid) {
        this.cadastroandroid = cadastroandroid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bairro)) return false;
        Bairro bairro = (Bairro) o;
        return Objects.equals(getCodbairro(), bairro.getCodbairro()) &&
                Objects.equals(getNome(), bairro.getNome()) &&
                Objects.equals(getCadastroandroid(), bairro.getCadastroandroid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodbairro(), getNome(), getCadastroandroid());
    }

    @Override
    public String toString() {
        return codbairro + "-" + nome;
    }

    public Bairro retornaBairro(Context context, Long codBairro) {
        Banco myDb = new Banco(context);
        Bairro bairro = new Bairro();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM bairro where codbairro = " + codBairro, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListBairro = new ArrayList<>(Arrays.asList(Bairro.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            bairro = new Bairro();

            for (int f = 0; fieldListBairro.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListBairro.get(f));
                String nomeCampo = fieldListBairro.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retBairro = getSetDinamico.insereField(fieldListBairro.get(f), bairro, retorno);
                    bairro = (Bairro) retBairro;
                }
            }
        }
        db.close();
        return bairro;
    }

    public List<Bairro> retornaListaBairro(Context context) {
        Banco myDb = new Banco(context);
        List<Bairro> clienteEnderecos = new ArrayList<>();
        Bairro clienteEndereco = new Bairro();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bairro", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                clienteEndereco = new Bairro();
                clienteEndereco = retornaBairro(context, cursor.getLong(cursor.getColumnIndex("codbairro")));
                clienteEnderecos.add(clienteEndereco);
                cursor.moveToNext();
            }
        }
        return clienteEnderecos;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codbairro) from bairro", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Cursor retornaBairroAlteradaAndroid(Context context, String tipo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bairro where " + tipo + " = 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraCodBairro(Context context, Long codigoAndroid, Long codigoServidor) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("codbairro", codigoServidor);
        int retorno = db.update("bairro", values, "codbairro = " + codigoAndroid, null);

    }

    public void removeBairroAlteradaAndroid(Context context, String campo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(campo, "0");
        int retorno = db.update("bairro", values, campo + " = 1", null);

    }

    public Boolean cadastraBairro(Context context, Bairro clienteEndereco) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(clienteEndereco.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), clienteEndereco, valores);
        }
        if (valores.get("codbairro") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codbairro");
            valores.remove("cadastroandroid");
            valores.put("codbairro", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("bairro", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            Bairro clienteret = clienteEndereco.retornaBairro(context, Long.parseLong(valores.get("codbairro").toString()));
            if (clienteret.equals(new Bairro())) {
                valores.remove("cadastroandroid");
                long retorno = db.insert("bairro", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                if (!clienteret.equals(clienteEndereco)) {
                    valores.remove("alteradoandroid");
                    valores.put("alteradoandroid", true);
                    long retorno = db.update("bairro", valores, "codbairro= " + valores.get("bairro").toString(), null);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {
                    return Boolean.TRUE;
                }
            }
        }
    }
}

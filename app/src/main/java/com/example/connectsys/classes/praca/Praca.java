package com.example.connectsys.classes.praca;

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

public class Praca {

    Long codpraca;
    String nome;

    public Long getCodpraca() {
        return codpraca;
    }

    public void setCodpraca(Long codpraca) {
        this.codpraca = codpraca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return codpraca + " - " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Praca)) return false;
        Praca praca = (Praca) o;
        return Objects.equals(getCodpraca(), praca.getCodpraca()) &&
                Objects.equals(getNome(), praca.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodpraca(), getNome());
    }

    public Praca retornaPraca(Context context, Long codBairro) {
        Banco myDb = new Banco(context);
        Praca praca = new Praca();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM praca where codpraca = " + codBairro, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListBairro = new ArrayList<>(Arrays.asList(Praca.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            praca = new Praca();

            for (int f = 0; fieldListBairro.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListBairro.get(f));
                String nomeCampo = fieldListBairro.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retBairro = getSetDinamico.insereField(fieldListBairro.get(f), praca, retorno);
                    praca = (Praca) retBairro;
                }
            }
        }
        db.close();
        return praca;
    }

    public List<Praca> retornaListaPraca(Context context) {
        Banco myDb = new Banco(context);
        List<Praca> pracas = new ArrayList<>();
        Praca praca = new Praca();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM praca", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                praca = new Praca();
                praca = retornaPraca(context, cursor.getLong(cursor.getColumnIndex("codpraca")));
                pracas.add(praca);
                cursor.moveToNext();
            }
        }
        return pracas;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codpraca) from praca", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Cursor retornaPracaAlteradaAndroid(Context context, String tipo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM praca where " + tipo + " = 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void removeBairroAlteradaAndroid(Context context, String campo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(campo, "0");
        int retorno = db.update("bairro", values, campo + " = 1", null);

    }

    public Boolean cadastraPraca(Context context, Praca praca) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(praca.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), praca, valores);
        }
        if (valores.get("codpraca") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codpraca");
            valores.remove("cadastroandroid");
            valores.put("codpraca", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("praca", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            Praca pracaret = praca.retornaPraca(context, Long.parseLong(valores.get("codpraca").toString()));
            if (pracaret.equals(new Praca())) {
                valores.remove("cadastroandroid");
                long retorno = db.insert("praca", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                if (!pracaret.equals(praca)) {
                    valores.remove("alteradoandroid");
                    valores.put("alteradoandroid", true);
                    long retorno = db.update("praca", valores, "codpraca= " + valores.get("codpraca").toString(), null);
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

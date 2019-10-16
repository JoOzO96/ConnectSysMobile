package com.example.connectsys.classes.tabelapreco;

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

public class TabelaPreco {

    Long codtabelapreco;
    String descricao;
    Double perccomissao;
    Boolean mostrarnalista;
    Boolean mostrarnalocalizacao;

    public Long getCodtabelapreco() {
        return codtabelapreco;
    }

    public void setCodtabelapreco(Long codtabelapreco) {
        this.codtabelapreco = codtabelapreco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPerccomissao() {
        return perccomissao;
    }

    public void setPerccomissao(Double perccomissao) {
        this.perccomissao = perccomissao;
    }

    public Boolean getMostrarnalista() {
        return mostrarnalista;
    }

    public void setMostrarnalista(Boolean mostrarnalista) {
        this.mostrarnalista = mostrarnalista;
    }

    public Boolean getMostrarnalocalizacao() {
        return mostrarnalocalizacao;
    }

    public void setMostrarnalocalizacao(Boolean mostrarnalocalizacao) {
        this.mostrarnalocalizacao = mostrarnalocalizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TabelaPreco)) return false;
        TabelaPreco that = (TabelaPreco) o;
        return Objects.equals(getCodtabelapreco(), that.getCodtabelapreco()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getPerccomissao(), that.getPerccomissao()) &&
                Objects.equals(getMostrarnalista(), that.getMostrarnalista()) &&
                Objects.equals(getMostrarnalocalizacao(), that.getMostrarnalocalizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodtabelapreco(), getDescricao(), getPerccomissao(), getMostrarnalista(), getMostrarnalocalizacao());
    }

    @Override
    public String toString() {
        return codtabelapreco + " - " + descricao;
    }

    public TabelaPreco retornaTabelaPreco(Context context, Long codtabelapreco) {
        Banco myDb = new Banco(context);
        TabelaPreco tabelaPreco = new TabelaPreco();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM tabelapreco where codtabelapreco = " + codtabelapreco, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(TabelaPreco.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldList.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object rettabelaPreco = getSetDinamico.insereField(fieldList.get(f), tabelaPreco, retorno);
                    tabelaPreco = (TabelaPreco) rettabelaPreco;
                }
            }
        }
        db.close();
        return tabelaPreco;
    }

    public Boolean cadastraTabelaPreco(Context context, TabelaPreco tabelaPreco) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(tabelaPreco.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), tabelaPreco, valores);
        }
        if (valores.get("codtabelapreco") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codtabelapreco");
            valores.put("codtabelapreco", retorno);
            retorno = db.insert("tabelapreco", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            TabelaPreco tabelaprecoret = tabelaPreco.retornaTabelaPreco(context, Long.parseLong(valores.get("codtabelapreco").toString()));

            if (!tabelaprecoret.equals(tabelaPreco)) {
                if (tabelaprecoret.equals(new TabelaPreco())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    retorno = db.insert("tabelapreco", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {

                    long retorno = db.update("tabelapreco", valores, "codtabelapreco= " + valores.get("codtabelapreco").toString(), null);
                    db.close();
                    valores.clear();
                    return retorno != -1;

                }
            }
            return true;
        }
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codtabelapreco) from tabelapreco", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public List<TabelaPreco> retornaListaTabelaPrecos(Context context) {
        Banco myDb = new Banco(context);
        List<TabelaPreco> tabelaPrecos = new ArrayList<>();
        TabelaPreco tabelaPreco = new TabelaPreco();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tabelapreco", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                tabelaPreco = new TabelaPreco();
                tabelaPreco = retornaTabelaPreco(context, cursor.getLong(cursor.getColumnIndex("codtabelapreco")));
                tabelaPrecos.add(tabelaPreco);
                cursor.moveToNext();
            }
        }
        return tabelaPrecos;
    }

}

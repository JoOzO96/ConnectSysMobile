package com.example.connectsys.classes.emitentenota;

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

public class EmitenteNota {


    Long codemitentenota;
    Long codemitente;
    String descricao;
    String modelo;
    String serie;
    Long codnatureza;
    Boolean bloquearcasonaopreenchidocfop;

    public Long getCodemitentenota() {
        return codemitentenota;
    }

    public void setCodemitentenota(Long codemitentenota) {
        this.codemitentenota = codemitentenota;
    }

    public Long getCodemitente() {
        return codemitente;
    }

    public void setCodemitente(Long codemitente) {
        this.codemitente = codemitente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Long getCodnatureza() {
        return codnatureza;
    }

    public void setCodnatureza(Long codnatureza) {
        this.codnatureza = codnatureza;
    }

    public Boolean getBloquearcasonaopreenchidocfop() {
        return bloquearcasonaopreenchidocfop;
    }

    public void setBloquearcasonaopreenchidocfop(Boolean bloquearcasonaopreenchidocfop) {
        this.bloquearcasonaopreenchidocfop = bloquearcasonaopreenchidocfop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmitenteNota)) return false;
        EmitenteNota that = (EmitenteNota) o;
        return Objects.equals(getCodemitentenota(), that.getCodemitentenota()) &&
                Objects.equals(getCodemitente(), that.getCodemitente()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getModelo(), that.getModelo()) &&
                Objects.equals(getSerie(), that.getSerie()) &&
                Objects.equals(getCodnatureza(), that.getCodnatureza()) &&
                Objects.equals(getBloquearcasonaopreenchidocfop(), that.getBloquearcasonaopreenchidocfop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodemitentenota(), getCodemitente(), getDescricao(), getModelo(), getSerie(), getCodnatureza(), getBloquearcasonaopreenchidocfop());
    }

    @Override
    public String toString() {
        return codemitente + descricao;
    }

    public Cursor retornaEmitenteNotaFiltradoCursor(Context context, Long codemitente) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM emitentenota where codemitentenota = " + codemitente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public EmitenteNota retornaEmitenteNota(Context context, Long codemitentenota) {
        Banco myDb = new Banco(context);
        EmitenteNota emitenteNota = new EmitenteNota();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM emitentenota where codemitentenota = " + codemitentenota, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(EmitenteNota.class.getDeclaredFields()));

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
            emitenteNota = new EmitenteNota();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), emitenteNota, retorno);
                    emitenteNota = (EmitenteNota) ret;
                }
            }
        }
        db.close();
        return emitenteNota;

    }

    public Boolean cadastraEmitenteNota(Context context, EmitenteNota emitenteNota) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(emitenteNota.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), emitenteNota, valores);
        }

        if (valores.get("codemitentenota") == null) {
            db.insert("emitentenota", null, valores);
            db.close();
            valores.clear();
            return true;
        } else {
            Cursor cursor = emitenteNota.retornaEmitenteNotaFiltradoCursor(context, Long.parseLong(valores.get("codemitentenota").toString()));

            if (cursor.getCount() > 0) {
                long retorno = db.update("emitentenota", valores, "codemitentenota = " + valores.get("codemitentenota").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                db.insert("emitentenota", null, valores);
                db.close();
                valores.clear();
                return true;
            }

        }
    }
}


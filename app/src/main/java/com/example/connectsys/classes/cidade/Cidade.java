package com.example.connectsys.classes.cidade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.connectsys.banco.Banco;
import com.example.connectsys.uteis.DadosBanco;
import com.example.connectsys.uteis.GetSetDinamico;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cidade {

    Long codcidade;
    String codnacionaluf;
    String uf;
    String codnacionalcidade;
    String nome;
    String pais;
    String codnacionalpais;
    Double percissqn;
    String homologacaoenvio;
    String homologacaocancelamento;
    String homologacaobuscasequencia;
    String producaoenvio;
    String producaocancelamento;
    String producaobuscasequencia;
    String homologacaosite;
    String producaosite;

    public Long getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Long codcidade) {
        this.codcidade = codcidade;
    }

    public String getCodnacionaluf() {
        return codnacionaluf;
    }

    public void setCodnacionaluf(String codnacionaluf) {
        this.codnacionaluf = codnacionaluf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodnacionalcidade() {
        return codnacionalcidade;
    }

    public void setCodnacionalcidade(String codnacionalcidade) {
        this.codnacionalcidade = codnacionalcidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodnacionalpais() {
        return codnacionalpais;
    }

    public void setCodnacionalpais(String codnacionalpais) {
        this.codnacionalpais = codnacionalpais;
    }

    public Double getPercissqn() {
        return percissqn;
    }

    public void setPercissqn(Double percissqn) {
        this.percissqn = percissqn;
    }

    public String getHomologacaoenvio() {
        return homologacaoenvio;
    }

    public void setHomologacaoenvio(String homologacaoenvio) {
        this.homologacaoenvio = homologacaoenvio;
    }

    public String getHomologacaocancelamento() {
        return homologacaocancelamento;
    }

    public void setHomologacaocancelamento(String homologacaocancelamento) {
        this.homologacaocancelamento = homologacaocancelamento;
    }

    public String getHomologacaobuscasequencia() {
        return homologacaobuscasequencia;
    }

    public void setHomologacaobuscasequencia(String homologacaobuscasequencia) {
        this.homologacaobuscasequencia = homologacaobuscasequencia;
    }

    public String getProducaoenvio() {
        return producaoenvio;
    }

    public void setProducaoenvio(String producaoenvio) {
        this.producaoenvio = producaoenvio;
    }

    public String getProducaocancelamento() {
        return producaocancelamento;
    }

    public void setProducaocancelamento(String producaocancelamento) {
        this.producaocancelamento = producaocancelamento;
    }

    public String getProducaobuscasequencia() {
        return producaobuscasequencia;
    }

    public void setProducaobuscasequencia(String producaobuscasequencia) {
        this.producaobuscasequencia = producaobuscasequencia;
    }

    public String getHomologacaosite() {
        return homologacaosite;
    }

    public void setHomologacaosite(String homologacaosite) {
        this.homologacaosite = homologacaosite;
    }

    public String getProducaosite() {
        return producaosite;
    }

    public void setProducaosite(String producaosite) {
        this.producaosite = producaosite;
    }

    @Override
    public String toString() {
        return codcidade + " - " + nome + " - " + uf;
    }

    public Boolean cadastraCidade(Context context, Cidade cidade) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(cidade.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), cidade, valores);
        }

        if (valores.get("codcidade") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codcidade");
            valores.remove("cadastroandroid");
            valores.put("codcidade", retorno);
            retorno = db.insert("cidade", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            Cidade cidade1 = new Cidade();
            //Cursor cursor = cidade.retornaCidadeFiltradaCursor(context, Long.parseLong(valores.get("codcidade").toString()));
            Cidade cidadeFiltrada = retornaCidadeObjeto(context, Long.parseLong(valores.get("codcidade").toString()));
            String objectString1 = new Gson().toJson(cidade);
            String objectString2 = new Gson().toJson(cidadeFiltrada);
            if (objectString1.equals(objectString2)) {
                valores.remove("alteradoandroid");
                valores.put("alteradoandroid", true);
                long retorno = db.update("cidade", valores, "codcidade= " + valores.get("codcidade").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                valores.remove("cadastroandroid");
                long retorno = db.insert("cidade", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            }

        }
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,max(codcidade) from cidade", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Cidade retornaCidadeObjeto(Context context, Long codigo) {
        Banco myDb = new Banco(context);
        Cidade cidade = new Cidade();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM cidade where codcidade = " + codigo, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        List<Field> fieldListCidade = new ArrayList<>(Arrays.asList(Cidade.class.getDeclaredFields()));

        for (int j = 0; cursor.getCount() != j; j++) {
            Cidade cidade1 = new Cidade();

            for (int f = 0; fieldListCidade.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCidade.get(f));
                String nomeCampo = fieldListCidade.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCidade = getSetDinamico.insereField(fieldListCidade.get(f), cidade1, retorno);
                    cidade1 = (Cidade) retCidade;
                }
            }
            cidade = cidade1;
        }
        db.close();
        return cidade;
    }

    public Long retornaNumeroDeCidades(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM cidade", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(0);
        } else {
            return 0L;
        }
    }

    public List<Cidade> retornaListaCidade(Context context) {
        Banco myDb = new Banco(context);
        List<Cidade> cidades = new ArrayList<>();
        Cidade cidade = new Cidade();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cidade", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                cidade = retornaCidadeObjeto(context, cursor.getLong(cursor.getColumnIndex("codcidade")));
                cidades.add(cidade);
                cursor.moveToNext();
            }
        }
        return cidades;
    }

}

package com.example.connectsys.classes.produtoicmsnotafiscal;

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

public class ProdutoIcmsNotaFiscal {

    Long codcontrole;
    String codicmsnotafiscal;
    String uf;
    Double percicms;
    Double percicmssubstituicao;
    Double percicmsfrete;
    Double perctributacaoicms;
    String descricao;
    Boolean padrao;
    Double perctributacaosubstituicao;
    Double perctributacaosubstituicaosimples;
    Double percpobreza;
    Boolean naousarinformacoesadicionais;

    public Long getCodcontrole() {
        return codcontrole;
    }

    public void setCodcontrole(Long codcontrole) {
        this.codcontrole = codcontrole;
    }

    public String getCodicmsnotafiscal() {
        return codicmsnotafiscal;
    }

    public void setCodicmsnotafiscal(String codicmsnotafiscal) {
        this.codicmsnotafiscal = codicmsnotafiscal;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getPercicms() {
        return percicms;
    }

    public void setPercicms(Double percicms) {
        this.percicms = percicms;
    }

    public Double getPercicmssubstituicao() {
        return percicmssubstituicao;
    }

    public void setPercicmssubstituicao(Double percicmssubstituicao) {
        this.percicmssubstituicao = percicmssubstituicao;
    }

    public Double getPercicmsfrete() {
        return percicmsfrete;
    }

    public void setPercicmsfrete(Double percicmsfrete) {
        this.percicmsfrete = percicmsfrete;
    }

    public Double getPerctributacaoicms() {
        return perctributacaoicms;
    }

    public void setPerctributacaoicms(Double perctributacaoicms) {
        this.perctributacaoicms = perctributacaoicms;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getPadrao() {
        return padrao;
    }

    public void setPadrao(Boolean padrao) {
        this.padrao = padrao;
    }

    public Double getPerctributacaosubstituicao() {
        return perctributacaosubstituicao;
    }

    public void setPerctributacaosubstituicao(Double perctributacaosubstituicao) {
        this.perctributacaosubstituicao = perctributacaosubstituicao;
    }

    public Double getPerctributacaosubstituicaosimples() {
        return perctributacaosubstituicaosimples;
    }

    public void setPerctributacaosubstituicaosimples(Double perctributacaosubstituicaosimples) {
        this.perctributacaosubstituicaosimples = perctributacaosubstituicaosimples;
    }

    public Double getPercpobreza() {
        return percpobreza;
    }

    public void setPercpobreza(Double percpobreza) {
        this.percpobreza = percpobreza;
    }

    public Boolean getNaousarinformacoesadicionais() {
        return naousarinformacoesadicionais;
    }

    public void setNaousarinformacoesadicionais(Boolean naousarinformacoesadicionais) {
        this.naousarinformacoesadicionais = naousarinformacoesadicionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoIcmsNotaFiscal)) return false;
        ProdutoIcmsNotaFiscal that = (ProdutoIcmsNotaFiscal) o;
        return Objects.equals(getCodcontrole(), that.getCodcontrole()) &&
                Objects.equals(getCodicmsnotafiscal(), that.getCodicmsnotafiscal()) &&
                Objects.equals(getUf(), that.getUf()) &&
                Objects.equals(getPercicms(), that.getPercicms()) &&
                Objects.equals(getPercicmssubstituicao(), that.getPercicmssubstituicao()) &&
                Objects.equals(getPercicmsfrete(), that.getPercicmsfrete()) &&
                Objects.equals(getPerctributacaoicms(), that.getPerctributacaoicms()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getPadrao(), that.getPadrao()) &&
                Objects.equals(getPerctributacaosubstituicao(), that.getPerctributacaosubstituicao()) &&
                Objects.equals(getPerctributacaosubstituicaosimples(), that.getPerctributacaosubstituicaosimples()) &&
                Objects.equals(getPercpobreza(), that.getPercpobreza()) &&
                Objects.equals(getNaousarinformacoesadicionais(), that.getNaousarinformacoesadicionais());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodcontrole(), getCodicmsnotafiscal(), getUf(), getPercicms(), getPercicmssubstituicao(), getPercicmsfrete(), getPerctributacaoicms(), getDescricao(), getPadrao(), getPerctributacaosubstituicao(), getPerctributacaosubstituicaosimples(), getPercpobreza(), getNaousarinformacoesadicionais());
    }

    public Boolean cadastraProdutoIcmsNotaFiscal(Context context, ProdutoIcmsNotaFiscal produtoIcmsNotaFiscal) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(produtoIcmsNotaFiscal.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), produtoIcmsNotaFiscal, valores);
        }
        if (valores.get("codcontrole") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codcontrole");
            valores.put("codcontrole", retorno);
            retorno = db.insert("produtoicmsnotafiscal", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            ProdutoIcmsNotaFiscal produtoIcmsNotaFiscalret = produtoIcmsNotaFiscal.retornaProdutoPrecoTabela(context, Long.parseLong(valores.get("codcontrole").toString()));

            if (!produtoIcmsNotaFiscalret.equals(produtoIcmsNotaFiscal)) {
                if (produtoIcmsNotaFiscalret.equals(new ProdutoIcmsNotaFiscal())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    retorno = db.insert("produtoicmsnotafiscal", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {

                    long retorno = db.update("produtoicmsnotafiscal", valores, "codcontrole= " + valores.get("codcontrole").toString(), null);
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
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codcontrole) from produtoicmsnotafiscal", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public ProdutoIcmsNotaFiscal retornaProdutoPrecoTabela(Context context, Long codcontrole) {
        Banco myDb = new Banco(context);
        ProdutoIcmsNotaFiscal produtoIcmsNotaFiscal = new ProdutoIcmsNotaFiscal();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM produtoicmsnotafiscal where codcontrole = " + codcontrole, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(ProdutoIcmsNotaFiscal.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldList.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), produtoIcmsNotaFiscal, retorno);
                    produtoIcmsNotaFiscal = (ProdutoIcmsNotaFiscal) ret;
                }
            }
        }
        db.close();
        return produtoIcmsNotaFiscal;
    }
}

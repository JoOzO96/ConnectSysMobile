package com.example.connectsys.classes.naturezaoperacao;

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

public class NaturezaOperacao {

    Long codnaturezaoperacao;
    String descricao;
    String cfop;
    String cfopf;
    String acumulado;
    Long codnfe;
    String situacaotributaria;
    String csosn;
    Boolean movimentarestoque;
    Boolean mostrarnorelatorio;
    String descricaomostrar;
    Boolean exibir;
    Boolean remessa;
    Boolean transporte;
    Boolean prevalecer;
    Boolean solicitarnfce;
    Boolean semimposto90900;
    Boolean forcarmovimentacaoestoque;
    String finalidade;

    public Long getCodnaturezaoperacao() {
        return codnaturezaoperacao;
    }

    public void setCodnaturezaoperacao(Long codnaturezaoperacao) {
        this.codnaturezaoperacao = codnaturezaoperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCfopf() {
        return cfopf;
    }

    public void setCfopf(String cfopf) {
        this.cfopf = cfopf;
    }

    public String getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }

    public Long getCodnfe() {
        return codnfe;
    }

    public void setCodnfe(Long codnfe) {
        this.codnfe = codnfe;
    }

    public String getSituacaotributaria() {
        return situacaotributaria;
    }

    public void setSituacaotributaria(String situacaotributaria) {
        this.situacaotributaria = situacaotributaria;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public Boolean getMovimentarestoque() {
        return movimentarestoque;
    }

    public void setMovimentarestoque(Boolean movimentarestoque) {
        this.movimentarestoque = movimentarestoque;
    }

    public Boolean getMostrarnorelatorio() {
        return mostrarnorelatorio;
    }

    public void setMostrarnorelatorio(Boolean mostrarnorelatorio) {
        this.mostrarnorelatorio = mostrarnorelatorio;
    }

    public String getDescricaomostrar() {
        return descricaomostrar;
    }

    public void setDescricaomostrar(String descricaomostrar) {
        this.descricaomostrar = descricaomostrar;
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }

    public Boolean getRemessa() {
        return remessa;
    }

    public void setRemessa(Boolean remessa) {
        this.remessa = remessa;
    }

    public Boolean getTransporte() {
        return transporte;
    }

    public void setTransporte(Boolean transporte) {
        this.transporte = transporte;
    }

    public Boolean getPrevalecer() {
        return prevalecer;
    }

    public void setPrevalecer(Boolean prevalecer) {
        this.prevalecer = prevalecer;
    }

    public Boolean getSolicitarnfce() {
        return solicitarnfce;
    }

    public void setSolicitarnfce(Boolean solicitarnfce) {
        this.solicitarnfce = solicitarnfce;
    }

    public Boolean getSemimposto90900() {
        return semimposto90900;
    }

    public void setSemimposto90900(Boolean semimposto90900) {
        this.semimposto90900 = semimposto90900;
    }

    public Boolean getForcarmovimentacaoestoque() {
        return forcarmovimentacaoestoque;
    }

    public void setForcarmovimentacaoestoque(Boolean forcarmovimentacaoestoque) {
        this.forcarmovimentacaoestoque = forcarmovimentacaoestoque;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturezaOperacao)) return false;
        NaturezaOperacao that = (NaturezaOperacao) o;
        return Objects.equals(getCodnaturezaoperacao(), that.getCodnaturezaoperacao()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getCfop(), that.getCfop()) &&
                Objects.equals(getCfopf(), that.getCfopf()) &&
                Objects.equals(getAcumulado(), that.getAcumulado()) &&
                Objects.equals(getCodnfe(), that.getCodnfe()) &&
                Objects.equals(getSituacaotributaria(), that.getSituacaotributaria()) &&
                Objects.equals(getCsosn(), that.getCsosn()) &&
                Objects.equals(getMovimentarestoque(), that.getMovimentarestoque()) &&
                Objects.equals(getMostrarnorelatorio(), that.getMostrarnorelatorio()) &&
                Objects.equals(getDescricaomostrar(), that.getDescricaomostrar()) &&
                Objects.equals(getExibir(), that.getExibir()) &&
                Objects.equals(getRemessa(), that.getRemessa()) &&
                Objects.equals(getTransporte(), that.getTransporte()) &&
                Objects.equals(getPrevalecer(), that.getPrevalecer()) &&
                Objects.equals(getSolicitarnfce(), that.getSolicitarnfce()) &&
                Objects.equals(getSemimposto90900(), that.getSemimposto90900());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodnaturezaoperacao(), getDescricao(), getCfop(), getCfopf(), getAcumulado(), getCodnfe(), getSituacaotributaria(), getCsosn(), getMovimentarestoque(), getMostrarnorelatorio(), getDescricaomostrar(), getExibir(), getRemessa(), getTransporte(), getPrevalecer(), getSolicitarnfce(), getSemimposto90900());
    }

    public Boolean cadastraNaturezaOperacao(Context context, NaturezaOperacao naturezaOperacao) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(naturezaOperacao.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), naturezaOperacao, valores);
        }
        if (valores.get("codnaturezaoperacao") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codnaturezaoperacao");
            valores.put("codnaturezaoperacao", retorno);
            retorno = db.insert("naturezaoperacao", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            NaturezaOperacao naturezaOperacaoret = naturezaOperacao.retornaNaturezaOperacao(context, Long.parseLong(valores.get("codnaturezaoperacao").toString()));

            if (!naturezaOperacaoret.equals(naturezaOperacao)) {
                if (naturezaOperacaoret.equals(new NaturezaOperacao())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    retorno = db.insert("naturezaoperacao", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {

                    long retorno = db.update("naturezaoperacao", valores, "codnaturezaoperacao= " + valores.get("codnaturezaoperacao").toString(), null);
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
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codnaturezaoperacao) from naturezaoperacao", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public NaturezaOperacao retornaNaturezaOperacao(Context context, Long codnaturezaoperacao) {
        Banco myDb = new Banco(context);
        NaturezaOperacao naturezaOperacao = new NaturezaOperacao();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM naturezaoperacao where codnaturezaoperacao = " + codnaturezaoperacao, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(NaturezaOperacao.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldList.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), naturezaOperacao, retorno);
                    naturezaOperacao = (NaturezaOperacao) ret;
                }
            }
        }
        db.close();
        return naturezaOperacao;
    }
}

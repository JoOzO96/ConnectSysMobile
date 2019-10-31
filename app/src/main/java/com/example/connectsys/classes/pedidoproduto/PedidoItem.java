package com.example.connectsys.classes.pedidoproduto;

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

public class PedidoItem {

    Long codpedidoitem;
    Long codpedido;
    String tipoitem;
    Long codproduto;
    String numerointerno;
    String numerofabricante;
    Double quantidadeestoque;
    Double quantidade;
    Double valorunitario;
    Double custoproduto;
    Double percdesconto;
    Double desconto;
    Double percentuallucro;
    Double percdescontopedido;
    Double valorcomissao;
    Long codnaturezaoperacao;
    Double valorseguro;
    Double valorfrete;
    Double valoroutros;
    Double valortotal;
    Double basecalculoicms;
    Double percicms;
    Double valoricms;
    Double basecalculosubstituicao;
    Double percsubstituicao;
    Double valorsubstituicao;
    Double mvautilizado;
    String csosn;
    Double baseissqn;
    Double percissqn;
    Double valorissqn;
    String codcidadeissqn;
    Double perctributacao;
    Double basecalculoipi;
    Double percipi;
    Double quantidadetributavelipi;
    Double valorunitarioipi;
    Double valoripi;
    Double basecalculopis;
    Double percpis;
    Double quantidadetributavelpis;
    Double valorunitariopis;
    Double valorpis;
    Double basecalculocofins;
    Double perccofins;
    Double quantidadetributavelcofins;
    Double valorunitariocofins;
    Double valorcofins;
    Double percaproveitamento;
    Double valoraproveitamento;
    Double pesoliquidounitariototal;
    Double pesobrutounitariototal;
    String codpis;
    String codcofins;
    String situacaotributaria;
    Double perctributacaosubstituicao;
    Double percdescontopromocao;
    Long coddescontocomissao;
    String descricaoitemvariavel;
    Double quantidadereservada;
    String codicmscupom;
    String descricaoadicional;

    public Long getCodpedidoitem() {
        return codpedidoitem;
    }

    public void setCodpedidoitem(Long codpedidoitem) {
        this.codpedidoitem = codpedidoitem;
    }

    public Long getCodpedido() {
        return codpedido;
    }

    public void setCodpedido(Long codpedido) {
        this.codpedido = codpedido;
    }

    public String getTipoitem() {
        return tipoitem;
    }

    public void setTipoitem(String tipoitem) {
        this.tipoitem = tipoitem;
    }

    public Long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public String getNumerointerno() {
        return numerointerno;
    }

    public void setNumerointerno(String numerointerno) {
        this.numerointerno = numerointerno;
    }

    public String getNumerofabricante() {
        return numerofabricante;
    }

    public void setNumerofabricante(String numerofabricante) {
        this.numerofabricante = numerofabricante;
    }

    public Double getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(Double quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Double getCustoproduto() {
        return custoproduto;
    }

    public void setCustoproduto(Double custoproduto) {
        this.custoproduto = custoproduto;
    }

    public Double getPercdesconto() {
        return percdesconto;
    }

    public void setPercdesconto(Double percdesconto) {
        this.percdesconto = percdesconto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getPercentuallucro() {
        return percentuallucro;
    }

    public void setPercentuallucro(Double percentuallucro) {
        this.percentuallucro = percentuallucro;
    }

    public Double getPercdescontopedido() {
        return percdescontopedido;
    }

    public void setPercdescontopedido(Double percdescontopedido) {
        this.percdescontopedido = percdescontopedido;
    }

    public Double getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(Double valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public Long getCodnaturezaoperacao() {
        return codnaturezaoperacao;
    }

    public void setCodnaturezaoperacao(Long codnaturezaoperacao) {
        this.codnaturezaoperacao = codnaturezaoperacao;
    }

    public Double getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(Double valorseguro) {
        this.valorseguro = valorseguro;
    }

    public Double getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(Double valorfrete) {
        this.valorfrete = valorfrete;
    }

    public Double getValoroutros() {
        return valoroutros;
    }

    public void setValoroutros(Double valoroutros) {
        this.valoroutros = valoroutros;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public Double getBasecalculoicms() {
        return basecalculoicms;
    }

    public void setBasecalculoicms(Double basecalculoicms) {
        this.basecalculoicms = basecalculoicms;
    }

    public Double getPercicms() {
        return percicms;
    }

    public void setPercicms(Double percicms) {
        this.percicms = percicms;
    }

    public Double getValoricms() {
        return valoricms;
    }

    public void setValoricms(Double valoricms) {
        this.valoricms = valoricms;
    }

    public Double getBasecalculosubstituicao() {
        return basecalculosubstituicao;
    }

    public void setBasecalculosubstituicao(Double basecalculosubstituicao) {
        this.basecalculosubstituicao = basecalculosubstituicao;
    }

    public Double getPercsubstituicao() {
        return percsubstituicao;
    }

    public void setPercsubstituicao(Double percsubstituicao) {
        this.percsubstituicao = percsubstituicao;
    }

    public Double getValorsubstituicao() {
        return valorsubstituicao;
    }

    public void setValorsubstituicao(Double valorsubstituicao) {
        this.valorsubstituicao = valorsubstituicao;
    }

    public Double getMvautilizado() {
        return mvautilizado;
    }

    public void setMvautilizado(Double mvautilizado) {
        this.mvautilizado = mvautilizado;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public Double getBaseissqn() {
        return baseissqn;
    }

    public void setBaseissqn(Double baseissqn) {
        this.baseissqn = baseissqn;
    }

    public Double getPercissqn() {
        return percissqn;
    }

    public void setPercissqn(Double percissqn) {
        this.percissqn = percissqn;
    }

    public Double getValorissqn() {
        return valorissqn;
    }

    public void setValorissqn(Double valorissqn) {
        this.valorissqn = valorissqn;
    }

    public String getCodcidadeissqn() {
        return codcidadeissqn;
    }

    public void setCodcidadeissqn(String codcidadeissqn) {
        this.codcidadeissqn = codcidadeissqn;
    }

    public Double getPerctributacao() {
        return perctributacao;
    }

    public void setPerctributacao(Double perctributacao) {
        this.perctributacao = perctributacao;
    }

    public Double getBasecalculoipi() {
        return basecalculoipi;
    }

    public void setBasecalculoipi(Double basecalculoipi) {
        this.basecalculoipi = basecalculoipi;
    }

    public Double getPercipi() {
        return percipi;
    }

    public void setPercipi(Double percipi) {
        this.percipi = percipi;
    }

    public Double getQuantidadetributavelipi() {
        return quantidadetributavelipi;
    }

    public void setQuantidadetributavelipi(Double quantidadetributavelipi) {
        this.quantidadetributavelipi = quantidadetributavelipi;
    }

    public Double getValorunitarioipi() {
        return valorunitarioipi;
    }

    public void setValorunitarioipi(Double valorunitarioipi) {
        this.valorunitarioipi = valorunitarioipi;
    }

    public Double getValoripi() {
        return valoripi;
    }

    public void setValoripi(Double valoripi) {
        this.valoripi = valoripi;
    }

    public Double getBasecalculopis() {
        return basecalculopis;
    }

    public void setBasecalculopis(Double basecalculopis) {
        this.basecalculopis = basecalculopis;
    }

    public Double getPercpis() {
        return percpis;
    }

    public void setPercpis(Double percpis) {
        this.percpis = percpis;
    }

    public Double getQuantidadetributavelpis() {
        return quantidadetributavelpis;
    }

    public void setQuantidadetributavelpis(Double quantidadetributavelpis) {
        this.quantidadetributavelpis = quantidadetributavelpis;
    }

    public Double getValorunitariopis() {
        return valorunitariopis;
    }

    public void setValorunitariopis(Double valorunitariopis) {
        this.valorunitariopis = valorunitariopis;
    }

    public Double getValorpis() {
        return valorpis;
    }

    public void setValorpis(Double valorpis) {
        this.valorpis = valorpis;
    }

    public Double getBasecalculocofins() {
        return basecalculocofins;
    }

    public void setBasecalculocofins(Double basecalculocofins) {
        this.basecalculocofins = basecalculocofins;
    }

    public Double getPerccofins() {
        return perccofins;
    }

    public void setPerccofins(Double perccofins) {
        this.perccofins = perccofins;
    }

    public Double getQuantidadetributavelcofins() {
        return quantidadetributavelcofins;
    }

    public void setQuantidadetributavelcofins(Double quantidadetributavelcofins) {
        this.quantidadetributavelcofins = quantidadetributavelcofins;
    }

    public Double getValorunitariocofins() {
        return valorunitariocofins;
    }

    public void setValorunitariocofins(Double valorunitariocofins) {
        this.valorunitariocofins = valorunitariocofins;
    }

    public Double getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(Double valorcofins) {
        this.valorcofins = valorcofins;
    }

    public Double getPercaproveitamento() {
        return percaproveitamento;
    }

    public void setPercaproveitamento(Double percaproveitamento) {
        this.percaproveitamento = percaproveitamento;
    }

    public Double getValoraproveitamento() {
        return valoraproveitamento;
    }

    public void setValoraproveitamento(Double valoraproveitamento) {
        this.valoraproveitamento = valoraproveitamento;
    }

    public Double getPesoliquidounitariototal() {
        return pesoliquidounitariototal;
    }

    public void setPesoliquidounitariototal(Double pesoliquidounitariototal) {
        this.pesoliquidounitariototal = pesoliquidounitariototal;
    }

    public Double getPesobrutounitariototal() {
        return pesobrutounitariototal;
    }

    public void setPesobrutounitariototal(Double pesobrutounitariototal) {
        this.pesobrutounitariototal = pesobrutounitariototal;
    }

    public String getCodpis() {
        return codpis;
    }

    public void setCodpis(String codpis) {
        this.codpis = codpis;
    }

    public String getCodcofins() {
        return codcofins;
    }

    public void setCodcofins(String codcofins) {
        this.codcofins = codcofins;
    }

    public String getSituacaotributaria() {
        return situacaotributaria;
    }

    public void setSituacaotributaria(String situacaotributaria) {
        this.situacaotributaria = situacaotributaria;
    }

    public Double getPerctributacaosubstituicao() {
        return perctributacaosubstituicao;
    }

    public void setPerctributacaosubstituicao(Double perctributacaosubstituicao) {
        this.perctributacaosubstituicao = perctributacaosubstituicao;
    }

    public Double getPercdescontopromocao() {
        return percdescontopromocao;
    }

    public void setPercdescontopromocao(Double percdescontopromocao) {
        this.percdescontopromocao = percdescontopromocao;
    }

    public Long getCoddescontocomissao() {
        return coddescontocomissao;
    }

    public void setCoddescontocomissao(Long coddescontocomissao) {
        this.coddescontocomissao = coddescontocomissao;
    }

    public String getDescricaoitemvariavel() {
        return descricaoitemvariavel;
    }

    public void setDescricaoitemvariavel(String descricaoitemvariavel) {
        this.descricaoitemvariavel = descricaoitemvariavel;
    }

    public Double getQuantidadereservada() {
        return quantidadereservada;
    }

    public void setQuantidadereservada(Double quantidadereservada) {
        this.quantidadereservada = quantidadereservada;
    }

    public String getCodicmscupom() {
        return codicmscupom;
    }

    public void setCodicmscupom(String codicmscupom) {
        this.codicmscupom = codicmscupom;
    }

    public String getDescricaoadicional() {
        return descricaoadicional;
    }

    public void setDescricaoadicional(String descricaoadicional) {
        this.descricaoadicional = descricaoadicional;
    }

    @Override
    public String toString() {
        return "" + codproduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoItem)) return false;
        PedidoItem that = (PedidoItem) o;
        return Objects.equals(getCodpedidoitem(), that.getCodpedidoitem()) &&
                Objects.equals(getCodpedido(), that.getCodpedido()) &&
                Objects.equals(getTipoitem(), that.getTipoitem()) &&
                Objects.equals(getCodproduto(), that.getCodproduto()) &&
                Objects.equals(getNumerointerno(), that.getNumerointerno()) &&
                Objects.equals(getNumerofabricante(), that.getNumerofabricante()) &&
                Objects.equals(getQuantidadeestoque(), that.getQuantidadeestoque()) &&
                Objects.equals(getQuantidade(), that.getQuantidade()) &&
                Objects.equals(getValorunitario(), that.getValorunitario()) &&
                Objects.equals(getCustoproduto(), that.getCustoproduto()) &&
                Objects.equals(getPercdesconto(), that.getPercdesconto()) &&
                Objects.equals(getDesconto(), that.getDesconto()) &&
                Objects.equals(getPercentuallucro(), that.getPercentuallucro()) &&
                Objects.equals(getPercdescontopedido(), that.getPercdescontopedido()) &&
                Objects.equals(getValorcomissao(), that.getValorcomissao()) &&
                Objects.equals(getCodnaturezaoperacao(), that.getCodnaturezaoperacao()) &&
                Objects.equals(getValorseguro(), that.getValorseguro()) &&
                Objects.equals(getValorfrete(), that.getValorfrete()) &&
                Objects.equals(getValoroutros(), that.getValoroutros()) &&
                Objects.equals(getValortotal(), that.getValortotal()) &&
                Objects.equals(getBasecalculoicms(), that.getBasecalculoicms()) &&
                Objects.equals(getPercicms(), that.getPercicms()) &&
                Objects.equals(getValoricms(), that.getValoricms()) &&
                Objects.equals(getBasecalculosubstituicao(), that.getBasecalculosubstituicao()) &&
                Objects.equals(getPercsubstituicao(), that.getPercsubstituicao()) &&
                Objects.equals(getValorsubstituicao(), that.getValorsubstituicao()) &&
                Objects.equals(getMvautilizado(), that.getMvautilizado()) &&
                Objects.equals(getCsosn(), that.getCsosn()) &&
                Objects.equals(getBaseissqn(), that.getBaseissqn()) &&
                Objects.equals(getPercissqn(), that.getPercissqn()) &&
                Objects.equals(getValorissqn(), that.getValorissqn()) &&
                Objects.equals(getCodcidadeissqn(), that.getCodcidadeissqn()) &&
                Objects.equals(getPerctributacao(), that.getPerctributacao()) &&
                Objects.equals(getBasecalculoipi(), that.getBasecalculoipi()) &&
                Objects.equals(getPercipi(), that.getPercipi()) &&
                Objects.equals(getQuantidadetributavelipi(), that.getQuantidadetributavelipi()) &&
                Objects.equals(getValorunitarioipi(), that.getValorunitarioipi()) &&
                Objects.equals(getValoripi(), that.getValoripi()) &&
                Objects.equals(getBasecalculopis(), that.getBasecalculopis()) &&
                Objects.equals(getPercpis(), that.getPercpis()) &&
                Objects.equals(getQuantidadetributavelpis(), that.getQuantidadetributavelpis()) &&
                Objects.equals(getValorunitariopis(), that.getValorunitariopis()) &&
                Objects.equals(getValorpis(), that.getValorpis()) &&
                Objects.equals(getBasecalculocofins(), that.getBasecalculocofins()) &&
                Objects.equals(getPerccofins(), that.getPerccofins()) &&
                Objects.equals(getQuantidadetributavelcofins(), that.getQuantidadetributavelcofins()) &&
                Objects.equals(getValorunitariocofins(), that.getValorunitariocofins()) &&
                Objects.equals(getValorcofins(), that.getValorcofins()) &&
                Objects.equals(getPercaproveitamento(), that.getPercaproveitamento()) &&
                Objects.equals(getValoraproveitamento(), that.getValoraproveitamento()) &&
                Objects.equals(getPesoliquidounitariototal(), that.getPesoliquidounitariototal()) &&
                Objects.equals(getPesobrutounitariototal(), that.getPesobrutounitariototal()) &&
                Objects.equals(getCodpis(), that.getCodpis()) &&
                Objects.equals(getCodcofins(), that.getCodcofins()) &&
                Objects.equals(getSituacaotributaria(), that.getSituacaotributaria()) &&
                Objects.equals(getPerctributacaosubstituicao(), that.getPerctributacaosubstituicao()) &&
                Objects.equals(getPercdescontopromocao(), that.getPercdescontopromocao()) &&
                Objects.equals(getCoddescontocomissao(), that.getCoddescontocomissao()) &&
                Objects.equals(getDescricaoitemvariavel(), that.getDescricaoitemvariavel()) &&
                Objects.equals(getQuantidadereservada(), that.getQuantidadereservada()) &&
                Objects.equals(getCodicmscupom(), that.getCodicmscupom()) &&
                Objects.equals(getDescricaoadicional(), that.getDescricaoadicional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodpedidoitem(), getCodpedido(), getTipoitem(), getCodproduto(), getNumerointerno(), getNumerofabricante(), getQuantidadeestoque(), getQuantidade(), getValorunitario(), getCustoproduto(), getPercdesconto(), getDesconto(), getPercentuallucro(), getPercdescontopedido(), getValorcomissao(), getCodnaturezaoperacao(), getValorseguro(), getValorfrete(), getValoroutros(), getValortotal(), getBasecalculoicms(), getPercicms(), getValoricms(), getBasecalculosubstituicao(), getPercsubstituicao(), getValorsubstituicao(), getMvautilizado(), getCsosn(), getBaseissqn(), getPercissqn(), getValorissqn(), getCodcidadeissqn(), getPerctributacao(), getBasecalculoipi(), getPercipi(), getQuantidadetributavelipi(), getValorunitarioipi(), getValoripi(), getBasecalculopis(), getPercpis(), getQuantidadetributavelpis(), getValorunitariopis(), getValorpis(), getBasecalculocofins(), getPerccofins(), getQuantidadetributavelcofins(), getValorunitariocofins(), getValorcofins(), getPercaproveitamento(), getValoraproveitamento(), getPesoliquidounitariototal(), getPesobrutounitariototal(), getCodpis(), getCodcofins(), getSituacaotributaria(), getPerctributacaosubstituicao(), getPercdescontopromocao(), getCoddescontocomissao(), getDescricaoitemvariavel(), getQuantidadereservada(), getCodicmscupom(), getDescricaoadicional());
    }


    public Boolean cadastraPedidoItem(Context context, PedidoItem pedidoItem) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(pedidoItem.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), pedidoItem, valores);
        }

        if (valores.get("codpedidoitem") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("cadastroandroid");
            valores.put("codpedidoitem", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("pedidoitem", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            valores.remove("alteradoandroid");
            valores.put("alteradoandroid", true);
            long retorno = db.update("pedidoitem", valores, "codpedidoitem= " + valores.get("codpedidoitem").toString(), null);
            db.close();
            valores.clear();
            return retorno != -1;
        }
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codpedidoitem) from pedidoitem", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public boolean removerPedido(Context context, Long codpedido) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getWritableDatabase();
        int retorno = db.delete("pedidoitem", "codpedidoitem = " + codpedido, null);
        return retorno > 0;
    }


    public List<PedidoItem> retornaItensPedido(Context context, Long codpedido) {
        List<PedidoItem> itensPedido = new ArrayList<>();
        Banco myDb = new Banco(context);
        PedidoItem pedidoItem = new PedidoItem();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM pedidoitem where codpedido = " + codpedido, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(PedidoItem.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            pedidoItem = new PedidoItem();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), pedidoItem, retorno);
                    pedidoItem = (PedidoItem) ret;
                }
            }
            itensPedido.add(pedidoItem);
            cursor.moveToNext();
        }
        db.close();
        return itensPedido;
    }

    public boolean removerPedidoItem(Context context, Long codpedidoitem) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getWritableDatabase();
        int retorno = db.delete("pedidoitem", "codpedidoitem = " + codpedidoitem, null);
        return retorno > 0;
    }

    public void removePedidoProdutoAlteradaAndroid(Context context, String campo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(campo, "0");
        int retorno = db.update("pedidoitem", values, campo + " = 1", null);

    }

    public PedidoItem retornaItemPedido(Context context, Long codpedido, Long codproduto) {
        Banco myDb = new Banco(context);
        PedidoItem pedidoItem = new PedidoItem();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM pedidoitem where codpedido = " + codpedido + " and codproduto =" + codproduto, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(PedidoItem.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            pedidoItem = new PedidoItem();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), pedidoItem, retorno);
                    pedidoItem = (PedidoItem) ret;
                }
            }
        }
        db.close();
        return pedidoItem;
    }
}

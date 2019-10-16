package com.example.connectsys.classes.produtoprecotabela;

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

public class ProdutoPrecoTabela {

    Long codpreco;
    Long codtabelapreco;
    Long codproduto;
    Double percentual;
    Double valor;
    Double percminimo;
    Double valorminimo;

    public Long getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Long codpreco) {
        this.codpreco = codpreco;
    }

    public Long getCodtabelapreco() {
        return codtabelapreco;
    }

    public void setCodtabelapreco(Long codtabelapreco) {
        this.codtabelapreco = codtabelapreco;
    }

    public Long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPercminimo() {
        return percminimo;
    }

    public void setPercminimo(Double percminimo) {
        this.percminimo = percminimo;
    }

    public Double getValorminimo() {
        return valorminimo;
    }

    public void setValorminimo(Double valorminimo) {
        this.valorminimo = valorminimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoPrecoTabela)) return false;
        ProdutoPrecoTabela that = (ProdutoPrecoTabela) o;
        return Objects.equals(getCodpreco(), that.getCodpreco()) &&
                Objects.equals(getCodtabelapreco(), that.getCodtabelapreco()) &&
                Objects.equals(getCodproduto(), that.getCodproduto()) &&
                Objects.equals(getPercentual(), that.getPercentual()) &&
                Objects.equals(getValor(), that.getValor()) &&
                Objects.equals(getPercminimo(), that.getPercminimo()) &&
                Objects.equals(getValorminimo(), that.getValorminimo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodpreco(), getCodtabelapreco(), getCodproduto(), getPercentual(), getValor(), getPercminimo(), getValorminimo());
    }

    public ProdutoPrecoTabela retornaProdutoPrecoTabela(Context context, Long codproduto, Long codtabelapreco) {
        Banco myDb = new Banco(context);
        ProdutoPrecoTabela produtoPrecoTabela = new ProdutoPrecoTabela();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM produtoprecotabela where codproduto = " + codproduto + " and codtabelapreco = " + codtabelapreco, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(ProdutoPrecoTabela.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldList.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), produtoPrecoTabela, retorno);
                    produtoPrecoTabela = (ProdutoPrecoTabela) ret;
                }
            }
        }
        db.close();
        return produtoPrecoTabela;
    }

    public Boolean cadastraProdutoPrecoTabela(Context context, ProdutoPrecoTabela produtoPrecoTabela) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(produtoPrecoTabela.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), produtoPrecoTabela, valores);
        }
        if (valores.get("codpreco") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codpreco");
            valores.put("codpreco", retorno);
            retorno = db.insert("produtoprecotabela", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            ProdutoPrecoTabela produtoPrecoTabelaret = produtoPrecoTabela.retornaProdutoPrecoTabela(context, Long.parseLong(valores.get("codproduto").toString()), Long.parseLong(valores.get("codtabelapreco").toString()));

            if (!produtoPrecoTabelaret.equals(produtoPrecoTabela)) {
                if (produtoPrecoTabelaret.equals(new ProdutoPrecoTabela())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    retorno = db.insert("produtoprecotabela", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {

                    long retorno = db.update("produtoprecotabela", valores, "codpreco= " + valores.get("codpreco").toString(), null);
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
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codpreco) from produtoprecotabela", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }
}

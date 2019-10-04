package com.example.connectsys.classes.formapagto;

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

public class FormaPagto {

    Long codformapagto;
    String descricao;
    Long codnfe;
    Boolean habilitapdv;
    Boolean entrarnofechamento;
    Boolean verificarliberacao;
    Boolean naoverificaparcelas;
    String formanfe;
    Long numeroimpressoesextra;
    String textocomprovante;
    Long codconfiguracaoboleto;
    Boolean exibir;


    @Override
    public String toString() {
        return codformapagto + " - " + descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormaPagto)) return false;
        FormaPagto that = (FormaPagto) o;
        return Objects.equals(getCodformapagto(), that.getCodformapagto()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getCodnfe(), that.getCodnfe()) &&
                Objects.equals(getHabilitapdv(), that.getHabilitapdv()) &&
                Objects.equals(getEntrarnofechamento(), that.getEntrarnofechamento()) &&
                Objects.equals(getVerificarliberacao(), that.getVerificarliberacao()) &&
                Objects.equals(getNaoverificaparcelas(), that.getNaoverificaparcelas()) &&
                Objects.equals(getFormanfe(), that.getFormanfe()) &&
                Objects.equals(getNumeroimpressoesextra(), that.getNumeroimpressoesextra()) &&
                Objects.equals(getTextocomprovante(), that.getTextocomprovante()) &&
                Objects.equals(getCodconfiguracaoboleto(), that.getCodconfiguracaoboleto()) &&
                Objects.equals(getExibir(), that.getExibir());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodformapagto(), getDescricao(), getCodnfe(), getHabilitapdv(), getEntrarnofechamento(), getVerificarliberacao(), getNaoverificaparcelas(), getFormanfe(), getNumeroimpressoesextra(), getTextocomprovante(), getCodconfiguracaoboleto(), getExibir());
    }

    public Long getCodformapagto() {
        return codformapagto;
    }

    public void setCodformapagto(Long codformapagto) {
        this.codformapagto = codformapagto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodnfe() {
        return codnfe;
    }

    public void setCodnfe(Long codnfe) {
        this.codnfe = codnfe;
    }

    public Boolean getHabilitapdv() {
        return habilitapdv;
    }

    public void setHabilitapdv(Boolean habilitapdv) {
        this.habilitapdv = habilitapdv;
    }

    public Boolean getEntrarnofechamento() {
        return entrarnofechamento;
    }

    public void setEntrarnofechamento(Boolean entrarnofechamento) {
        this.entrarnofechamento = entrarnofechamento;
    }

    public Boolean getVerificarliberacao() {
        return verificarliberacao;
    }

    public void setVerificarliberacao(Boolean verificarliberacao) {
        this.verificarliberacao = verificarliberacao;
    }

    public Boolean getNaoverificaparcelas() {
        return naoverificaparcelas;
    }

    public void setNaoverificaparcelas(Boolean naoverificaparcelas) {
        this.naoverificaparcelas = naoverificaparcelas;
    }

    public String getFormanfe() {
        return formanfe;
    }

    public void setFormanfe(String formanfe) {
        this.formanfe = formanfe;
    }

    public Long getNumeroimpressoesextra() {
        return numeroimpressoesextra;
    }

    public void setNumeroimpressoesextra(Long numeroimpressoesextra) {
        this.numeroimpressoesextra = numeroimpressoesextra;
    }

    public String getTextocomprovante() {
        return textocomprovante;
    }

    public void setTextocomprovante(String textocomprovante) {
        this.textocomprovante = textocomprovante;
    }

    public Long getCodconfiguracaoboleto() {
        return codconfiguracaoboleto;
    }

    public void setCodconfiguracaoboleto(Long codconfiguracaoboleto) {
        this.codconfiguracaoboleto = codconfiguracaoboleto;
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codformapagto) from formapagto", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Boolean cadastraFormaPagto(Context context, FormaPagto formaPagto) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(formaPagto.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), formaPagto, valores);
        }
        if (valores.get("codformapagto") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codcliente");
            valores.remove("cadastroandroid");
            valores.put("codformapagto", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("formapagto", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            FormaPagto clienteret = formaPagto.retornaFormapagto(context, Long.parseLong(valores.get("codformapagto").toString()));

            if (!clienteret.equals(formaPagto)) {
                if (clienteret.equals(new FormaPagto())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    valores.remove("cadastroandroid");
                    retorno = db.insert("formapagto", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {
                    valores.remove("alteradoandroid");
                    valores.put("alteradoandroid", true);
                    long retorno = db.update("formapagto", valores, "formapagto= " + valores.get("codformapagto").toString(), null);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                }
            }
            return true;
        }
    }

    public FormaPagto retornaFormapagto(Context context, Long codformapagto) {
        Banco myDb = new Banco(context);
        FormaPagto formaPagto = new FormaPagto();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM formapagto where codformapagto = " + codformapagto, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(FormaPagto.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCliente = getSetDinamico.insereField(fieldListCliente.get(f), formaPagto, retorno);
                    formaPagto = (FormaPagto) retCliente;
                }
            }
        }
        db.close();
        return formaPagto;
    }

}

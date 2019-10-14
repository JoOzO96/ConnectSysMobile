package com.example.connectsys.classes.vendedor;

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
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Vendedor {

    Long codvendedor;
    String tipo;
    String nome;
    Long codcidade;
    String endereco;
    String numero;
    String complemento;
    Long codbairro;
    String cep;
    String fone;
    String fonefax;
    String fonecelular;
    Double perccomissao;
    String email;
    Date datanascimento;
    Date datacadastro;
    String status;
    String cpf;
    String rg;
    String tituloeleitoral;
    Long codregiao;
    Long divisor;

    public Long getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(Long codvendedor) {
        this.codvendedor = codvendedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Long codcidade) {
        this.codcidade = codcidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(Long codbairro) {
        this.codbairro = codbairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFonefax() {
        return fonefax;
    }

    public void setFonefax(String fonefax) {
        this.fonefax = fonefax;
    }

    public String getFonecelular() {
        return fonecelular;
    }

    public void setFonecelular(String fonecelular) {
        this.fonecelular = fonecelular;
    }

    public Double getPerccomissao() {
        return perccomissao;
    }

    public void setPerccomissao(Double perccomissao) {
        this.perccomissao = perccomissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTituloeleitoral() {
        return tituloeleitoral;
    }

    public void setTituloeleitoral(String tituloeleitoral) {
        this.tituloeleitoral = tituloeleitoral;
    }

    public Long getCodregiao() {
        return codregiao;
    }

    public void setCodregiao(Long codregiao) {
        this.codregiao = codregiao;
    }

    public Long getDivisor() {
        return divisor;
    }

    public void setDivisor(Long divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendedor)) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(getCodvendedor(), vendedor.getCodvendedor()) &&
                Objects.equals(getTipo(), vendedor.getTipo()) &&
                Objects.equals(getNome(), vendedor.getNome()) &&
                Objects.equals(getCodcidade(), vendedor.getCodcidade()) &&
                Objects.equals(getEndereco(), vendedor.getEndereco()) &&
                Objects.equals(getNumero(), vendedor.getNumero()) &&
                Objects.equals(getComplemento(), vendedor.getComplemento()) &&
                Objects.equals(getCodbairro(), vendedor.getCodbairro()) &&
                Objects.equals(getCep(), vendedor.getCep()) &&
                Objects.equals(getFone(), vendedor.getFone()) &&
                Objects.equals(getFonefax(), vendedor.getFonefax()) &&
                Objects.equals(getFonecelular(), vendedor.getFonecelular()) &&
                Objects.equals(getPerccomissao(), vendedor.getPerccomissao()) &&
                Objects.equals(getEmail(), vendedor.getEmail()) &&
                Objects.equals(getDatanascimento(), vendedor.getDatanascimento()) &&
                Objects.equals(getDatacadastro(), vendedor.getDatacadastro()) &&
                Objects.equals(getStatus(), vendedor.getStatus()) &&
                Objects.equals(getCpf(), vendedor.getCpf()) &&
                Objects.equals(getRg(), vendedor.getRg()) &&
                Objects.equals(getTituloeleitoral(), vendedor.getTituloeleitoral()) &&
                Objects.equals(getCodregiao(), vendedor.getCodregiao()) &&
                Objects.equals(getDivisor(), vendedor.getDivisor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodvendedor(), getTipo(), getNome(), getCodcidade(), getEndereco(), getNumero(), getComplemento(), getCodbairro(), getCep(), getFone(), getFonefax(), getFonecelular(), getPerccomissao(), getEmail(), getDatanascimento(), getDatacadastro(), getStatus(), getCpf(), getRg(), getTituloeleitoral(), getCodregiao(), getDivisor());
    }

    @Override
    public String toString() {
        return codvendedor + " - " + nome;
    }

    public Boolean cadastraVendedor(Context context, Vendedor vendedor) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(vendedor.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), vendedor, valores);
        }

        if (valores.get("codvendedor") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codvendedor");
            valores.remove("cadastroandroid");
            valores.put("codvendedor", retorno);
            retorno = db.insert("vendedor", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            //Cursor cursor = cidade.retornaCidadeFiltradaCursor(context, Long.parseLong(valores.get("codcidade").toString()));
            Vendedor vendedorObjeto = retornaVendedorObjeto(context, Long.parseLong(valores.get("codvendedor").toString()));
            if (!vendedorObjeto.equals(new Vendedor())) {
                valores.remove("alteradoandroid");
                valores.put("alteradoandroid", true);
                long retorno = db.update("vendedor", valores, "codvendedor= " + valores.get("codvendedor").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                valores.remove("cadastroandroid");
                long retorno = db.insert("vendedor", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            }

        }
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,max(codvendedor) from vendedor", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Vendedor retornaVendedorObjeto(Context context, Long codigo) {
        Banco myDb = new Banco(context);
        Vendedor vendedor = new Vendedor();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM vendedor where codvendedor = " + codigo, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        List<Field> fieldListVendedor = new ArrayList<>(Arrays.asList(Vendedor.class.getDeclaredFields()));

        for (int j = 0; cursor.getCount() != j; j++) {
            vendedor = new Vendedor();

            for (int f = 0; fieldListVendedor.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListVendedor.get(f));
                String nomeCampo = fieldListVendedor.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retVendedor = getSetDinamico.insereField(fieldListVendedor.get(f), vendedor, retorno);
                    vendedor = (Vendedor) retVendedor;
                }
            }
        }
        db.close();
        return vendedor;
    }

    public List<Vendedor> retornaListaVendedor(Context context) {
        Banco myDb = new Banco(context);
        List<Vendedor> vendedors = new ArrayList<>();
        Vendedor vendedor = new Vendedor();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM vendedor", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                vendedor = new Vendedor();
                vendedor = retornaVendedorObjeto(context, cursor.getLong(cursor.getColumnIndex("codvendedor")));
                vendedors.add(vendedor);
                cursor.moveToNext();
            }
        }
        return vendedors;
    }
}

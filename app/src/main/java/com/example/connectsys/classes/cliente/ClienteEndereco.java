package com.example.connectsys.classes.cliente;

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

public class ClienteEndereco {

    Long codendereco;
    Long codcliente;
    Long codcidade;
    String endereco;
    String numero;
    String complemento;
    Long codbairro;
    String cep;
    String fone;
    String fonefax;
    String fonecelular;
    String tipo;
    String obs;
    String inscricaoestadual;

    public Long getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(Long codendereco) {
        this.codendereco = codendereco;
    }

    public Long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    @Override
    public String toString() {
        return codendereco + " - " + endereco + " - " + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteEndereco)) return false;
        ClienteEndereco that = (ClienteEndereco) o;
        return Objects.equals(getCodendereco(), that.getCodendereco()) &&
                Objects.equals(getCodcliente(), that.getCodcliente()) &&
                Objects.equals(getCodcidade(), that.getCodcidade()) &&
                Objects.equals(getEndereco(), that.getEndereco()) &&
                Objects.equals(getNumero(), that.getNumero()) &&
                Objects.equals(getComplemento(), that.getComplemento()) &&
                Objects.equals(getCodbairro(), that.getCodbairro()) &&
                Objects.equals(getCep(), that.getCep()) &&
                Objects.equals(getFone(), that.getFone()) &&
                Objects.equals(getFonefax(), that.getFonefax()) &&
                Objects.equals(getFonecelular(), that.getFonecelular()) &&
                Objects.equals(getTipo(), that.getTipo()) &&
                Objects.equals(getObs(), that.getObs()) &&
                Objects.equals(getInscricaoestadual(), that.getInscricaoestadual());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodendereco(), getCodcliente(), getCodcidade(), getEndereco(), getNumero(), getComplemento(), getCodbairro(), getCep(), getFone(), getFonefax(), getFonecelular(), getTipo(), getObs(), getInscricaoestadual());
    }

    public ClienteEndereco retornaClienteEndereco(Context context, Long codCliente) {
        Banco myDb = new Banco(context);
        ClienteEndereco clienteEndereco = new ClienteEndereco();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteendereco where codcliente = " + codCliente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(ClienteEndereco.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            ClienteEndereco clienteEndereco1 = new ClienteEndereco();

            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCliente = getSetDinamico.insereField(fieldListCliente.get(f), clienteEndereco1, retorno);
                    clienteEndereco1 = (ClienteEndereco) retCliente;
                }
            }
            clienteEndereco = clienteEndereco1;
        }
        db.close();
        return clienteEndereco;
    }

    public ClienteEndereco retornaEndereco(Context context, Long codendereco) {
        Banco myDb = new Banco(context);
        ClienteEndereco clienteEndereco = new ClienteEndereco();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteendereco where codendereco = " + codendereco, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(ClienteEndereco.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            ClienteEndereco clienteEndereco1 = new ClienteEndereco();

            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCliente = getSetDinamico.insereField(fieldListCliente.get(f), clienteEndereco1, retorno);
                    clienteEndereco1 = (ClienteEndereco) retCliente;
                }
            }
            clienteEndereco = clienteEndereco1;
        }
        db.close();
        return clienteEndereco;
    }

    public List<ClienteEndereco> retornaListaClienteEndereco(Context context, Long codcliente) {
        Banco myDb = new Banco(context);
        List<ClienteEndereco> clienteEnderecos = new ArrayList<>();
        ClienteEndereco clienteEndereco = new ClienteEndereco();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clienteendereco where codcliente = " + codcliente, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                clienteEndereco = new ClienteEndereco();
                clienteEndereco = retornaEndereco(context, cursor.getLong(cursor.getColumnIndex("codendereco")));
                clienteEnderecos.add(clienteEndereco);
                cursor.moveToNext();
            }
        }
        return clienteEnderecos;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codendereco) from clienteendereco", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Cursor retornaClienteEnderecoAlteradaAndroid(Context context, String tipo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clienteendereco where " + tipo + " = 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraCodClienteEndereco(Context context, Long codigoAndroid, Long codigoServidor) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("codendereco", codigoServidor);
        int retorno = db.update("clienteendereco", values, "codendereco = " + codigoAndroid, null);

    }

    public void removeClienteEnderecoAlteradaAndroid(Context context, String campo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(campo, "0");
        int retorno = db.update("clienteendereco", values, campo + " = 1", null);

    }

    public Boolean cadastraClienteEndereco(Context context, ClienteEndereco clienteEndereco) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(clienteEndereco.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), clienteEndereco, valores);
        }
        if (valores.get("codendereco") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codendereco");
            valores.remove("cadastroandroid");
            valores.put("codendereco", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("clienteendereco", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            ClienteEndereco clienteret = clienteEndereco.retornaEndereco(context, Long.parseLong(valores.get("codendereco").toString()));
            if (clienteret.equals(new ClienteEndereco())) {
                valores.remove("cadastroandroid");
                long retorno = db.insert("clienteendereco", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                if (!clienteret.equals(clienteEndereco)) {
                    valores.remove("alteradoandroid");
                    valores.put("alteradoandroid", true);
                    long retorno = db.update("clienteendereco", valores, "codendereco= " + valores.get("codendereco").toString(), null);
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

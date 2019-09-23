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

    public Cliente retornaClienteEndereco(Context context, Long codCliente) {
        Banco myDb = new Banco(context);
        Cliente cliente = new Cliente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM clienteendereco where codcliente = " + codCliente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(Cliente.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            Cliente cliente1 = new Cliente();

            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCliente = getSetDinamico.insereField(fieldListCliente.get(f), cliente1, retorno);
                    cliente1 = (Cliente) retCliente;
                }
            }
            cliente = cliente1;
        }
        db.close();
        return cliente;
    }

    public List<Cliente> retornaListaClienteEndereco(Context context, Long codcliente) {
        Banco myDb = new Banco(context);
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clienteendereco", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                cliente = retornaClienteEndereco(context, cursor.getLong(cursor.getColumnIndex("codcliente")));
                clientes.add(cliente);
                cursor.moveToNext();
            }
        }
        return clientes;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codcliente) from clienteendereco", null);
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
            retorno = db.insert("cliente", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            Cliente clienteret = clienteEndereco.retornaClienteEndereco(context, Long.parseLong(valores.get("codendereco").toString()));

            if (clienteret.equals(clienteEndereco)) {
                valores.remove("alteradoandroid");
                valores.put("alteradoandroid", true);
                long retorno = db.update("clienteendereco", valores, "codendereco= " + valores.get("codendereco").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                long retorno = retornaMaiorCod(context);
                retorno = retorno + 1;
                valores.remove("cadastroandroid");
                retorno = db.insert("clienteendereco", null, valores);
                db.close();
                valores.clear();
                return retorno != -1;
            }
        }
    }
}

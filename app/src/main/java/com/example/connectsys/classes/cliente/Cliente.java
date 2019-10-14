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
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente {


    Long codcliente;
    String fisicajuridica;
    String razaosocial;
    String nomefantasia;
    Date datacadastro;
    Date datanascimento;
    Date dataultimacompra;
    Long codocupacao;
    String tipoocupacao;
    String foneocupacao;
    String localocupacao;
    Long codcidade;
    String cnpj;
    String inscricaoestadualsuframa;
    String inscricaoestadual;
    String cpf;
    String rg;
    String tituloeleitoral;
    Double limitecredito;
    String fone;
    String fonefax;
    String fonecelular;
    String email;
    String site;
    String obs;
    String estadocivil;
    String conjugenome;
    Date conjugedatanascimento;
    String conjugecpf;
    String conjugerg;
    String foneconjuge;
    String inscricaomunicipal;
    Long codrepresentante;
    Long codconceito;
    String banco;
    String status;
    Boolean maladireta;
    String imagem;
    String emailnfe;
    Boolean enviarxml;
    Boolean enviarpdf;
    Boolean issqncidadecliente;
    Double rendamensal;
    Double conjugerendamensal;
    Long regimetributario;
    Boolean tratamentotributariodiferenciado;
    String obsnotapadrao;
    String particularidades;
    String pai;
    String mae;
    String motivobloqueio;
    Double percdesconto;
    String sexo;
    String endereco;
    String numero;
    String complemento;
    Long codbairro;
    String cep;
    String tipoie;
    Boolean consumidorfinal;
    Boolean cadastroandroid;

    public Boolean getCadastroandroid() {
        return cadastroandroid;
    }

    public void setCadastroandroid(Boolean cadastroandroid) {
        this.cadastroandroid = cadastroandroid;
    }

    public Long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
    }

    public String getFisicajuridica() {
        return fisicajuridica;
    }

    public void setFisicajuridica(String fisicajuridica) {
        this.fisicajuridica = fisicajuridica;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDataultimacompra() {
        return dataultimacompra;
    }

    public void setDataultimacompra(Date dataultimacompra) {
        this.dataultimacompra = dataultimacompra;
    }

    public Long getCodocupacao() {
        return codocupacao;
    }

    public void setCodocupacao(Long codocupacao) {
        this.codocupacao = codocupacao;
    }

    public String getTipoocupacao() {
        return tipoocupacao;
    }

    public void setTipoocupacao(String tipoocupacao) {
        this.tipoocupacao = tipoocupacao;
    }

    public String getFoneocupacao() {
        return foneocupacao;
    }

    public void setFoneocupacao(String foneocupacao) {
        this.foneocupacao = foneocupacao;
    }

    public String getLocalocupacao() {
        return localocupacao;
    }

    public void setLocalocupacao(String localocupacao) {
        this.localocupacao = localocupacao;
    }

    public Long getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Long codcidade) {
        this.codcidade = codcidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadualsuframa() {
        return inscricaoestadualsuframa;
    }

    public void setInscricaoestadualsuframa(String inscricaoestadualsuframa) {
        this.inscricaoestadualsuframa = inscricaoestadualsuframa;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
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

    public Double getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(Double limitecredito) {
        this.limitecredito = limitecredito;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getConjugenome() {
        return conjugenome;
    }

    public void setConjugenome(String conjugenome) {
        this.conjugenome = conjugenome;
    }

    public Date getConjugedatanascimento() {
        return conjugedatanascimento;
    }

    public void setConjugedatanascimento(Date conjugedatanascimento) {
        this.conjugedatanascimento = conjugedatanascimento;
    }

    public String getConjugecpf() {
        return conjugecpf;
    }

    public void setConjugecpf(String conjugecpf) {
        this.conjugecpf = conjugecpf;
    }

    public String getConjugerg() {
        return conjugerg;
    }

    public void setConjugerg(String conjugerg) {
        this.conjugerg = conjugerg;
    }

    public String getFoneconjuge() {
        return foneconjuge;
    }

    public void setFoneconjuge(String foneconjuge) {
        this.foneconjuge = foneconjuge;
    }

    public String getInscricaomunicipal() {
        return inscricaomunicipal;
    }

    public void setInscricaomunicipal(String inscricaomunicipal) {
        this.inscricaomunicipal = inscricaomunicipal;
    }

    public Long getCodrepresentante() {
        return codrepresentante;
    }

    public void setCodrepresentante(Long codrepresentante) {
        this.codrepresentante = codrepresentante;
    }

    public Long getCodconceito() {
        return codconceito;
    }

    public void setCodconceito(Long codconceito) {
        this.codconceito = codconceito;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getMaladireta() {
        return maladireta;
    }

    public void setMaladireta(Boolean maladireta) {
        this.maladireta = maladireta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getEmailnfe() {
        return emailnfe;
    }

    public void setEmailnfe(String emailnfe) {
        this.emailnfe = emailnfe;
    }

    public Boolean getEnviarxml() {
        return enviarxml;
    }

    public void setEnviarxml(Boolean enviarxml) {
        this.enviarxml = enviarxml;
    }

    public Boolean getEnviarpdf() {
        return enviarpdf;
    }

    public void setEnviarpdf(Boolean enviarpdf) {
        this.enviarpdf = enviarpdf;
    }

    public Boolean getIssqncidadecliente() {
        return issqncidadecliente;
    }

    public void setIssqncidadecliente(Boolean issqncidadecliente) {
        this.issqncidadecliente = issqncidadecliente;
    }

    public Double getRendamensal() {
        return rendamensal;
    }

    public void setRendamensal(Double rendamensal) {
        this.rendamensal = rendamensal;
    }

    public Double getConjugerendamensal() {
        return conjugerendamensal;
    }

    public void setConjugerendamensal(Double conjugerendamensal) {
        this.conjugerendamensal = conjugerendamensal;
    }

    public Long getRegimetributario() {
        return regimetributario;
    }

    public void setRegimetributario(Long regimetributario) {
        this.regimetributario = regimetributario;
    }

    public Boolean getTratamentotributariodiferenciado() {
        return tratamentotributariodiferenciado;
    }

    public void setTratamentotributariodiferenciado(Boolean tratamentotributariodiferenciado) {
        this.tratamentotributariodiferenciado = tratamentotributariodiferenciado;
    }

    public String getObsnotapadrao() {
        return obsnotapadrao;
    }

    public void setObsnotapadrao(String obsnotapadrao) {
        this.obsnotapadrao = obsnotapadrao;
    }

    public String getParticularidades() {
        return particularidades;
    }

    public void setParticularidades(String particularidades) {
        this.particularidades = particularidades;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getMotivobloqueio() {
        return motivobloqueio;
    }

    public void setMotivobloqueio(String motivobloqueio) {
        this.motivobloqueio = motivobloqueio;
    }

    public Double getPercdesconto() {
        return percdesconto;
    }

    public void setPercdesconto(Double percdesconto) {
        this.percdesconto = percdesconto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getTipoie() {
        return tipoie;
    }

    public void setTipoie(String tipoie) {
        this.tipoie = tipoie;
    }

    public Boolean getConsumidorfinal() {
        return consumidorfinal;
    }

    public void setConsumidorfinal(Boolean consumidorfinal) {
        this.consumidorfinal = consumidorfinal;
    }


    @Override
    public String toString() {
        return codcliente + " - " + razaosocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCodcliente(), cliente.getCodcliente()) &&
                Objects.equals(getFisicajuridica(), cliente.getFisicajuridica()) &&
                Objects.equals(getRazaosocial(), cliente.getRazaosocial()) &&
                Objects.equals(getNomefantasia(), cliente.getNomefantasia()) &&
                Objects.equals(getDatacadastro(), cliente.getDatacadastro()) &&
                Objects.equals(getDatanascimento(), cliente.getDatanascimento()) &&
                Objects.equals(getDataultimacompra(), cliente.getDataultimacompra()) &&
                Objects.equals(getCodocupacao(), cliente.getCodocupacao()) &&
                Objects.equals(getTipoocupacao(), cliente.getTipoocupacao()) &&
                Objects.equals(getFoneocupacao(), cliente.getFoneocupacao()) &&
                Objects.equals(getLocalocupacao(), cliente.getLocalocupacao()) &&
                Objects.equals(getCodcidade(), cliente.getCodcidade()) &&
                Objects.equals(getCnpj(), cliente.getCnpj()) &&
                Objects.equals(getInscricaoestadualsuframa(), cliente.getInscricaoestadualsuframa()) &&
                Objects.equals(getInscricaoestadual(), cliente.getInscricaoestadual()) &&
                Objects.equals(getCpf(), cliente.getCpf()) &&
                Objects.equals(getRg(), cliente.getRg()) &&
                Objects.equals(getTituloeleitoral(), cliente.getTituloeleitoral()) &&
                Objects.equals(getLimitecredito(), cliente.getLimitecredito()) &&
                Objects.equals(getFone(), cliente.getFone()) &&
                Objects.equals(getFonefax(), cliente.getFonefax()) &&
                Objects.equals(getFonecelular(), cliente.getFonecelular()) &&
                Objects.equals(getEmail(), cliente.getEmail()) &&
                Objects.equals(getSite(), cliente.getSite()) &&
                Objects.equals(getObs(), cliente.getObs()) &&
                Objects.equals(getEstadocivil(), cliente.getEstadocivil()) &&
                Objects.equals(getConjugenome(), cliente.getConjugenome()) &&
                Objects.equals(getConjugedatanascimento(), cliente.getConjugedatanascimento()) &&
                Objects.equals(getConjugecpf(), cliente.getConjugecpf()) &&
                Objects.equals(getConjugerg(), cliente.getConjugerg()) &&
                Objects.equals(getFoneconjuge(), cliente.getFoneconjuge()) &&
                Objects.equals(getInscricaomunicipal(), cliente.getInscricaomunicipal()) &&
                Objects.equals(getCodrepresentante(), cliente.getCodrepresentante()) &&
                Objects.equals(getCodconceito(), cliente.getCodconceito()) &&
                Objects.equals(getBanco(), cliente.getBanco()) &&
                Objects.equals(getStatus(), cliente.getStatus()) &&
                Objects.equals(getMaladireta(), cliente.getMaladireta()) &&
                Objects.equals(getImagem(), cliente.getImagem()) &&
                Objects.equals(getEmailnfe(), cliente.getEmailnfe()) &&
                Objects.equals(getEnviarxml(), cliente.getEnviarxml()) &&
                Objects.equals(getEnviarpdf(), cliente.getEnviarpdf()) &&
                Objects.equals(getIssqncidadecliente(), cliente.getIssqncidadecliente()) &&
                Objects.equals(getRendamensal(), cliente.getRendamensal()) &&
                Objects.equals(getConjugerendamensal(), cliente.getConjugerendamensal()) &&
                Objects.equals(getRegimetributario(), cliente.getRegimetributario()) &&
                Objects.equals(getTratamentotributariodiferenciado(), cliente.getTratamentotributariodiferenciado()) &&
                Objects.equals(getObsnotapadrao(), cliente.getObsnotapadrao()) &&
                Objects.equals(getParticularidades(), cliente.getParticularidades()) &&
                Objects.equals(getPai(), cliente.getPai()) &&
                Objects.equals(getMae(), cliente.getMae()) &&
                Objects.equals(getMotivobloqueio(), cliente.getMotivobloqueio()) &&
                Objects.equals(getPercdesconto(), cliente.getPercdesconto()) &&
                Objects.equals(getSexo(), cliente.getSexo()) &&
                Objects.equals(getEndereco(), cliente.getEndereco()) &&
                Objects.equals(getNumero(), cliente.getNumero()) &&
                Objects.equals(getComplemento(), cliente.getComplemento()) &&
                Objects.equals(getCodbairro(), cliente.getCodbairro()) &&
                Objects.equals(getCep(), cliente.getCep()) &&
                Objects.equals(getTipoie(), cliente.getTipoie()) &&
                Objects.equals(getConsumidorfinal(), cliente.getConsumidorfinal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodcliente(), getFisicajuridica(), getRazaosocial(), getNomefantasia(), getDatacadastro(), getDatanascimento(), getDataultimacompra(), getCodocupacao(), getTipoocupacao(), getFoneocupacao(), getLocalocupacao(), getCodcidade(), getCnpj(), getInscricaoestadualsuframa(), getInscricaoestadual(), getCpf(), getRg(), getTituloeleitoral(), getLimitecredito(), getFone(), getFonefax(), getFonecelular(), getEmail(), getSite(), getObs(), getEstadocivil(), getConjugenome(), getConjugedatanascimento(), getConjugecpf(), getConjugerg(), getFoneconjuge(), getInscricaomunicipal(), getCodrepresentante(), getCodconceito(), getBanco(), getStatus(), getMaladireta(), getImagem(), getEmailnfe(), getEnviarxml(), getEnviarpdf(), getIssqncidadecliente(), getRendamensal(), getConjugerendamensal(), getRegimetributario(), getTratamentotributariodiferenciado(), getObsnotapadrao(), getParticularidades(), getPai(), getMae(), getMotivobloqueio(), getPercdesconto(), getSexo(), getEndereco(), getNumero(), getComplemento(), getCodbairro(), getCep(), getTipoie(), getConsumidorfinal());
    }

    //FUNÇÕES DA CLASSE CLIENTE

    public Cliente retornaCliente(Context context, Long codCliente) {
        Banco myDb = new Banco(context);
        Cliente cliente = new Cliente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM cliente where codcliente = " + codCliente, null);
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

    public Cliente retornaClienteSimplificado(Context context, Long codCliente) {
        Banco myDb = new Banco(context);
        Cliente cliente = new Cliente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id, codcliente, razaosocial FROM cliente where codcliente = " + codCliente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(Cliente.class.getDeclaredFields()));

        for (int j = fieldListCliente.size() - 1; 0 <= j; j--) {
            if (fieldListCliente.get(j).getName().toLowerCase().equals("codcliente") || fieldListCliente.get(j).getName().toLowerCase().equals("razaosocial")) {

            } else {
                fieldListCliente.remove(j);
            }
        }

        for (int i = 0; cursor.getCount() != i; i++) {
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
            cursor.moveToNext();

        }
        db.close();
        return cliente;
    }

    public List<Cliente> retornaListaCliente(Context context, Boolean simplificado) {
        Banco myDb = new Banco(context);
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente", null);
        if (simplificado) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    cliente = new Cliente();
                    cliente = retornaClienteSimplificado(context, cursor.getLong(cursor.getColumnIndex("codcliente")));
                    clientes.add(cliente);
                    cursor.moveToNext();
                }
            }
        } else {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    cliente = new Cliente();
                    cliente = retornaCliente(context, cursor.getLong(cursor.getColumnIndex("codcliente")));
                    clientes.add(cliente);
                    cursor.moveToNext();
                }
            }
        }


        return clientes;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codcliente) from cliente", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Cursor retornaClienteAlteradaAndroid(Context context, String tipo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente where " + tipo + " = 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraPedidoCliente(Context context, Long codigoAndroid, Long codigoServidor) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("codcliente", codigoServidor);
        int retorno = db.update("pedido", values, "codcliente = " + codigoAndroid, null);
        values.clear();
    }

    public void alteraCodCliente(Context context, Long codigoAndroid, Long codigoServidor) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("codcliente", codigoServidor);
        int retorno = db.update("cliente", values, "codcliente = " + codigoAndroid, null);

    }

    public void removeClienteAlteradaAndroid(Context context, String campo) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(campo, "0");
        int retorno = db.update("cliente", values, campo + " = 1", null);

    }

    public Boolean cadastraCliente(Context context, Cliente cliente, Boolean sincronizacao) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(cliente.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), cliente, valores);
        }
        if (valores.get("codcliente") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("codcliente");
            valores.remove("cadastroandroid");
            valores.put("codcliente", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("cliente", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            Cliente clienteret = cliente.retornaCliente(context, Long.parseLong(valores.get("codcliente").toString()));

            if (!clienteret.equals(cliente)) {
                if (clienteret.equals(new Cliente())) {
                    long retorno = retornaMaiorCod(context);
                    retorno = retorno + 1;
                    valores.remove("cadastroandroid");
                    retorno = db.insert("cliente", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {
                    if (!sincronizacao) {
                        valores.remove("alteradoandroid");
                        valores.put("alteradoandroid", true);
                        long retorno = db.update("cliente", valores, "codcliente= " + valores.get("codcliente").toString(), null);
                        db.close();
                        valores.clear();
                        return retorno != -1;
                    }
                }
            }
            return true;
        }
    }

    public Long retornaNumeroDeClientes(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM cliente", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(0);
        } else {
            return 0L;
        }
    }
}

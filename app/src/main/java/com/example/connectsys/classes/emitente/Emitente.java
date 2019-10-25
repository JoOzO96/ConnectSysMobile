package com.example.connectsys.classes.emitente;

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

public class Emitente {

    Long codemitente;
    String razaosocial;
    String nomefantasia;
    Long codcidade;
    String endereco;
    String numero;
    String complemento;
    Long codbairro;
    String cep;
    String cnpj;
    String inscricaoestadual;
    String inscricaoestadualsub;
    String inscricaomunicipal;
    String cnae;
    String cpf;
    String rg;
    String fone;
    String fonefax;
    String fonecelular;
    String obs;
    String emailservidorsmtp;
    Long emailporta;
    String emaillogin;
    String emailsenha;
    Boolean emailrequerautenticacao;
    Boolean emailusaconexaosegura;
    String emailnomeremetente;
    String emailemailremetente;
    Boolean cliente;
    Double percaproveitamentocredito;
    String regimetributario;
    String versaoenvio;
    String versaocorrecao;
    String versaocancelamento;
    String versaomanifesto;
    String versaoconsultacadastro;
    String email;
    String contadornome;
    String contadorcpf;
    String contadorcrc;
    String contadorcnpj;
    String contadorcep;
    String contadorendereco;
    String contadornumero;
    String contadorcomplemento;
    Long contadorcodbairro;
    String contadorfone;
    String contadorfonefax;
    String contadoremail;
    Long contadorcodcidade;
    String modulo;
    String tipoemitente;
    Boolean ajustefone;
    Boolean ajustoupercdescontonfc;
    Boolean enviarxmls;
    Boolean enviararquivosautomaticamente;
    Boolean emitenfe;
    Boolean emitenfce;
    String producaohomologacao;
    String tipoimpressao;
    Boolean habilitapesagem;
    Boolean ajustoutamanhotipodocumentopedido;
    Boolean coletaponto;
    Boolean permitedadosmotor;
    Boolean emitemdfe;
    String versaomdfe;
    Boolean permitecaixaindividual;
    Boolean ajusteemailcontador;
    Boolean emailrequertls;
    Long emailportatls;
    String emailmetodossl;
    String emailmodossl;
    String emailusotls;
    String emailautenticacaossl;
    Long emailtimeout;
    Boolean enviardadosftp;
    Boolean habilitaproducao;
    Boolean emitecte;
    String versaocte;
    Boolean emitenfs;
    String enviarcopiaparaemail;
    Boolean emiteboleto;
    Boolean enviarato;
    Boolean enviarcefem;
    Boolean emitecteos;
    String versaotabelaibpt;
    String regimeespecial;
    Long intervalobackup;

    public Long getCodemitente() {
        return codemitente;
    }

    public void setCodemitente(Long codemitente) {
        this.codemitente = codemitente;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getInscricaoestadualsub() {
        return inscricaoestadualsub;
    }

    public void setInscricaoestadualsub(String inscricaoestadualsub) {
        this.inscricaoestadualsub = inscricaoestadualsub;
    }

    public String getInscricaomunicipal() {
        return inscricaomunicipal;
    }

    public void setInscricaomunicipal(String inscricaomunicipal) {
        this.inscricaomunicipal = inscricaomunicipal;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEmailservidorsmtp() {
        return emailservidorsmtp;
    }

    public void setEmailservidorsmtp(String emailservidorsmtp) {
        this.emailservidorsmtp = emailservidorsmtp;
    }

    public Long getEmailporta() {
        return emailporta;
    }

    public void setEmailporta(Long emailporta) {
        this.emailporta = emailporta;
    }

    public String getEmaillogin() {
        return emaillogin;
    }

    public void setEmaillogin(String emaillogin) {
        this.emaillogin = emaillogin;
    }

    public String getEmailsenha() {
        return emailsenha;
    }

    public void setEmailsenha(String emailsenha) {
        this.emailsenha = emailsenha;
    }

    public Boolean getEmailrequerautenticacao() {
        return emailrequerautenticacao;
    }

    public void setEmailrequerautenticacao(Boolean emailrequerautenticacao) {
        this.emailrequerautenticacao = emailrequerautenticacao;
    }

    public Boolean getEmailusaconexaosegura() {
        return emailusaconexaosegura;
    }

    public void setEmailusaconexaosegura(Boolean emailusaconexaosegura) {
        this.emailusaconexaosegura = emailusaconexaosegura;
    }

    public String getEmailnomeremetente() {
        return emailnomeremetente;
    }

    public void setEmailnomeremetente(String emailnomeremetente) {
        this.emailnomeremetente = emailnomeremetente;
    }

    public String getEmailemailremetente() {
        return emailemailremetente;
    }

    public void setEmailemailremetente(String emailemailremetente) {
        this.emailemailremetente = emailemailremetente;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Double getPercaproveitamentocredito() {
        return percaproveitamentocredito;
    }

    public void setPercaproveitamentocredito(Double percaproveitamentocredito) {
        this.percaproveitamentocredito = percaproveitamentocredito;
    }

    public String getRegimetributario() {
        return regimetributario;
    }

    public void setRegimetributario(String regimetributario) {
        this.regimetributario = regimetributario;
    }

    public String getVersaoenvio() {
        return versaoenvio;
    }

    public void setVersaoenvio(String versaoenvio) {
        this.versaoenvio = versaoenvio;
    }

    public String getVersaocorrecao() {
        return versaocorrecao;
    }

    public void setVersaocorrecao(String versaocorrecao) {
        this.versaocorrecao = versaocorrecao;
    }

    public String getVersaocancelamento() {
        return versaocancelamento;
    }

    public void setVersaocancelamento(String versaocancelamento) {
        this.versaocancelamento = versaocancelamento;
    }

    public String getVersaomanifesto() {
        return versaomanifesto;
    }

    public void setVersaomanifesto(String versaomanifesto) {
        this.versaomanifesto = versaomanifesto;
    }

    public String getVersaoconsultacadastro() {
        return versaoconsultacadastro;
    }

    public void setVersaoconsultacadastro(String versaoconsultacadastro) {
        this.versaoconsultacadastro = versaoconsultacadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContadornome() {
        return contadornome;
    }

    public void setContadornome(String contadornome) {
        this.contadornome = contadornome;
    }

    public String getContadorcpf() {
        return contadorcpf;
    }

    public void setContadorcpf(String contadorcpf) {
        this.contadorcpf = contadorcpf;
    }

    public String getContadorcrc() {
        return contadorcrc;
    }

    public void setContadorcrc(String contadorcrc) {
        this.contadorcrc = contadorcrc;
    }

    public String getContadorcnpj() {
        return contadorcnpj;
    }

    public void setContadorcnpj(String contadorcnpj) {
        this.contadorcnpj = contadorcnpj;
    }

    public String getContadorcep() {
        return contadorcep;
    }

    public void setContadorcep(String contadorcep) {
        this.contadorcep = contadorcep;
    }

    public String getContadorendereco() {
        return contadorendereco;
    }

    public void setContadorendereco(String contadorendereco) {
        this.contadorendereco = contadorendereco;
    }

    public String getContadornumero() {
        return contadornumero;
    }

    public void setContadornumero(String contadornumero) {
        this.contadornumero = contadornumero;
    }

    public String getContadorcomplemento() {
        return contadorcomplemento;
    }

    public void setContadorcomplemento(String contadorcomplemento) {
        this.contadorcomplemento = contadorcomplemento;
    }

    public Long getContadorcodbairro() {
        return contadorcodbairro;
    }

    public void setContadorcodbairro(Long contadorcodbairro) {
        this.contadorcodbairro = contadorcodbairro;
    }

    public String getContadorfone() {
        return contadorfone;
    }

    public void setContadorfone(String contadorfone) {
        this.contadorfone = contadorfone;
    }

    public String getContadorfonefax() {
        return contadorfonefax;
    }

    public void setContadorfonefax(String contadorfonefax) {
        this.contadorfonefax = contadorfonefax;
    }

    public String getContadoremail() {
        return contadoremail;
    }

    public void setContadoremail(String contadoremail) {
        this.contadoremail = contadoremail;
    }

    public Long getContadorcodcidade() {
        return contadorcodcidade;
    }

    public void setContadorcodcidade(Long contadorcodcidade) {
        this.contadorcodcidade = contadorcodcidade;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getTipoemitente() {
        return tipoemitente;
    }

    public void setTipoemitente(String tipoemitente) {
        this.tipoemitente = tipoemitente;
    }

    public Boolean getAjustefone() {
        return ajustefone;
    }

    public void setAjustefone(Boolean ajustefone) {
        this.ajustefone = ajustefone;
    }

    public Boolean getAjustoupercdescontonfc() {
        return ajustoupercdescontonfc;
    }

    public void setAjustoupercdescontonfc(Boolean ajustoupercdescontonfc) {
        this.ajustoupercdescontonfc = ajustoupercdescontonfc;
    }

    public Boolean getEnviarxmls() {
        return enviarxmls;
    }

    public void setEnviarxmls(Boolean enviarxmls) {
        this.enviarxmls = enviarxmls;
    }

    public Boolean getEnviararquivosautomaticamente() {
        return enviararquivosautomaticamente;
    }

    public void setEnviararquivosautomaticamente(Boolean enviararquivosautomaticamente) {
        this.enviararquivosautomaticamente = enviararquivosautomaticamente;
    }

    public Boolean getEmitenfe() {
        return emitenfe;
    }

    public void setEmitenfe(Boolean emitenfe) {
        this.emitenfe = emitenfe;
    }

    public Boolean getEmitenfce() {
        return emitenfce;
    }

    public void setEmitenfce(Boolean emitenfce) {
        this.emitenfce = emitenfce;
    }

    public String getProducaohomologacao() {
        return producaohomologacao;
    }

    public void setProducaohomologacao(String producaohomologacao) {
        this.producaohomologacao = producaohomologacao;
    }

    public String getTipoimpressao() {
        return tipoimpressao;
    }

    public void setTipoimpressao(String tipoimpressao) {
        this.tipoimpressao = tipoimpressao;
    }

    public Boolean getHabilitapesagem() {
        return habilitapesagem;
    }

    public void setHabilitapesagem(Boolean habilitapesagem) {
        this.habilitapesagem = habilitapesagem;
    }

    public Boolean getAjustoutamanhotipodocumentopedido() {
        return ajustoutamanhotipodocumentopedido;
    }

    public void setAjustoutamanhotipodocumentopedido(Boolean ajustoutamanhotipodocumentopedido) {
        this.ajustoutamanhotipodocumentopedido = ajustoutamanhotipodocumentopedido;
    }

    public Boolean getColetaponto() {
        return coletaponto;
    }

    public void setColetaponto(Boolean coletaponto) {
        this.coletaponto = coletaponto;
    }

    public Boolean getPermitedadosmotor() {
        return permitedadosmotor;
    }

    public void setPermitedadosmotor(Boolean permitedadosmotor) {
        this.permitedadosmotor = permitedadosmotor;
    }

    public Boolean getEmitemdfe() {
        return emitemdfe;
    }

    public void setEmitemdfe(Boolean emitemdfe) {
        this.emitemdfe = emitemdfe;
    }

    public String getVersaomdfe() {
        return versaomdfe;
    }

    public void setVersaomdfe(String versaomdfe) {
        this.versaomdfe = versaomdfe;
    }

    public Boolean getPermitecaixaindividual() {
        return permitecaixaindividual;
    }

    public void setPermitecaixaindividual(Boolean permitecaixaindividual) {
        this.permitecaixaindividual = permitecaixaindividual;
    }

    public Boolean getAjusteemailcontador() {
        return ajusteemailcontador;
    }

    public void setAjusteemailcontador(Boolean ajusteemailcontador) {
        this.ajusteemailcontador = ajusteemailcontador;
    }

    public Boolean getEmailrequertls() {
        return emailrequertls;
    }

    public void setEmailrequertls(Boolean emailrequertls) {
        this.emailrequertls = emailrequertls;
    }

    public Long getEmailportatls() {
        return emailportatls;
    }

    public void setEmailportatls(Long emailportatls) {
        this.emailportatls = emailportatls;
    }

    public String getEmailmetodossl() {
        return emailmetodossl;
    }

    public void setEmailmetodossl(String emailmetodossl) {
        this.emailmetodossl = emailmetodossl;
    }

    public String getEmailmodossl() {
        return emailmodossl;
    }

    public void setEmailmodossl(String emailmodossl) {
        this.emailmodossl = emailmodossl;
    }

    public String getEmailusotls() {
        return emailusotls;
    }

    public void setEmailusotls(String emailusotls) {
        this.emailusotls = emailusotls;
    }

    public String getEmailautenticacaossl() {
        return emailautenticacaossl;
    }

    public void setEmailautenticacaossl(String emailautenticacaossl) {
        this.emailautenticacaossl = emailautenticacaossl;
    }

    public Long getEmailtimeout() {
        return emailtimeout;
    }

    public void setEmailtimeout(Long emailtimeout) {
        this.emailtimeout = emailtimeout;
    }

    public Boolean getEnviardadosftp() {
        return enviardadosftp;
    }

    public void setEnviardadosftp(Boolean enviardadosftp) {
        this.enviardadosftp = enviardadosftp;
    }

    public Boolean getHabilitaproducao() {
        return habilitaproducao;
    }

    public void setHabilitaproducao(Boolean habilitaproducao) {
        this.habilitaproducao = habilitaproducao;
    }

    public Boolean getEmitecte() {
        return emitecte;
    }

    public void setEmitecte(Boolean emitecte) {
        this.emitecte = emitecte;
    }

    public String getVersaocte() {
        return versaocte;
    }

    public void setVersaocte(String versaocte) {
        this.versaocte = versaocte;
    }

    public Boolean getEmitenfs() {
        return emitenfs;
    }

    public void setEmitenfs(Boolean emitenfs) {
        this.emitenfs = emitenfs;
    }

    public String getEnviarcopiaparaemail() {
        return enviarcopiaparaemail;
    }

    public void setEnviarcopiaparaemail(String enviarcopiaparaemail) {
        this.enviarcopiaparaemail = enviarcopiaparaemail;
    }

    public Boolean getEmiteboleto() {
        return emiteboleto;
    }

    public void setEmiteboleto(Boolean emiteboleto) {
        this.emiteboleto = emiteboleto;
    }

    public Boolean getEnviarato() {
        return enviarato;
    }

    public void setEnviarato(Boolean enviarato) {
        this.enviarato = enviarato;
    }

    public Boolean getEnviarcefem() {
        return enviarcefem;
    }

    public void setEnviarcefem(Boolean enviarcefem) {
        this.enviarcefem = enviarcefem;
    }

    public Boolean getEmitecteos() {
        return emitecteos;
    }

    public void setEmitecteos(Boolean emitecteos) {
        this.emitecteos = emitecteos;
    }

    public String getVersaotabelaibpt() {
        return versaotabelaibpt;
    }

    public void setVersaotabelaibpt(String versaotabelaibpt) {
        this.versaotabelaibpt = versaotabelaibpt;
    }

    public String getRegimeespecial() {
        return regimeespecial;
    }

    public void setRegimeespecial(String regimeespecial) {
        this.regimeespecial = regimeespecial;
    }

    public Long getIntervalobackup() {
        return intervalobackup;
    }

    public void setIntervalobackup(Long intervalobackup) {
        this.intervalobackup = intervalobackup;
    }

    public Cursor retornaConfiguracaoGeralFiltradoCursor(Context context, Long codemitente) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM emitente where codemitente = " + codemitente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Emitente retornaEmitente(Context context, Long codemitente) {
        Banco myDb = new Banco(context);
        Emitente emitente = new Emitente();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM emitente where codemitente = " + codemitente, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(Emitente.class.getDeclaredFields()));

        for (int f = 0; fieldList.size() != f; f++) {
            if (fieldList.get(f).getName().toLowerCase().equals("alteradoandroid")) {
                fieldList.remove(f);
            }
            if (fieldList.get(f).getName().toLowerCase().equals("cadastroandroid")) {
                fieldList.remove(f);
            }
            if (fieldList.get(f).getName().toLowerCase().equals("deletadooandroid")) {
                fieldList.remove(f);
            }
        }

        for (int j = 0; cursor.getCount() != j; j++) {
            emitente = new Emitente();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), emitente, retorno);
                    emitente = (Emitente) ret;
                }
            }
        }
        db.close();
        return emitente;

    }

    public Boolean cadastraEmitente(Context context, Emitente emitente) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(emitente.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), emitente, valores);
        }

        if (valores.get("codemitente") == null) {
            db.insert("emitente", null, valores);
            db.close();
            valores.clear();
            return true;
        } else {
            Cursor cursor = emitente.retornaConfiguracaoGeralFiltradoCursor(context, Long.parseLong(valores.get("codemitente").toString()));

            if (cursor.getCount() > 0) {
                long retorno = db.update("emitente", valores, "codemitente = " + valores.get("codemitente").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                db.insert("emitente", null, valores);
                db.close();
                valores.clear();
                return true;
            }

        }
    }
}

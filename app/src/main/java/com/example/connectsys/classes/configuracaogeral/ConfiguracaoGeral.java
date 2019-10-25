package com.example.connectsys.classes.configuracaogeral;

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

public class ConfiguracaoGeral {

    Long codconfiguracao;
    Double limitecreditopadrao;
    Long codvendedorpadrao;
    Long codformapagtopadrao;
    Long codtabelaprecopadrao;
    Long codcontacaixapadraoreceber;
    Long codcontacaixapadraopagar;
    Long codbancopadrao;
    Long codconceitopadrao;
    Long codcidadepadrao;
    Long codcfoppadraoservicos;
    Long codmecanicopadrao;
    Long codmecanicapadrao;
    Long codrepresentantepadrao;
    Long codcontacaixacomissaopadrao;
    Boolean baixarentrada;
    Boolean verificarparcelasentrada;
    Boolean verificarparcelaspedido;
    Long validadeorcamento;
    Double percjurocontaspagar;
    Double percjurocontasreceber;
    Double juroatrasoduplicata;
    Long codempresapadrao;
    Long codocupacaopadrao;
    Long codmarcapadrao;
    Long codlocalizacaopadrao;
    Long codgrupopadrao;
    Long codicmsnotafiscalpadrao;
    Long codicmscupompadrao;
    Long codunidadepadrao;
    Long codcfoppadraoproduto;
    String codipientradapadrao;
    String codipisaidapadrao;
    String codpispadrao;
    String codcofinspadrao;
    Boolean alterartabelasnasentradas;
    Long codtabelaprecocupompadrao;
    Long codcontacaixacupompadrao;
    Boolean movimentarcaixacontasrecebernasnotas;
    Boolean bloquearvendacupomcontareceber;
    Boolean bloquearvendapedidocontareceber;
    Boolean bloquearvendanotacontareceber;
    Boolean financeirosomentenasretiradas;
    Long codcontacaixadevolucao;
    Long codformapagtodevolucao;
    Boolean calculartributosnospedidosnormais;
    Boolean calculartributosnospedidossimplificados;
    Boolean calculartributosnospedidosfrentecaixa;
    Boolean naopermitirdiminuirvalorunitariopedidos;
    Boolean mostrarultimovalorvendidonospedidos;
    Boolean mostrarperclucropedidos;
    Boolean mostrarpercdescontocomissaopedidos;
    String textocarne;
    String textopedido;
    String textoorcamento;
    String textocondicional;
    Boolean mantervalorvendaaposatualizarcustoformulario;
    Boolean mostrarvalorminimovendapedidos;
    String codprodutovariavel;
    String csosnespecialpadrao;
    String cstespecialpadrao;
    Long codcfopespecialpadrao;
    String codpisespecialpadrao;
    String codcofinsespecialpadrao;
    Boolean imprimirnotasemconfirmacao;
    Boolean imprimirpedidosemconfirmacao;
    Boolean bloquearquantidadenocadastro;
    Boolean bloquearvendacupomematraso;
    Boolean bloquearvendapedidoematraso;
    Boolean bloquearvendanotaematraso;
    Boolean solicitarabrirpreco;
    Boolean solicitarabrircasosespeciais;
    Boolean solicitarabrirsimilar;
    Boolean solicitarabrirreferencia;
    Boolean aceitarletracodproduto;
    Boolean cupomautomaticopedido;
    String formulariopedidoabrir;
    String modofretenotapadrao;
    String modofretepedidopadrao;
    String cstentradapadrao;
    String cstsaidapadrao;
    String csosnpadrao;
    String ncmpadrao;
    String codpisentradapadrao;
    Double percpisentradapadrao;
    Double valorpisentradapadrao;
    Double percpissaidapadrao;
    Double valorpissaidapadrao;
    String codcofinsentradapadrao;
    Double perccofinsentradapadrao;
    Double valorcofinsentradapadrao;
    Double perccofinssaidapadrao;
    Double valorcofinssaidapadrao;
    Long codclientepedidopadrao;
    Boolean mantermaiorcustoentrada;
    String tipodocumentopedido;
    Long codcontacaixamovimentocaixacredito;
    Long codcontacaixamovimentocaixadebito;
    Long codformapagtomovimentocaixainterno;
    Boolean verificarcaixaabertoinicializar;
    Boolean movimentarestoquecupom;
    Boolean mostrartributosnospedidos;
    Boolean mensagemcontasrecebernota;
    Boolean gerarnotadopedido;
    Boolean mensagemcontasrecebercupom;
    Boolean bloquearvendaquantidadezerocupom;
    Boolean emitircupomdopedido;
    Boolean mensagemestoquenegativo;
    Boolean mensagemestoquemaximo;
    Boolean mensagemestoqueminimo;
    Boolean mensagemcontasreceberpedido;
    Long codpracapadrao;
    Boolean mensagemcontaspagar;
    Double margemsuperiorretiradadevolucao;
    Boolean movimentarestoquenotas;
    Boolean liberarduplicidadecodigo;
    Boolean zerarmovimentacaopedidos;
    Boolean movimentarestoqueorcamento;
    Boolean bloquearpedidos;
    Boolean abrirminimomaximoaoiniciar;
    Boolean baixarpedido;
    Boolean baixarnota;
    Long codcontacaixapadrao;
    String botao6;
    Long diasretroativos;
    Boolean usarcfopoutrosnoestorno;
    Double percentualminimopadrao;
    Double percentualpadrao;
    Boolean mostrartotalvendanocontasreceber;
    Boolean bloquearcasonaopreenchidocfop;
    Boolean bloquearsemregimetributario;
    String tipodataspedido;
    String tipodatasnota;
    String tipodatasfinanceiro;
    Boolean cadastroclientesimplificado;
    Boolean mostrarbotaopedidoembranco;
    Boolean abrirlocalizacaopedidosemaberto;
    Boolean habilitarimprimirpedidosemfechar;
    Boolean ordenarlocalizacaopedidopornomedata;
    Boolean opcaosimcomopadraoimprimirpedido;
    Boolean ajustarcstnotadevolucao;
    Boolean mostrarmensagemnfcesemaberto;
    Boolean habilitaralterarempresanospedidos;
    Boolean exibirimportacaonfc;
    Boolean mensagemvalorminimopedido;
    Boolean testarcustoitemnopedido;
    Boolean habilitartrocaemitente;
    Boolean movimentestoquepedido;
    Boolean mostrarfretenospedidossimplificados;
    Boolean relatoriocontaazul;
    Boolean operacaorapidapedidosimplificado;
    Boolean etiquetasnosprodutos;
    Long codetiquetas;
    Boolean convertercodigoparaean;
    Boolean habilitaralterarempresafinanceiro;
    Boolean habilitadadoscultivo;
    Boolean mostrarvaloresnalocalizacaoprodutos;
    Boolean mostrarfotolocalizacaoprodutos;
    Boolean habilitadatascomemorativas;
    Boolean criarparcelaavistasemsolicitar;
    Boolean arredondardecimalnasparcelas;
    Boolean permitecaixaindividual;
    Boolean verificarquantidadesnotas;
    Boolean permitirduplicaritemnopedido;
    Boolean criarparcelaavistasemsolicitarnfce;
    Long codvendedorpadraonotas;
    Boolean usarvendedorusuarionota;
    Boolean usarvendedorusuarionfce;
    String tipoordenacaolocalizacaopedido;
    Boolean cadastrarnovosempreimportacaoxml;
    Boolean bloquearduplicidadeitemnota;
    Boolean bloquearduplicidadeitemcupom;
    Boolean mostraritenslocalizacaopedido;
    Boolean avancoautomaticocupom;
    Boolean abrirgavetafechamento;
    Boolean ajustarcstnotaremessa;
    Boolean movimentarestoquecondicional;
    Boolean fococodigoaolocalizarproduto;
    Boolean operacaosimpleslocalizacaoprodutos;
    Boolean mantertotaisdigitadosnasentradas;
    Boolean mostrarparticularidadespedidos;
    Boolean mostrarparticularidadesnotas;
    Long diasprazoautomatico;
    String tipodocumentofiscalgerardopedido;
    Boolean localizacaoprodutorapida;
    Boolean movimentarestoquenfce;
    Boolean bloquearpedidoquantidadenegativa;
    Boolean chassicadastrocliente;
    Boolean possibilitarimportardaentradanopedido;
    Boolean movimentarfinandeironfs;
    Boolean irnotanovaaoabrir;
    Boolean permitiralterartipo;
    Boolean solicitarlancarchequecaixa;
    Long codnaturezadevolucao;
    Boolean ajustarcsosnnaocontribuinte;
    String csosnparaclientesfinais;
    Long codoperadorpadrao;
    String focolocalizarcontareceber;
    Boolean sairquantolocalizarumunicoregistrocontasreceber;
    Boolean controlarst;
    String focoaposlocalizaritempedido;
    Long quantidadenotaslimitemostrar;
    String focofinalizarnfce;
    Double quantidadeitemnfce;
    Long cfoppadraocadastroproduto;
    Boolean abrirgerarparcelasautomaticamente;
    String tipoordenacaoitempedido;
    Boolean naoverificarduplicidadecasoeandiferente;
    Long quantidadepedidoslimitelentidao;
    Boolean consumidorfinalpadraonfe;
    String tipolocalizacaopedido;
    String foconovoitemnfce;
    Boolean mantervalorvendacustoatualmenorcustoanterior;
    Boolean adicionarinformacoesprodutoanota;
    Boolean cadastroprecoautomatico;
    Double decimalarredondar;
    String botao7;
    Boolean gerarnfsdopedido;
    Boolean abrirconsultacontasreceberatraso;
    Boolean solicitarvalorduplicarcte;
    Boolean avisarcomposto;
    Boolean bloquearcomposto;
    Boolean naomovimentarcaixanocontaspagar;
    Long codnaturezadevolucaosaida;
    Boolean imprimiravisognredifal;
    Boolean bloquearduplicidadeentrada;

    public Long getCodconfiguracao() {
        return codconfiguracao;
    }

    public void setCodconfiguracao(Long codconfiguracao) {
        this.codconfiguracao = codconfiguracao;
    }

    public Double getLimitecreditopadrao() {
        return limitecreditopadrao;
    }

    public void setLimitecreditopadrao(Double limitecreditopadrao) {
        this.limitecreditopadrao = limitecreditopadrao;
    }

    public Long getCodvendedorpadrao() {
        return codvendedorpadrao;
    }

    public void setCodvendedorpadrao(Long codvendedorpadrao) {
        this.codvendedorpadrao = codvendedorpadrao;
    }

    public Long getCodformapagtopadrao() {
        return codformapagtopadrao;
    }

    public void setCodformapagtopadrao(Long codformapagtopadrao) {
        this.codformapagtopadrao = codformapagtopadrao;
    }

    public Long getCodtabelaprecopadrao() {
        return codtabelaprecopadrao;
    }

    public void setCodtabelaprecopadrao(Long codtabelaprecopadrao) {
        this.codtabelaprecopadrao = codtabelaprecopadrao;
    }

    public Long getCodcontacaixapadraoreceber() {
        return codcontacaixapadraoreceber;
    }

    public void setCodcontacaixapadraoreceber(Long codcontacaixapadraoreceber) {
        this.codcontacaixapadraoreceber = codcontacaixapadraoreceber;
    }

    public Long getCodcontacaixapadraopagar() {
        return codcontacaixapadraopagar;
    }

    public void setCodcontacaixapadraopagar(Long codcontacaixapadraopagar) {
        this.codcontacaixapadraopagar = codcontacaixapadraopagar;
    }

    public Long getCodbancopadrao() {
        return codbancopadrao;
    }

    public void setCodbancopadrao(Long codbancopadrao) {
        this.codbancopadrao = codbancopadrao;
    }

    public Long getCodconceitopadrao() {
        return codconceitopadrao;
    }

    public void setCodconceitopadrao(Long codconceitopadrao) {
        this.codconceitopadrao = codconceitopadrao;
    }

    public Long getCodcidadepadrao() {
        return codcidadepadrao;
    }

    public void setCodcidadepadrao(Long codcidadepadrao) {
        this.codcidadepadrao = codcidadepadrao;
    }

    public Long getCodcfoppadraoservicos() {
        return codcfoppadraoservicos;
    }

    public void setCodcfoppadraoservicos(Long codcfoppadraoservicos) {
        this.codcfoppadraoservicos = codcfoppadraoservicos;
    }

    public Long getCodmecanicopadrao() {
        return codmecanicopadrao;
    }

    public void setCodmecanicopadrao(Long codmecanicopadrao) {
        this.codmecanicopadrao = codmecanicopadrao;
    }

    public Long getCodmecanicapadrao() {
        return codmecanicapadrao;
    }

    public void setCodmecanicapadrao(Long codmecanicapadrao) {
        this.codmecanicapadrao = codmecanicapadrao;
    }

    public Long getCodrepresentantepadrao() {
        return codrepresentantepadrao;
    }

    public void setCodrepresentantepadrao(Long codrepresentantepadrao) {
        this.codrepresentantepadrao = codrepresentantepadrao;
    }

    public Long getCodcontacaixacomissaopadrao() {
        return codcontacaixacomissaopadrao;
    }

    public void setCodcontacaixacomissaopadrao(Long codcontacaixacomissaopadrao) {
        this.codcontacaixacomissaopadrao = codcontacaixacomissaopadrao;
    }

    public Boolean getBaixarentrada() {
        return baixarentrada;
    }

    public void setBaixarentrada(Boolean baixarentrada) {
        this.baixarentrada = baixarentrada;
    }

    public Boolean getVerificarparcelasentrada() {
        return verificarparcelasentrada;
    }

    public void setVerificarparcelasentrada(Boolean verificarparcelasentrada) {
        this.verificarparcelasentrada = verificarparcelasentrada;
    }

    public Boolean getVerificarparcelaspedido() {
        return verificarparcelaspedido;
    }

    public void setVerificarparcelaspedido(Boolean verificarparcelaspedido) {
        this.verificarparcelaspedido = verificarparcelaspedido;
    }

    public Long getValidadeorcamento() {
        return validadeorcamento;
    }

    public void setValidadeorcamento(Long validadeorcamento) {
        this.validadeorcamento = validadeorcamento;
    }

    public Double getPercjurocontaspagar() {
        return percjurocontaspagar;
    }

    public void setPercjurocontaspagar(Double percjurocontaspagar) {
        this.percjurocontaspagar = percjurocontaspagar;
    }

    public Double getPercjurocontasreceber() {
        return percjurocontasreceber;
    }

    public void setPercjurocontasreceber(Double percjurocontasreceber) {
        this.percjurocontasreceber = percjurocontasreceber;
    }

    public Double getJuroatrasoduplicata() {
        return juroatrasoduplicata;
    }

    public void setJuroatrasoduplicata(Double juroatrasoduplicata) {
        this.juroatrasoduplicata = juroatrasoduplicata;
    }

    public Long getCodempresapadrao() {
        return codempresapadrao;
    }

    public void setCodempresapadrao(Long codempresapadrao) {
        this.codempresapadrao = codempresapadrao;
    }

    public Long getCodocupacaopadrao() {
        return codocupacaopadrao;
    }

    public void setCodocupacaopadrao(Long codocupacaopadrao) {
        this.codocupacaopadrao = codocupacaopadrao;
    }

    public Long getCodmarcapadrao() {
        return codmarcapadrao;
    }

    public void setCodmarcapadrao(Long codmarcapadrao) {
        this.codmarcapadrao = codmarcapadrao;
    }

    public Long getCodlocalizacaopadrao() {
        return codlocalizacaopadrao;
    }

    public void setCodlocalizacaopadrao(Long codlocalizacaopadrao) {
        this.codlocalizacaopadrao = codlocalizacaopadrao;
    }

    public Long getCodgrupopadrao() {
        return codgrupopadrao;
    }

    public void setCodgrupopadrao(Long codgrupopadrao) {
        this.codgrupopadrao = codgrupopadrao;
    }

    public Long getCodicmsnotafiscalpadrao() {
        return codicmsnotafiscalpadrao;
    }

    public void setCodicmsnotafiscalpadrao(Long codicmsnotafiscalpadrao) {
        this.codicmsnotafiscalpadrao = codicmsnotafiscalpadrao;
    }

    public Long getCodicmscupompadrao() {
        return codicmscupompadrao;
    }

    public void setCodicmscupompadrao(Long codicmscupompadrao) {
        this.codicmscupompadrao = codicmscupompadrao;
    }

    public Long getCodunidadepadrao() {
        return codunidadepadrao;
    }

    public void setCodunidadepadrao(Long codunidadepadrao) {
        this.codunidadepadrao = codunidadepadrao;
    }

    public Long getCodcfoppadraoproduto() {
        return codcfoppadraoproduto;
    }

    public void setCodcfoppadraoproduto(Long codcfoppadraoproduto) {
        this.codcfoppadraoproduto = codcfoppadraoproduto;
    }

    public String getCodipientradapadrao() {
        return codipientradapadrao;
    }

    public void setCodipientradapadrao(String codipientradapadrao) {
        this.codipientradapadrao = codipientradapadrao;
    }

    public String getCodipisaidapadrao() {
        return codipisaidapadrao;
    }

    public void setCodipisaidapadrao(String codipisaidapadrao) {
        this.codipisaidapadrao = codipisaidapadrao;
    }

    public String getCodpispadrao() {
        return codpispadrao;
    }

    public void setCodpispadrao(String codpispadrao) {
        this.codpispadrao = codpispadrao;
    }

    public String getCodcofinspadrao() {
        return codcofinspadrao;
    }

    public void setCodcofinspadrao(String codcofinspadrao) {
        this.codcofinspadrao = codcofinspadrao;
    }

    public Boolean getAlterartabelasnasentradas() {
        return alterartabelasnasentradas;
    }

    public void setAlterartabelasnasentradas(Boolean alterartabelasnasentradas) {
        this.alterartabelasnasentradas = alterartabelasnasentradas;
    }

    public Long getCodtabelaprecocupompadrao() {
        return codtabelaprecocupompadrao;
    }

    public void setCodtabelaprecocupompadrao(Long codtabelaprecocupompadrao) {
        this.codtabelaprecocupompadrao = codtabelaprecocupompadrao;
    }

    public Long getCodcontacaixacupompadrao() {
        return codcontacaixacupompadrao;
    }

    public void setCodcontacaixacupompadrao(Long codcontacaixacupompadrao) {
        this.codcontacaixacupompadrao = codcontacaixacupompadrao;
    }

    public Boolean getMovimentarcaixacontasrecebernasnotas() {
        return movimentarcaixacontasrecebernasnotas;
    }

    public void setMovimentarcaixacontasrecebernasnotas(Boolean movimentarcaixacontasrecebernasnotas) {
        this.movimentarcaixacontasrecebernasnotas = movimentarcaixacontasrecebernasnotas;
    }

    public Boolean getBloquearvendacupomcontareceber() {
        return bloquearvendacupomcontareceber;
    }

    public void setBloquearvendacupomcontareceber(Boolean bloquearvendacupomcontareceber) {
        this.bloquearvendacupomcontareceber = bloquearvendacupomcontareceber;
    }

    public Boolean getBloquearvendapedidocontareceber() {
        return bloquearvendapedidocontareceber;
    }

    public void setBloquearvendapedidocontareceber(Boolean bloquearvendapedidocontareceber) {
        this.bloquearvendapedidocontareceber = bloquearvendapedidocontareceber;
    }

    public Boolean getBloquearvendanotacontareceber() {
        return bloquearvendanotacontareceber;
    }

    public void setBloquearvendanotacontareceber(Boolean bloquearvendanotacontareceber) {
        this.bloquearvendanotacontareceber = bloquearvendanotacontareceber;
    }

    public Boolean getFinanceirosomentenasretiradas() {
        return financeirosomentenasretiradas;
    }

    public void setFinanceirosomentenasretiradas(Boolean financeirosomentenasretiradas) {
        this.financeirosomentenasretiradas = financeirosomentenasretiradas;
    }

    public Long getCodcontacaixadevolucao() {
        return codcontacaixadevolucao;
    }

    public void setCodcontacaixadevolucao(Long codcontacaixadevolucao) {
        this.codcontacaixadevolucao = codcontacaixadevolucao;
    }

    public Long getCodformapagtodevolucao() {
        return codformapagtodevolucao;
    }

    public void setCodformapagtodevolucao(Long codformapagtodevolucao) {
        this.codformapagtodevolucao = codformapagtodevolucao;
    }

    public Boolean getCalculartributosnospedidosnormais() {
        return calculartributosnospedidosnormais;
    }

    public void setCalculartributosnospedidosnormais(Boolean calculartributosnospedidosnormais) {
        this.calculartributosnospedidosnormais = calculartributosnospedidosnormais;
    }

    public Boolean getCalculartributosnospedidossimplificados() {
        return calculartributosnospedidossimplificados;
    }

    public void setCalculartributosnospedidossimplificados(Boolean calculartributosnospedidossimplificados) {
        this.calculartributosnospedidossimplificados = calculartributosnospedidossimplificados;
    }

    public Boolean getCalculartributosnospedidosfrentecaixa() {
        return calculartributosnospedidosfrentecaixa;
    }

    public void setCalculartributosnospedidosfrentecaixa(Boolean calculartributosnospedidosfrentecaixa) {
        this.calculartributosnospedidosfrentecaixa = calculartributosnospedidosfrentecaixa;
    }

    public Boolean getNaopermitirdiminuirvalorunitariopedidos() {
        return naopermitirdiminuirvalorunitariopedidos;
    }

    public void setNaopermitirdiminuirvalorunitariopedidos(Boolean naopermitirdiminuirvalorunitariopedidos) {
        this.naopermitirdiminuirvalorunitariopedidos = naopermitirdiminuirvalorunitariopedidos;
    }

    public Boolean getMostrarultimovalorvendidonospedidos() {
        return mostrarultimovalorvendidonospedidos;
    }

    public void setMostrarultimovalorvendidonospedidos(Boolean mostrarultimovalorvendidonospedidos) {
        this.mostrarultimovalorvendidonospedidos = mostrarultimovalorvendidonospedidos;
    }

    public Boolean getMostrarperclucropedidos() {
        return mostrarperclucropedidos;
    }

    public void setMostrarperclucropedidos(Boolean mostrarperclucropedidos) {
        this.mostrarperclucropedidos = mostrarperclucropedidos;
    }

    public Boolean getMostrarpercdescontocomissaopedidos() {
        return mostrarpercdescontocomissaopedidos;
    }

    public void setMostrarpercdescontocomissaopedidos(Boolean mostrarpercdescontocomissaopedidos) {
        this.mostrarpercdescontocomissaopedidos = mostrarpercdescontocomissaopedidos;
    }

    public String getTextocarne() {
        return textocarne;
    }

    public void setTextocarne(String textocarne) {
        this.textocarne = textocarne;
    }

    public String getTextopedido() {
        return textopedido;
    }

    public void setTextopedido(String textopedido) {
        this.textopedido = textopedido;
    }

    public String getTextoorcamento() {
        return textoorcamento;
    }

    public void setTextoorcamento(String textoorcamento) {
        this.textoorcamento = textoorcamento;
    }

    public String getTextocondicional() {
        return textocondicional;
    }

    public void setTextocondicional(String textocondicional) {
        this.textocondicional = textocondicional;
    }

    public Boolean getMantervalorvendaaposatualizarcustoformulario() {
        return mantervalorvendaaposatualizarcustoformulario;
    }

    public void setMantervalorvendaaposatualizarcustoformulario(Boolean mantervalorvendaaposatualizarcustoformulario) {
        this.mantervalorvendaaposatualizarcustoformulario = mantervalorvendaaposatualizarcustoformulario;
    }

    public Boolean getMostrarvalorminimovendapedidos() {
        return mostrarvalorminimovendapedidos;
    }

    public void setMostrarvalorminimovendapedidos(Boolean mostrarvalorminimovendapedidos) {
        this.mostrarvalorminimovendapedidos = mostrarvalorminimovendapedidos;
    }

    public String getCodprodutovariavel() {
        return codprodutovariavel;
    }

    public void setCodprodutovariavel(String codprodutovariavel) {
        this.codprodutovariavel = codprodutovariavel;
    }

    public String getCsosnespecialpadrao() {
        return csosnespecialpadrao;
    }

    public void setCsosnespecialpadrao(String csosnespecialpadrao) {
        this.csosnespecialpadrao = csosnespecialpadrao;
    }

    public String getCstespecialpadrao() {
        return cstespecialpadrao;
    }

    public void setCstespecialpadrao(String cstespecialpadrao) {
        this.cstespecialpadrao = cstespecialpadrao;
    }

    public Long getCodcfopespecialpadrao() {
        return codcfopespecialpadrao;
    }

    public void setCodcfopespecialpadrao(Long codcfopespecialpadrao) {
        this.codcfopespecialpadrao = codcfopespecialpadrao;
    }

    public String getCodpisespecialpadrao() {
        return codpisespecialpadrao;
    }

    public void setCodpisespecialpadrao(String codpisespecialpadrao) {
        this.codpisespecialpadrao = codpisespecialpadrao;
    }

    public String getCodcofinsespecialpadrao() {
        return codcofinsespecialpadrao;
    }

    public void setCodcofinsespecialpadrao(String codcofinsespecialpadrao) {
        this.codcofinsespecialpadrao = codcofinsespecialpadrao;
    }

    public Boolean getImprimirnotasemconfirmacao() {
        return imprimirnotasemconfirmacao;
    }

    public void setImprimirnotasemconfirmacao(Boolean imprimirnotasemconfirmacao) {
        this.imprimirnotasemconfirmacao = imprimirnotasemconfirmacao;
    }

    public Boolean getImprimirpedidosemconfirmacao() {
        return imprimirpedidosemconfirmacao;
    }

    public void setImprimirpedidosemconfirmacao(Boolean imprimirpedidosemconfirmacao) {
        this.imprimirpedidosemconfirmacao = imprimirpedidosemconfirmacao;
    }

    public Boolean getBloquearquantidadenocadastro() {
        return bloquearquantidadenocadastro;
    }

    public void setBloquearquantidadenocadastro(Boolean bloquearquantidadenocadastro) {
        this.bloquearquantidadenocadastro = bloquearquantidadenocadastro;
    }

    public Boolean getBloquearvendacupomematraso() {
        return bloquearvendacupomematraso;
    }

    public void setBloquearvendacupomematraso(Boolean bloquearvendacupomematraso) {
        this.bloquearvendacupomematraso = bloquearvendacupomematraso;
    }

    public Boolean getBloquearvendapedidoematraso() {
        return bloquearvendapedidoematraso;
    }

    public void setBloquearvendapedidoematraso(Boolean bloquearvendapedidoematraso) {
        this.bloquearvendapedidoematraso = bloquearvendapedidoematraso;
    }

    public Boolean getBloquearvendanotaematraso() {
        return bloquearvendanotaematraso;
    }

    public void setBloquearvendanotaematraso(Boolean bloquearvendanotaematraso) {
        this.bloquearvendanotaematraso = bloquearvendanotaematraso;
    }

    public Boolean getSolicitarabrirpreco() {
        return solicitarabrirpreco;
    }

    public void setSolicitarabrirpreco(Boolean solicitarabrirpreco) {
        this.solicitarabrirpreco = solicitarabrirpreco;
    }

    public Boolean getSolicitarabrircasosespeciais() {
        return solicitarabrircasosespeciais;
    }

    public void setSolicitarabrircasosespeciais(Boolean solicitarabrircasosespeciais) {
        this.solicitarabrircasosespeciais = solicitarabrircasosespeciais;
    }

    public Boolean getSolicitarabrirsimilar() {
        return solicitarabrirsimilar;
    }

    public void setSolicitarabrirsimilar(Boolean solicitarabrirsimilar) {
        this.solicitarabrirsimilar = solicitarabrirsimilar;
    }

    public Boolean getSolicitarabrirreferencia() {
        return solicitarabrirreferencia;
    }

    public void setSolicitarabrirreferencia(Boolean solicitarabrirreferencia) {
        this.solicitarabrirreferencia = solicitarabrirreferencia;
    }

    public Boolean getAceitarletracodproduto() {
        return aceitarletracodproduto;
    }

    public void setAceitarletracodproduto(Boolean aceitarletracodproduto) {
        this.aceitarletracodproduto = aceitarletracodproduto;
    }

    public Boolean getCupomautomaticopedido() {
        return cupomautomaticopedido;
    }

    public void setCupomautomaticopedido(Boolean cupomautomaticopedido) {
        this.cupomautomaticopedido = cupomautomaticopedido;
    }

    public String getFormulariopedidoabrir() {
        return formulariopedidoabrir;
    }

    public void setFormulariopedidoabrir(String formulariopedidoabrir) {
        this.formulariopedidoabrir = formulariopedidoabrir;
    }

    public String getModofretenotapadrao() {
        return modofretenotapadrao;
    }

    public void setModofretenotapadrao(String modofretenotapadrao) {
        this.modofretenotapadrao = modofretenotapadrao;
    }

    public String getModofretepedidopadrao() {
        return modofretepedidopadrao;
    }

    public void setModofretepedidopadrao(String modofretepedidopadrao) {
        this.modofretepedidopadrao = modofretepedidopadrao;
    }

    public String getCstentradapadrao() {
        return cstentradapadrao;
    }

    public void setCstentradapadrao(String cstentradapadrao) {
        this.cstentradapadrao = cstentradapadrao;
    }

    public String getCstsaidapadrao() {
        return cstsaidapadrao;
    }

    public void setCstsaidapadrao(String cstsaidapadrao) {
        this.cstsaidapadrao = cstsaidapadrao;
    }

    public String getCsosnpadrao() {
        return csosnpadrao;
    }

    public void setCsosnpadrao(String csosnpadrao) {
        this.csosnpadrao = csosnpadrao;
    }

    public String getNcmpadrao() {
        return ncmpadrao;
    }

    public void setNcmpadrao(String ncmpadrao) {
        this.ncmpadrao = ncmpadrao;
    }

    public String getCodpisentradapadrao() {
        return codpisentradapadrao;
    }

    public void setCodpisentradapadrao(String codpisentradapadrao) {
        this.codpisentradapadrao = codpisentradapadrao;
    }

    public Double getPercpisentradapadrao() {
        return percpisentradapadrao;
    }

    public void setPercpisentradapadrao(Double percpisentradapadrao) {
        this.percpisentradapadrao = percpisentradapadrao;
    }

    public Double getValorpisentradapadrao() {
        return valorpisentradapadrao;
    }

    public void setValorpisentradapadrao(Double valorpisentradapadrao) {
        this.valorpisentradapadrao = valorpisentradapadrao;
    }

    public Double getPercpissaidapadrao() {
        return percpissaidapadrao;
    }

    public void setPercpissaidapadrao(Double percpissaidapadrao) {
        this.percpissaidapadrao = percpissaidapadrao;
    }

    public Double getValorpissaidapadrao() {
        return valorpissaidapadrao;
    }

    public void setValorpissaidapadrao(Double valorpissaidapadrao) {
        this.valorpissaidapadrao = valorpissaidapadrao;
    }

    public String getCodcofinsentradapadrao() {
        return codcofinsentradapadrao;
    }

    public void setCodcofinsentradapadrao(String codcofinsentradapadrao) {
        this.codcofinsentradapadrao = codcofinsentradapadrao;
    }

    public Double getPerccofinsentradapadrao() {
        return perccofinsentradapadrao;
    }

    public void setPerccofinsentradapadrao(Double perccofinsentradapadrao) {
        this.perccofinsentradapadrao = perccofinsentradapadrao;
    }

    public Double getValorcofinsentradapadrao() {
        return valorcofinsentradapadrao;
    }

    public void setValorcofinsentradapadrao(Double valorcofinsentradapadrao) {
        this.valorcofinsentradapadrao = valorcofinsentradapadrao;
    }

    public Double getPerccofinssaidapadrao() {
        return perccofinssaidapadrao;
    }

    public void setPerccofinssaidapadrao(Double perccofinssaidapadrao) {
        this.perccofinssaidapadrao = perccofinssaidapadrao;
    }

    public Double getValorcofinssaidapadrao() {
        return valorcofinssaidapadrao;
    }

    public void setValorcofinssaidapadrao(Double valorcofinssaidapadrao) {
        this.valorcofinssaidapadrao = valorcofinssaidapadrao;
    }

    public Long getCodclientepedidopadrao() {
        return codclientepedidopadrao;
    }

    public void setCodclientepedidopadrao(Long codclientepedidopadrao) {
        this.codclientepedidopadrao = codclientepedidopadrao;
    }

    public Boolean getMantermaiorcustoentrada() {
        return mantermaiorcustoentrada;
    }

    public void setMantermaiorcustoentrada(Boolean mantermaiorcustoentrada) {
        this.mantermaiorcustoentrada = mantermaiorcustoentrada;
    }

    public String getTipodocumentopedido() {
        return tipodocumentopedido;
    }

    public void setTipodocumentopedido(String tipodocumentopedido) {
        this.tipodocumentopedido = tipodocumentopedido;
    }

    public Long getCodcontacaixamovimentocaixacredito() {
        return codcontacaixamovimentocaixacredito;
    }

    public void setCodcontacaixamovimentocaixacredito(Long codcontacaixamovimentocaixacredito) {
        this.codcontacaixamovimentocaixacredito = codcontacaixamovimentocaixacredito;
    }

    public Long getCodcontacaixamovimentocaixadebito() {
        return codcontacaixamovimentocaixadebito;
    }

    public void setCodcontacaixamovimentocaixadebito(Long codcontacaixamovimentocaixadebito) {
        this.codcontacaixamovimentocaixadebito = codcontacaixamovimentocaixadebito;
    }

    public Long getCodformapagtomovimentocaixainterno() {
        return codformapagtomovimentocaixainterno;
    }

    public void setCodformapagtomovimentocaixainterno(Long codformapagtomovimentocaixainterno) {
        this.codformapagtomovimentocaixainterno = codformapagtomovimentocaixainterno;
    }

    public Boolean getVerificarcaixaabertoinicializar() {
        return verificarcaixaabertoinicializar;
    }

    public void setVerificarcaixaabertoinicializar(Boolean verificarcaixaabertoinicializar) {
        this.verificarcaixaabertoinicializar = verificarcaixaabertoinicializar;
    }

    public Boolean getMovimentarestoquecupom() {
        return movimentarestoquecupom;
    }

    public void setMovimentarestoquecupom(Boolean movimentarestoquecupom) {
        this.movimentarestoquecupom = movimentarestoquecupom;
    }

    public Boolean getMostrartributosnospedidos() {
        return mostrartributosnospedidos;
    }

    public void setMostrartributosnospedidos(Boolean mostrartributosnospedidos) {
        this.mostrartributosnospedidos = mostrartributosnospedidos;
    }

    public Boolean getMensagemcontasrecebernota() {
        return mensagemcontasrecebernota;
    }

    public void setMensagemcontasrecebernota(Boolean mensagemcontasrecebernota) {
        this.mensagemcontasrecebernota = mensagemcontasrecebernota;
    }

    public Boolean getGerarnotadopedido() {
        return gerarnotadopedido;
    }

    public void setGerarnotadopedido(Boolean gerarnotadopedido) {
        this.gerarnotadopedido = gerarnotadopedido;
    }

    public Boolean getMensagemcontasrecebercupom() {
        return mensagemcontasrecebercupom;
    }

    public void setMensagemcontasrecebercupom(Boolean mensagemcontasrecebercupom) {
        this.mensagemcontasrecebercupom = mensagemcontasrecebercupom;
    }

    public Boolean getBloquearvendaquantidadezerocupom() {
        return bloquearvendaquantidadezerocupom;
    }

    public void setBloquearvendaquantidadezerocupom(Boolean bloquearvendaquantidadezerocupom) {
        this.bloquearvendaquantidadezerocupom = bloquearvendaquantidadezerocupom;
    }

    public Boolean getEmitircupomdopedido() {
        return emitircupomdopedido;
    }

    public void setEmitircupomdopedido(Boolean emitircupomdopedido) {
        this.emitircupomdopedido = emitircupomdopedido;
    }

    public Boolean getMensagemestoquenegativo() {
        return mensagemestoquenegativo;
    }

    public void setMensagemestoquenegativo(Boolean mensagemestoquenegativo) {
        this.mensagemestoquenegativo = mensagemestoquenegativo;
    }

    public Boolean getMensagemestoquemaximo() {
        return mensagemestoquemaximo;
    }

    public void setMensagemestoquemaximo(Boolean mensagemestoquemaximo) {
        this.mensagemestoquemaximo = mensagemestoquemaximo;
    }

    public Boolean getMensagemestoqueminimo() {
        return mensagemestoqueminimo;
    }

    public void setMensagemestoqueminimo(Boolean mensagemestoqueminimo) {
        this.mensagemestoqueminimo = mensagemestoqueminimo;
    }

    public Boolean getMensagemcontasreceberpedido() {
        return mensagemcontasreceberpedido;
    }

    public void setMensagemcontasreceberpedido(Boolean mensagemcontasreceberpedido) {
        this.mensagemcontasreceberpedido = mensagemcontasreceberpedido;
    }

    public Long getCodpracapadrao() {
        return codpracapadrao;
    }

    public void setCodpracapadrao(Long codpracapadrao) {
        this.codpracapadrao = codpracapadrao;
    }

    public Boolean getMensagemcontaspagar() {
        return mensagemcontaspagar;
    }

    public void setMensagemcontaspagar(Boolean mensagemcontaspagar) {
        this.mensagemcontaspagar = mensagemcontaspagar;
    }

    public Double getMargemsuperiorretiradadevolucao() {
        return margemsuperiorretiradadevolucao;
    }

    public void setMargemsuperiorretiradadevolucao(Double margemsuperiorretiradadevolucao) {
        this.margemsuperiorretiradadevolucao = margemsuperiorretiradadevolucao;
    }

    public Boolean getMovimentarestoquenotas() {
        return movimentarestoquenotas;
    }

    public void setMovimentarestoquenotas(Boolean movimentarestoquenotas) {
        this.movimentarestoquenotas = movimentarestoquenotas;
    }

    public Boolean getLiberarduplicidadecodigo() {
        return liberarduplicidadecodigo;
    }

    public void setLiberarduplicidadecodigo(Boolean liberarduplicidadecodigo) {
        this.liberarduplicidadecodigo = liberarduplicidadecodigo;
    }

    public Boolean getZerarmovimentacaopedidos() {
        return zerarmovimentacaopedidos;
    }

    public void setZerarmovimentacaopedidos(Boolean zerarmovimentacaopedidos) {
        this.zerarmovimentacaopedidos = zerarmovimentacaopedidos;
    }

    public Boolean getMovimentarestoqueorcamento() {
        return movimentarestoqueorcamento;
    }

    public void setMovimentarestoqueorcamento(Boolean movimentarestoqueorcamento) {
        this.movimentarestoqueorcamento = movimentarestoqueorcamento;
    }

    public Boolean getBloquearpedidos() {
        return bloquearpedidos;
    }

    public void setBloquearpedidos(Boolean bloquearpedidos) {
        this.bloquearpedidos = bloquearpedidos;
    }

    public Boolean getAbrirminimomaximoaoiniciar() {
        return abrirminimomaximoaoiniciar;
    }

    public void setAbrirminimomaximoaoiniciar(Boolean abrirminimomaximoaoiniciar) {
        this.abrirminimomaximoaoiniciar = abrirminimomaximoaoiniciar;
    }

    public Boolean getBaixarpedido() {
        return baixarpedido;
    }

    public void setBaixarpedido(Boolean baixarpedido) {
        this.baixarpedido = baixarpedido;
    }

    public Boolean getBaixarnota() {
        return baixarnota;
    }

    public void setBaixarnota(Boolean baixarnota) {
        this.baixarnota = baixarnota;
    }

    public Long getCodcontacaixapadrao() {
        return codcontacaixapadrao;
    }

    public void setCodcontacaixapadrao(Long codcontacaixapadrao) {
        this.codcontacaixapadrao = codcontacaixapadrao;
    }

    public String getBotao6() {
        return botao6;
    }

    public void setBotao6(String botao6) {
        this.botao6 = botao6;
    }

    public Long getDiasretroativos() {
        return diasretroativos;
    }

    public void setDiasretroativos(Long diasretroativos) {
        this.diasretroativos = diasretroativos;
    }

    public Boolean getUsarcfopoutrosnoestorno() {
        return usarcfopoutrosnoestorno;
    }

    public void setUsarcfopoutrosnoestorno(Boolean usarcfopoutrosnoestorno) {
        this.usarcfopoutrosnoestorno = usarcfopoutrosnoestorno;
    }

    public Double getPercentualminimopadrao() {
        return percentualminimopadrao;
    }

    public void setPercentualminimopadrao(Double percentualminimopadrao) {
        this.percentualminimopadrao = percentualminimopadrao;
    }

    public Double getPercentualpadrao() {
        return percentualpadrao;
    }

    public void setPercentualpadrao(Double percentualpadrao) {
        this.percentualpadrao = percentualpadrao;
    }

    public Boolean getMostrartotalvendanocontasreceber() {
        return mostrartotalvendanocontasreceber;
    }

    public void setMostrartotalvendanocontasreceber(Boolean mostrartotalvendanocontasreceber) {
        this.mostrartotalvendanocontasreceber = mostrartotalvendanocontasreceber;
    }

    public Boolean getBloquearcasonaopreenchidocfop() {
        return bloquearcasonaopreenchidocfop;
    }

    public void setBloquearcasonaopreenchidocfop(Boolean bloquearcasonaopreenchidocfop) {
        this.bloquearcasonaopreenchidocfop = bloquearcasonaopreenchidocfop;
    }

    public Boolean getBloquearsemregimetributario() {
        return bloquearsemregimetributario;
    }

    public void setBloquearsemregimetributario(Boolean bloquearsemregimetributario) {
        this.bloquearsemregimetributario = bloquearsemregimetributario;
    }

    public String getTipodataspedido() {
        return tipodataspedido;
    }

    public void setTipodataspedido(String tipodataspedido) {
        this.tipodataspedido = tipodataspedido;
    }

    public String getTipodatasnota() {
        return tipodatasnota;
    }

    public void setTipodatasnota(String tipodatasnota) {
        this.tipodatasnota = tipodatasnota;
    }

    public String getTipodatasfinanceiro() {
        return tipodatasfinanceiro;
    }

    public void setTipodatasfinanceiro(String tipodatasfinanceiro) {
        this.tipodatasfinanceiro = tipodatasfinanceiro;
    }

    public Boolean getCadastroclientesimplificado() {
        return cadastroclientesimplificado;
    }

    public void setCadastroclientesimplificado(Boolean cadastroclientesimplificado) {
        this.cadastroclientesimplificado = cadastroclientesimplificado;
    }

    public Boolean getMostrarbotaopedidoembranco() {
        return mostrarbotaopedidoembranco;
    }

    public void setMostrarbotaopedidoembranco(Boolean mostrarbotaopedidoembranco) {
        this.mostrarbotaopedidoembranco = mostrarbotaopedidoembranco;
    }

    public Boolean getAbrirlocalizacaopedidosemaberto() {
        return abrirlocalizacaopedidosemaberto;
    }

    public void setAbrirlocalizacaopedidosemaberto(Boolean abrirlocalizacaopedidosemaberto) {
        this.abrirlocalizacaopedidosemaberto = abrirlocalizacaopedidosemaberto;
    }

    public Boolean getHabilitarimprimirpedidosemfechar() {
        return habilitarimprimirpedidosemfechar;
    }

    public void setHabilitarimprimirpedidosemfechar(Boolean habilitarimprimirpedidosemfechar) {
        this.habilitarimprimirpedidosemfechar = habilitarimprimirpedidosemfechar;
    }

    public Boolean getOrdenarlocalizacaopedidopornomedata() {
        return ordenarlocalizacaopedidopornomedata;
    }

    public void setOrdenarlocalizacaopedidopornomedata(Boolean ordenarlocalizacaopedidopornomedata) {
        this.ordenarlocalizacaopedidopornomedata = ordenarlocalizacaopedidopornomedata;
    }

    public Boolean getOpcaosimcomopadraoimprimirpedido() {
        return opcaosimcomopadraoimprimirpedido;
    }

    public void setOpcaosimcomopadraoimprimirpedido(Boolean opcaosimcomopadraoimprimirpedido) {
        this.opcaosimcomopadraoimprimirpedido = opcaosimcomopadraoimprimirpedido;
    }

    public Boolean getAjustarcstnotadevolucao() {
        return ajustarcstnotadevolucao;
    }

    public void setAjustarcstnotadevolucao(Boolean ajustarcstnotadevolucao) {
        this.ajustarcstnotadevolucao = ajustarcstnotadevolucao;
    }

    public Boolean getMostrarmensagemnfcesemaberto() {
        return mostrarmensagemnfcesemaberto;
    }

    public void setMostrarmensagemnfcesemaberto(Boolean mostrarmensagemnfcesemaberto) {
        this.mostrarmensagemnfcesemaberto = mostrarmensagemnfcesemaberto;
    }

    public Boolean getHabilitaralterarempresanospedidos() {
        return habilitaralterarempresanospedidos;
    }

    public void setHabilitaralterarempresanospedidos(Boolean habilitaralterarempresanospedidos) {
        this.habilitaralterarempresanospedidos = habilitaralterarempresanospedidos;
    }

    public Boolean getExibirimportacaonfc() {
        return exibirimportacaonfc;
    }

    public void setExibirimportacaonfc(Boolean exibirimportacaonfc) {
        this.exibirimportacaonfc = exibirimportacaonfc;
    }

    public Boolean getMensagemvalorminimopedido() {
        return mensagemvalorminimopedido;
    }

    public void setMensagemvalorminimopedido(Boolean mensagemvalorminimopedido) {
        this.mensagemvalorminimopedido = mensagemvalorminimopedido;
    }

    public Boolean getTestarcustoitemnopedido() {
        return testarcustoitemnopedido;
    }

    public void setTestarcustoitemnopedido(Boolean testarcustoitemnopedido) {
        this.testarcustoitemnopedido = testarcustoitemnopedido;
    }

    public Boolean getHabilitartrocaemitente() {
        return habilitartrocaemitente;
    }

    public void setHabilitartrocaemitente(Boolean habilitartrocaemitente) {
        this.habilitartrocaemitente = habilitartrocaemitente;
    }

    public Boolean getMovimentestoquepedido() {
        return movimentestoquepedido;
    }

    public void setMovimentestoquepedido(Boolean movimentestoquepedido) {
        this.movimentestoquepedido = movimentestoquepedido;
    }

    public Boolean getMostrarfretenospedidossimplificados() {
        return mostrarfretenospedidossimplificados;
    }

    public void setMostrarfretenospedidossimplificados(Boolean mostrarfretenospedidossimplificados) {
        this.mostrarfretenospedidossimplificados = mostrarfretenospedidossimplificados;
    }

    public Boolean getRelatoriocontaazul() {
        return relatoriocontaazul;
    }

    public void setRelatoriocontaazul(Boolean relatoriocontaazul) {
        this.relatoriocontaazul = relatoriocontaazul;
    }

    public Boolean getOperacaorapidapedidosimplificado() {
        return operacaorapidapedidosimplificado;
    }

    public void setOperacaorapidapedidosimplificado(Boolean operacaorapidapedidosimplificado) {
        this.operacaorapidapedidosimplificado = operacaorapidapedidosimplificado;
    }

    public Boolean getEtiquetasnosprodutos() {
        return etiquetasnosprodutos;
    }

    public void setEtiquetasnosprodutos(Boolean etiquetasnosprodutos) {
        this.etiquetasnosprodutos = etiquetasnosprodutos;
    }

    public Long getCodetiquetas() {
        return codetiquetas;
    }

    public void setCodetiquetas(Long codetiquetas) {
        this.codetiquetas = codetiquetas;
    }

    public Boolean getConvertercodigoparaean() {
        return convertercodigoparaean;
    }

    public void setConvertercodigoparaean(Boolean convertercodigoparaean) {
        this.convertercodigoparaean = convertercodigoparaean;
    }

    public Boolean getHabilitaralterarempresafinanceiro() {
        return habilitaralterarempresafinanceiro;
    }

    public void setHabilitaralterarempresafinanceiro(Boolean habilitaralterarempresafinanceiro) {
        this.habilitaralterarempresafinanceiro = habilitaralterarempresafinanceiro;
    }

    public Boolean getHabilitadadoscultivo() {
        return habilitadadoscultivo;
    }

    public void setHabilitadadoscultivo(Boolean habilitadadoscultivo) {
        this.habilitadadoscultivo = habilitadadoscultivo;
    }

    public Boolean getMostrarvaloresnalocalizacaoprodutos() {
        return mostrarvaloresnalocalizacaoprodutos;
    }

    public void setMostrarvaloresnalocalizacaoprodutos(Boolean mostrarvaloresnalocalizacaoprodutos) {
        this.mostrarvaloresnalocalizacaoprodutos = mostrarvaloresnalocalizacaoprodutos;
    }

    public Boolean getMostrarfotolocalizacaoprodutos() {
        return mostrarfotolocalizacaoprodutos;
    }

    public void setMostrarfotolocalizacaoprodutos(Boolean mostrarfotolocalizacaoprodutos) {
        this.mostrarfotolocalizacaoprodutos = mostrarfotolocalizacaoprodutos;
    }

    public Boolean getHabilitadatascomemorativas() {
        return habilitadatascomemorativas;
    }

    public void setHabilitadatascomemorativas(Boolean habilitadatascomemorativas) {
        this.habilitadatascomemorativas = habilitadatascomemorativas;
    }

    public Boolean getCriarparcelaavistasemsolicitar() {
        return criarparcelaavistasemsolicitar;
    }

    public void setCriarparcelaavistasemsolicitar(Boolean criarparcelaavistasemsolicitar) {
        this.criarparcelaavistasemsolicitar = criarparcelaavistasemsolicitar;
    }

    public Boolean getArredondardecimalnasparcelas() {
        return arredondardecimalnasparcelas;
    }

    public void setArredondardecimalnasparcelas(Boolean arredondardecimalnasparcelas) {
        this.arredondardecimalnasparcelas = arredondardecimalnasparcelas;
    }

    public Boolean getPermitecaixaindividual() {
        return permitecaixaindividual;
    }

    public void setPermitecaixaindividual(Boolean permitecaixaindividual) {
        this.permitecaixaindividual = permitecaixaindividual;
    }

    public Boolean getVerificarquantidadesnotas() {
        return verificarquantidadesnotas;
    }

    public void setVerificarquantidadesnotas(Boolean verificarquantidadesnotas) {
        this.verificarquantidadesnotas = verificarquantidadesnotas;
    }

    public Boolean getPermitirduplicaritemnopedido() {
        return permitirduplicaritemnopedido;
    }

    public void setPermitirduplicaritemnopedido(Boolean permitirduplicaritemnopedido) {
        this.permitirduplicaritemnopedido = permitirduplicaritemnopedido;
    }

    public Boolean getCriarparcelaavistasemsolicitarnfce() {
        return criarparcelaavistasemsolicitarnfce;
    }

    public void setCriarparcelaavistasemsolicitarnfce(Boolean criarparcelaavistasemsolicitarnfce) {
        this.criarparcelaavistasemsolicitarnfce = criarparcelaavistasemsolicitarnfce;
    }

    public Long getCodvendedorpadraonotas() {
        return codvendedorpadraonotas;
    }

    public void setCodvendedorpadraonotas(Long codvendedorpadraonotas) {
        this.codvendedorpadraonotas = codvendedorpadraonotas;
    }

    public Boolean getUsarvendedorusuarionota() {
        return usarvendedorusuarionota;
    }

    public void setUsarvendedorusuarionota(Boolean usarvendedorusuarionota) {
        this.usarvendedorusuarionota = usarvendedorusuarionota;
    }

    public Boolean getUsarvendedorusuarionfce() {
        return usarvendedorusuarionfce;
    }

    public void setUsarvendedorusuarionfce(Boolean usarvendedorusuarionfce) {
        this.usarvendedorusuarionfce = usarvendedorusuarionfce;
    }

    public String getTipoordenacaolocalizacaopedido() {
        return tipoordenacaolocalizacaopedido;
    }

    public void setTipoordenacaolocalizacaopedido(String tipoordenacaolocalizacaopedido) {
        this.tipoordenacaolocalizacaopedido = tipoordenacaolocalizacaopedido;
    }

    public Boolean getCadastrarnovosempreimportacaoxml() {
        return cadastrarnovosempreimportacaoxml;
    }

    public void setCadastrarnovosempreimportacaoxml(Boolean cadastrarnovosempreimportacaoxml) {
        this.cadastrarnovosempreimportacaoxml = cadastrarnovosempreimportacaoxml;
    }

    public Boolean getBloquearduplicidadeitemnota() {
        return bloquearduplicidadeitemnota;
    }

    public void setBloquearduplicidadeitemnota(Boolean bloquearduplicidadeitemnota) {
        this.bloquearduplicidadeitemnota = bloquearduplicidadeitemnota;
    }

    public Boolean getBloquearduplicidadeitemcupom() {
        return bloquearduplicidadeitemcupom;
    }

    public void setBloquearduplicidadeitemcupom(Boolean bloquearduplicidadeitemcupom) {
        this.bloquearduplicidadeitemcupom = bloquearduplicidadeitemcupom;
    }

    public Boolean getMostraritenslocalizacaopedido() {
        return mostraritenslocalizacaopedido;
    }

    public void setMostraritenslocalizacaopedido(Boolean mostraritenslocalizacaopedido) {
        this.mostraritenslocalizacaopedido = mostraritenslocalizacaopedido;
    }

    public Boolean getAvancoautomaticocupom() {
        return avancoautomaticocupom;
    }

    public void setAvancoautomaticocupom(Boolean avancoautomaticocupom) {
        this.avancoautomaticocupom = avancoautomaticocupom;
    }

    public Boolean getAbrirgavetafechamento() {
        return abrirgavetafechamento;
    }

    public void setAbrirgavetafechamento(Boolean abrirgavetafechamento) {
        this.abrirgavetafechamento = abrirgavetafechamento;
    }

    public Boolean getAjustarcstnotaremessa() {
        return ajustarcstnotaremessa;
    }

    public void setAjustarcstnotaremessa(Boolean ajustarcstnotaremessa) {
        this.ajustarcstnotaremessa = ajustarcstnotaremessa;
    }

    public Boolean getMovimentarestoquecondicional() {
        return movimentarestoquecondicional;
    }

    public void setMovimentarestoquecondicional(Boolean movimentarestoquecondicional) {
        this.movimentarestoquecondicional = movimentarestoquecondicional;
    }

    public Boolean getFococodigoaolocalizarproduto() {
        return fococodigoaolocalizarproduto;
    }

    public void setFococodigoaolocalizarproduto(Boolean fococodigoaolocalizarproduto) {
        this.fococodigoaolocalizarproduto = fococodigoaolocalizarproduto;
    }

    public Boolean getOperacaosimpleslocalizacaoprodutos() {
        return operacaosimpleslocalizacaoprodutos;
    }

    public void setOperacaosimpleslocalizacaoprodutos(Boolean operacaosimpleslocalizacaoprodutos) {
        this.operacaosimpleslocalizacaoprodutos = operacaosimpleslocalizacaoprodutos;
    }

    public Boolean getMantertotaisdigitadosnasentradas() {
        return mantertotaisdigitadosnasentradas;
    }

    public void setMantertotaisdigitadosnasentradas(Boolean mantertotaisdigitadosnasentradas) {
        this.mantertotaisdigitadosnasentradas = mantertotaisdigitadosnasentradas;
    }

    public Boolean getMostrarparticularidadespedidos() {
        return mostrarparticularidadespedidos;
    }

    public void setMostrarparticularidadespedidos(Boolean mostrarparticularidadespedidos) {
        this.mostrarparticularidadespedidos = mostrarparticularidadespedidos;
    }

    public Boolean getMostrarparticularidadesnotas() {
        return mostrarparticularidadesnotas;
    }

    public void setMostrarparticularidadesnotas(Boolean mostrarparticularidadesnotas) {
        this.mostrarparticularidadesnotas = mostrarparticularidadesnotas;
    }

    public Long getDiasprazoautomatico() {
        return diasprazoautomatico;
    }

    public void setDiasprazoautomatico(Long diasprazoautomatico) {
        this.diasprazoautomatico = diasprazoautomatico;
    }

    public String getTipodocumentofiscalgerardopedido() {
        return tipodocumentofiscalgerardopedido;
    }

    public void setTipodocumentofiscalgerardopedido(String tipodocumentofiscalgerardopedido) {
        this.tipodocumentofiscalgerardopedido = tipodocumentofiscalgerardopedido;
    }

    public Boolean getLocalizacaoprodutorapida() {
        return localizacaoprodutorapida;
    }

    public void setLocalizacaoprodutorapida(Boolean localizacaoprodutorapida) {
        this.localizacaoprodutorapida = localizacaoprodutorapida;
    }

    public Boolean getMovimentarestoquenfce() {
        return movimentarestoquenfce;
    }

    public void setMovimentarestoquenfce(Boolean movimentarestoquenfce) {
        this.movimentarestoquenfce = movimentarestoquenfce;
    }

    public Boolean getBloquearpedidoquantidadenegativa() {
        return bloquearpedidoquantidadenegativa;
    }

    public void setBloquearpedidoquantidadenegativa(Boolean bloquearpedidoquantidadenegativa) {
        this.bloquearpedidoquantidadenegativa = bloquearpedidoquantidadenegativa;
    }

    public Boolean getChassicadastrocliente() {
        return chassicadastrocliente;
    }

    public void setChassicadastrocliente(Boolean chassicadastrocliente) {
        this.chassicadastrocliente = chassicadastrocliente;
    }

    public Boolean getPossibilitarimportardaentradanopedido() {
        return possibilitarimportardaentradanopedido;
    }

    public void setPossibilitarimportardaentradanopedido(Boolean possibilitarimportardaentradanopedido) {
        this.possibilitarimportardaentradanopedido = possibilitarimportardaentradanopedido;
    }

    public Boolean getMovimentarfinandeironfs() {
        return movimentarfinandeironfs;
    }

    public void setMovimentarfinandeironfs(Boolean movimentarfinandeironfs) {
        this.movimentarfinandeironfs = movimentarfinandeironfs;
    }

    public Boolean getIrnotanovaaoabrir() {
        return irnotanovaaoabrir;
    }

    public void setIrnotanovaaoabrir(Boolean irnotanovaaoabrir) {
        this.irnotanovaaoabrir = irnotanovaaoabrir;
    }

    public Boolean getPermitiralterartipo() {
        return permitiralterartipo;
    }

    public void setPermitiralterartipo(Boolean permitiralterartipo) {
        this.permitiralterartipo = permitiralterartipo;
    }

    public Boolean getSolicitarlancarchequecaixa() {
        return solicitarlancarchequecaixa;
    }

    public void setSolicitarlancarchequecaixa(Boolean solicitarlancarchequecaixa) {
        this.solicitarlancarchequecaixa = solicitarlancarchequecaixa;
    }

    public Long getCodnaturezadevolucao() {
        return codnaturezadevolucao;
    }

    public void setCodnaturezadevolucao(Long codnaturezadevolucao) {
        this.codnaturezadevolucao = codnaturezadevolucao;
    }

    public Boolean getAjustarcsosnnaocontribuinte() {
        return ajustarcsosnnaocontribuinte;
    }

    public void setAjustarcsosnnaocontribuinte(Boolean ajustarcsosnnaocontribuinte) {
        this.ajustarcsosnnaocontribuinte = ajustarcsosnnaocontribuinte;
    }

    public String getCsosnparaclientesfinais() {
        return csosnparaclientesfinais;
    }

    public void setCsosnparaclientesfinais(String csosnparaclientesfinais) {
        this.csosnparaclientesfinais = csosnparaclientesfinais;
    }

    public Long getCodoperadorpadrao() {
        return codoperadorpadrao;
    }

    public void setCodoperadorpadrao(Long codoperadorpadrao) {
        this.codoperadorpadrao = codoperadorpadrao;
    }

    public String getFocolocalizarcontareceber() {
        return focolocalizarcontareceber;
    }

    public void setFocolocalizarcontareceber(String focolocalizarcontareceber) {
        this.focolocalizarcontareceber = focolocalizarcontareceber;
    }

    public Boolean getSairquantolocalizarumunicoregistrocontasreceber() {
        return sairquantolocalizarumunicoregistrocontasreceber;
    }

    public void setSairquantolocalizarumunicoregistrocontasreceber(Boolean sairquantolocalizarumunicoregistrocontasreceber) {
        this.sairquantolocalizarumunicoregistrocontasreceber = sairquantolocalizarumunicoregistrocontasreceber;
    }

    public Boolean getControlarst() {
        return controlarst;
    }

    public void setControlarst(Boolean controlarst) {
        this.controlarst = controlarst;
    }

    public String getFocoaposlocalizaritempedido() {
        return focoaposlocalizaritempedido;
    }

    public void setFocoaposlocalizaritempedido(String focoaposlocalizaritempedido) {
        this.focoaposlocalizaritempedido = focoaposlocalizaritempedido;
    }

    public Long getQuantidadenotaslimitemostrar() {
        return quantidadenotaslimitemostrar;
    }

    public void setQuantidadenotaslimitemostrar(Long quantidadenotaslimitemostrar) {
        this.quantidadenotaslimitemostrar = quantidadenotaslimitemostrar;
    }

    public String getFocofinalizarnfce() {
        return focofinalizarnfce;
    }

    public void setFocofinalizarnfce(String focofinalizarnfce) {
        this.focofinalizarnfce = focofinalizarnfce;
    }

    public Double getQuantidadeitemnfce() {
        return quantidadeitemnfce;
    }

    public void setQuantidadeitemnfce(Double quantidadeitemnfce) {
        this.quantidadeitemnfce = quantidadeitemnfce;
    }

    public Long getCfoppadraocadastroproduto() {
        return cfoppadraocadastroproduto;
    }

    public void setCfoppadraocadastroproduto(Long cfoppadraocadastroproduto) {
        this.cfoppadraocadastroproduto = cfoppadraocadastroproduto;
    }

    public Boolean getAbrirgerarparcelasautomaticamente() {
        return abrirgerarparcelasautomaticamente;
    }

    public void setAbrirgerarparcelasautomaticamente(Boolean abrirgerarparcelasautomaticamente) {
        this.abrirgerarparcelasautomaticamente = abrirgerarparcelasautomaticamente;
    }

    public String getTipoordenacaoitempedido() {
        return tipoordenacaoitempedido;
    }

    public void setTipoordenacaoitempedido(String tipoordenacaoitempedido) {
        this.tipoordenacaoitempedido = tipoordenacaoitempedido;
    }

    public Boolean getNaoverificarduplicidadecasoeandiferente() {
        return naoverificarduplicidadecasoeandiferente;
    }

    public void setNaoverificarduplicidadecasoeandiferente(Boolean naoverificarduplicidadecasoeandiferente) {
        this.naoverificarduplicidadecasoeandiferente = naoverificarduplicidadecasoeandiferente;
    }

    public Long getQuantidadepedidoslimitelentidao() {
        return quantidadepedidoslimitelentidao;
    }

    public void setQuantidadepedidoslimitelentidao(Long quantidadepedidoslimitelentidao) {
        this.quantidadepedidoslimitelentidao = quantidadepedidoslimitelentidao;
    }

    public Boolean getConsumidorfinalpadraonfe() {
        return consumidorfinalpadraonfe;
    }

    public void setConsumidorfinalpadraonfe(Boolean consumidorfinalpadraonfe) {
        this.consumidorfinalpadraonfe = consumidorfinalpadraonfe;
    }

    public String getTipolocalizacaopedido() {
        return tipolocalizacaopedido;
    }

    public void setTipolocalizacaopedido(String tipolocalizacaopedido) {
        this.tipolocalizacaopedido = tipolocalizacaopedido;
    }

    public String getFoconovoitemnfce() {
        return foconovoitemnfce;
    }

    public void setFoconovoitemnfce(String foconovoitemnfce) {
        this.foconovoitemnfce = foconovoitemnfce;
    }

    public Boolean getMantervalorvendacustoatualmenorcustoanterior() {
        return mantervalorvendacustoatualmenorcustoanterior;
    }

    public void setMantervalorvendacustoatualmenorcustoanterior(Boolean mantervalorvendacustoatualmenorcustoanterior) {
        this.mantervalorvendacustoatualmenorcustoanterior = mantervalorvendacustoatualmenorcustoanterior;
    }

    public Boolean getAdicionarinformacoesprodutoanota() {
        return adicionarinformacoesprodutoanota;
    }

    public void setAdicionarinformacoesprodutoanota(Boolean adicionarinformacoesprodutoanota) {
        this.adicionarinformacoesprodutoanota = adicionarinformacoesprodutoanota;
    }

    public Boolean getCadastroprecoautomatico() {
        return cadastroprecoautomatico;
    }

    public void setCadastroprecoautomatico(Boolean cadastroprecoautomatico) {
        this.cadastroprecoautomatico = cadastroprecoautomatico;
    }

    public Double getDecimalarredondar() {
        return decimalarredondar;
    }

    public void setDecimalarredondar(Double decimalarredondar) {
        this.decimalarredondar = decimalarredondar;
    }

    public String getBotao7() {
        return botao7;
    }

    public void setBotao7(String botao7) {
        this.botao7 = botao7;
    }

    public Boolean getGerarnfsdopedido() {
        return gerarnfsdopedido;
    }

    public void setGerarnfsdopedido(Boolean gerarnfsdopedido) {
        this.gerarnfsdopedido = gerarnfsdopedido;
    }

    public Boolean getAbrirconsultacontasreceberatraso() {
        return abrirconsultacontasreceberatraso;
    }

    public void setAbrirconsultacontasreceberatraso(Boolean abrirconsultacontasreceberatraso) {
        this.abrirconsultacontasreceberatraso = abrirconsultacontasreceberatraso;
    }

    public Boolean getSolicitarvalorduplicarcte() {
        return solicitarvalorduplicarcte;
    }

    public void setSolicitarvalorduplicarcte(Boolean solicitarvalorduplicarcte) {
        this.solicitarvalorduplicarcte = solicitarvalorduplicarcte;
    }

    public Boolean getAvisarcomposto() {
        return avisarcomposto;
    }

    public void setAvisarcomposto(Boolean avisarcomposto) {
        this.avisarcomposto = avisarcomposto;
    }

    public Boolean getBloquearcomposto() {
        return bloquearcomposto;
    }

    public void setBloquearcomposto(Boolean bloquearcomposto) {
        this.bloquearcomposto = bloquearcomposto;
    }

    public Boolean getNaomovimentarcaixanocontaspagar() {
        return naomovimentarcaixanocontaspagar;
    }

    public void setNaomovimentarcaixanocontaspagar(Boolean naomovimentarcaixanocontaspagar) {
        this.naomovimentarcaixanocontaspagar = naomovimentarcaixanocontaspagar;
    }

    public Long getCodnaturezadevolucaosaida() {
        return codnaturezadevolucaosaida;
    }

    public void setCodnaturezadevolucaosaida(Long codnaturezadevolucaosaida) {
        this.codnaturezadevolucaosaida = codnaturezadevolucaosaida;
    }

    public Boolean getImprimiravisognredifal() {
        return imprimiravisognredifal;
    }

    public void setImprimiravisognredifal(Boolean imprimiravisognredifal) {
        this.imprimiravisognredifal = imprimiravisognredifal;
    }

    public Boolean getBloquearduplicidadeentrada() {
        return bloquearduplicidadeentrada;
    }

    public void setBloquearduplicidadeentrada(Boolean bloquearduplicidadeentrada) {
        this.bloquearduplicidadeentrada = bloquearduplicidadeentrada;
    }


    public Cursor retornaConfiguracaoGeralFiltradoCursor(Context context, Long codconfiguracao) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM configuracaogeral where codconfiguracao = " + codconfiguracao, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public ConfiguracaoGeral retornaConfiguracaoGeral(Context context, Long codigo) {
        Banco myDb = new Banco(context);
        ConfiguracaoGeral configuracaoGeral = new ConfiguracaoGeral();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM configuracaogeral where codconfiguracao = " + codigo, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldList = new ArrayList<>(Arrays.asList(ConfiguracaoGeral.class.getDeclaredFields()));

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
            configuracaoGeral = new ConfiguracaoGeral();
            for (int f = 0; fieldList.size() != f; f++) {
                String tipo = getSetDinamico.retornaTipoCampo(fieldList.get(f));
                String nomeCampo = fieldList.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object ret = getSetDinamico.insereField(fieldList.get(f), configuracaoGeral, retorno);
                    configuracaoGeral = (ConfiguracaoGeral) ret;
                }
            }
        }
        db.close();
        return configuracaoGeral;

    }

    public Boolean cadastraEmitente(Context context, ConfiguracaoGeral configuracaoGeral) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(configuracaoGeral.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), configuracaoGeral, valores);
        }

        if (valores.get("codconfiguracao") == null) {
            db.insert("configuracaogeral", null, valores);
            db.close();
            valores.clear();
            return true;
        } else {
            Cursor cursor = configuracaoGeral.retornaConfiguracaoGeralFiltradoCursor(context, Long.parseLong(valores.get("codconfiguracao").toString()));

            if (cursor.getCount() > 0) {
                long retorno = db.update("configuracaogeral", valores, "codconfiguracao = " + valores.get("codconfiguracao").toString(), null);
                db.close();
                valores.clear();
                return retorno != -1;
            } else {
                db.insert("configuracaogeral", null, valores);
                db.close();
                valores.clear();
                return true;
            }

        }
    }
}

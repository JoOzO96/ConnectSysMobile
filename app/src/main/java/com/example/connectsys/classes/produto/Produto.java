package com.example.connectsys.classes.produto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.connectsys.banco.Banco;
import com.example.connectsys.uteis.DadosBanco;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Produto {


    Long codproduto;
    String numerointerno;
    String numerofabricante;
    String numeroean;
    Long codlocalizacao;
    Long codgrupo;
    Long codsubgrupo;
    Long codfornecedorpadrao;
    Long codicmscupom;
    Long codicmsnotafiscal;
    Long codmarca;
    Long codcomposicao;
    String descricao;
    Date datacadastro;
    Date datavenda;
    Date datacompra;
    Date dataalteracao;
    String aplicacao;
    Long codunidade;
    String custoletra;
    Double valorcompra;
    Double valorcusto;
    Double custocomercializacaopercentual;
    Double custovenda;
    Double quantidadeestoque;
    Double quantidademinima;
    Double quantidademaxima;
    Double fretevalor;
    Double fretepercentual;
    Double darf;
    Double icms;
    Double ipi;
    Double percentualavista;
    Double percentualaprazo;
    Double valoravista;
    Double valoraprazo;
    Double valortotal;
    String ncm;
    String classificacaofiscal;
    String situacaotributaria;
    Double perccomissao;
    Boolean inativo;
    Boolean naocomprar;
    Double pesoliquidounitarioipi;
    Double pesoliquidototalipi;
    Double pesobrutototal;
    Double pesoliquidototal;
    Double ipivenda;
    Double ipikg;
    String imagem;
    String tipoproduto;
    String observacao;
    Double mvainterno;
    Double mvaexterno;
    Long codprodutosimilar;
    String numerointernosimilar;
    String issqncodlistaservico;
    String issqnsituacaotributaria;
    String situacaotributariasaida;
    String csosn;
    String codipientrada;
    String codipisaida;
    String codpis;
    Double percpis;
    Double valorpisunitario;
    String codcofins;
    Double perccofins;
    Double valorcofinsunitario;
    String codpisentrada;
    String codcofinsentrada;
    Double percsubstituicao;
    String codexcecaoipi;
    String classeipi;
    String cnpjipi;
    String codseloipi;
    Long quantidadeseloipi;
    String codenquandramentoipi;
    String informacaoadicional;
    Boolean empromocao;
    Double percdescontopromocao;
    Double valordevendapromocao;
    Double valorcofinsunitarioentrada;
    Double perccofinsentrada;
    Double percpisentrada;
    Double valorpisunitarioentrada;
    Double percipientrada;
    Double valoripiunitarioentrada;
    String codtipo;
    String localiza;
    Double percdescontoformulacao;
    Long codnaturezapadrao;
    Long codempresa;
    String icmsvelho;
    Date datavalidade;
    String cest;
    String origem;
    String origemgarden;
    String categoria;
    String cientifico;
    String aplicacaogarden;
    String cultivo;
    Boolean produtocomposto;
    Double totalcomposicao;
    Double valorunitariosubstituicao;
    Long codnotaentradacadastro;
    Double valordespesas;
    String chassi;
    Long codunidadetributavel;
    Double fatortributavel;
    String cstconsumidorfinal;
    String csosnconsumidorfinal;
    String exigibilidadeiss;
    Double efet_baseicmsstretido;
    Double efet_aliquotasuportada;
    Double efet_valoricmsstretido;
    Double efet_basefcpstretido;
    Double efet_aliquotafcpretido;
    Double efet_valorfcpstretido;
    String informacaoadicionalexterna;
    Boolean cestao;
    Long codnaturezarevenda;

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

    public String getNumeroean() {
        return numeroean;
    }

    public void setNumeroean(String numeroean) {
        this.numeroean = numeroean;
    }

    public Long getCodlocalizacao() {
        return codlocalizacao;
    }

    public void setCodlocalizacao(Long codlocalizacao) {
        this.codlocalizacao = codlocalizacao;
    }

    public Long getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(Long codgrupo) {
        this.codgrupo = codgrupo;
    }

    public Long getCodsubgrupo() {
        return codsubgrupo;
    }

    public void setCodsubgrupo(Long codsubgrupo) {
        this.codsubgrupo = codsubgrupo;
    }

    public Long getCodfornecedorpadrao() {
        return codfornecedorpadrao;
    }

    public void setCodfornecedorpadrao(Long codfornecedorpadrao) {
        this.codfornecedorpadrao = codfornecedorpadrao;
    }

    public Long getCodicmscupom() {
        return codicmscupom;
    }

    public void setCodicmscupom(Long codicmscupom) {
        this.codicmscupom = codicmscupom;
    }

    public Long getCodicmsnotafiscal() {
        return codicmsnotafiscal;
    }

    public void setCodicmsnotafiscal(Long codicmsnotafiscal) {
        this.codicmsnotafiscal = codicmsnotafiscal;
    }

    public Long getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Long codmarca) {
        this.codmarca = codmarca;
    }

    public Long getCodcomposicao() {
        return codcomposicao;
    }

    public void setCodcomposicao(Long codcomposicao) {
        this.codcomposicao = codcomposicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Date getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Long getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(Long codunidade) {
        this.codunidade = codunidade;
    }

    public String getCustoletra() {
        return custoletra;
    }

    public void setCustoletra(String custoletra) {
        this.custoletra = custoletra;
    }

    public Double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Double getValorcusto() {
        return valorcusto;
    }

    public void setValorcusto(Double valorcusto) {
        this.valorcusto = valorcusto;
    }

    public Double getCustocomercializacaopercentual() {
        return custocomercializacaopercentual;
    }

    public void setCustocomercializacaopercentual(Double custocomercializacaopercentual) {
        this.custocomercializacaopercentual = custocomercializacaopercentual;
    }

    public Double getCustovenda() {
        return custovenda;
    }

    public void setCustovenda(Double custovenda) {
        this.custovenda = custovenda;
    }

    public Double getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(Double quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public Double getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(Double quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public Double getQuantidademaxima() {
        return quantidademaxima;
    }

    public void setQuantidademaxima(Double quantidademaxima) {
        this.quantidademaxima = quantidademaxima;
    }

    public Double getFretevalor() {
        return fretevalor;
    }

    public void setFretevalor(Double fretevalor) {
        this.fretevalor = fretevalor;
    }

    public Double getFretepercentual() {
        return fretepercentual;
    }

    public void setFretepercentual(Double fretepercentual) {
        this.fretepercentual = fretepercentual;
    }

    public Double getDarf() {
        return darf;
    }

    public void setDarf(Double darf) {
        this.darf = darf;
    }

    public Double getIcms() {
        return icms;
    }

    public void setIcms(Double icms) {
        this.icms = icms;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getPercentualavista() {
        return percentualavista;
    }

    public void setPercentualavista(Double percentualavista) {
        this.percentualavista = percentualavista;
    }

    public Double getPercentualaprazo() {
        return percentualaprazo;
    }

    public void setPercentualaprazo(Double percentualaprazo) {
        this.percentualaprazo = percentualaprazo;
    }

    public Double getValoravista() {
        return valoravista;
    }

    public void setValoravista(Double valoravista) {
        this.valoravista = valoravista;
    }

    public Double getValoraprazo() {
        return valoraprazo;
    }

    public void setValoraprazo(Double valoraprazo) {
        this.valoraprazo = valoraprazo;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getClassificacaofiscal() {
        return classificacaofiscal;
    }

    public void setClassificacaofiscal(String classificacaofiscal) {
        this.classificacaofiscal = classificacaofiscal;
    }

    public String getSituacaotributaria() {
        return situacaotributaria;
    }

    public void setSituacaotributaria(String situacaotributaria) {
        this.situacaotributaria = situacaotributaria;
    }

    public Double getPerccomissao() {
        return perccomissao;
    }

    public void setPerccomissao(Double perccomissao) {
        this.perccomissao = perccomissao;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public Boolean getNaocomprar() {
        return naocomprar;
    }

    public void setNaocomprar(Boolean naocomprar) {
        this.naocomprar = naocomprar;
    }

    public Double getPesoliquidounitarioipi() {
        return pesoliquidounitarioipi;
    }

    public void setPesoliquidounitarioipi(Double pesoliquidounitarioipi) {
        this.pesoliquidounitarioipi = pesoliquidounitarioipi;
    }

    public Double getPesoliquidototalipi() {
        return pesoliquidototalipi;
    }

    public void setPesoliquidototalipi(Double pesoliquidototalipi) {
        this.pesoliquidototalipi = pesoliquidototalipi;
    }

    public Double getPesobrutototal() {
        return pesobrutototal;
    }

    public void setPesobrutototal(Double pesobrutototal) {
        this.pesobrutototal = pesobrutototal;
    }

    public Double getPesoliquidototal() {
        return pesoliquidototal;
    }

    public void setPesoliquidototal(Double pesoliquidototal) {
        this.pesoliquidototal = pesoliquidototal;
    }

    public Double getIpivenda() {
        return ipivenda;
    }

    public void setIpivenda(Double ipivenda) {
        this.ipivenda = ipivenda;
    }

    public Double getIpikg() {
        return ipikg;
    }

    public void setIpikg(Double ipikg) {
        this.ipikg = ipikg;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getMvainterno() {
        return mvainterno;
    }

    public void setMvainterno(Double mvainterno) {
        this.mvainterno = mvainterno;
    }

    public Double getMvaexterno() {
        return mvaexterno;
    }

    public void setMvaexterno(Double mvaexterno) {
        this.mvaexterno = mvaexterno;
    }

    public Long getCodprodutosimilar() {
        return codprodutosimilar;
    }

    public void setCodprodutosimilar(Long codprodutosimilar) {
        this.codprodutosimilar = codprodutosimilar;
    }

    public String getNumerointernosimilar() {
        return numerointernosimilar;
    }

    public void setNumerointernosimilar(String numerointernosimilar) {
        this.numerointernosimilar = numerointernosimilar;
    }

    public String getIssqncodlistaservico() {
        return issqncodlistaservico;
    }

    public void setIssqncodlistaservico(String issqncodlistaservico) {
        this.issqncodlistaservico = issqncodlistaservico;
    }

    public String getIssqnsituacaotributaria() {
        return issqnsituacaotributaria;
    }

    public void setIssqnsituacaotributaria(String issqnsituacaotributaria) {
        this.issqnsituacaotributaria = issqnsituacaotributaria;
    }

    public String getSituacaotributariasaida() {
        return situacaotributariasaida;
    }

    public void setSituacaotributariasaida(String situacaotributariasaida) {
        this.situacaotributariasaida = situacaotributariasaida;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCodipientrada() {
        return codipientrada;
    }

    public void setCodipientrada(String codipientrada) {
        this.codipientrada = codipientrada;
    }

    public String getCodipisaida() {
        return codipisaida;
    }

    public void setCodipisaida(String codipisaida) {
        this.codipisaida = codipisaida;
    }

    public String getCodpis() {
        return codpis;
    }

    public void setCodpis(String codpis) {
        this.codpis = codpis;
    }

    public Double getPercpis() {
        return percpis;
    }

    public void setPercpis(Double percpis) {
        this.percpis = percpis;
    }

    public Double getValorpisunitario() {
        return valorpisunitario;
    }

    public void setValorpisunitario(Double valorpisunitario) {
        this.valorpisunitario = valorpisunitario;
    }

    public String getCodcofins() {
        return codcofins;
    }

    public void setCodcofins(String codcofins) {
        this.codcofins = codcofins;
    }

    public Double getPerccofins() {
        return perccofins;
    }

    public void setPerccofins(Double perccofins) {
        this.perccofins = perccofins;
    }

    public Double getValorcofinsunitario() {
        return valorcofinsunitario;
    }

    public void setValorcofinsunitario(Double valorcofinsunitario) {
        this.valorcofinsunitario = valorcofinsunitario;
    }

    public String getCodpisentrada() {
        return codpisentrada;
    }

    public void setCodpisentrada(String codpisentrada) {
        this.codpisentrada = codpisentrada;
    }

    public String getCodcofinsentrada() {
        return codcofinsentrada;
    }

    public void setCodcofinsentrada(String codcofinsentrada) {
        this.codcofinsentrada = codcofinsentrada;
    }

    public Double getPercsubstituicao() {
        return percsubstituicao;
    }

    public void setPercsubstituicao(Double percsubstituicao) {
        this.percsubstituicao = percsubstituicao;
    }

    public String getCodexcecaoipi() {
        return codexcecaoipi;
    }

    public void setCodexcecaoipi(String codexcecaoipi) {
        this.codexcecaoipi = codexcecaoipi;
    }

    public String getClasseipi() {
        return classeipi;
    }

    public void setClasseipi(String classeipi) {
        this.classeipi = classeipi;
    }

    public String getCnpjipi() {
        return cnpjipi;
    }

    public void setCnpjipi(String cnpjipi) {
        this.cnpjipi = cnpjipi;
    }

    public String getCodseloipi() {
        return codseloipi;
    }

    public void setCodseloipi(String codseloipi) {
        this.codseloipi = codseloipi;
    }

    public Long getQuantidadeseloipi() {
        return quantidadeseloipi;
    }

    public void setQuantidadeseloipi(Long quantidadeseloipi) {
        this.quantidadeseloipi = quantidadeseloipi;
    }

    public String getCodenquandramentoipi() {
        return codenquandramentoipi;
    }

    public void setCodenquandramentoipi(String codenquandramentoipi) {
        this.codenquandramentoipi = codenquandramentoipi;
    }

    public String getInformacaoadicional() {
        return informacaoadicional;
    }

    public void setInformacaoadicional(String informacaoadicional) {
        this.informacaoadicional = informacaoadicional;
    }

    public Boolean getEmpromocao() {
        return empromocao;
    }

    public void setEmpromocao(Boolean empromocao) {
        this.empromocao = empromocao;
    }

    public Double getPercdescontopromocao() {
        return percdescontopromocao;
    }

    public void setPercdescontopromocao(Double percdescontopromocao) {
        this.percdescontopromocao = percdescontopromocao;
    }

    public Double getValordevendapromocao() {
        return valordevendapromocao;
    }

    public void setValordevendapromocao(Double valordevendapromocao) {
        this.valordevendapromocao = valordevendapromocao;
    }

    public Double getValorcofinsunitarioentrada() {
        return valorcofinsunitarioentrada;
    }

    public void setValorcofinsunitarioentrada(Double valorcofinsunitarioentrada) {
        this.valorcofinsunitarioentrada = valorcofinsunitarioentrada;
    }

    public Double getPerccofinsentrada() {
        return perccofinsentrada;
    }

    public void setPerccofinsentrada(Double perccofinsentrada) {
        this.perccofinsentrada = perccofinsentrada;
    }

    public Double getPercpisentrada() {
        return percpisentrada;
    }

    public void setPercpisentrada(Double percpisentrada) {
        this.percpisentrada = percpisentrada;
    }

    public Double getValorpisunitarioentrada() {
        return valorpisunitarioentrada;
    }

    public void setValorpisunitarioentrada(Double valorpisunitarioentrada) {
        this.valorpisunitarioentrada = valorpisunitarioentrada;
    }

    public Double getPercipientrada() {
        return percipientrada;
    }

    public void setPercipientrada(Double percipientrada) {
        this.percipientrada = percipientrada;
    }

    public Double getValoripiunitarioentrada() {
        return valoripiunitarioentrada;
    }

    public void setValoripiunitarioentrada(Double valoripiunitarioentrada) {
        this.valoripiunitarioentrada = valoripiunitarioentrada;
    }

    public String getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(String codtipo) {
        this.codtipo = codtipo;
    }

    public String getLocaliza() {
        return localiza;
    }

    public void setLocaliza(String localiza) {
        this.localiza = localiza;
    }

    public Double getPercdescontoformulacao() {
        return percdescontoformulacao;
    }

    public void setPercdescontoformulacao(Double percdescontoformulacao) {
        this.percdescontoformulacao = percdescontoformulacao;
    }

    public Long getCodnaturezapadrao() {
        return codnaturezapadrao;
    }

    public void setCodnaturezapadrao(Long codnaturezapadrao) {
        this.codnaturezapadrao = codnaturezapadrao;
    }

    public Long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Long codempresa) {
        this.codempresa = codempresa;
    }

    public String getIcmsvelho() {
        return icmsvelho;
    }

    public void setIcmsvelho(String icmsvelho) {
        this.icmsvelho = icmsvelho;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigemgarden() {
        return origemgarden;
    }

    public void setOrigemgarden(String origemgarden) {
        this.origemgarden = origemgarden;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCientifico() {
        return cientifico;
    }

    public void setCientifico(String cientifico) {
        this.cientifico = cientifico;
    }

    public String getAplicacaogarden() {
        return aplicacaogarden;
    }

    public void setAplicacaogarden(String aplicacaogarden) {
        this.aplicacaogarden = aplicacaogarden;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public Boolean getProdutocomposto() {
        return produtocomposto;
    }

    public void setProdutocomposto(Boolean produtocomposto) {
        this.produtocomposto = produtocomposto;
    }

    public Double getTotalcomposicao() {
        return totalcomposicao;
    }

    public void setTotalcomposicao(Double totalcomposicao) {
        this.totalcomposicao = totalcomposicao;
    }

    public Double getValorunitariosubstituicao() {
        return valorunitariosubstituicao;
    }

    public void setValorunitariosubstituicao(Double valorunitariosubstituicao) {
        this.valorunitariosubstituicao = valorunitariosubstituicao;
    }

    public Long getCodnotaentradacadastro() {
        return codnotaentradacadastro;
    }

    public void setCodnotaentradacadastro(Long codnotaentradacadastro) {
        this.codnotaentradacadastro = codnotaentradacadastro;
    }

    public Double getValordespesas() {
        return valordespesas;
    }

    public void setValordespesas(Double valordespesas) {
        this.valordespesas = valordespesas;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Long getCodunidadetributavel() {
        return codunidadetributavel;
    }

    public void setCodunidadetributavel(Long codunidadetributavel) {
        this.codunidadetributavel = codunidadetributavel;
    }

    public Double getFatortributavel() {
        return fatortributavel;
    }

    public void setFatortributavel(Double fatortributavel) {
        this.fatortributavel = fatortributavel;
    }

    public String getCstconsumidorfinal() {
        return cstconsumidorfinal;
    }

    public void setCstconsumidorfinal(String cstconsumidorfinal) {
        this.cstconsumidorfinal = cstconsumidorfinal;
    }

    public String getCsosnconsumidorfinal() {
        return csosnconsumidorfinal;
    }

    public void setCsosnconsumidorfinal(String csosnconsumidorfinal) {
        this.csosnconsumidorfinal = csosnconsumidorfinal;
    }

    public String getExigibilidadeiss() {
        return exigibilidadeiss;
    }

    public void setExigibilidadeiss(String exigibilidadeiss) {
        this.exigibilidadeiss = exigibilidadeiss;
    }

    public Double getEfet_baseicmsstretido() {
        return efet_baseicmsstretido;
    }

    public void setEfet_baseicmsstretido(Double efet_baseicmsstretido) {
        this.efet_baseicmsstretido = efet_baseicmsstretido;
    }

    public Double getEfet_aliquotasuportada() {
        return efet_aliquotasuportada;
    }

    public void setEfet_aliquotasuportada(Double efet_aliquotasuportada) {
        this.efet_aliquotasuportada = efet_aliquotasuportada;
    }

    public Double getEfet_valoricmsstretido() {
        return efet_valoricmsstretido;
    }

    public void setEfet_valoricmsstretido(Double efet_valoricmsstretido) {
        this.efet_valoricmsstretido = efet_valoricmsstretido;
    }

    public Double getEfet_basefcpstretido() {
        return efet_basefcpstretido;
    }

    public void setEfet_basefcpstretido(Double efet_basefcpstretido) {
        this.efet_basefcpstretido = efet_basefcpstretido;
    }

    public Double getEfet_aliquotafcpretido() {
        return efet_aliquotafcpretido;
    }

    public void setEfet_aliquotafcpretido(Double efet_aliquotafcpretido) {
        this.efet_aliquotafcpretido = efet_aliquotafcpretido;
    }

    public Double getEfet_valorfcpstretido() {
        return efet_valorfcpstretido;
    }

    public void setEfet_valorfcpstretido(Double efet_valorfcpstretido) {
        this.efet_valorfcpstretido = efet_valorfcpstretido;
    }

    public String getInformacaoadicionalexterna() {
        return informacaoadicionalexterna;
    }

    public void setInformacaoadicionalexterna(String informacaoadicionalexterna) {
        this.informacaoadicionalexterna = informacaoadicionalexterna;
    }

    public Boolean getCestao() {
        return cestao;
    }

    public void setCestao(Boolean cestao) {
        this.cestao = cestao;
    }

    public Long getCodnaturezarevenda() {
        return codnaturezarevenda;
    }

    public void setCodnaturezarevenda(Long codnaturezarevenda) {
        this.codnaturezarevenda = codnaturezarevenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getCodproduto(), produto.getCodproduto()) &&
                Objects.equals(getNumerointerno(), produto.getNumerointerno()) &&
                Objects.equals(getNumerofabricante(), produto.getNumerofabricante()) &&
                Objects.equals(getNumeroean(), produto.getNumeroean()) &&
                Objects.equals(getCodlocalizacao(), produto.getCodlocalizacao()) &&
                Objects.equals(getCodgrupo(), produto.getCodgrupo()) &&
                Objects.equals(getCodsubgrupo(), produto.getCodsubgrupo()) &&
                Objects.equals(getCodfornecedorpadrao(), produto.getCodfornecedorpadrao()) &&
                Objects.equals(getCodicmscupom(), produto.getCodicmscupom()) &&
                Objects.equals(getCodicmsnotafiscal(), produto.getCodicmsnotafiscal()) &&
                Objects.equals(getCodmarca(), produto.getCodmarca()) &&
                Objects.equals(getCodcomposicao(), produto.getCodcomposicao()) &&
                Objects.equals(getDescricao(), produto.getDescricao()) &&
                Objects.equals(getDatacadastro(), produto.getDatacadastro()) &&
                Objects.equals(getDatavenda(), produto.getDatavenda()) &&
                Objects.equals(getDatacompra(), produto.getDatacompra()) &&
                Objects.equals(getDataalteracao(), produto.getDataalteracao()) &&
                Objects.equals(getAplicacao(), produto.getAplicacao()) &&
                Objects.equals(getCodunidade(), produto.getCodunidade()) &&
                Objects.equals(getCustoletra(), produto.getCustoletra()) &&
                Objects.equals(getValorcompra(), produto.getValorcompra()) &&
                Objects.equals(getValorcusto(), produto.getValorcusto()) &&
                Objects.equals(getCustocomercializacaopercentual(), produto.getCustocomercializacaopercentual()) &&
                Objects.equals(getCustovenda(), produto.getCustovenda()) &&
                Objects.equals(getQuantidadeestoque(), produto.getQuantidadeestoque()) &&
                Objects.equals(getQuantidademinima(), produto.getQuantidademinima()) &&
                Objects.equals(getQuantidademaxima(), produto.getQuantidademaxima()) &&
                Objects.equals(getFretevalor(), produto.getFretevalor()) &&
                Objects.equals(getFretepercentual(), produto.getFretepercentual()) &&
                Objects.equals(getDarf(), produto.getDarf()) &&
                Objects.equals(getIcms(), produto.getIcms()) &&
                Objects.equals(getIpi(), produto.getIpi()) &&
                Objects.equals(getPercentualavista(), produto.getPercentualavista()) &&
                Objects.equals(getPercentualaprazo(), produto.getPercentualaprazo()) &&
                Objects.equals(getValoravista(), produto.getValoravista()) &&
                Objects.equals(getValoraprazo(), produto.getValoraprazo()) &&
                Objects.equals(getValortotal(), produto.getValortotal()) &&
                Objects.equals(getNcm(), produto.getNcm()) &&
                Objects.equals(getClassificacaofiscal(), produto.getClassificacaofiscal()) &&
                Objects.equals(getSituacaotributaria(), produto.getSituacaotributaria()) &&
                Objects.equals(getPerccomissao(), produto.getPerccomissao()) &&
                Objects.equals(getInativo(), produto.getInativo()) &&
                Objects.equals(getNaocomprar(), produto.getNaocomprar()) &&
                Objects.equals(getPesoliquidounitarioipi(), produto.getPesoliquidounitarioipi()) &&
                Objects.equals(getPesoliquidototalipi(), produto.getPesoliquidototalipi()) &&
                Objects.equals(getPesobrutototal(), produto.getPesobrutototal()) &&
                Objects.equals(getPesoliquidototal(), produto.getPesoliquidototal()) &&
                Objects.equals(getIpivenda(), produto.getIpivenda()) &&
                Objects.equals(getIpikg(), produto.getIpikg()) &&
                Objects.equals(getImagem(), produto.getImagem()) &&
                Objects.equals(getTipoproduto(), produto.getTipoproduto()) &&
                Objects.equals(getObservacao(), produto.getObservacao()) &&
                Objects.equals(getMvainterno(), produto.getMvainterno()) &&
                Objects.equals(getMvaexterno(), produto.getMvaexterno()) &&
                Objects.equals(getCodprodutosimilar(), produto.getCodprodutosimilar()) &&
                Objects.equals(getNumerointernosimilar(), produto.getNumerointernosimilar()) &&
                Objects.equals(getIssqncodlistaservico(), produto.getIssqncodlistaservico()) &&
                Objects.equals(getIssqnsituacaotributaria(), produto.getIssqnsituacaotributaria()) &&
                Objects.equals(getSituacaotributariasaida(), produto.getSituacaotributariasaida()) &&
                Objects.equals(getCsosn(), produto.getCsosn()) &&
                Objects.equals(getCodipientrada(), produto.getCodipientrada()) &&
                Objects.equals(getCodipisaida(), produto.getCodipisaida()) &&
                Objects.equals(getCodpis(), produto.getCodpis()) &&
                Objects.equals(getPercpis(), produto.getPercpis()) &&
                Objects.equals(getValorpisunitario(), produto.getValorpisunitario()) &&
                Objects.equals(getCodcofins(), produto.getCodcofins()) &&
                Objects.equals(getPerccofins(), produto.getPerccofins()) &&
                Objects.equals(getValorcofinsunitario(), produto.getValorcofinsunitario()) &&
                Objects.equals(getCodpisentrada(), produto.getCodpisentrada()) &&
                Objects.equals(getCodcofinsentrada(), produto.getCodcofinsentrada()) &&
                Objects.equals(getPercsubstituicao(), produto.getPercsubstituicao()) &&
                Objects.equals(getCodexcecaoipi(), produto.getCodexcecaoipi()) &&
                Objects.equals(getClasseipi(), produto.getClasseipi()) &&
                Objects.equals(getCnpjipi(), produto.getCnpjipi()) &&
                Objects.equals(getCodseloipi(), produto.getCodseloipi()) &&
                Objects.equals(getQuantidadeseloipi(), produto.getQuantidadeseloipi()) &&
                Objects.equals(getCodenquandramentoipi(), produto.getCodenquandramentoipi()) &&
                Objects.equals(getInformacaoadicional(), produto.getInformacaoadicional()) &&
                Objects.equals(getEmpromocao(), produto.getEmpromocao()) &&
                Objects.equals(getPercdescontopromocao(), produto.getPercdescontopromocao()) &&
                Objects.equals(getValordevendapromocao(), produto.getValordevendapromocao()) &&
                Objects.equals(getValorcofinsunitarioentrada(), produto.getValorcofinsunitarioentrada()) &&
                Objects.equals(getPerccofinsentrada(), produto.getPerccofinsentrada()) &&
                Objects.equals(getPercpisentrada(), produto.getPercpisentrada()) &&
                Objects.equals(getValorpisunitarioentrada(), produto.getValorpisunitarioentrada()) &&
                Objects.equals(getPercipientrada(), produto.getPercipientrada()) &&
                Objects.equals(getValoripiunitarioentrada(), produto.getValoripiunitarioentrada()) &&
                Objects.equals(getCodtipo(), produto.getCodtipo()) &&
                Objects.equals(getLocaliza(), produto.getLocaliza()) &&
                Objects.equals(getPercdescontoformulacao(), produto.getPercdescontoformulacao()) &&
                Objects.equals(getCodnaturezapadrao(), produto.getCodnaturezapadrao()) &&
                Objects.equals(getCodempresa(), produto.getCodempresa()) &&
                Objects.equals(getIcmsvelho(), produto.getIcmsvelho()) &&
                Objects.equals(getDatavalidade(), produto.getDatavalidade()) &&
                Objects.equals(getCest(), produto.getCest()) &&
                Objects.equals(getOrigem(), produto.getOrigem()) &&
                Objects.equals(getOrigemgarden(), produto.getOrigemgarden()) &&
                Objects.equals(getCategoria(), produto.getCategoria()) &&
                Objects.equals(getCientifico(), produto.getCientifico()) &&
                Objects.equals(getAplicacaogarden(), produto.getAplicacaogarden()) &&
                Objects.equals(getCultivo(), produto.getCultivo()) &&
                Objects.equals(getProdutocomposto(), produto.getProdutocomposto()) &&
                Objects.equals(getTotalcomposicao(), produto.getTotalcomposicao()) &&
                Objects.equals(getValorunitariosubstituicao(), produto.getValorunitariosubstituicao()) &&
                Objects.equals(getCodnotaentradacadastro(), produto.getCodnotaentradacadastro()) &&
                Objects.equals(getValordespesas(), produto.getValordespesas()) &&
                Objects.equals(getChassi(), produto.getChassi()) &&
                Objects.equals(getCodunidadetributavel(), produto.getCodunidadetributavel()) &&
                Objects.equals(getFatortributavel(), produto.getFatortributavel()) &&
                Objects.equals(getCstconsumidorfinal(), produto.getCstconsumidorfinal()) &&
                Objects.equals(getCsosnconsumidorfinal(), produto.getCsosnconsumidorfinal()) &&
                Objects.equals(getExigibilidadeiss(), produto.getExigibilidadeiss()) &&
                Objects.equals(getEfet_baseicmsstretido(), produto.getEfet_baseicmsstretido()) &&
                Objects.equals(getEfet_aliquotasuportada(), produto.getEfet_aliquotasuportada()) &&
                Objects.equals(getEfet_valoricmsstretido(), produto.getEfet_valoricmsstretido()) &&
                Objects.equals(getEfet_basefcpstretido(), produto.getEfet_basefcpstretido()) &&
                Objects.equals(getEfet_aliquotafcpretido(), produto.getEfet_aliquotafcpretido()) &&
                Objects.equals(getEfet_valorfcpstretido(), produto.getEfet_valorfcpstretido()) &&
                Objects.equals(getInformacaoadicionalexterna(), produto.getInformacaoadicionalexterna()) &&
                Objects.equals(getCestao(), produto.getCestao()) &&
                Objects.equals(getCodnaturezarevenda(), produto.getCodnaturezarevenda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodproduto(), getNumerointerno(), getNumerofabricante(), getNumeroean(), getCodlocalizacao(), getCodgrupo(), getCodsubgrupo(), getCodfornecedorpadrao(), getCodicmscupom(), getCodicmsnotafiscal(), getCodmarca(), getCodcomposicao(), getDescricao(), getDatacadastro(), getDatavenda(), getDatacompra(), getDataalteracao(), getAplicacao(), getCodunidade(), getCustoletra(), getValorcompra(), getValorcusto(), getCustocomercializacaopercentual(), getCustovenda(), getQuantidadeestoque(), getQuantidademinima(), getQuantidademaxima(), getFretevalor(), getFretepercentual(), getDarf(), getIcms(), getIpi(), getPercentualavista(), getPercentualaprazo(), getValoravista(), getValoraprazo(), getValortotal(), getNcm(), getClassificacaofiscal(), getSituacaotributaria(), getPerccomissao(), getInativo(), getNaocomprar(), getPesoliquidounitarioipi(), getPesoliquidototalipi(), getPesobrutototal(), getPesoliquidototal(), getIpivenda(), getIpikg(), getImagem(), getTipoproduto(), getObservacao(), getMvainterno(), getMvaexterno(), getCodprodutosimilar(), getNumerointernosimilar(), getIssqncodlistaservico(), getIssqnsituacaotributaria(), getSituacaotributariasaida(), getCsosn(), getCodipientrada(), getCodipisaida(), getCodpis(), getPercpis(), getValorpisunitario(), getCodcofins(), getPerccofins(), getValorcofinsunitario(), getCodpisentrada(), getCodcofinsentrada(), getPercsubstituicao(), getCodexcecaoipi(), getClasseipi(), getCnpjipi(), getCodseloipi(), getQuantidadeseloipi(), getCodenquandramentoipi(), getInformacaoadicional(), getEmpromocao(), getPercdescontopromocao(), getValordevendapromocao(), getValorcofinsunitarioentrada(), getPerccofinsentrada(), getPercpisentrada(), getValorpisunitarioentrada(), getPercipientrada(), getValoripiunitarioentrada(), getCodtipo(), getLocaliza(), getPercdescontoformulacao(), getCodnaturezapadrao(), getCodempresa(), getIcmsvelho(), getDatavalidade(), getCest(), getOrigem(), getOrigemgarden(), getCategoria(), getCientifico(), getAplicacaogarden(), getCultivo(), getProdutocomposto(), getTotalcomposicao(), getValorunitariosubstituicao(), getCodnotaentradacadastro(), getValordespesas(), getChassi(), getCodunidadetributavel(), getFatortributavel(), getCstconsumidorfinal(), getCsosnconsumidorfinal(), getExigibilidadeiss(), getEfet_baseicmsstretido(), getEfet_aliquotasuportada(), getEfet_valoricmsstretido(), getEfet_basefcpstretido(), getEfet_aliquotafcpretido(), getEfet_valorfcpstretido(), getInformacaoadicionalexterna(), getCestao(), getCodnaturezarevenda());
    }

    //FUNÇÕES DA CLASSE PRODUTO


    @Override
    public String toString() {
        return codproduto + " - " + descricao;
    }

    public void removeProdutos(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        db.delete("produto", null, null);
    }

    public Cursor retornaProdutoFiltradaCursorSincro(SQLiteDatabase db, Long codProduto) {
        Cursor cursor = db.rawQuery("SELECT codproduto FROM produto where codproduto = " + codProduto, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Boolean cadastraProdutoSincro(SQLiteDatabase db, Produto produto) {
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(produto.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), produto, valores);
        }
        if (valores.containsKey("codproduto")) {
            if (valores.get("codproduto") != null) {
                Cursor cursor = produto.retornaProdutoFiltradaCursorSincro(db, Long.parseLong(valores.get("codproduto").toString()));
                if (cursor.getCount() == 0) {
                    Long retorno = 0L;
                    valores.remove("cadastroandroid");
                    retorno = db.insert("produto", null, valores);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                } else {

                    valores.remove("alteradoandroid");
                    long retorno = db.update("produto", valores, "codproduto= " + valores.get("codproduto").toString(), null);
                    db.close();
                    valores.clear();
                    return retorno != -1;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Cursor retornaProduto(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM produto", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;
    }
}

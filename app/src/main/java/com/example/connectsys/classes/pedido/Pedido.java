package com.example.connectsys.classes.pedido;

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

public class Pedido {

    Long codpedido;
    String orcamentopedido;
    Long codcliente;
    String nomecliente;
    Long codendereco;
    Date data;
    Long codvendedor;
    Long codtabela;
    Long nrparcelas;
    Long codformapagto;
    Long codcontacaixa;
    String obs;
    String numeronotafiscal;
    Boolean gerarnota;
    Boolean gerarcupom;
    Boolean lancado;
    Boolean cancelado;
    Boolean baixouestoque;
    String veiculo;
    String placa;
    Double valoroutros;
    Double percdescontoservicos;
    Double valordescontoservicos;
    Double valortotal;
    Double subtotalservicos;
    Double subtotalprodutos;
    Double percdescontoprodutos;
    Double valordescontoprodutos;
    Double valortotalitens;
    Long codmotor;
    Long odometro;
    Long codrepresentante;
    Long codmecanica;
    Double baseprodutosrepresentante;
    Double percprodutosrepresentante;
    Double valorprodutosrepresentante;
    Double baseservicosrepresentante;
    Double percservicosrepresentante;
    Double valorservicosrepresentante;
    Double baseprodutosmecanico;
    Double percprodutosmecanico;
    Double valorprodutosmecanico;
    Double baseservicosmecanico;
    Double percservicosmecanico;
    Double valorservicosmecanico;
    Double baseprodutosmecanica;
    Double percprodutosmecanica;
    Double valorprodutosmecanica;
    Double baseservicosmecanica;
    Double percservicosmecanica;
    Double valorservicosmecanica;
    String veiculodescricao;
    Long codmecanico;
    Long codcontapagarcomissaomecanica;
    Double valorfrete;
    Date datafechamento;
    Long codnaturezaoperacao;
    Long codpraca;
    Double baseicms;
    Double valoricms;
    Double basesubstituicao;
    Double valorsubstituicao;
    Double valorseguro;
    Double valordescontototal;
    Double valorimportacao;
    Double valoripi;
    Double valorpis;
    Double valorcofins;
    Double baseissqn;
    Double valorissqn;
    String freteporconta;
    Long codveiculo;
    Double volume;
    Long codigoregimetributario;
    Double valoraproximadoimpostos;
    Long codnotafiscalgerada;
    Long codemitente;
    Double valorpago;
    Double valortroco;
    Boolean retirada;
    String numerocupomfiscal;
    Long numeropdv;
    Boolean importouitensnfc;
    String datahoraimportouitensnfc;
    String usuariologado;
    Long codcaixaabertura;
    String usuario;
    Long codnfs;
    String numeronfs;
    Long codcestao;

    public Long getCodpedido() {
        return codpedido;
    }

    public void setCodpedido(Long codpedido) {
        this.codpedido = codpedido;
    }

    public String getOrcamentopedido() {
        return orcamentopedido;
    }

    public void setOrcamentopedido(String orcamentopedido) {
        this.orcamentopedido = orcamentopedido;
    }

    public Long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Long getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(Long codendereco) {
        this.codendereco = codendereco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(Long codvendedor) {
        this.codvendedor = codvendedor;
    }

    public Long getCodtabela() {
        return codtabela;
    }

    public void setCodtabela(Long codtabela) {
        this.codtabela = codtabela;
    }

    public Long getNrparcelas() {
        return nrparcelas;
    }

    public void setNrparcelas(Long nrparcelas) {
        this.nrparcelas = nrparcelas;
    }

    public Long getCodformapagto() {
        return codformapagto;
    }

    public void setCodformapagto(Long codformapagto) {
        this.codformapagto = codformapagto;
    }

    public Long getCodcontacaixa() {
        return codcontacaixa;
    }

    public void setCodcontacaixa(Long codcontacaixa) {
        this.codcontacaixa = codcontacaixa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNumeronotafiscal() {
        return numeronotafiscal;
    }

    public void setNumeronotafiscal(String numeronotafiscal) {
        this.numeronotafiscal = numeronotafiscal;
    }

    public Boolean getGerarnota() {
        return gerarnota;
    }

    public void setGerarnota(Boolean gerarnota) {
        this.gerarnota = gerarnota;
    }

    public Boolean getGerarcupom() {
        return gerarcupom;
    }

    public void setGerarcupom(Boolean gerarcupom) {
        this.gerarcupom = gerarcupom;
    }

    public Boolean getLancado() {
        return lancado;
    }

    public void setLancado(Boolean lancado) {
        this.lancado = lancado;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public Boolean getBaixouestoque() {
        return baixouestoque;
    }

    public void setBaixouestoque(Boolean baixouestoque) {
        this.baixouestoque = baixouestoque;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValoroutros() {
        return valoroutros;
    }

    public void setValoroutros(Double valoroutros) {
        this.valoroutros = valoroutros;
    }

    public Double getPercdescontoservicos() {
        return percdescontoservicos;
    }

    public void setPercdescontoservicos(Double percdescontoservicos) {
        this.percdescontoservicos = percdescontoservicos;
    }

    public Double getValordescontoservicos() {
        return valordescontoservicos;
    }

    public void setValordescontoservicos(Double valordescontoservicos) {
        this.valordescontoservicos = valordescontoservicos;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public Double getSubtotalservicos() {
        return subtotalservicos;
    }

    public void setSubtotalservicos(Double subtotalservicos) {
        this.subtotalservicos = subtotalservicos;
    }

    public Double getSubtotalprodutos() {
        return subtotalprodutos;
    }

    public void setSubtotalprodutos(Double subtotalprodutos) {
        this.subtotalprodutos = subtotalprodutos;
    }

    public Double getPercdescontoprodutos() {
        return percdescontoprodutos;
    }

    public void setPercdescontoprodutos(Double percdescontoprodutos) {
        this.percdescontoprodutos = percdescontoprodutos;
    }

    public Double getValordescontoprodutos() {
        return valordescontoprodutos;
    }

    public void setValordescontoprodutos(Double valordescontoprodutos) {
        this.valordescontoprodutos = valordescontoprodutos;
    }

    public Double getValortotalitens() {
        return valortotalitens;
    }

    public void setValortotalitens(Double valortotalitens) {
        this.valortotalitens = valortotalitens;
    }

    public Long getCodmotor() {
        return codmotor;
    }

    public void setCodmotor(Long codmotor) {
        this.codmotor = codmotor;
    }

    public Long getOdometro() {
        return odometro;
    }

    public void setOdometro(Long odometro) {
        this.odometro = odometro;
    }

    public Long getCodrepresentante() {
        return codrepresentante;
    }

    public void setCodrepresentante(Long codrepresentante) {
        this.codrepresentante = codrepresentante;
    }

    public Long getCodmecanica() {
        return codmecanica;
    }

    public void setCodmecanica(Long codmecanica) {
        this.codmecanica = codmecanica;
    }

    public Double getBaseprodutosrepresentante() {
        return baseprodutosrepresentante;
    }

    public void setBaseprodutosrepresentante(Double baseprodutosrepresentante) {
        this.baseprodutosrepresentante = baseprodutosrepresentante;
    }

    public Double getPercprodutosrepresentante() {
        return percprodutosrepresentante;
    }

    public void setPercprodutosrepresentante(Double percprodutosrepresentante) {
        this.percprodutosrepresentante = percprodutosrepresentante;
    }

    public Double getValorprodutosrepresentante() {
        return valorprodutosrepresentante;
    }

    public void setValorprodutosrepresentante(Double valorprodutosrepresentante) {
        this.valorprodutosrepresentante = valorprodutosrepresentante;
    }

    public Double getBaseservicosrepresentante() {
        return baseservicosrepresentante;
    }

    public void setBaseservicosrepresentante(Double baseservicosrepresentante) {
        this.baseservicosrepresentante = baseservicosrepresentante;
    }

    public Double getPercservicosrepresentante() {
        return percservicosrepresentante;
    }

    public void setPercservicosrepresentante(Double percservicosrepresentante) {
        this.percservicosrepresentante = percservicosrepresentante;
    }

    public Double getValorservicosrepresentante() {
        return valorservicosrepresentante;
    }

    public void setValorservicosrepresentante(Double valorservicosrepresentante) {
        this.valorservicosrepresentante = valorservicosrepresentante;
    }

    public Double getBaseprodutosmecanico() {
        return baseprodutosmecanico;
    }

    public void setBaseprodutosmecanico(Double baseprodutosmecanico) {
        this.baseprodutosmecanico = baseprodutosmecanico;
    }

    public Double getPercprodutosmecanico() {
        return percprodutosmecanico;
    }

    public void setPercprodutosmecanico(Double percprodutosmecanico) {
        this.percprodutosmecanico = percprodutosmecanico;
    }

    public Double getValorprodutosmecanico() {
        return valorprodutosmecanico;
    }

    public void setValorprodutosmecanico(Double valorprodutosmecanico) {
        this.valorprodutosmecanico = valorprodutosmecanico;
    }

    public Double getBaseservicosmecanico() {
        return baseservicosmecanico;
    }

    public void setBaseservicosmecanico(Double baseservicosmecanico) {
        this.baseservicosmecanico = baseservicosmecanico;
    }

    public Double getPercservicosmecanico() {
        return percservicosmecanico;
    }

    public void setPercservicosmecanico(Double percservicosmecanico) {
        this.percservicosmecanico = percservicosmecanico;
    }

    public Double getValorservicosmecanico() {
        return valorservicosmecanico;
    }

    public void setValorservicosmecanico(Double valorservicosmecanico) {
        this.valorservicosmecanico = valorservicosmecanico;
    }

    public Double getBaseprodutosmecanica() {
        return baseprodutosmecanica;
    }

    public void setBaseprodutosmecanica(Double baseprodutosmecanica) {
        this.baseprodutosmecanica = baseprodutosmecanica;
    }

    public Double getPercprodutosmecanica() {
        return percprodutosmecanica;
    }

    public void setPercprodutosmecanica(Double percprodutosmecanica) {
        this.percprodutosmecanica = percprodutosmecanica;
    }

    public Double getValorprodutosmecanica() {
        return valorprodutosmecanica;
    }

    public void setValorprodutosmecanica(Double valorprodutosmecanica) {
        this.valorprodutosmecanica = valorprodutosmecanica;
    }

    public Double getBaseservicosmecanica() {
        return baseservicosmecanica;
    }

    public void setBaseservicosmecanica(Double baseservicosmecanica) {
        this.baseservicosmecanica = baseservicosmecanica;
    }

    public Double getPercservicosmecanica() {
        return percservicosmecanica;
    }

    public void setPercservicosmecanica(Double percservicosmecanica) {
        this.percservicosmecanica = percservicosmecanica;
    }

    public Double getValorservicosmecanica() {
        return valorservicosmecanica;
    }

    public void setValorservicosmecanica(Double valorservicosmecanica) {
        this.valorservicosmecanica = valorservicosmecanica;
    }

    public String getVeiculodescricao() {
        return veiculodescricao;
    }

    public void setVeiculodescricao(String veiculodescricao) {
        this.veiculodescricao = veiculodescricao;
    }

    public Long getCodmecanico() {
        return codmecanico;
    }

    public void setCodmecanico(Long codmecanico) {
        this.codmecanico = codmecanico;
    }

    public Long getCodcontapagarcomissaomecanica() {
        return codcontapagarcomissaomecanica;
    }

    public void setCodcontapagarcomissaomecanica(Long codcontapagarcomissaomecanica) {
        this.codcontapagarcomissaomecanica = codcontapagarcomissaomecanica;
    }

    public Double getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(Double valorfrete) {
        this.valorfrete = valorfrete;
    }

    public Date getDatafechamento() {
        return datafechamento;
    }

    public void setDatafechamento(Date datafechamento) {
        this.datafechamento = datafechamento;
    }

    public Long getCodnaturezaoperacao() {
        return codnaturezaoperacao;
    }

    public void setCodnaturezaoperacao(Long codnaturezaoperacao) {
        this.codnaturezaoperacao = codnaturezaoperacao;
    }

    public Long getCodpraca() {
        return codpraca;
    }

    public void setCodpraca(Long codpraca) {
        this.codpraca = codpraca;
    }

    public Double getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(Double baseicms) {
        this.baseicms = baseicms;
    }

    public Double getValoricms() {
        return valoricms;
    }

    public void setValoricms(Double valoricms) {
        this.valoricms = valoricms;
    }

    public Double getBasesubstituicao() {
        return basesubstituicao;
    }

    public void setBasesubstituicao(Double basesubstituicao) {
        this.basesubstituicao = basesubstituicao;
    }

    public Double getValorsubstituicao() {
        return valorsubstituicao;
    }

    public void setValorsubstituicao(Double valorsubstituicao) {
        this.valorsubstituicao = valorsubstituicao;
    }

    public Double getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(Double valorseguro) {
        this.valorseguro = valorseguro;
    }

    public Double getValordescontototal() {
        return valordescontototal;
    }

    public void setValordescontototal(Double valordescontototal) {
        this.valordescontototal = valordescontototal;
    }

    public Double getValorimportacao() {
        return valorimportacao;
    }

    public void setValorimportacao(Double valorimportacao) {
        this.valorimportacao = valorimportacao;
    }

    public Double getValoripi() {
        return valoripi;
    }

    public void setValoripi(Double valoripi) {
        this.valoripi = valoripi;
    }

    public Double getValorpis() {
        return valorpis;
    }

    public void setValorpis(Double valorpis) {
        this.valorpis = valorpis;
    }

    public Double getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(Double valorcofins) {
        this.valorcofins = valorcofins;
    }

    public Double getBaseissqn() {
        return baseissqn;
    }

    public void setBaseissqn(Double baseissqn) {
        this.baseissqn = baseissqn;
    }

    public Double getValorissqn() {
        return valorissqn;
    }

    public void setValorissqn(Double valorissqn) {
        this.valorissqn = valorissqn;
    }

    public String getFreteporconta() {
        return freteporconta;
    }

    public void setFreteporconta(String freteporconta) {
        this.freteporconta = freteporconta;
    }

    public Long getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Long codveiculo) {
        this.codveiculo = codveiculo;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Long getCodigoregimetributario() {
        return codigoregimetributario;
    }

    public void setCodigoregimetributario(Long codigoregimetributario) {
        this.codigoregimetributario = codigoregimetributario;
    }

    public Double getValoraproximadoimpostos() {
        return valoraproximadoimpostos;
    }

    public void setValoraproximadoimpostos(Double valoraproximadoimpostos) {
        this.valoraproximadoimpostos = valoraproximadoimpostos;
    }

    public Long getCodnotafiscalgerada() {
        return codnotafiscalgerada;
    }

    public void setCodnotafiscalgerada(Long codnotafiscalgerada) {
        this.codnotafiscalgerada = codnotafiscalgerada;
    }

    public Long getCodemitente() {
        return codemitente;
    }

    public void setCodemitente(Long codemitente) {
        this.codemitente = codemitente;
    }

    public Double getValorpago() {
        return valorpago;
    }

    public void setValorpago(Double valorpago) {
        this.valorpago = valorpago;
    }

    public Double getValortroco() {
        return valortroco;
    }

    public void setValortroco(Double valortroco) {
        this.valortroco = valortroco;
    }

    public Boolean getRetirada() {
        return retirada;
    }

    public void setRetirada(Boolean retirada) {
        this.retirada = retirada;
    }

    public String getNumerocupomfiscal() {
        return numerocupomfiscal;
    }

    public void setNumerocupomfiscal(String numerocupomfiscal) {
        this.numerocupomfiscal = numerocupomfiscal;
    }

    public Long getNumeropdv() {
        return numeropdv;
    }

    public void setNumeropdv(Long numeropdv) {
        this.numeropdv = numeropdv;
    }

    public Boolean getImportouitensnfc() {
        return importouitensnfc;
    }

    public void setImportouitensnfc(Boolean importouitensnfc) {
        this.importouitensnfc = importouitensnfc;
    }

    public String getDatahoraimportouitensnfc() {
        return datahoraimportouitensnfc;
    }

    public void setDatahoraimportouitensnfc(String datahoraimportouitensnfc) {
        this.datahoraimportouitensnfc = datahoraimportouitensnfc;
    }

    public String getUsuariologado() {
        return usuariologado;
    }

    public void setUsuariologado(String usuariologado) {
        this.usuariologado = usuariologado;
    }

    public Long getCodcaixaabertura() {
        return codcaixaabertura;
    }

    public void setCodcaixaabertura(Long codcaixaabertura) {
        this.codcaixaabertura = codcaixaabertura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getCodnfs() {
        return codnfs;
    }

    public void setCodnfs(Long codnfs) {
        this.codnfs = codnfs;
    }

    public String getNumeronfs() {
        return numeronfs;
    }

    public void setNumeronfs(String numeronfs) {
        this.numeronfs = numeronfs;
    }

    public Long getCodcestao() {
        return codcestao;
    }

    public void setCodcestao(Long codcestao) {
        this.codcestao = codcestao;
    }

    @Override
    public String toString() {
        return codpedido + " - " + nomecliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getCodpedido(), pedido.getCodpedido()) &&
                Objects.equals(getOrcamentopedido(), pedido.getOrcamentopedido()) &&
                Objects.equals(getCodcliente(), pedido.getCodcliente()) &&
                Objects.equals(getNomecliente(), pedido.getNomecliente()) &&
                Objects.equals(getCodendereco(), pedido.getCodendereco()) &&
                Objects.equals(getData(), pedido.getData()) &&
                Objects.equals(getCodvendedor(), pedido.getCodvendedor()) &&
                Objects.equals(getCodtabela(), pedido.getCodtabela()) &&
                Objects.equals(getNrparcelas(), pedido.getNrparcelas()) &&
                Objects.equals(getCodformapagto(), pedido.getCodformapagto()) &&
                Objects.equals(getCodcontacaixa(), pedido.getCodcontacaixa()) &&
                Objects.equals(getObs(), pedido.getObs()) &&
                Objects.equals(getNumeronotafiscal(), pedido.getNumeronotafiscal()) &&
                Objects.equals(getGerarnota(), pedido.getGerarnota()) &&
                Objects.equals(getGerarcupom(), pedido.getGerarcupom()) &&
                Objects.equals(getLancado(), pedido.getLancado()) &&
                Objects.equals(getCancelado(), pedido.getCancelado()) &&
                Objects.equals(getBaixouestoque(), pedido.getBaixouestoque()) &&
                Objects.equals(getVeiculo(), pedido.getVeiculo()) &&
                Objects.equals(getPlaca(), pedido.getPlaca()) &&
                Objects.equals(getValoroutros(), pedido.getValoroutros()) &&
                Objects.equals(getPercdescontoservicos(), pedido.getPercdescontoservicos()) &&
                Objects.equals(getValordescontoservicos(), pedido.getValordescontoservicos()) &&
                Objects.equals(getValortotal(), pedido.getValortotal()) &&
                Objects.equals(getSubtotalservicos(), pedido.getSubtotalservicos()) &&
                Objects.equals(getSubtotalprodutos(), pedido.getSubtotalprodutos()) &&
                Objects.equals(getPercdescontoprodutos(), pedido.getPercdescontoprodutos()) &&
                Objects.equals(getValordescontoprodutos(), pedido.getValordescontoprodutos()) &&
                Objects.equals(getValortotalitens(), pedido.getValortotalitens()) &&
                Objects.equals(getCodmotor(), pedido.getCodmotor()) &&
                Objects.equals(getOdometro(), pedido.getOdometro()) &&
                Objects.equals(getCodrepresentante(), pedido.getCodrepresentante()) &&
                Objects.equals(getCodmecanica(), pedido.getCodmecanica()) &&
                Objects.equals(getBaseprodutosrepresentante(), pedido.getBaseprodutosrepresentante()) &&
                Objects.equals(getPercprodutosrepresentante(), pedido.getPercprodutosrepresentante()) &&
                Objects.equals(getValorprodutosrepresentante(), pedido.getValorprodutosrepresentante()) &&
                Objects.equals(getBaseservicosrepresentante(), pedido.getBaseservicosrepresentante()) &&
                Objects.equals(getPercservicosrepresentante(), pedido.getPercservicosrepresentante()) &&
                Objects.equals(getValorservicosrepresentante(), pedido.getValorservicosrepresentante()) &&
                Objects.equals(getBaseprodutosmecanico(), pedido.getBaseprodutosmecanico()) &&
                Objects.equals(getPercprodutosmecanico(), pedido.getPercprodutosmecanico()) &&
                Objects.equals(getValorprodutosmecanico(), pedido.getValorprodutosmecanico()) &&
                Objects.equals(getBaseservicosmecanico(), pedido.getBaseservicosmecanico()) &&
                Objects.equals(getPercservicosmecanico(), pedido.getPercservicosmecanico()) &&
                Objects.equals(getValorservicosmecanico(), pedido.getValorservicosmecanico()) &&
                Objects.equals(getBaseprodutosmecanica(), pedido.getBaseprodutosmecanica()) &&
                Objects.equals(getPercprodutosmecanica(), pedido.getPercprodutosmecanica()) &&
                Objects.equals(getValorprodutosmecanica(), pedido.getValorprodutosmecanica()) &&
                Objects.equals(getBaseservicosmecanica(), pedido.getBaseservicosmecanica()) &&
                Objects.equals(getPercservicosmecanica(), pedido.getPercservicosmecanica()) &&
                Objects.equals(getValorservicosmecanica(), pedido.getValorservicosmecanica()) &&
                Objects.equals(getVeiculodescricao(), pedido.getVeiculodescricao()) &&
                Objects.equals(getCodmecanico(), pedido.getCodmecanico()) &&
                Objects.equals(getCodcontapagarcomissaomecanica(), pedido.getCodcontapagarcomissaomecanica()) &&
                Objects.equals(getValorfrete(), pedido.getValorfrete()) &&
                Objects.equals(getDatafechamento(), pedido.getDatafechamento()) &&
                Objects.equals(getCodnaturezaoperacao(), pedido.getCodnaturezaoperacao()) &&
                Objects.equals(getCodpraca(), pedido.getCodpraca()) &&
                Objects.equals(getBaseicms(), pedido.getBaseicms()) &&
                Objects.equals(getValoricms(), pedido.getValoricms()) &&
                Objects.equals(getBasesubstituicao(), pedido.getBasesubstituicao()) &&
                Objects.equals(getValorsubstituicao(), pedido.getValorsubstituicao()) &&
                Objects.equals(getValorseguro(), pedido.getValorseguro()) &&
                Objects.equals(getValordescontototal(), pedido.getValordescontototal()) &&
                Objects.equals(getValorimportacao(), pedido.getValorimportacao()) &&
                Objects.equals(getValoripi(), pedido.getValoripi()) &&
                Objects.equals(getValorpis(), pedido.getValorpis()) &&
                Objects.equals(getValorcofins(), pedido.getValorcofins()) &&
                Objects.equals(getBaseissqn(), pedido.getBaseissqn()) &&
                Objects.equals(getValorissqn(), pedido.getValorissqn()) &&
                Objects.equals(getFreteporconta(), pedido.getFreteporconta()) &&
                Objects.equals(getCodveiculo(), pedido.getCodveiculo()) &&
                Objects.equals(getVolume(), pedido.getVolume()) &&
                Objects.equals(getCodigoregimetributario(), pedido.getCodigoregimetributario()) &&
                Objects.equals(getValoraproximadoimpostos(), pedido.getValoraproximadoimpostos()) &&
                Objects.equals(getCodnotafiscalgerada(), pedido.getCodnotafiscalgerada()) &&
                Objects.equals(getCodemitente(), pedido.getCodemitente()) &&
                Objects.equals(getValorpago(), pedido.getValorpago()) &&
                Objects.equals(getValortroco(), pedido.getValortroco()) &&
                Objects.equals(getRetirada(), pedido.getRetirada()) &&
                Objects.equals(getNumerocupomfiscal(), pedido.getNumerocupomfiscal()) &&
                Objects.equals(getNumeropdv(), pedido.getNumeropdv()) &&
                Objects.equals(getImportouitensnfc(), pedido.getImportouitensnfc()) &&
                Objects.equals(getDatahoraimportouitensnfc(), pedido.getDatahoraimportouitensnfc()) &&
                Objects.equals(getUsuariologado(), pedido.getUsuariologado()) &&
                Objects.equals(getCodcaixaabertura(), pedido.getCodcaixaabertura()) &&
                Objects.equals(getUsuario(), pedido.getUsuario()) &&
                Objects.equals(getCodnfs(), pedido.getCodnfs()) &&
                Objects.equals(getNumeronfs(), pedido.getNumeronfs()) &&
                Objects.equals(getCodcestao(), pedido.getCodcestao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodpedido(), getOrcamentopedido(), getCodcliente(), getNomecliente(), getCodendereco(), getData(), getCodvendedor(), getCodtabela(), getNrparcelas(), getCodformapagto(), getCodcontacaixa(), getObs(), getNumeronotafiscal(), getGerarnota(), getGerarcupom(), getLancado(), getCancelado(), getBaixouestoque(), getVeiculo(), getPlaca(), getValoroutros(), getPercdescontoservicos(), getValordescontoservicos(), getValortotal(), getSubtotalservicos(), getSubtotalprodutos(), getPercdescontoprodutos(), getValordescontoprodutos(), getValortotalitens(), getCodmotor(), getOdometro(), getCodrepresentante(), getCodmecanica(), getBaseprodutosrepresentante(), getPercprodutosrepresentante(), getValorprodutosrepresentante(), getBaseservicosrepresentante(), getPercservicosrepresentante(), getValorservicosrepresentante(), getBaseprodutosmecanico(), getPercprodutosmecanico(), getValorprodutosmecanico(), getBaseservicosmecanico(), getPercservicosmecanico(), getValorservicosmecanico(), getBaseprodutosmecanica(), getPercprodutosmecanica(), getValorprodutosmecanica(), getBaseservicosmecanica(), getPercservicosmecanica(), getValorservicosmecanica(), getVeiculodescricao(), getCodmecanico(), getCodcontapagarcomissaomecanica(), getValorfrete(), getDatafechamento(), getCodnaturezaoperacao(), getCodpraca(), getBaseicms(), getValoricms(), getBasesubstituicao(), getValorsubstituicao(), getValorseguro(), getValordescontototal(), getValorimportacao(), getValoripi(), getValorpis(), getValorcofins(), getBaseissqn(), getValorissqn(), getFreteporconta(), getCodveiculo(), getVolume(), getCodigoregimetributario(), getValoraproximadoimpostos(), getCodnotafiscalgerada(), getCodemitente(), getValorpago(), getValortroco(), getRetirada(), getNumerocupomfiscal(), getNumeropdv(), getImportouitensnfc(), getDatahoraimportouitensnfc(), getUsuariologado(), getCodcaixaabertura(), getUsuario(), getCodnfs(), getNumeronfs(), getCodcestao());
    }

    public List<Pedido> retornaListaPedido(Context context) {
        Banco myDb = new Banco(context);
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM pedido", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                pedido = retornaPedido(context, cursor.getLong(cursor.getColumnIndex("codpedido")));
                pedidos.add(pedido);
                cursor.moveToNext();
            }
        }

        return pedidos;
    }

    public Pedido retornaPedido(Context context, Long codpedido) {
        Banco myDb = new Banco(context);
        Pedido pedido = new Pedido();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM pedido where codpedido = " + codpedido, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(Pedido.class.getDeclaredFields()));
        for (int j = 0; cursor.getCount() != j; j++) {
            for (int f = 0; fieldListCliente.size() != f; f++) {

                String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(f));
                String nomeCampo = fieldListCliente.get(f).getName().toLowerCase();
                Object retorno = getSetDinamico.retornaValorCursor(tipo, nomeCampo, cursor);
                if (retorno != null) {
                    Object retCliente = getSetDinamico.insereField(fieldListCliente.get(f), pedido, retorno);
                    pedido = (Pedido) retCliente;
                }
            }
        }
        db.close();
        return pedido;
    }

    public Long retornaMaiorCod(Context context) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  rowid _id,  max(codpedido) from pedido", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getLong(1);
        } else {
            return 0L;
        }
    }

    public Boolean cadastraPedido(Context context, Pedido pedido) {
        Banco myDb = new Banco(context);
        DadosBanco dadosBanco = new DadosBanco();
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = myDb.getWritableDatabase();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(pedido.getClass().getDeclaredFields()));

        for (int i = 0; fieldList.size() != i; i++) {
            valores = dadosBanco.insereValoresContent(fieldList.get(i), pedido, valores);
        }

        if (valores.get("codpedido") == null) {
            long retorno = retornaMaiorCod(context);
            retorno = retorno + 1;
            valores.remove("cadastroandroid");
            valores.put("codpedido", retorno);
            valores.put("cadastroandroid", true);
            retorno = db.insert("pedido", null, valores);
            db.close();
            valores.clear();
            return retorno != -1;
        } else {
            valores.remove("alteradoandroid");
            valores.put("alteradoandroid", true);
            long retorno = db.update("pedido", valores, "codpedido= " + valores.get("codpedido").toString(), null);
            db.close();
            valores.clear();
            return retorno != -1;
        }
    }

    public boolean removerPedido(Context context, Long codpedido) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getWritableDatabase();
        int retorno = db.delete("pedido", "codpedido = " + codpedido, null);
        return retorno > 0;
    }

    public boolean removerPedidoProduto(Context context, Long codpedido) {
        Banco myDb = new Banco(context);
        SQLiteDatabase db = myDb.getWritableDatabase();
        int retorno = db.delete("pedidoproduto", "codpedido = " + codpedido, null);
        return retorno > -1;
    }
}

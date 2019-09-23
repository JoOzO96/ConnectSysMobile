package com.example.connectsys.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose on 18/05/2017.
 */

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "connectsys.db";
    private static final int VERSAO = 1;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        executaSQL(db, "CREATE TABLE produto(cadastradoandroid boolean, deletadoandroid boolean, alteradoandroid boolean)");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codproduto LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN numerointerno TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN numerofabricante TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN numeroean TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codlocalizacao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codgrupo LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codsubgrupo LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codfornecedorpadrao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codicmscupom LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codicmsnotafiscal LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codmarca LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codcomposicao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN descricao TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN datacadastro LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN datavenda LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN datacompra LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN dataalteracao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN aplicacao TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codunidade LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN custoletra TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorcompra DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorcusto DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN custocomercializacaopercentual LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN custovenda DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN quantidadeestoque LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN quantidademinima LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN quantidademaxima LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN fretevalor DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN fretepercentual LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN darf LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN icms LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN ipi LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percentualavista LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percentualaprazo LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valoravista DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valoraprazo DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valortotal DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN ncm TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN classificacaofiscal TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN situacaotributaria TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN perccomissao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN inativo BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN naocomprar BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN pesoliquidounitarioipi LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN pesoliquidototalipi LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN pesobrutototal LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN pesoliquidototal LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN ipivenda LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN ipikg DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN imagem TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN tipoproduto TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN observacao TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN mvainterno LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN mvaexterno LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codprodutosimilar LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN numerointernosimilar TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN issqncodlistaservico TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN issqnsituacaotributaria TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN situacaotributariasaida TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN csosn TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codipientrada TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codipisaida TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codpis TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percpis LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorpisunitario DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codcofins TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN perccofins LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorcofinsunitario DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codpisentrada TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codcofinsentrada TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN icmsvelho TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percipientrada LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valoripiunitarioentrada DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percpisentrada LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorpisunitarioentrada DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN perccofinsentrada LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorcofinsunitarioentrada DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codtipo TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codexcecaoipi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN classeipi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cnpjipi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codseloipi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN quantidadeseloipi LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codenquandramentoipi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN informacaoadicional TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN empromocao BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percdescontopromocao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valordevendapromocao DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percsubstituicao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN localiza TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN percdescontoformulacao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codnaturezapadrao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codempresa LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN datavalidade LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cest TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN origem TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN produtocomposto BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN totalcomposicao LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valorunitariosubstituicao DOUBLE");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN origemgarden TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN categoria TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cientifico TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN aplicacaogarden TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cultivo TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codnotaentradacadastro LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN valordespesas LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN chassi TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codunidadetributavel LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN fatortributavel LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cstconsumidorfinal TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN csosnconsumidorfinal TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN exigibilidadeiss TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_baseicmsstretido LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_aliquotasuportada LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_valoricmsstretido LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_basefcpstretido LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_aliquotafcpretido LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN efet_valorfcpstretido LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN informacaoadicionalexterna TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cestao BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN codnaturezarevenda LONG");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN descricaoresumida TEXT");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN cadastroandroid BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN alteradoandroid BOOLEAN");
        executaSQL(db, "ALTER TABLE produto ADD COLUMN deletadoandroid BOOLEAN");

        executaSQL(db, "CREATE TABLE cliente(cadastroandroid boolean, deletadoandroid boolean, alteradoandroid boolean)");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codcliente LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN fisicajuridica TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN razaosocial TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN nomefantasia TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN datacadastro LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN datanascimento LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN dataultimacompra LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codocupacao LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN tipoocupacao TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN foneocupacao TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN localocupacao TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codcidade LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN cnpj TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN inscricaoestadualsuframa TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN inscricaoestadual TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN cpf TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN rg TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN tituloeleitoral TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN limitecredito DOUBLE");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN fone TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN fonefax TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN fonecelular TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN email TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN site TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN obs TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN estadocivil TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN conjugenome TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN conjugedatanascimento LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN conjugecpf TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN conjugerg TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN foneconjuge TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN inscricaomunicipal TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codrepresentante LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codconceito LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN banco TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN status TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN maladireta BOOLEAN");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN imagem TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN emailnfe TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN enviarxml BOOLEAN");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN enviarpdf BOOLEAN");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN issqncidadecliente BOOLEAN");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN rendamensal DOUBLE");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN conjugerendamensal DOUBLE");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN regimetributario LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN tratamentotributariodiferenciado BOOLEAN");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN obsnotapadrao TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN particularidades TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN pai TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN mae TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN motivobloqueio TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN percdesconto LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN sexo TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN endereco TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN numero TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN complemento TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN codbairro LONG");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN cep TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN tipoie TEXT");
        executaSQL(db, "ALTER TABLE cliente ADD COLUMN consumidorfinal BOOLEAN");

        executaSQL(db, "CREATE TABLE cidade(cadastroandroid boolean, deletadoandroid boolean, alteradoandroid boolean)");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN codcidade LONG");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN codnacionaluf TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN uf TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN codnacionalcidade TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN nome TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN pais TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN codnacionalpais TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN percissqn LONG");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN homologacaoenvio TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN homologacaocancelamento TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN homologacaobuscasequencia TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN producaoenvio TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN producaocancelamento TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN producaobuscasequencia TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN homologacaosite TEXT");
        executaSQL(db, "ALTER TABLE cidade ADD COLUMN producaosite TEXT");

        executaSQL(db, "CREATE TABLE clienteendereco(cadastroandroid boolean, deletadoandroid boolean, alteradoandroid boolean)");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN codendereco LONG");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN codcliente LONG");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN codcidade LONG");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN endereco TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN numero TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN complemento TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN codbairro LONG");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN cep TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN fone TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN fonefax TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN fonecelular TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN tipo TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN obs TEXT");
        executaSQL(db, "ALTER TABLE clienteendereco ADD COLUMN inscricaoestadual TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public boolean executaSQL(SQLiteDatabase db, String sql) {
        try {
            db.execSQL(sql);
        } catch (Exception e) {

        }
        return true;
    }

}

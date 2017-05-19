package com.appcorsan;

/**
 * Created by sala01 on 19/05/2017.
 */

public class Utils {

    public static final String URL_AUTENTICACAO_USERNAME ="";
    public static final String URL_AUTENTICACAO_PASSWORD ="";

    public static final String URL_AUTENTICACAO = "https://sectre.procergs.com.br/aomc/rest/autenticacao/authenticate";
    public static final String URL_LISTA_FATURAS = "https://sectre.procergs.com.br/aomc/rest/imoveis/%s/faturasPendentes";
    public static final String URL_EMISSAO_FATURA ="https://sectre.procergs.com.br/aomc/rest/imoveis/emitirSegundaVia?nroDifer=%s&codigoImovel=%s&txtCompet=%s";
    public static final String URL_LISTA_EMPRESA = "https://sectre.procergs.com.br/aomc/rest/empresaOrgao/lista";

    public static final String TOKEN_API_AOMC = "TOKEN_API_AOMC";

}

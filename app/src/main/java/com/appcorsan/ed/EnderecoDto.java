
package com.appcorsan.ed;


public class EnderecoDto {

    private LogradouroDto logradouroDto;
    private String txtLocalidade;
    private String txtBairro;
    private String txtCep;
    private String txtComplemento;
    private String txtEndereco;
    private Double nroLat;
    private Double nroLng;

    public LogradouroDto getLogradouroDto() {
        return logradouroDto;
    }

    public void setLogradouroDto(LogradouroDto logradouroDto) {
        this.logradouroDto = logradouroDto;
    }

    public String getTxtLocalidade() {
        return txtLocalidade;
    }

    public void setTxtLocalidade(String txtLocalidade) {
        this.txtLocalidade = txtLocalidade;
    }

    public String getTxtBairro() {
        return txtBairro;
    }

    public void setTxtBairro(String txtBairro) {
        this.txtBairro = txtBairro;
    }

    public String getTxtCep() {
        return txtCep;
    }

    public void setTxtCep(String txtCep) {
        this.txtCep = txtCep;
    }

    public String getTxtComplemento() {
        return txtComplemento;
    }

    public void setTxtComplemento(String txtComplemento) {
        this.txtComplemento = txtComplemento;
    }

    public String getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco = txtEndereco;
    }

    public Double getNroLat() {
        return nroLat;
    }

    public void setNroLat(Double nroLat) {
        this.nroLat = nroLat;
    }

    public Double getNroLng() {
        return nroLng;
    }

    public void setNroLng(Double nroLng) {
        this.nroLng = nroLng;
    }

}

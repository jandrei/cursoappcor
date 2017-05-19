
package com.appcorsan.ed;

import java.util.List;

public class EmpresaOrgao {

    private String descEmpresa;
    private String siglaEmpresa;
    private String email;
    private List<Telefone> telefones = null;
    private EnderecoDto enderecoDto;

    public String getDescEmpresa() {
        return descEmpresa;
    }

    public void setDescEmpresa(String descEmpresa) {
        this.descEmpresa = descEmpresa;
    }

    public String getSiglaEmpresa() {
        return siglaEmpresa;
    }

    public void setSiglaEmpresa(String siglaEmpresa) {
        this.siglaEmpresa = siglaEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public EnderecoDto getEnderecoDto() {
        return enderecoDto;
    }

    public void setEnderecoDto(EnderecoDto enderecoDto) {
        this.enderecoDto = enderecoDto;
    }

}


package com.appcorsan.ed;

import java.util.List;

public class ListaFatura {

    private ImovelDto imovelDto;
    private List<Fatura> faturas = null;

    public ImovelDto getImovelDto() {
        return imovelDto;
    }

    public void setImovelDto(ImovelDto imovelDto) {
        this.imovelDto = imovelDto;
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }

}

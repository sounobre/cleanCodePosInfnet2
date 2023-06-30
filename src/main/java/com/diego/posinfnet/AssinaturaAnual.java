package com.diego.posinfnet;

import java.math.BigDecimal;
import java.time.LocalDate;

class AssinaturaAnual extends Assinatura {
    public AssinaturaAnual(BigDecimal mensalidade, LocalDate begin, Cliente cliente) {
        super(mensalidade, begin, cliente);
    }

    public AssinaturaAnual(BigDecimal mensalidade, LocalDate begin, LocalDate end, Cliente cliente) {
        super(mensalidade, begin, end, cliente);
    }

    @Override
    public BigDecimal calcularTaxa() {
        return BigDecimal.ZERO; // Isento de taxa
    }
}

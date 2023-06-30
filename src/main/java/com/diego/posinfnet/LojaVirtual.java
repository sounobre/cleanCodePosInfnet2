package com.diego.posinfnet;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class LojaVirtual {
    public static void main(String[] args) {
        // 1. Crie alguns produtos, clientes e pagamentos
        Produto produto1 = new Produto("Música 1", Path.of("musica1.mp3"), BigDecimal.valueOf(2.99));
        Produto produto2 = new Produto("Vídeo 1", Path.of("video1.mp4"), BigDecimal.valueOf(4.99));
        Produto produto3 = new Produto("Imagem 1", Path.of("imagem1.jpg"), BigDecimal.valueOf(1.99));

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        Assinatura assinatura1 = new AssinaturaAnual(BigDecimal.valueOf(99.98), LocalDate.now().minusMonths(1), cliente1);
        Assinatura assinatura2 = new AssinaturaSemestral(BigDecimal.valueOf(99.98), LocalDate.now().minusMonths(2), cliente2);
        Assinatura assinatura3 = new AssinaturaTrimestral(BigDecimal.valueOf(99.98), LocalDate.now().minusMonths(3), cliente1);

        Pagamento pagamento1 = new Pagamento(Arrays.asList(produto1, produto2), LocalDate.now(), cliente1);
        Pagamento pagamento2 = new Pagamento(Arrays.asList(produto3), LocalDate.now().minusDays(1), cliente2);
        Pagamento pagamento3 = new Pagamento(Arrays.asList(produto1), LocalDate.now().minusMonths(1), cliente1);

        List<Pagamento> pagamentos = Arrays.asList(pagamento1, pagamento2, pagamento3);

        // 2. Ordene e imprima os pagamentos pela data de compra
        List<Pagamento> pagamentosOrdenados = pagamentos.stream()
                .sorted(Comparator.comparing(Pagamento::getDataCompra))
                .collect(Collectors.toList());

        System.out.println("Pagamentos ordenados:");
        for (Pagamento pagamento : pagamentosOrdenados) {
            System.out.println(pagamento.getDataCompra());
        }

        // 3. Calcule e imprima a soma dos valores totais dos pagamentos
        BigDecimal somaValoresTotais = pagamentos.stream()
                .map(Pagamento::calcularValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Soma dos valores totais: " + somaValoresTotais);

        // 4. Verifique se algum cliente possui assinatura em atraso
        boolean clienteComAssinaturaAtrasada = pagamentos.stream()
                .map(Pagamento::getCliente)
                .distinct()
                .anyMatch(Cliente::isAssinaturaAtrasada);

        if (clienteComAssinaturaAtrasada) {
            System.out.println("Existe pelo menos um cliente com assinatura em atraso.");
        } else {
            System.out.println("Nenhum cliente possui assinatura em atraso.");
        }
    }
}

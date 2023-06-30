package com.diego.posinfnet;

class Cliente {
    private String nome;
    private boolean assinaturaAtrasada;

    public Cliente(String nome) {
        this.nome = nome;
        this.assinaturaAtrasada = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAssinaturaAtrasada() {
        return assinaturaAtrasada;
    }

    public void setAssinaturaAtrasada(boolean assinaturaAtrasada) {
        this.assinaturaAtrasada = assinaturaAtrasada;
    }
}

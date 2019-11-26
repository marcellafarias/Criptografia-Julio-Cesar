package com.marcella.descripto.model;

import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marcella.descripto.Descripto;
import com.marcella.descripto.util.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {

    private int numero_casas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumo_criptografico;

    public int getNumero_casas() {
        return numero_casas;
    }

    public void setNumero_casas(int numeroCasas) {
        this.numero_casas = numeroCasas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public void setResumo_criptografico(String resumoCriptografico) {
        this.resumo_criptografico = resumoCriptografico;
    }

    public void decifrar() {
        this.setDecifrado(Descripto.descriptografar(cifrado, numero_casas));
        this.setResumo_criptografico(DigestUtils.sha1Hex(decifrado));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cifrado, decifrado, numero_casas, resumo_criptografico, token);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Answer other = (Answer) obj;
        return numero_casas == other.numero_casas
                && Objects.equals(cifrado, other.cifrado)
                && Objects.equals(decifrado, other.decifrado)
                && Objects.equals(resumo_criptografico, other.resumo_criptografico)
                && Objects.equals(token, other.token);
    }

    @Override
    public String toString() {
        return StringUtils.toJson(this);
    }


}

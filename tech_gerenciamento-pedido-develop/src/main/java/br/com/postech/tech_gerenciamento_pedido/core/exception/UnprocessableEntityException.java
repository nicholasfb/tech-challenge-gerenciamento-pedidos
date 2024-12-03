package br.com.postech.tech_gerenciamento_pedido.core.exception;

public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(String message) {
        super(message);
    }

}

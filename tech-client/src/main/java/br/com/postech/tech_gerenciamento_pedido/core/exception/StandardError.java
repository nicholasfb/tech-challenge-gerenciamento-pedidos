package br.com.postech.tech_gerenciamento_pedido.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private Instant timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

}
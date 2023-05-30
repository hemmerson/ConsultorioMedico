package com.example.consultoriomedico.DAO;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/05/2023
 */
public class ErroDAO extends Exception{
    public ErroDAO() {
        super();
    }

    public ErroDAO(String message) {
        super("Erro DAO: "+message);
    }

    public ErroDAO(String message, Throwable cause) {
        super("Erro DAO: "+message, cause);
    }

    public ErroDAO(Throwable cause) {
        super(cause);
    }

    protected ErroDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("Erro DAO: "+message, cause, enableSuppression, writableStackTrace);
    }
}

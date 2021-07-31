package org.vriesema.novi.rowingapp.exceptions;


public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super("Record not found");
    }
}

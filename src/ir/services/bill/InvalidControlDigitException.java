package ir.services.bill;

public class InvalidControlDigitException extends Exception {

    public InvalidControlDigitException(){

    }

    public InvalidControlDigitException( String message ){
        super(message);
    }
}

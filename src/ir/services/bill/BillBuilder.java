package ir.services.bill;

public class BillBuilder {

    Bill bill = new Bill();

    public BillBuilder setAmount( long amount ){
        bill.setAmount( amount );
        return this;
    }

    public BillBuilder setType( String type ) throws InvalidInputException {
        bill.setServiceType( type );
        return this;
    }

    public BillBuilder setBillFileCode( String billFileCode ) throws InvalidInputException {
        bill.setBillFileCode( billFileCode );
        return this;
    }

    public BillBuilder setBillBranchCode( String billBranchCode  ) throws InvalidInputException {
        bill.setBillBranchCode( billBranchCode );
        return this;
    }


    public BillBuilder setPaymentYearCode( String paymentYearCode ) throws InvalidInputException {
        bill.setPaymentYearCode( paymentYearCode );
        return this;
    }


    public BillBuilder setPaymentPeriodCode( String paymentPeriodCode ) throws InvalidInputException {
        bill.setPaymentPeriodCode( paymentPeriodCode );
        return this;
    }

    public Bill prepare(){
        bill.setBillId(BillServices.generateBillId(bill));
        bill.setBillControlDigit( String.valueOf(bill.getBillId().charAt(12)) );
        bill.setPaymentId(BillServices.generatePaymentId(bill));
        bill.setPaymentControlDigit1( String.valueOf(bill.getPaymentId().charAt(11)) );
        bill.setPaymentControlDigit2( String.valueOf(bill.getPaymentId().charAt(12)) );
        bill.setBarcodeContent( bill.getBillId()+bill.getPaymentId() );
        return bill;
    }


}

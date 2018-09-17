package ir.services.bill;

public class BillServices {


    public static boolean checkBillId( String billId ) throws InvalidInputException, InvalidControlDigitException {
        int len = billId.length();
        if( len <= 13 && len >= 5 ) {
            String temp = billId.substring(0,len-1);
            String controlDigit = billId.substring(len-1,len);
            if( BillServicesHelper.base11(temp) == Integer.valueOf(controlDigit) ){
                return true;
            } else {
                throw new InvalidControlDigitException("Invalid billId control digit!");
            }
        } else {
            throw new InvalidInputException("Invalid billId len!");
        }
    }


    public static boolean checkPaymentId( String paymentId , String billId ) throws InvalidInputException, InvalidControlDigitException {
        int len = paymentId.length();
        if( len <= 13 && len >= 5 ) {
            String temp = paymentId.substring(0,len-2);
            String controlDigit1 = paymentId.substring(len-2,len-1);
            String controlDigit2 = paymentId.substring(len-1,len);
            if( BillServicesHelper.base11(temp) == Integer.valueOf(controlDigit1) ){
                if( BillServicesHelper.base11(billId.replaceFirst("^0+(?!$)", "") +  paymentId.replaceFirst("^0+(?!$)", "") )  == Integer.valueOf(controlDigit2) ){
                    return true;
                } else {
                    throw new InvalidControlDigitException("Invalid paymentId control digit 2!");
                }
            } else {
                throw new InvalidControlDigitException("Invalid paymentId control digit 1!");
            }
        } else {
            throw new InvalidInputException("Invalid paymentId len!");
        }
    }


    public static String generateBillId( String billFileCode , String billBranchCode , String serviceType ){
        StringBuilder billId = new StringBuilder();
        billId.append( ("00000000" + billFileCode ).substring( billFileCode.length()) );
        billId.append( ("000" + billBranchCode ).substring( billBranchCode.length()));
        billId.append(serviceType);
        billId.append(BillServicesHelper.base11(billId.toString()));
        return billId.toString();
    }

    public static String generateBillId( Bill bill ){
        return generateBillId( bill.getBillFileCode() , bill.getBillBranchCode() , bill.getServiceType() );
    }

    public static String generatePaymentId( long amount , String paymentYearCode , String paymentPeriodCode , String billId ){
        StringBuilder paymentId = new StringBuilder();
        paymentId.append(String.format("%08d",amount/1000));
        paymentId.append(paymentYearCode);
        paymentId.append( ("00" + paymentPeriodCode ).substring( paymentPeriodCode.length()));
        paymentId.append( BillServicesHelper.base11(paymentId.toString()) );
        paymentId.append( BillServicesHelper.base11(billId.replaceFirst("^0+(?!$)", "") +  paymentId.toString().replaceFirst("^0+(?!$)", "") ) );
        return paymentId.toString();
    }

    public static String generatePaymentId( Bill bill ){
        return generatePaymentId( bill.getAmount() , bill.getPaymentYearCode() , bill.getPaymentPeriodCode() , bill.getBillId() );
    }

    public static Bill getBill( String billId , String paymentId ){
        Bill bill = new Bill();

        return bill;
    }

    public static Bill getBill( String barcodeContent ){
        Bill bill = new Bill();

        return bill;
    }

}

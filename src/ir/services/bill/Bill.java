package ir.services.bill;

public class Bill {
    private String paymentId;
    private String paymentYearCode;
    private String paymentPeriodCode;
    private String paymentControlDigit1;
    private String paymentControlDigit2;
    private long amount;
    private String billId;
    private String billFileCode;
    private String billBranchCode;
    private String serviceType;
    private String billControlDigit;
    private String barcodeContent;


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentYearCode() {
        return paymentYearCode;
    }

    public void setPaymentYearCode(String paymentYearCode) throws InvalidInputException {
        if(paymentYearCode.length()==1){
            this.paymentYearCode = paymentYearCode;
        } else {
            throw new InvalidInputException("Invalid paymentYearCode len!");
        }

    }

    public String getPaymentPeriodCode() {
        return paymentPeriodCode;
    }

    public void setPaymentPeriodCode(String paymentPeriodCode) throws InvalidInputException {
        if(paymentPeriodCode.length()<=2){
            this.paymentPeriodCode = paymentPeriodCode;
        } else {
            throw new InvalidInputException("Invalid paymentPeriodCode len!");
        }
    }

    public String getPaymentControlDigit1() {
        return paymentControlDigit1;
    }

    public void setPaymentControlDigit1(String paymentControlDigit1) {
        this.paymentControlDigit1 = paymentControlDigit1;
    }

    public String getPaymentControlDigit2() {
        return paymentControlDigit2;
    }

    public void setPaymentControlDigit2(String paymentControlDigit2) {
        this.paymentControlDigit2 = paymentControlDigit2;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillFileCode() {
        return billFileCode;
    }

    public void setBillFileCode(String billFileCode) throws InvalidInputException {
        if( billFileCode.length() <= 8 ){
            this.billFileCode = billFileCode;
        } else {
            throw new InvalidInputException("Invalid billFileCode len!");
        }

    }

    public String getBillBranchCode() {
        return billBranchCode;
    }

    public void setBillBranchCode(String billBranchCode) throws InvalidInputException {
        if( billBranchCode.length() <= 3 ){
            this.billBranchCode = billBranchCode;
        } else {
            throw new InvalidInputException("Invalid billBranchCode len!");
        }
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) throws InvalidInputException {
        if( serviceType.length() == 1 ){
            this.serviceType = serviceType;
        } else {
            throw new InvalidInputException("Invalid serviceType len!");
        }
    }

    public String getBillControlDigit() {
        return billControlDigit;
    }

    public void setBillControlDigit(String billControlDigit) {
        this.billControlDigit = billControlDigit;
    }

    public String getBarcodeContent() {
        return barcodeContent;
    }

    public void setBarcodeContent(String barcodeContent) {
        this.barcodeContent = barcodeContent;
    }

    public enum Type {
        WATER("1"),
        ELECTRICITY("2"),
        GAS("3"),
        PHONE("4"),
        MOBILE("5"),
        CITY("6");

        private String code;

        Type(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}

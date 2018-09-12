import ir.services.bill.*;

public class Main {

    public static void main(String[] args) {

        try {

             Bill bill = new BillBuilder()
                    .setAmount(4300000)
                    .setType(Bill.Type.ELECTRICITY.getCode())
                    .setBillFileCode("8573723")
                    .setBillBranchCode("223")
                    .setPaymentPeriodCode("1")
                    .setPaymentYearCode("7")
                    .prepare();

            System.out.println( bill.getBillId()+"|"+bill.getPaymentId() );
            System.out.println( bill.getBarcodeContent() );

            System.out.println( "Control Digit: " + BillServicesHelper.base11("167703625"));
            System.out.println( "Check: " + BillServices.checkBillId("1677036252"));


        } catch (InvalidInputException | InvalidControlDigitException e) {
            System.err.println(e.getMessage());
        }


    }
}

package ir.services.bill;

public class BillServicesHelper {

    public static final short[] BASE_11 = {2,3,4,5,6,7} ;

    public static int base11( String input ){
        int sum = 0 , j = 0;
        for( int i = input.length() -1 ; i >= 0 ; i-- ){
            sum += Integer.parseInt(String.valueOf(input.charAt(i)))*BASE_11[j];
            if(BASE_11[j]==7) j=0; else j++;
        }
        int mo =  sum % 11;
        if( mo > 1){
            return 11 - mo ;
        } else {
            return 0 ;
        }
    }

}

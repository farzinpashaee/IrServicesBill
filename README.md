# IrServicesBill

IrServicesBill is a library to generate and validate iranian Services Bill Payment. This library build based on Iranian Banking Informatics Commission document released in 2006.

## Getting Started

To use this library you can add the jar file into your project.

## Examples
#### Generating Bill
To generate new bill you can use BillBuilder and it's methods to build a new Bill Object:
```
Bill bill = new BillBuilder()
                    .setAmount(4300000)
                    .setType(Bill.TYPE_ELECTRICITY)
                    .setBillFileCode("8573723")
                    .setBillBranchCode("223")
                    .setPaymentPeriodCode("1")
                    .setPaymentYearCode("7")
                    .prepare();
```

You can retrieve paymentId and billId from bill object after calling prepare method.
```
String billId = bill.getBillId();
String paymentId = bill.getPaymentId() 
```

#### Validating Bill
You can also use BillServices class to validate Bill ID and Payment ID:

## Versioning

1.0.0

## Authors

* **Farzin Pashaee** - *Initial work* - [IrServicesBill](https://github.com/farzinpashaee/IrServicesBill)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



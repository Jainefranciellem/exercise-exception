package Service;

import interfaces.OnlinePaymentInterface;

public class PayPalService implements OnlinePaymentInterface {

    public Double interest(Double amount, Integer months) {
        Double result = amount * 0.01 * months;
        return result;
    };
    
    public Double paymentFee(Double amount) {
        Double result = amount * 0.02;
        return result;
    }

}